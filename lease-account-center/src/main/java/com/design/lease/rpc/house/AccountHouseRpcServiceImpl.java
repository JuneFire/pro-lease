package com.design.lease.rpc.house;

import com.design.lease.bo.UserDetailBO;
import com.design.lease.house.dto.AccountHouseDTO;
import com.design.lease.house.service.AccountHouseRpcService;
import com.design.lease.rpc.dto.RpcResponseDTO;
import com.design.lease.user.dao.LeaseUserInfoDao;
import com.design.lease.user.po.LeaseUserInfoPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountHouseRpcServiceImpl implements AccountHouseRpcService {

    private static final Logger logger = LoggerFactory.getLogger(AccountHouseRpcService.class);

    @Autowired
    private LeaseUserInfoDao userInfoDao;

    @Override
    public RpcResponseDTO<UserDetailBO> queryHouseDetail(Long id) {
//        LeaseUserInfoPO userInfoPO  = userInfoDao.selectByPrimaryKey(id);
//        UserDetailBO userDetailBO = new UserDetailBO();
//        userDetailBO.setAmount(userInfoPO.getAmount());
//        userDetailBO.setUid(userInfoPO.getUid());
//        userDetailBO.setEmail(userInfoPO.getEmail());
//        userDetailBO.setIphone(userInfoPO.getIphone());
//        userDetailBO.setUname(userInfoPO.getUname());
//        return new RpcResponseDTO<UserDetailBO>().buildSuccessResponse(userDetailBO);
        return null;
    }

    @Override
    public RpcResponseDTO<UserDetailBO> queryAllUserDetail() {
        return null;
    }

    @Override
    public RpcResponseDTO<UserDetailBO> queryUserDetailByUid(AccountHouseDTO accountHouseDTO)
    {
        if (accountHouseDTO == null || accountHouseDTO.getUid() == null){
            logger.error("执行接口queryUserDetailByUid接口参数错误.");
            return new RpcResponseDTO<UserDetailBO>().buildParamErrorResponse();
        }

        LeaseUserInfoPO userInfoPO  = userInfoDao.selectByPrimaryKey(accountHouseDTO.getUid());
        UserDetailBO userDetailBO = new UserDetailBO();
        userDetailBO.setAmount(userInfoPO.getAmount());
        userDetailBO.setUid(userInfoPO.getUid());
        userDetailBO.setEmail(userInfoPO.getEmail());
        userDetailBO.setIphone(userInfoPO.getIphone());
        userDetailBO.setUname(userInfoPO.getUname());
        return new RpcResponseDTO<UserDetailBO>().buildSuccessResponse(userDetailBO);
    }
}
