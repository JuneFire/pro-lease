/**
 * TODO: complete the comment
 */
package com.design.lease.house.dao;

import com.design.lease.house.po.LeaseHousePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LeaseHouseDao {
    int deleteByPrimaryKey(Long id);

    int insert(LeaseHousePO record);

    int insertSelective(LeaseHousePO record);

    LeaseHousePO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaseHousePO record);

    int updateByPrimaryKey(LeaseHousePO record);

    List<LeaseHousePO>  queryHouses(@Param("status") Integer status);

    LeaseHousePO queryHouseDetailByNo(@Param("houseNo") String hno);
}