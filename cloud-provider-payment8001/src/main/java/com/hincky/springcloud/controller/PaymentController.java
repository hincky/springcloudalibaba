package com.hincky.springcloud.controller;

import com.hincky.springcloud.entities.CommonResult;
import com.hincky.springcloud.entities.Payment;
import com.hincky.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {//controller与前端交互用CommonResult类
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create") //往数据库写，写操作，用postMapping;
                                            //而且浏览器对post不友好，应该用postman进行自测，通过后再交付使用
    public CommonResult create(@RequestBody Payment payment){//若这里没有RequestBody，其他客户端调用该方法时，数据库只会新增主键，但拿不到数据
        int result = paymentService.create(payment);
//        System.out.println();//自己搞的时候可以用sout测试，到了企业就要用日志了
        log.info("插入结果"+result);
        if (result > 0 ){
            return new CommonResult(200,"插入数据成功",result);
        }else {
            return new CommonResult(400,"插入数据失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")//从数据库读，读操作，用getMapping
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        Payment payment = paymentService.getPaymentById(id);
//        System.out.println();//自己搞的时候可以用sout测试，到了企业就要用日志了
        log.info("插入结果"+payment);
        if (payment != null ){
            return new CommonResult(200,"获取数据成功",payment);
        }else {
            return new CommonResult(400,"获取数据失败，查询id"+id,null);
        }
    }

}
