package com.muhardin.endy.belajar.switchuser.belajarswitchuser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuditLogController {
    @GetMapping("/auditlog/list")
    public ModelMap daftarKegiatan() {
        return new ModelMap();
    }
}
