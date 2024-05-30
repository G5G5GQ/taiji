package com.mall.common.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页实体类
 * @author
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> implements Serializable {

    private static final long serialVersionUID = -275582248840137389L;

    @ApiModelProperty("总记录数")
    private Long total = 0L;

    @ApiModelProperty("总页数数")
    private Long totalPages = 0L;

    @ApiModelProperty("总页数数")
    private Long currentPage = 0L;

    @ApiModelProperty("本页数据记录")
    private List<T> rows = new ArrayList<>();
}
