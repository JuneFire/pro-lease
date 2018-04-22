package com.design.lease.house.service;

import com.alibaba.dubbo.rpc.RpcException;
import com.design.lease.account.dto.HouseDto;
import com.design.lease.bo.HouseDetailBO;
import com.design.lease.bo.HouseRelationDetailBO;
import com.design.lease.enums.HouseStatusEnum;
import com.design.lease.house.bo.WsHouseDetailBO;
import com.design.lease.house.vo.HouseBodyVo;
import com.design.lease.rpc.HouseRpcService;
import com.design.lease.rpc.constant.RpcCommonConstant;
import com.design.lease.rpc.dto.RpcResponseDTO;
import com.design.lease.ws.bo.Header;
import com.design.lease.ws.dto.WsResponseMsgVO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HouseRelationService {

    private static final Logger logger = LoggerFactory.getLogger(HouseRelationService.class);

    @Autowired
    private HouseRpcService houseRpcService;

    public WsResponseMsgVO<List<HouseRelationDetailBO>> queryRelationList(Header header, HouseBodyVo body){
        HouseDto houseDto = buildHouseDTO(header);
        try {
            RpcResponseDTO<List<HouseRelationDetailBO>> resDTO = houseRpcService.queryHouseRelationDetailList(houseDto);
            if (!StringUtils.equals(resDTO.getCode(), RpcCommonConstant.SUCCESS_CODE) || resDTO.getDate() == null) {
                logger.error("查询房屋列表RpcException返回结果异常.houseDto={}",houseDto);
                return new WsResponseMsgVO<List<HouseRelationDetailBO>>().buildUnknownErrorResponse();
            }
            return new WsResponseMsgVO<List<HouseRelationDetailBO>>().buildSuccessResponse(resDTO.getDate());
        }catch (RpcException e){
            logger.error("查询房屋列表RpcException异常.houseDto={}",houseDto,e);
            return new WsResponseMsgVO<List<HouseRelationDetailBO>>().buildUnknownErrorResponse();
        }
    }


    public HouseDto buildHouseDTO(Header header){
        HouseDto houseDto = new HouseDto();
        houseDto.setUid(header.getUid());
        return houseDto;
    }

}
