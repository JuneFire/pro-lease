package com.design.lease.house.service;

import com.design.lease.account.dto.HouseDto;
import com.design.lease.bo.HouseRelationDetailBO;
import com.design.lease.house.vo.HouseBodyVo;
import com.design.lease.rpc.HouseRpcService;
import com.design.lease.rpc.dto.RpcResponseDTO;
import com.design.lease.template.ServiceTemplate;
import com.design.lease.ws.bo.Header;
import com.design.lease.ws.dto.WsResponseMsgVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HouseRelationDetailService extends ServiceTemplate<HouseBodyVo,HouseRelationDetailBO,HouseRelationDetailBO>{

    @Autowired
    private HouseRpcService houseRpcService;

    @Override
    public boolean checkParam(HouseBodyVo bodyVo) {
        return bodyVo.getHouseNo() == null;
    }

    @Override
    public RpcResponseDTO<HouseRelationDetailBO> service(Header header, HouseBodyVo bodyVo) {
        HouseDto houseDto = buildHouseDTO(bodyVo);
        return houseRpcService.queryHouseRelationDetailByHno(houseDto);
    }

    @Override
    public WsResponseMsgVO<HouseRelationDetailBO> success(HouseRelationDetailBO houseRelationDetailBO) {
        return new WsResponseMsgVO<HouseRelationDetailBO>().buildSuccessResponse(houseRelationDetailBO);
    }

    public HouseDto buildHouseDTO(HouseBodyVo body){
        HouseDto houseDto = new HouseDto();
        houseDto.setHouseNo(body.getHouseNo());
        return houseDto;
    }
}
