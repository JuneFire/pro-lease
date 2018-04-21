package com.design.lease.account.controller;

import com.design.lease.account.vo.UserBodyVo;
import com.design.lease.ws.bo.Header;
import com.design.lease.ws.dto.WsResponseMsgVO;
import com.design.lease.ws.target.Route;
import com.design.lease.ws.target.Ws;
import com.design.lease.ws.target.WsNameSpace;
import org.springframework.stereotype.Component;

@Ws
@Component
@WsNameSpace("/ws/user/v1")
public class UserController {

    @Route("/queryUser")
    public WsResponseMsgVO queryUser(Header head, UserBodyVo body){
        return null;
    }



}
