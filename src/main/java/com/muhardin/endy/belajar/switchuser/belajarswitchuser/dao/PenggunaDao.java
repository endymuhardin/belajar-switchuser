package com.muhardin.endy.belajar.switchuser.belajarswitchuser.dao;

import com.muhardin.endy.belajar.switchuser.belajarswitchuser.entity.Pengguna;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface PenggunaDao extends PagingAndSortingRepository<Pengguna, String> {
    Optional<Pengguna> findByUsername(String name);
}
