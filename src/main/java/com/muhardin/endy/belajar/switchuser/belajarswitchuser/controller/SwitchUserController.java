package com.muhardin.endy.belajar.switchuser.belajarswitchuser.controller;

import com.muhardin.endy.belajar.switchuser.belajarswitchuser.dao.PenggunaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwitchUserController {
    @Autowired private PenggunaDao penggunaDao;
    @GetMapping("/switchuser/auditlog")
    public ModelMap daftarKegiatan() {
        return new ModelMap();
    }

    @GetMapping("/switchuser/select")
    public ModelMap pilihUser() {
        return new ModelMap()
                .addAttribute("daftarPengguna",
                        penggunaDao.findAll());
    }
}
