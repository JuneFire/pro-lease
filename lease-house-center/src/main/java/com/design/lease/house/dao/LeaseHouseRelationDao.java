/**
 * TODO: complete the comment
 */
package com.design.lease.house.dao;

import com.design.lease.house.po.LeaseHouseRelationPO;

public interface LeaseHouseRelationDao {
    int deleteByPrimaryKey(Long id);

    int insert(LeaseHouseRelationPO record);

    int insertSelective(LeaseHouseRelationPO record);

    LeaseHouseRelationPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaseHouseRelationPO record);

    int updateByPrimaryKey(LeaseHouseRelationPO record);
}