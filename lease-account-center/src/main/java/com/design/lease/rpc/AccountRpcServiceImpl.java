package com.design.lease.rpc;

import com.design.lease.account.dao.LeaseAccountDao;
import com.design.lease.account.po.LeaseAccountPO;
import com.design.lease.bo.UserDetailBO;
import com.design.lease.dto.AccountDto;
import com.design.lease.dto.UserInfoDTO;
import com.design.lease.rpc.dto.RpcResponseDTO;
import com.design.lease.user.dao.LeaseUserInfoDao;
import com.design.lease.user.po.LeaseUserInfoPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountRpcServiceImpl implements AccountRpcService{

    private static final Logger logger = LoggerFactory.getLogger(AccountRpcService.class);

    @Autowired
    private LeaseAccountDao accountDao;

    @Autowired
    private LeaseUserInfoDao userInfoDao;

    @Override
    public RpcResponseDTO<UserDetailBO> login(AccountDto accountDto) {

        if (accountDto == null || accountDto.getAccountName() == null || accountDto.getPassword() == null){
            logger.error("执行login方法异常,参数错误.accountDto = {}",accountDto);
            return new RpcResponseDTO<UserDetailBO>().buildParamErrorResponse();
        }

        LeaseAccountPO leaseAccountPO = accountDao.checkAccount(accountDto.getAccountName(),accountDto.getPassword());

        if (leaseAccountPO == null || leaseAccountPO.getUid() == null){
            logger.error("执行login方法错误,没有查到账户信息或者账户信息uid为null.accountDto={}",accountDto);
            return new RpcResponseDTO<UserDetailBO>().buildFailResponse();
        }

        LeaseUserInfoPO leaseUserInfoPO = userInfoDao.queryUserDetailByUid(leaseAccountPO.getUid());

        if (leaseUserInfoPO == null){
            logger.error("执行login方法错误,没有查到用户信息为null.accountDto={}",accountDto);
            return new RpcResponseDTO<UserDetailBO>().buildFailResponse();
        }

        UserDetailBO userDetailBO = new UserDetailBO();
        BeanUtils.copyProperties(leaseUserInfoPO,userDetailBO);

        return new RpcResponseDTO<UserDetailBO>().buildSuccessResponse(userDetailBO);
    }

    @Override
    public RpcResponseDTO<UserDetailBO> queryUserDetailByUid(UserInfoDTO userInfoDTO) {

        if (userInfoDTO == null || userInfoDTO.getUid() == null){
            logger.error("执行queryUserDetailByUid方法异常,参数错误.userInfoDTO = {}",userInfoDTO);
            return new RpcResponseDTO<UserDetailBO>().buildParamErrorResponse();
        }

        LeaseUserInfoPO leaseUserInfoPO = userInfoDao.queryUserDetailByUid(userInfoDTO.getUid());

        if (leaseUserInfoPO == null){
            logger.error("执行queryUserDetailByUid方法错误,没有查到用户信息为null.userInfoDTO={}",userInfoDTO);
            return new RpcResponseDTO<UserDetailBO>().buildFailResponse();
        }

        UserDetailBO userDetailBO = new UserDetailBO();
        BeanUtils.copyProperties(leaseUserInfoPO,userDetailBO);

        return new RpcResponseDTO<UserDetailBO>().buildSuccessResponse(userDetailBO);
    }

}
