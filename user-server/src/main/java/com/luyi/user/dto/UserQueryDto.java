package com.luyi.user.dto;

import com.luyi.user.common.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: luyi
 * @Description: 用户查询Dto
 * @Date: Created in 2022-05-18
 */
@Data
public class UserQueryDto extends PageDto {
    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String name;
    /**
     * email
     */
    @ApiModelProperty(value = "邮箱地址")
    private String email;
}