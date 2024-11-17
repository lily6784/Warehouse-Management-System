package com.warehouse.demo.controller;

import com.warehouse.demo.po.CustomerPo;
import com.warehouse.demo.po.UsersPo;
import com.warehouse.demo.service.CustomerService;
import com.warehouse.demo.service.UsersService;
import com.warehouse.demo.util.WebResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //查看用户信息
    @ApiOperation(value = "查询顾客（支持模糊查询）" , notes = "查询顾客（支持模糊查询）" , httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "query", dataType = "String", value = "用户id", example = "1"),
            @ApiImplicitParam(name = "name", paramType = "query", dataType = "String", value = "姓名", example = "1"),
            @ApiImplicitParam(name = "email", paramType = "query", dataType = "String", value = "email", example = "1"),
    })
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public WebResponse<List<CustomerPo>> select(@RequestParam(required = false) String id,
                                                @RequestParam(required = false) String name,
                                                @RequestParam(required = false) String email) {
        try {
            List<CustomerPo> list = customerService.select(id,name,email);
            return new WebResponse<List<CustomerPo>>().success(list);
        } catch (Exception e) {
            return new WebResponse<List<CustomerPo>>().failure(e.getMessage());
        }
    }
}
