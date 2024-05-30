package com.mall.common.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -1344985274358664283L;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    @ApiModelProperty("创建人")
    private Long createBy;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    @ApiModelProperty("创建人")
    private Long updateBy;

    @TableLogic(value = "0", delval = "1")
    @TableField(value = "del", fill = FieldFill.INSERT)
    @ApiModelProperty("是否删除;0未删,1删除")
    private Integer del;

}
