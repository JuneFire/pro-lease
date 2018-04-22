/**
 * TODO: complete the comment
 */
package com.design.lease.account.dao;

import com.design.lease.account.po.LeaseAccountPO;
import org.apache.ibatis.annotations.Param;

public interface LeaseAccountDao {
    int deleteByPrimaryKey(Long id);

    int insert(LeaseAccountPO record);

    int insertSelective(LeaseAccountPO record);

    LeaseAccountPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaseAccountPO record);

    int updateByPrimaryKey(LeaseAccountPO record);

    LeaseAccountPO checkAccount(@Param("accountName") String accountName,@Param("password") String password);
}