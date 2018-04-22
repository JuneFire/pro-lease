package com.design.lease.rpc;

import com.design.lease.bo.UserDetailBO;
import com.design.lease.dto.AccountDto;
import com.design.lease.dto.UserInfoDTO;
import com.design.lease.rpc.dto.RpcResponseDTO;

public interface AccountRpcService {

    RpcResponseDTO<UserDetailBO> login(AccountDto accountDto);

    RpcResponseDTO<UserDetailBO> queryUserDetailByUid(UserInfoDTO userInfoDTO);

}
