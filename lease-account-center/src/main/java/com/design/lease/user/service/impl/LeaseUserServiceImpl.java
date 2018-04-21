package com.design.lease.user.service.impl;

import com.design.lease.user.dao.LeaseUserFlowDao;
import com.design.lease.user.dao.LeaseUserInfoDao;
import com.design.lease.user.service.LeaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaseUserServiceImpl implements LeaseUserService{

    @Autowired
    private LeaseUserInfoDao userInfoDao;

    @Autowired
    private LeaseUserFlowDao userFlowDao;

}
