package com.muhardin.endy.belajar.switchuser.belajarswitchuser;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class BelajarSwitchuserApplicationTests {
    @Autowired private PasswordEncoder passwordEncoder;

    @Test
    public void testGeneratePassword() {
        String hashed = passwordEncoder.encode("user00");
        System.out.println("Hashed : "+hashed);
    }
}
