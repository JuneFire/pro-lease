package com.design.lease.accoun.test;

import com.design.lease.BaseTest;
import com.design.lease.account.dao.LeaseAccountDao;
import com.design.lease.account.po.LeaseAccountPO;
import com.design.lease.account.service.AccountService;
import com.design.lease.admin.dao.LeaseAdminDao;
import com.design.lease.house.service.AccountHouseRpcService;
import com.design.lease.user.dao.LeaseUserFlowDao;
import com.design.lease.user.dao.LeaseUserInfoDao;
import com.design.lease.user.po.LeaseUserFlowPO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountTest extends BaseTest{

    @Autowired
    private LeaseUserFlowDao leaseUserFlowDao;

    @Autowired
    private LeaseUserInfoDao leaseUserInfoDao;

    @Autowired
    private LeaseAdminDao leaseAdminDao;

    @Autowired
    private LeaseAccountDao leaseAccountDao;

    @Autowired
    private AccountService accountService;


    @Test
    public void leaseAccountTest(){

        LeaseAccountPO leaseUserFlowPO = accountService.queryByAccount(1L);
        System.out.println("leaseUserFlowPO : " + leaseUserFlowPO);

    }

}
