package com.design.lease.trade.controller;

import com.design.lease.ws.bo.Header;
import com.design.lease.ws.dto.WsResponseMsgVO;
import com.design.lease.ws.target.Route;
import com.design.lease.ws.target.Ws;
import com.design.lease.ws.target.WsNameSpace;
import com.design.lease.trade.vo.TradeBodyVo;
import org.springframework.stereotype.Component;

@Ws
@Component
@WsNameSpace("/ws/trade/v1")
public class TradeController {

    @Route("/collections")
    public WsResponseMsgVO collections(Header head, TradeBodyVo body){
        return null;
    }

    @Route("/collectionDetail")
    public WsResponseMsgVO collectionDetail(Header head,TradeBodyVo body){
        return null;
    }

    @Route("/landlordList")
    public WsResponseMsgVO landlordList(Header head,TradeBodyVo body){
        return null;
    }

    @Route("/landlordDetail")
    public WsResponseMsgVO landlordDetail(Header head,TradeBodyVo body){
        return null;
    }


}
