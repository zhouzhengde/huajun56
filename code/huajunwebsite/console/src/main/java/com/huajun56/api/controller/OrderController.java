package com.huajun56.api.controller;

import com.huajun56.common.base.BaseController;
import com.huajun56.common.entity.Pager;
import com.huajun56.common.exception.ServiceException;
import com.huajun56.common.util.$;
import com.huajun56.common.util.Constants;
import com.huajun56.common.util.ExceptionCode;
import com.huajun56.crm.entity.Customer;
import com.huajun56.crm.entity.Order;
import com.huajun56.crm.service.CustomerService;
import com.huajun56.crm.service.OrderService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.Map;

/**
 * Created by Bond(China)
 *
 * @date 2017/3/18
 */
@Api(tags = {"托运订单"}, description = "提供Portals（门户站点）系统，关于托运信息查询计算服务。")
@RestController("portalsOrderController")
@RequestMapping("api/portals/order")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "latest/{number}", method = RequestMethod.GET)
    @ApiOperation("最近托运信息")
    @ApiImplicitParam(name = "number", required = true, dataType = "int", paramType = "path")
    public Map<String, Object> newestOrder(@ApiParam("需要查询的数据量，不能大于100，当输入为0时，将使用20为默认值") @PathVariable("number") Integer number) throws ServiceException {

        if ($.isNull(number) || number == 0) {
            number = 20;
        }

        if (number > 100) {
            throw new ServiceException(ExceptionCode.ILLEGAL_PARAMETER.getCode(), "请求的数据量不能超过100！");
        }


        Pager<Order> pager = new Pager<>();
        pager.setPageSize(number);

        return success(orderService.findByPager(pager).getResult());
    }

    @ApiOperation("提交托运订单")
    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> submitNewOrder(@ApiParam("订单信息") @RequestBody Order order) throws ServiceException {

        if ($.isNull(order.getFromMobile())) {
            throw new ServiceException(ExceptionCode.ILLEGAL_PARAMETER.getCode(), "请提供托运人的手机号码！");
        }

        if ($.isNull(order.getFromRealname())) {
            throw new ServiceException(ExceptionCode.ILLEGAL_PARAMETER.getCode(), "请提供托运人的真实姓名！");
        }


        Customer customer = customerService.findByMobile(order.getFromMobile());
        if ($.isNull(customer)) {
            customer = new Customer();
            customer.setMobile(order.getFromMobile());
            customer.setRealname(order.getFromRealname());
            customer.setCreateBy(Constants.PORTALS_CREATE_BY);
            customer.setCreateDate(new Date());
            customerService.add(customer);
        }

        order.setCustomerId(customer.getId());
        return success(orderService.add(order));
    }

    @ApiOperation("查询订单详情")
    @ApiImplicitParam(name = "id", required = true, dataType = "string", paramType = "path")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Map<String, Object> get(@ApiParam("订单编号") @PathVariable("id") String id) throws ServiceException {
        return success(orderService.findOne(id));
    }

}
