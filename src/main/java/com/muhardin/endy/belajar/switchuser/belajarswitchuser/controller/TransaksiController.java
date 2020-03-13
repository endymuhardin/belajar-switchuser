package com.muhardin.endy.belajar.switchuser.belajarswitchuser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransaksiController {

    @GetMapping("/transaksi/list")
    public ModelMap daftarTransaksi() {
        return new ModelMap();
    }
}
