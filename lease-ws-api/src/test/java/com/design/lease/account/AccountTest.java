package com.design.lease.account;

import com.design.lease.BaseTest;
import com.design.lease.account.controller.AccountController;
import com.design.lease.account.service.AccountService;
import com.design.lease.account.vo.AccountBodyVo;
import com.design.lease.ws.bo.Header;
import com.design.lease.utils.JacksonObjectUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountTest extends BaseTest{

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountController accountController;

    @Test
    public void accountTest(){
        Header header = new Header();
        AccountBodyVo bodyVo = new AccountBodyVo();
        System.out.println(JacksonObjectUtils.jacksonObjectToSerializable(accountService.templateService(header,bodyVo)));
    }

}
