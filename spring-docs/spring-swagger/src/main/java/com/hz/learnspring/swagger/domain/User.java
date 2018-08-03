package com.hz.learnspring.swagger.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实体类
 *
 * Created by hezhao on 2018-07-10 13:35
 */
@Data @Builder @NoArgsConstructor @AllArgsConstructor
@ApiModel(value="model", description = "用户实体")
public class User {

    @ApiModelProperty(value="用户Id",name = "id")
    private Long id;

    @ApiModelProperty(value="用户名",name = "username")
    private String username;

    @ApiModelProperty(value="密码",name = "password")
    private String password;

}
