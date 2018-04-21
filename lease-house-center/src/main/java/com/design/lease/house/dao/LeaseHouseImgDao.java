/**
 * TODO: complete the comment
 */
package com.design.lease.house.dao;

import com.design.lease.house.po.LeaseHouseImgPO;

public interface LeaseHouseImgDao {
    int deleteByPrimaryKey(Long id);

    int insert(LeaseHouseImgPO record);

    int insertSelective(LeaseHouseImgPO record);

    LeaseHouseImgPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaseHouseImgPO record);

    int updateByPrimaryKey(LeaseHouseImgPO record);
}