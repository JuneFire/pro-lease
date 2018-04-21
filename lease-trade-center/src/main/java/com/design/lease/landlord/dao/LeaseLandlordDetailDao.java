/**
 * TODO: complete the comment
 */
package com.design.lease.landlord.dao;

import com.design.lease.landlord.po.LeaseLandlordDetailPO;

public interface LeaseLandlordDetailDao {
    int deleteByPrimaryKey(Long id);

    int insert(LeaseLandlordDetailPO record);

    int insertSelective(LeaseLandlordDetailPO record);

    LeaseLandlordDetailPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaseLandlordDetailPO record);

    int updateByPrimaryKey(LeaseLandlordDetailPO record);
}