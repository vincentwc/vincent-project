package com.vincent.api;

import lombok.Data;

/**
 * @author wang_cheng
 * @desc 分页参数
 * @date 2024/6/14 16:16
 */
@Data
public class PageParam {

    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 每页显示数量
     */
    private Integer pageSize;
}
