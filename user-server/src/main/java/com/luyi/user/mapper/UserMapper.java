package com.luyi.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luyi.user.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @Author: luyi
 * @Description:
 * @Date: Created in 2022-05-18
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 修改用户状态为删除状态
     */
    @Update("update user set status=0 where id=#{id}")
    public int updateUserStatus(@Param("id") int id);
}
