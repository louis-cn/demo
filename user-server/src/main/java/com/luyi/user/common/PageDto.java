package com.luyi.user.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * @Author: luyi
 * @Description: 分页Dto
 * @Date: Created in 2022-05-18
 */
@Data
public class PageDto {
    private Integer pageIndex = 1;
    private Integer pageSize = 20;

    public IPage getPage() {
        return new Page<>(pageIndex, pageSize);
    }
}
