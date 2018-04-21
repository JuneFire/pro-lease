package com.design.lease.trade.controller;

import com.design.lease.ws.bo.Header;
import com.design.lease.ws.dto.WsResponseMsgVO;
import com.design.lease.ws.target.Route;
import com.design.lease.ws.target.Ws;
import com.design.lease.ws.target.WsNameSpace;
import com.design.lease.trade.vo.PayBodyVo;
import org.springframework.stereotype.Component;

@Ws
@Component
@WsNameSpace("/ws/pay/v1")
public class PayController {

    @Route("/payReq")
    public WsResponseMsgVO payReq(Header head, PayBodyVo body){
        return null;
    }

    @Route("/payCon")
    public WsResponseMsgVO payConfirm(Header head,PayBodyVo body){
        return null;
    }

    @Route("/payRes")
    public WsResponseMsgVO payResult(Header head,PayBodyVo body){
        return null;
    }


}
