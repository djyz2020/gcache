package com.gmall.gcache.controller;

import com.gmall.gcache.common.response.ServerResponseEntity;
import com.gmall.gcache.entity.UserVO;
import com.gmall.gcache.service.CaffeineCacheService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(tags = "用户服务")
public class UserController {

    private CaffeineCacheService caffeineCacheService;

    public UserController(CaffeineCacheService caffeineCacheService) {
        this.caffeineCacheService = caffeineCacheService;
    }

    @GetMapping("/queryUserList")
    @ApiOperation(value = "用户信息查询")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "userId", value = "用户ID", defaultValue = "", required = true)
    })
    public ServerResponseEntity<UserVO> queryUserList(@RequestParam("userId") String userId) {
        UserVO userVO = caffeineCacheService.queryUser(userId);
        return ServerResponseEntity.success(userVO);
    }

    @PostMapping("/updateUserList")
    @ApiOperation(value = "用户信息修改")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "用户ID", defaultValue = "", required = true),
            @ApiImplicitParam(name = "name", value = "用户名称", defaultValue = "")
    })
    public ServerResponseEntity<UserVO> updateUserList(@RequestBody UserVO userVO) {
        UserVO resultVO = caffeineCacheService.updateUser(userVO.getId(), userVO);
        return ServerResponseEntity.success(resultVO);
    }

}
