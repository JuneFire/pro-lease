package com.design.lease.house.handler;

import com.design.lease.bo.HouseDetailBO;
import com.design.lease.house.po.LeaseHousePO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class HouseHandler {

    public List<HouseDetailBO> buildHouseList(List<LeaseHousePO> list){
        List<HouseDetailBO> houseDetailBOS = new ArrayList<>();
        for(LeaseHousePO leaseHousePO : list){
            houseDetailBOS.add(buildHouseDetail(leaseHousePO));
        }
        return houseDetailBOS;
    }

    public HouseDetailBO buildHouseDetail(LeaseHousePO leaseHousePO){
        HouseDetailBO  houseDetalBO = new HouseDetailBO();
        BeanUtils.copyProperties(leaseHousePO,houseDetalBO);
        return houseDetalBO;
    }

}
