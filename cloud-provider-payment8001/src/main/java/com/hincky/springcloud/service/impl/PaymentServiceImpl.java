package com.hincky.springcloud.service.impl;

import com.hincky.springcloud.dao.PaymentDao;
import com.hincky.springcloud.entities.Payment;
import com.hincky.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource           //@autowired是spring的Resource是java内部的，也可以进行依赖注入
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
