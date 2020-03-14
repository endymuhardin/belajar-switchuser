package com.muhardin.endy.belajar.switchuser.belajarswitchuser.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data @Entity
public class Transaksi {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @ManyToOne @JoinColumn(name = "id_pengguna")
    private Pengguna pengguna;

    @NotNull
    private LocalDateTime waktuTransaksi;

    @NotNull @NotEmpty
    private String keterangan;

    @NotNull @Min(1000)
    private BigDecimal nilai;
}
