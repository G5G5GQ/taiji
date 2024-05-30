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
 * 游标分页实体类
 * @author
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CursorPageResponse<T> implements Serializable {

    private static final long serialVersionUID = -5292652179193121403L;

    @ApiModelProperty("下一个游标位置")
    private Long nextCursor = null;

    @ApiModelProperty("本页数据记录")
    private List<T> rows = null;
}
