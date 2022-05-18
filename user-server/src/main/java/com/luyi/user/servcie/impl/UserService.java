package com.luyi.user.servcie.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luyi.user.dto.StatusEnum;
import com.luyi.user.dto.UserQueryDto;
import com.luyi.user.entity.User;
import com.luyi.user.fegin.EmailFeignService;
import com.luyi.user.mapper.UserMapper;
import com.luyi.user.servcie.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author: luyi
 * @Description: 用户服务service层
 * @Date: Created in 2022-05-18
 */
@Service
@Primary
@Slf4j
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    EmailFeignService emailFeignService;

    public List<User> getUserList() {
        return this.list();
    }

    public IPage getUserList(UserQueryDto userQueryDto) {
        LambdaQueryChainWrapper<User> wrapper = this.lambdaQuery().eq(User::getStatus, StatusEnum.NORMAL.getValue());
        // 组装查询条件
        if (StringUtils.isNotEmpty(userQueryDto.getName())) {
            wrapper.like(User::getName, userQueryDto.getName());
        }
        if (StringUtils.isNotEmpty(userQueryDto.getEmail())) {
            wrapper.eq(User::getEmail, userQueryDto.getEmail());
        }
        // 默认设置为倒序查询
        wrapper.orderByDesc(User::getRegisterTime);

        return wrapper.page(userQueryDto.getPage());
    }

    public User getUser(int id) {
        return this.getById(id);
    }

    public boolean isExist(User user) {
        LambdaQueryChainWrapper<User> wrapper = this.lambdaQuery().eq(User::getEmail, user.getEmail());
        return wrapper.count() > 0 ? true : false;
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void register(User user) {
        user.setRegisterTime(new Date());
        user.setStatus(StatusEnum.NORMAL.getValue());
        this.save(user);
        try {
            //调用邮件发送服务 同步请求 异步发送邮件
            emailFeignService.sendEmailByAsync(user.getEmail());
        } catch (Exception exception) {
            log.error("邮件服务调用异常 email地址:{},异常信息：{}",user.getEmail(),exception.getMessage());
        }
    }

    @Transactional(readOnly = false)
    public void editUser(User user) {
        this.saveOrUpdate(user);
    }

    @Transactional(readOnly = false)
    public void deleteUser(int id) {
        User user = this.getById(id);
        if (user != null) {
            //逻辑删除
            userMapper.updateUserStatus(id);
        }
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteUserByIds(String[] ids) {
        for (String id : ids) {
            if(StringUtils.isEmpty(id))
                continue;
            userMapper.updateUserStatus(Integer.valueOf(id));
        }
    }
}
