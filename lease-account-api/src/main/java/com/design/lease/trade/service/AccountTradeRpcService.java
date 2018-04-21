package com.design.lease.trade.service;

import com.design.lease.bo.UserDetailBO;
import com.design.lease.rpc.dto.RpcResponseDTO;
import com.design.lease.trade.dto.UserTradeDTO;

public interface AccountTradeRpcService {

    public RpcResponseDTO<UserDetailBO> queryUserDetailByUid(UserTradeDTO userTradeDTO);

}
