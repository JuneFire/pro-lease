/**
 * TODO: complete the comment
 */
package com.design.lease.collection.dao;


import com.design.lease.collection.po.LeaseHouseCollectionPO;

public interface LeaseHouseCollectionDao {
    int deleteByPrimaryKey(Long id);

    int insert(LeaseHouseCollectionPO record);

    int insertSelective(LeaseHouseCollectionPO record);

    LeaseHouseCollectionPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaseHouseCollectionPO record);

    int updateByPrimaryKey(LeaseHouseCollectionPO record);
}