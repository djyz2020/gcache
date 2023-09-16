package com.gmall.gcache.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserVO extends BaseVO {

    /** 用户ID **/
    @ApiModelProperty("用户ID")
    private String id;

    /** 用户名称 **/
    @ApiModelProperty("用户名称")
    private String name;

}
