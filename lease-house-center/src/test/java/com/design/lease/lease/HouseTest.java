package com.design.lease.lease;

import com.design.lease.BaseTest;
import com.design.lease.house.dao.LeaseHouseDao;
import com.design.lease.house.po.LeaseHousePO;
import com.design.lease.house.service.AccountHouseRpcService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class HouseTest extends BaseTest{

    @Autowired
    private LeaseHouseDao leaseHouseDao;

    @Autowired
    private AccountHouseRpcService accountHouseRpcService;

    @Test
    public void houseTest(){

        accountHouseRpcService.queryHouseDetail(1L);

        LeaseHousePO leaseHousePO = leaseHouseDao.selectByPrimaryKey(1L);
        System.out.println("LeaseHousePO  : " + leaseHousePO);
    }

}
