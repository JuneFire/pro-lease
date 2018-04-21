package com.design.lease.rpc.trade;

import com.design.lease.bo.UserDetailBO;
import com.design.lease.rpc.dto.RpcResponseDTO;
import com.design.lease.trade.dto.UserTradeDTO;
import com.design.lease.trade.service.AccountTradeRpcService;
import com.design.lease.user.service.LeaseUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountTradeRpcServiceImpl implements AccountTradeRpcService{

    @Autowired
    private LeaseUserService leaseUserService;

    @Override
    public RpcResponseDTO<UserDetailBO> queryUserDetailByUid(UserTradeDTO userTradeDTO) {
        return null;
    }
}
