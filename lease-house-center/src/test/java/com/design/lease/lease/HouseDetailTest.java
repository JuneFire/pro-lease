package com.design.lease.lease;

import com.design.lease.BaseTest;
import com.design.lease.house.dao.LeaseHouseDao;
import com.design.lease.house.po.LeaseHousePO;
import com.design.lease.utils.JacksonObjectUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class HouseDetailTest extends BaseTest{

    @Autowired
    private LeaseHouseDao houseDao;

    @Test
    public void testHouseDetail(){
        LeaseHousePO leaseHousePO = houseDao.queryHouseDetailByNo("H15645134");
        System.out.println("leaseHousePO = "+ JacksonObjectUtils.jacksonObjectToSerializable(leaseHousePO));
    }

}
