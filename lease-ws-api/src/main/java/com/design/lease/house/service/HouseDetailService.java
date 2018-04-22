package com.design.lease.house.service;

import com.design.lease.account.dto.HouseDto;
import com.design.lease.bo.HouseDetailBO;
import com.design.lease.house.bo.WsHouseDetailBO;
import com.design.lease.house.vo.HouseBodyVo;
import com.design.lease.rpc.HouseRpcService;
import com.design.lease.rpc.dto.RpcResponseDTO;
import com.design.lease.template.ServiceTemplate;
import com.design.lease.ws.bo.Header;
import com.design.lease.ws.dto.WsResponseMsgVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HouseDetailService extends ServiceTemplate<HouseBodyVo,HouseDetailBO,WsHouseDetailBO>{

    @Autowired
    private HouseRpcService houseRpcService;

    @Override
    public boolean checkParam(HouseBodyVo houseBodyVo) {
        return false;
    }

    @Override
    public RpcResponseDTO<HouseDetailBO> service(Header header, HouseBodyVo houseBodyVo) {
        HouseDto houseDto = new HouseDto();
        houseDto.setHouseNo(houseBodyVo.getHouseNo());
        return houseRpcService.queryHouseDetailByHno(houseDto);
    }

    @Override
    public WsResponseMsgVO<WsHouseDetailBO> success(HouseDetailBO houseDetailBO) {
        WsHouseDetailBO wsHouseDetailBO = new WsHouseDetailBO();
        BeanUtils.copyProperties(houseDetailBO,wsHouseDetailBO);
        return new WsResponseMsgVO<WsHouseDetailBO>().buildSuccessResponse(wsHouseDetailBO);
    }

}
