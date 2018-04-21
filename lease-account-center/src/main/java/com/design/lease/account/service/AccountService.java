package com.design.lease.account.service;

import com.design.lease.account.po.LeaseAccountPO;

public interface AccountService {

    public LeaseAccountPO queryByAccount(Long id);

}
