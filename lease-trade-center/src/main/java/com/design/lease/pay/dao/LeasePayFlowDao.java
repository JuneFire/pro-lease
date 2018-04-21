/**
 * TODO: complete the comment
 */
package com.design.lease.pay.dao;

import com.design.lease.pay.po.LeasePayFlowPO;

public interface LeasePayFlowDao {
    int deleteByPrimaryKey(Long id);

    int insert(LeasePayFlowPO record);

    int insertSelective(LeasePayFlowPO record);

    LeasePayFlowPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeasePayFlowPO record);

    int updateByPrimaryKey(LeasePayFlowPO record);
}