/**
 * TODO: complete the comment
 */
package com.design.lease.house.dao;

import com.design.lease.house.po.LeaseHouseRelationPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LeaseHouseRelationDao {
    int deleteByPrimaryKey(Long id);

    int insert(LeaseHouseRelationPO record);

    int insertSelective(LeaseHouseRelationPO record);

    LeaseHouseRelationPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaseHouseRelationPO record);

    int updateByPrimaryKey(LeaseHouseRelationPO record);

    LeaseHouseRelationPO queryRelationDetailByHno(@Param("houseNo") String houseNo);

    List<LeaseHouseRelationPO> queryRelationList(@Param("uid") Long uid);
}