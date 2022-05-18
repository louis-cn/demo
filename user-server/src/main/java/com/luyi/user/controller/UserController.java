package com.luyi.user.controller;

import com.luyi.user.common.CommonException;
import com.luyi.user.common.Constants;
import com.luyi.user.common.ResponseData;
import com.luyi.user.dto.UserQueryDto;
import com.luyi.user.entity.User;
import com.luyi.user.servcie.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author: luyi
 * @Description: 用户服务API
 * @Date: Created in 2022-05-18
 */
@Api(value = "API - 用户服务")
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "分页查询用户")
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseData list(@RequestBody UserQueryDto userQueryDto) {
        return ResponseData.success(userService.getUserList(userQueryDto));
    }

    @ApiOperation(value = "注册用户")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseData register(@RequestBody @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            throw new CommonException(Constants.PARAM_ERROR);
        }
        // 校验邮箱是否被注册
        if (userService.isExist(user)) {
            throw new CommonException(Constants.USER_EXIST_ERROR);
        }
        userService.register(user);
        return ResponseData.success(Constants.SUCCESS, user);
    }

    @ApiOperation(value = "用户编辑")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public ResponseData edit(@RequestBody @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            throw new CommonException(Constants.PARAM_ERROR);
        }
        if (user == null) {
            throw new CommonException(Constants.DATA_IS_NULL);
        }
        userService.editUser(user);
        return ResponseData.success(Constants.SUCCESS, user);
    }

    @ApiOperation(value = "根据用户Id查询用户")
    @RequestMapping(value = "/get/{userId}", method = RequestMethod.GET)
    public ResponseData get(@PathVariable("userId") int id) {
        User user = userService.getUser(id);
        // 验证是否存在
        if (user == null || user.getId() == null) {
            throw new CommonException(Constants.DATA_IS_NULL);
        }
        return ResponseData.success(user);
    }

    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE)
    public ResponseData delete(@PathVariable("userId") int id) {
        User user = userService.getUser(id);
        // 验证是否存在
        if (user == null || user.getId() == null) {
            throw new CommonException(Constants.DATA_IS_NULL);
        }

        userService.deleteUser(id);
        return ResponseData.success(Constants.SUCCESS);
    }

    @ApiOperation(value = "批量删除用户")
    @RequestMapping(value = "/deleteBatch", method = RequestMethod.DELETE)
    public ResponseData deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        userService.deleteUserByIds(ids.split(","));
        return ResponseData.success(Constants.SUCCESS);
    }

}
