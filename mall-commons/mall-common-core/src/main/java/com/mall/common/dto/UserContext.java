package com.mall.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author
 * @description 用户信息
 * @date 2023/09/01 14:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserContext implements Serializable {
    private static final long serialVersionUID = 3903006277517097659L;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("用户账号")
    private String username;

    @ApiModelProperty("微信openId")
    private String openId;
}
