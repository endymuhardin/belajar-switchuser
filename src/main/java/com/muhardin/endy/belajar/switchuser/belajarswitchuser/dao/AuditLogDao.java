package com.muhardin.endy.belajar.switchuser.belajarswitchuser.dao;

import com.muhardin.endy.belajar.switchuser.belajarswitchuser.entity.AuditLog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuditLogDao extends PagingAndSortingRepository<AuditLog, String> {
}
