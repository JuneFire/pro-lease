/**
 * TODO: complete the comment
 */
package com.design.lease.house.dao;

import com.design.lease.house.po.LeaseHouseTempPO;

public interface LeaseHouseTempDao {
    int deleteByPrimaryKey(Long id);

    int insert(LeaseHouseTempPO record);

    int insertSelective(LeaseHouseTempPO record);

    LeaseHouseTempPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaseHouseTempPO record);

    int updateByPrimaryKey(LeaseHouseTempPO record);
}