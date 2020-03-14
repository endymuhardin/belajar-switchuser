package com.muhardin.endy.belajar.switchuser.belajarswitchuser.controller;

import com.muhardin.endy.belajar.switchuser.belajarswitchuser.dao.PenggunaDao;
import com.muhardin.endy.belajar.switchuser.belajarswitchuser.dao.TransaksiDao;
import com.muhardin.endy.belajar.switchuser.belajarswitchuser.entity.Pengguna;
import com.muhardin.endy.belajar.switchuser.belajarswitchuser.entity.Transaksi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Slf4j
@Controller
public class TransaksiController {

    @Autowired
    private TransaksiDao transaksiDao;

    @Autowired private PenggunaDao penggunaDao;

    @GetMapping("/transaksi/list")
    public ModelMap daftarTransaksi(Authentication currentUser) {
        log.info("User yang sedang login : "+currentUser.getName());

        ModelMap mm = new ModelMap();

        penggunaDao.findByUsername(currentUser.getName())
                .ifPresent(p->{
                    mm.addAttribute(
                            "daftarTransaksi",
                            transaksiDao.findByPengguna(p));
                });

        return mm;
    }
}
