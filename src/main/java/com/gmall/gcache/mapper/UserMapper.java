package com.gmall.gcache.mapper;

import com.gmall.gcache.entity.UserVO;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    /**
     * 用户信息查询
     *
     * @param userId
     * @return userVO
     */
    UserVO findUserById(@Param("userId") String userId);
}
