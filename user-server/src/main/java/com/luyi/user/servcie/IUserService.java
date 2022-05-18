package com.luyi.user.servcie;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.luyi.user.dto.UserQueryDto;
import com.luyi.user.entity.User;

import java.util.List;

public interface IUserService extends IService<User> {
    /**
     * 获取用户列表
     */
    List<User> getUserList();

    /**
     * 根据用户查询分页条件获取用户类别
     */
    IPage getUserList(UserQueryDto userQueryDto);

    /**
     * 通过ID获取用户
     */
    User getUser(int id);

    /**
     * 用户是否已经存在
     */
    boolean isExist(User user);

    /**
     * 用户注册
     */
    void register(User user);

    /**
     * 编辑用户
     */
    void editUser(User user);

    /**
     * 删除用户
     */
    void deleteUser(int id);

    /**
     * 批量删除用户
     */
    void deleteUserByIds(String[] ids);
}
