package com.design.lease.admin.service.impl;

import com.design.lease.admin.dao.LeaseAdminDao;
import com.design.lease.admin.service.LeaseAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaseAdminServiceImpl implements LeaseAdminService{

    @Autowired
    private LeaseAdminDao leaseAdminDao;


}
