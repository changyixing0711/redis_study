package com.xinzhi.Controller;

import com.xinzhi.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author：小常
 * @Package：com.xinzhi.Controller
 * @Project：redis_study
 * @name：OrderController
 * @Date：2023/3/6 14:48
 * @Filename：OrderController
 */
@RestController
@Slf4j
@Api(tags = "订单接口")
public class OrderController {
    @Resource
    private OrderService orderService;

    @ApiOperation("新增订单")
    @RequestMapping(value = "/order/add",method = RequestMethod.POST)
    public void addOrder(){
    orderService.addOrder();
    }

    @ApiOperation("查询订单")
    @RequestMapping(value = "/order/{keyId}",method = RequestMethod.GET)
    public String getOrderById(@PathVariable Integer keyId){
        return orderService.getOrderById(keyId);
    }
}
