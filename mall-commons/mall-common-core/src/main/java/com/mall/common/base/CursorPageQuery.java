package com.mall.common.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 游标分页入参
 * @author
 * @date 2023/09/22 21:12
 */
@Data
@ApiModel("游标分页入参")
public class CursorPageQuery {

    @ApiModelProperty(value = "游标位置", example = "1")
    private Long cursor = 0L;

    @ApiModelProperty(value = "每页记录数", example = "10")
    private int pageSize = 10;

}
