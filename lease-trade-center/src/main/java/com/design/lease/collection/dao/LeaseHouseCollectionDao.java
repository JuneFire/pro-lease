/**
 * TODO: complete the comment
 */
package com.design.lease.collection.dao;


import com.design.lease.collection.po.LeaseHouseCollectionPO;
import com.design.lease.landlord.po.LeaseLandlordDetailPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LeaseHouseCollectionDao {
    int deleteByPrimaryKey(Long id);

    int insert(LeaseHouseCollectionPO record);

    int insertSelective(LeaseHouseCollectionPO record);

    LeaseHouseCollectionPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaseHouseCollectionPO record);

    int updateByPrimaryKey(LeaseHouseCollectionPO record);

    List<LeaseHouseCollectionPO> queryCollectionList(@Param("uid") Long uid);

    LeaseHouseCollectionPO queryCollectionDetailByOrderId(@Param("orderId") String orderId);

    LeaseHouseCollectionPO queryCollectionDetailByHouseNo(@Param("houseNo") String houseNo,@Param("uid") Long uid,@Param("status") int status);

}