package com.muhardin.endy.belajar.switchuser.belajarswitchuser.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data @Entity
public class Pengguna {

    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotEmpty @NotNull @Size(max = 100)
    private String username;

    @NotEmpty @NotNull @Size(max = 255)
    private String hashedPassword;

    @NotEmpty @NotNull @Size(max = 255)
    private String nama;
}
