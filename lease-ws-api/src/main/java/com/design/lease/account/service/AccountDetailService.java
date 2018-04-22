package com.design.lease.account.service;

import com.design.lease.account.bo.AccountDetailBO;
import com.design.lease.account.vo.AccountBodyVo;
import com.design.lease.bo.UserDetailBO;
import com.design.lease.dto.AccountDto;
import com.design.lease.dto.UserInfoDTO;
import com.design.lease.rpc.AccountRpcService;
import com.design.lease.template.ServiceTemplate;
import com.design.lease.ws.bo.Header;
import com.design.lease.ws.dto.WsResponseMsgVO;
import com.design.lease.house.dto.AccountHouseDTO;
import com.design.lease.house.service.AccountHouseRpcService;
import com.design.lease.rpc.dto.RpcResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountDetailService extends ServiceTemplate<AccountBodyVo,UserDetailBO,AccountDetailBO>{

    @Autowired
    private AccountRpcService accountRpcService;

    @Override
    public boolean checkParam(AccountBodyVo accountBodyVo) {
        return accountBodyVo.getAccountName() == null || accountBodyVo.getPassword() == null;
    }

    @Override
    public RpcResponseDTO<UserDetailBO> service(Header header,AccountBodyVo accountBodyVo) {
        UserInfoDTO userInfo = new UserInfoDTO();
        userInfo.setUid(header.getUid());
        return accountRpcService.queryUserDetailByUid(userInfo);
    }

    @Override
    public WsResponseMsgVO<AccountDetailBO> success(UserDetailBO userDetailBO) {
        AccountDetailBO accountDetailBO = new AccountDetailBO();
        BeanUtils.copyProperties(userDetailBO,accountDetailBO);
        return new WsResponseMsgVO<AccountDetailBO>().buildSuccessResponse(accountDetailBO);
    }

}
