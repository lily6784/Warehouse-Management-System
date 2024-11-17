package com.warehouse.demo.controller;

import com.warehouse.demo.dto.UsersDto;
import com.warehouse.demo.po.UsersPo;
import com.warehouse.demo.service.UsersService;
import com.warehouse.demo.util.WebResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UsersService usersService;

    //查看用户信息
    @ApiOperation(value = "查询用户（支持模糊查询）" , notes = "查询用户（支持模糊查询）" , httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "query", dataType = "BigDecimal", value = "用户id", example = "1"),
            @ApiImplicitParam(name = "name", paramType = "query", dataType = "String", value = "姓名", example = "1"),
            @ApiImplicitParam(name = "role", paramType = "query", dataType = "String", value = "角色", example = "1"),
    })
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public WebResponse<List<UsersPo>> select(@RequestParam(required = false) BigDecimal id,
                                      @RequestParam(required = false) String name,
                                      @RequestParam(required = false) String role) {
        try {
            List<UsersPo> list = usersService.select(id,name,role);
            return new WebResponse<List<UsersPo>>().success(list);
        } catch (Exception e) {
            return new WebResponse<List<UsersPo>>().failure(e.getMessage());
        }
    }


    @ApiOperation(value = "添加用户(返回1代表成功，返回0失败)" , notes = "添加用户(返回1代表成功，返回0失败)" , httpMethod = "POST")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public WebResponse<String> insert(@RequestBody UsersPo usersPo) {
        try {
            int i = usersService.insert(usersPo);
            return new WebResponse<String>().success(String.valueOf(i));
        } catch (Exception e) {
            return new WebResponse<String>().failure(e.getMessage());
        }
    }

    @ApiOperation(value = "根据主键更改用户(返回1代表成功，返回0失败)" , notes = "根据主键更改用户(返回1代表成功，返回0失败)" , httpMethod = "POST")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public WebResponse<String> updateById(@RequestBody UsersPo usersPo) {
        try {
            int i = usersService.update(usersPo);
            return new WebResponse<String>().success(String.valueOf(i));
        } catch (Exception e) {
            return new WebResponse<String>().failure(e.getMessage());
        }
    }

    @ApiOperation(value = "根据主键批量删除用户" , notes = "根据主键批量删除用户" , httpMethod = "POST")
    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public WebResponse<Object> deleteByMulti(@RequestBody List<Long> ids) {
        try {
            int i = usersService.deleteByMulti(ids);
            return new WebResponse<Object>().success(i);
        } catch (Exception e) {
            return new WebResponse<Object>().failure(e.getMessage());
        }
    }
}
