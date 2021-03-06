package com.design.lease.account.controller;

import com.design.lease.account.bo.AccountDetailBO;
import com.design.lease.account.service.AccountDetailService;
import com.design.lease.account.service.AccountLoginService;
import com.design.lease.account.vo.AccountBodyVo;
import com.design.lease.ws.bo.Header;
import com.design.lease.ws.dto.WsResponseMsgVO;
import com.design.lease.ws.target.NeedValidation;
import com.design.lease.ws.target.Route;
import com.design.lease.ws.target.Ws;
import com.design.lease.ws.target.WsNameSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Ws
@Component
@WsNameSpace("/ws/account/v1")
public class AccountController {

    @Autowired
    private AccountLoginService loginService;

    @Autowired
    private AccountDetailService detailService;

    @Route("/login")
    public WsResponseMsgVO<AccountDetailBO> login(Header head, AccountBodyVo body){
        WsResponseMsgVO<AccountDetailBO> wsResponseMsgVO = loginService.templateService(head,body);
        return wsResponseMsgVO;
    }

    @Route("/queryUser")
    @NeedValidation(login = true)
    public WsResponseMsgVO account(Header header, AccountBodyVo body){
        return detailService.templateService(header,body);
    }


}
