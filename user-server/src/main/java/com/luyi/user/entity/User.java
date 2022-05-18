package com.luyi.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: luyi
 * @Description: 用户实体类
 * @Date: Created in 2022-05-18
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "用户实体类", description = "用户实体类")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    @NotBlank(message = "昵称不能为空")
    @Length(max = 20, message = "昵称长度不能超过20个字符")
    private String name;

    /**
     * 电子邮件
     */
    @ApiModelProperty(value = "电子邮箱")
    @NotBlank(message = "电子邮箱不能为空")
    @Length(max = 60, message = "电子邮箱长度不能超过60个字符")
    @Email
    private String email;

    /**
     * 状态
     */
    @ApiModelProperty(value = "用户状态")
    private Integer status;

    /**
     * 注册时间
     */
    @ApiModelProperty(value = "注册时间")
    private Date registerTime;

}
