/**
 * TODO: complete the comment
 */
package com.design.lease.landlord.dao;

import com.design.lease.landlord.po.LeaseLandlordDetailPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LeaseLandlordDetailDao {
    int deleteByPrimaryKey(Long id);

    int insert(LeaseLandlordDetailPO record);

    int insertSelective(LeaseLandlordDetailPO record);

    LeaseLandlordDetailPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaseLandlordDetailPO record);

    int updateByPrimaryKey(LeaseLandlordDetailPO record);

    List<LeaseLandlordDetailPO> queryOrderList(@Param("uid") Long uid);

    LeaseLandlordDetailPO queryOrderDetailByOrderNo(@Param("orderId") String orderId);

    List<LeaseLandlordDetailPO> queryOrderByStatus(@Param("uid") Long uid,@Param("status") int status);

}