/**
 * TODO: complete the comment
 */
package com.design.lease.pay.dao;


import com.design.lease.pay.po.LeasePayDetailPO;

public interface LeasePayDetailDao {
    int deleteByPrimaryKey(Long id);

    int insert(LeasePayDetailPO record);

    int insertSelective(LeasePayDetailPO record);

    LeasePayDetailPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeasePayDetailPO record);

    int updateByPrimaryKey(LeasePayDetailPO record);
}