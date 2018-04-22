package com.design.lease.house.rpc;

import com.design.lease.account.dto.HouseDto;
import com.design.lease.bo.HouseDetailBO;
import com.design.lease.bo.HouseRelationDetailBO;
import com.design.lease.house.dao.LeaseHouseDao;
import com.design.lease.house.dao.LeaseHouseRelationDao;
import com.design.lease.house.handler.HouseHandler;
import com.design.lease.house.po.LeaseHousePO;
import com.design.lease.house.po.LeaseHouseRelationPO;
import com.design.lease.rpc.HouseRpcService;
import com.design.lease.rpc.dto.RpcResponseDTO;
import com.design.lease.utils.JacksonObjectUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HouseRpcServiceImpl extends HouseHandler implements HouseRpcService{

    private static final Logger logger = LoggerFactory.getLogger(HouseRpcService.class);

    @Autowired
    private LeaseHouseDao houseDao;

    @Autowired
    private LeaseHouseRelationDao relationDao;

    @Override
    public RpcResponseDTO<List<HouseDetailBO>> queryHouse(HouseDto houseDto) {

        if (houseDto == null || houseDto.getStatus() == null){
            logger.info("执行queryHouse异常.参数错误");
            return new RpcResponseDTO<List<HouseDetailBO>>().buildParamErrorResponse();
        }

        List<LeaseHousePO> list = houseDao.queryHouses(houseDto.getStatus());


        if (CollectionUtils.isEmpty(list)){
            logger.info("----------执行queryHouse完成,返回结果为null.houseDto = {}", JacksonObjectUtils.jacksonObjectToSerializable(houseDto));
            return new RpcResponseDTO<List<HouseDetailBO>>().buildFailResponse();
        }

        List<HouseDetailBO> houseDetailBOS = this.buildHouseList(list);

        return new RpcResponseDTO<List<HouseDetailBO>>().buildSuccessResponse(houseDetailBOS);
    }

    @Override
    public RpcResponseDTO<HouseDetailBO> queryHouseDetailByHno(HouseDto houseDto) {

        if (houseDto == null || houseDto.getHouseNo() == null){
            logger.info("执行queryHouseDetailByHno异常.参数错误");
            return new RpcResponseDTO<HouseDetailBO>().buildParamErrorResponse();
        }

        LeaseHousePO leaseHousePO = houseDao.queryHouseDetailByNo(houseDto.getHouseNo());

        if (leaseHousePO == null){
            logger.info("----------执行queryHouse完成,返回结果为null.houseDto = {}", JacksonObjectUtils.jacksonObjectToSerializable(houseDto));
            return new RpcResponseDTO<HouseDetailBO>().buildFailResponse();
        }

        HouseDetailBO houseDetailBO = new HouseDetailBO();
        BeanUtils.copyProperties(leaseHousePO,houseDetailBO);

        return new RpcResponseDTO<HouseDetailBO>().buildSuccessResponse(houseDetailBO);
    }

    @Override
    public RpcResponseDTO<HouseRelationDetailBO> queryHouseRelationDetailByHno(HouseDto houseDto) {

        if (houseDto == null || houseDto.getHouseNo() == null){
            logger.info("执行queryHouseDetailByHno异常.参数错误");
            return new RpcResponseDTO<HouseRelationDetailBO>().buildParamErrorResponse();
        }

        LeaseHouseRelationPO leaseHouseRelationPO = relationDao.queryRelationDetailByHno(houseDto.getHouseNo());

        if (leaseHouseRelationPO == null){
            logger.info("----------执行queryHouseRelationDetailByHno完成,返回结果为null.houseDto = {}", JacksonObjectUtils.jacksonObjectToSerializable(houseDto));
            return new RpcResponseDTO<HouseRelationDetailBO>().buildFailResponse();
        }

        HouseRelationDetailBO relationDetailBO = new HouseRelationDetailBO();
        BeanUtils.copyProperties(leaseHouseRelationPO,relationDetailBO);

        return new RpcResponseDTO<HouseRelationDetailBO>().buildSuccessResponse(relationDetailBO);
    }

    @Override
    public RpcResponseDTO<List<HouseRelationDetailBO>> queryHouseRelationDetailList(HouseDto houseDto) {

        if (houseDto == null || houseDto.getUid() == null){
            logger.info("执行queryHouseDetailByHno异常.参数错误");
            return new RpcResponseDTO<List<HouseRelationDetailBO>>().buildParamErrorResponse();
        }

        List<LeaseHouseRelationPO> leaseHouseRelationPOS = relationDao.queryRelationList(houseDto.getUid());

        if (CollectionUtils.isEmpty(leaseHouseRelationPOS)){
            logger.info("----------执行queryHouse完成,返回结果为null.houseDto = {}", JacksonObjectUtils.jacksonObjectToSerializable(houseDto));
            return new RpcResponseDTO<List<HouseRelationDetailBO>>().buildFailResponse();
        }

        List<HouseRelationDetailBO> list = buildHouseRelationList(leaseHouseRelationPOS);

        return new RpcResponseDTO<List<HouseRelationDetailBO>>().buildSuccessResponse(list);
    }
}
