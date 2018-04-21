package com.design.lease.account.service.impl;

import com.design.lease.account.dao.LeaseAccountDao;
import com.design.lease.account.po.LeaseAccountPO;
import com.design.lease.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private LeaseAccountDao leaseAccountDao;

    @Override
    public LeaseAccountPO queryByAccount(Long id) {
        return leaseAccountDao.selectByPrimaryKey(id);
    }
}
