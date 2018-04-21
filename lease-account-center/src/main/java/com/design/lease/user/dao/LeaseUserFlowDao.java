/**
 * TODO: complete the comment
 */
package com.design.lease.user.dao;

import com.design.lease.user.po.LeaseUserFlowPO;

public interface LeaseUserFlowDao {
    int deleteByPrimaryKey(Long id);

    int insert(LeaseUserFlowPO record);

    int insertSelective(LeaseUserFlowPO record);

    LeaseUserFlowPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaseUserFlowPO record);

    int updateByPrimaryKey(LeaseUserFlowPO record);
}