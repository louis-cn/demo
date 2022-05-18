package com.luyi.user.dto;

/**
 * @Author: luyi
 * @Description: 用户状态枚举类
 * @Date: Created in 2022-05-18
 */
public enum StatusEnum {
    // 正常
    NORMAL(1),
    // 删除
    REMOVED(0);

    private int value;

    StatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}