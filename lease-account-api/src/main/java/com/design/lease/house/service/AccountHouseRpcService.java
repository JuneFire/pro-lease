package com.design.lease.house.service;

import com.design.lease.bo.UserDetailBO;
import com.design.lease.house.dto.AccountHouseDTO;
import com.design.lease.rpc.dto.RpcResponseDTO;

public interface AccountHouseRpcService {

    public RpcResponseDTO<UserDetailBO> queryHouseDetail(Long id);

    public RpcResponseDTO<UserDetailBO> queryAllUserDetail();

    public RpcResponseDTO<UserDetailBO> queryUserDetailByUid(AccountHouseDTO accountHouseDTO);

}
