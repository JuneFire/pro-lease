package com.design.lease.account.controller;

import com.design.lease.account.bo.AccountDetailBO;
import com.design.lease.account.service.AccountService;
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
    private AccountService accountService;

    @Route("/login")
    public WsResponseMsgVO<AccountDetailBO> login(Header head, AccountBodyVo body){
        WsResponseMsgVO<AccountDetailBO> wsResponseMsgVO = accountService.templateService(head,body);
        return wsResponseMsgVO;
    }

    @Route("/account")
    @NeedValidation(login = true)
    public WsResponseMsgVO account(Header header, AccountBodyVo body){
        return null;
    }


}
