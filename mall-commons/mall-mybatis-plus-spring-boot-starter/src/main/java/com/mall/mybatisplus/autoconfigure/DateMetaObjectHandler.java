package com.mall.mybatisplus.autoconfigure;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.mall.common.enums.DelEnum;
import com.mall.common.util.IdGenerator;
import com.mall.common.util.UserManager;
import com.mall.mybatisplus.properties.MybatisPlusAutoFillProperties;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * 自定义填充公共字段
 */
public class DateMetaObjectHandler implements MetaObjectHandler {
    private MybatisPlusAutoFillProperties autoFillProperties;

    public DateMetaObjectHandler(MybatisPlusAutoFillProperties autoFillProperties) {
        this.autoFillProperties = autoFillProperties;
    }

    /**
     * 是否开启了插入填充
     */
    @Override
    public boolean openInsertFill() {
        return autoFillProperties.getEnableInsertFill();
    }

    /**
     * 是否开启了更新填充
     */
    @Override
    public boolean openUpdateFill() {
        return autoFillProperties.getEnableUpdateFill();
    }

    /**
     * 插入填充，字段为空自动填充
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Object id = getFieldValByName(autoFillProperties.getIdField(), metaObject);
        Object createTime = getFieldValByName(autoFillProperties.getCreateTimeField(), metaObject);
        Object createBy = getFieldValByName(autoFillProperties.getCreateByField(), metaObject);
        if (id == null) {
            setFieldValByName(autoFillProperties.getIdField(), IdGenerator.getId(), metaObject);
        }
        if (createTime == null) {
            setFieldValByName(autoFillProperties.getCreateTimeField(), LocalDateTime.now(), metaObject);
        }
        if (createBy == null) {
            Optional.ofNullable(UserManager.getUserId()).ifPresent(e -> setFieldValByName(autoFillProperties.getCreateByField(), e, metaObject));
        }
        setFieldValByName(autoFillProperties.getDelField(), DelEnum.NORMAL.getValue(), metaObject);
    }

    /**
     * 更新填充
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        Object updateTime = getFieldValByName(autoFillProperties.getUpdateTimeField(), metaObject);
        Object updateBy = getFieldValByName(autoFillProperties.getUpdateByField(), metaObject);
        if (updateTime == null) {
            setFieldValByName(autoFillProperties.getUpdateTimeField(), LocalDateTimeUtil.now(), metaObject);
        }
        if (updateBy == null) {
            Optional.ofNullable(UserManager.getUserId()).ifPresent(e -> setFieldValByName(autoFillProperties.getUpdateByField(), e, metaObject));
        }
    }
}