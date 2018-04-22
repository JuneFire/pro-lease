package com.design.lease.helper;

import com.design.lease.account.dto.HouseDto;
import com.design.lease.bo.HouseCollectionDetailBO;
import com.design.lease.bo.HouseDetailBO;
import com.design.lease.bo.LandlordDetailBO;
import com.design.lease.collection.enums.CollectionTypeEnum;
import com.design.lease.collection.po.LeaseHouseCollectionPO;
import com.design.lease.dto.HouseCollectionDTO;
import com.design.lease.landlord.po.LeaseLandlordDetailPO;
import com.design.lease.utils.GeneratorUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class TradeHelper {

    public List<HouseCollectionDetailBO> buildHouseList(List<LeaseHouseCollectionPO> list){
        List<HouseCollectionDetailBO> houseDetailBOS = new ArrayList<>();
        for(LeaseHouseCollectionPO leaseHousePO : list){
            houseDetailBOS.add(buildHouseDetail(leaseHousePO));
        }
        return houseDetailBOS;
    }

    public HouseCollectionDetailBO buildHouseDetail(LeaseHouseCollectionPO leaseHousePO){
        HouseCollectionDetailBO  houseDetalBO = new HouseCollectionDetailBO();
        BeanUtils.copyProperties(leaseHousePO,houseDetalBO);
        return houseDetalBO;
    }

    public LeaseHouseCollectionPO buildHouseCollection(HouseCollectionDTO collectionDTO,HouseDetailBO houseDetailBO){
        LeaseHouseCollectionPO leaseHouseCollectionPO = new LeaseHouseCollectionPO();
        leaseHouseCollectionPO.setHouseName(houseDetailBO.getHouseName());
        leaseHouseCollectionPO.setHouseNo(collectionDTO.getHouseNo());
        leaseHouseCollectionPO.setOrderId(GeneratorUtils.generatorOrderNo(collectionDTO.getUid()));
        leaseHouseCollectionPO.setStatus(CollectionTypeEnum.COLLECTION_TYPE_success.getCode());
        leaseHouseCollectionPO.setUid(collectionDTO.getUid());
        return leaseHouseCollectionPO;
    }

    public HouseDto buildHouseDTO(HouseCollectionDTO collectionDTO){
        HouseDto houseDto = new HouseDto();
        houseDto.setHouseNo(collectionDTO.getHouseNo());
        return houseDto;
    }

    public List<LandlordDetailBO> buildLandlordDetailList(List<LeaseLandlordDetailPO> list){
        List<LandlordDetailBO> houseDetailBOS = new ArrayList<>();
        for(LeaseLandlordDetailPO leaseHousePO : list){
            houseDetailBOS.add(buildLandlordDetail(leaseHousePO));
        }
        return houseDetailBOS;
    }

    public LandlordDetailBO buildLandlordDetail(LeaseLandlordDetailPO leaseHousePO){
        LandlordDetailBO  houseDetalBO = new LandlordDetailBO();
        BeanUtils.copyProperties(leaseHousePO,houseDetalBO);
        return houseDetalBO;
    }

}
