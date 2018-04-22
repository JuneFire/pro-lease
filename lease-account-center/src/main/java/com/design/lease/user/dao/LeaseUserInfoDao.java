/**
 * TODO: complete the comment
 */
package com.design.lease.user.dao;

import com.design.lease.user.po.LeaseUserInfoPO;
import org.apache.ibatis.annotations.Param;

public interface LeaseUserInfoDao {
    int deleteByPrimaryKey(Long id);

    int insert(LeaseUserInfoPO record);

    int insertSelective(LeaseUserInfoPO record);

    LeaseUserInfoPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaseUserInfoPO record);

    int updateByPrimaryKey(LeaseUserInfoPO record);

    LeaseUserInfoPO queryUserDetailByUid(@Param("uid") Long uid);
}