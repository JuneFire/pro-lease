/**
 * TODO: complete the comment
 */
package com.design.lease.admin.dao;

import com.design.lease.admin.po.LeaseAdminPO;

public interface LeaseAdminDao {
    int deleteByPrimaryKey(Long id);

    int insert(LeaseAdminPO record);

    int insertSelective(LeaseAdminPO record);

    LeaseAdminPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaseAdminPO record);

    int updateByPrimaryKey(LeaseAdminPO record);
}