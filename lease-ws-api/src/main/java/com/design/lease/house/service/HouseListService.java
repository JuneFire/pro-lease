package com.design.lease.house.service;

import com.alibaba.dubbo.rpc.RpcException;
import com.design.lease.account.dto.HouseDto;
import com.design.lease.bo.HouseDetailBO;
import com.design.lease.enums.HouseStatusEnum;
import com.design.lease.house.bo.WsHouseDetailBO;
import com.design.lease.house.vo.HouseBodyVo;
import com.design.lease.rpc.HouseRpcService;
import com.design.lease.rpc.constant.RpcCommonConstant;
import com.design.lease.rpc.dto.RpcResponseDTO;
import com.design.lease.ws.bo.Header;
import com.design.lease.ws.dto.WsResponseMsgVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HouseListService {

    private static final Logger logger = LoggerFactory.getLogger(HouseListService.class);

    @Autowired
    private HouseRpcService houseRpcService;

    public WsResponseMsgVO<List<WsHouseDetailBO>> queryHouseList(Header head, HouseBodyVo body){
        HouseDto houseDto = buildHouseDTO(body);
        try {
            RpcResponseDTO<List<HouseDetailBO>> resDTO = houseRpcService.queryHouse(houseDto);
            if (!StringUtils.equals(resDTO.getCode(), RpcCommonConstant.SUCCESS_CODE) || resDTO.getDate() == null) {
                logger.error("查询房屋列表RpcException返回结果异常.houseDto={}",houseDto);
                return new WsResponseMsgVO<List<WsHouseDetailBO>().buildUnknownErrorResponse();
            }
            List<WsHouseDetailBO> wsHouseDetailBOS = this.buildWsHouseDetail(resDTO.getDate());
            return new WsResponseMsgVO<List<WsHouseDetailBO>>().buildSuccessResponse(wsHouseDetailBOS);
        } catch (RpcException e){
            logger.error("查询房屋列表RpcException异常.houseDto={}",houseDto,e);
            return new WsResponseMsgVO<List<WsHouseDetailBO>>().buildUnknownErrorResponse();
        }
    }

    public List<WsHouseDetailBO> buildWsHouseDetail(List<HouseDetailBO> houseDetailBOS){
        List<WsHouseDetailBO> list = new ArrayList<>();
        WsHouseDetailBO wsHouseDetailBO = null;
        for(HouseDetailBO houseDetailBO : houseDetailBOS){
            wsHouseDetailBO = new WsHouseDetailBO();
            BeanUtils.copyProperties(houseDetailBO,wsHouseDetailBO);
            list.add(wsHouseDetailBO);
        }
        return list;
    }

    public HouseDto buildHouseDTO(HouseBodyVo body){
        HouseDto houseDto = new HouseDto();
        if(body.getStatus() == null){
            houseDto.setStatus(HouseStatusEnum.STATUS_PUB.getCode());
        }else {
            houseDto.setStatus(body.getStatus());
        }
        houseDto.setHouseName(body.getHouseName());
        houseDto.setHouseNo(body.getHouseNo());
        return houseDto;
    }

}
