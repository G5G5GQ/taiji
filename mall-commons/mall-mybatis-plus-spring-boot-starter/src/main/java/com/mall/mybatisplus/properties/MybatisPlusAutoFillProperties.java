package com.mall.mybatisplus.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * mybatis-plus 配置
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "mall.mybatis-plus.auto-fill")
public class MybatisPlusAutoFillProperties {
    /**
     * 是否开启自动填充字段
     */
    private Boolean enabled = true;
    /**
     * 是否开启了插入填充
     */
    private Boolean enableInsertFill = true;
    /**
     * 是否开启了更新填充
     */
    private Boolean enableUpdateFill = true;

    /**
     * 数据库主键ID
     */
    private String idField = "id";
    /**
     * 创建时间字段名
     */
    private String createTimeField = "createTime";
    /**
     * 更新时间字段名
     */
    private String updateTimeField = "updateTime";

    /**
     * 创建人字段名
     */
    private String createByField = "createBy";
    /**
     * 修改人字段名
     */
    private String updateByField = "updateby";

    /**
     * 逻辑删除字段
     */
    private String delField = "del";
}
