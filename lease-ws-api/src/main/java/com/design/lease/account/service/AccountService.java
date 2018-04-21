package com.design.lease.account.service;

import com.design.lease.account.bo.AccountDetailBO;
import com.design.lease.account.vo.AccountBodyVo;
import com.design.lease.bo.UserDetailBO;
import com.design.lease.template.ServiceTemplate;
import com.design.lease.ws.bo.Header;
import com.design.lease.ws.dto.WsResponseMsgVO;
import com.design.lease.house.dto.AccountHouseDTO;
import com.design.lease.house.service.AccountHouseRpcService;
import com.design.lease.rpc.dto.RpcResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("accountService")
public class AccountService extends ServiceTemplate<AccountBodyVo,UserDetailBO,AccountDetailBO>{

    @Autowired
    private AccountHouseRpcService accountHouseRpcService;

    @Override
    public boolean checkParam(AccountBodyVo accountBodyVo) {
        return accountBodyVo.getUid() == null;
    }

    @Override
    public RpcResponseDTO<UserDetailBO> service(Header header,AccountBodyVo accountBodyVo) {
        AccountHouseDTO accountHouseDTO = new AccountHouseDTO();
        accountHouseDTO.setUid(accountBodyVo.getUid());
        return accountHouseRpcService.queryUserDetailByUid(accountHouseDTO);
    }

    @Override
    public WsResponseMsgVO<AccountDetailBO> success(UserDetailBO userDetailBO) {
        AccountDetailBO accountDetailBO = new AccountDetailBO();
        BeanUtils.copyProperties(userDetailBO,accountDetailBO);
        return new WsResponseMsgVO<AccountDetailBO>().buildSuccessResponse(accountDetailBO);
    }

}
