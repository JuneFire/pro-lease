package com.design.lease.house.controller;

import com.design.lease.house.service.HouseDetailService;
import com.design.lease.house.service.HouseListService;
import com.design.lease.house.service.HouseRelationDetailService;
import com.design.lease.house.service.HouseRelationService;
import com.design.lease.house.vo.HouseBodyVo;
import com.design.lease.ws.bo.Header;
import com.design.lease.ws.dto.WsResponseMsgVO;
import com.design.lease.ws.target.Route;
import com.design.lease.ws.target.Ws;
import com.design.lease.ws.target.WsNameSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Ws
@Component
@WsNameSpace("/ws/house/v1")
public class HouseController {

    @Autowired
    private HouseListService houseListService;

    @Autowired
    private HouseDetailService houseDetailService;

    @Autowired
    private HouseRelationService relationService;

    @Autowired
    private HouseRelationDetailService relationDetailService;

    @Route("/houses")
    public WsResponseMsgVO houses(Header head, HouseBodyVo body){

        return houseListService.queryHouseList(head,body);
    }

    @Route("/houseDetail")
    public WsResponseMsgVO houseDetail(Header head, HouseBodyVo body){
        return houseDetailService.templateService(head, body);
    }

    @Route("/houseRelations")
    public WsResponseMsgVO houseRelation(Header head, HouseBodyVo body){
        return relationService.queryRelationList(head,body);
    }

    @Route
    public WsResponseMsgVO houseRelationDetail(Header head, HouseBodyVo body){
        return relationDetailService.templateService(head,body);
    }

}
