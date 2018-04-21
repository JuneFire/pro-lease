package com.design.lease.house.rpc;

import com.design.lease.account.dto.HouseDto;
import com.design.lease.bo.HouseDetailBO;
import com.design.lease.house.dao.LeaseHouseDao;
import com.design.lease.house.handler.HouseHandler;
import com.design.lease.house.po.LeaseHousePO;
import com.design.lease.rpc.HouseRpcService;
import com.design.lease.rpc.dto.RpcResponseDTO;
import com.design.lease.utils.JacksonObjectUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HouseRpcServiceImpl extends HouseHandler implements HouseRpcService{

    private static final Logger logger = LoggerFactory.getLogger(HouseRpcService.class);

    @Autowired
    private LeaseHouseDao houseDao;

    @Override
    public RpcResponseDTO<List<HouseDetailBO>> queryHouse(HouseDto houseDto) {

        if (houseDto == null || houseDto.getStatus() == null){
            logger.info("执行queryHouse异常.参数错误");
            return new RpcResponseDTO<List<HouseDetailBO>>().buildParamErrorResponse();
        }

        List<LeaseHousePO> list = houseDao.queryHouses(houseDto.getStatus());


        if (CollectionUtils.isEmpty(list)){
            logger.info("----------执行queryHouse完成,返回结果为null.houseDto = {}", JacksonObjectUtils.jacksonObjectToSerializable(houseDto));
            return new RpcResponseDTO<List<HouseDetailBO>>().buildSuccessResponse();
        }

        List<HouseDetailBO> houseDetailBOS = this.buildHouseList(list);

        return new RpcResponseDTO<List<HouseDetailBO>>().buildSuccessResponse(houseDetailBOS);
    }

    @Override
    public RpcResponseDTO<HouseDetailBO> queryHouseDetailByHno(HouseDto houseDto) {
        return null;
    }
}
