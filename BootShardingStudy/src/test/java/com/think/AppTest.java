package com.think;

import com.think.main.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.think.dao.OrderMapper;
import com.think.entity.TOrder;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class AppTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void test() {
        TOrder order = new TOrder();

        // 分库标识，奇数test1, 偶test0
        order.setUserId(886);

        // 分表标识，奇数 t_order_1 偶数 t_order_0
        order.setOrderId(76);
        orderMapper.insert(order);
    }

    @Test
    public void test2() {
        TOrder order = orderMapper.findById(31);
        System.out.println(order.getOrderId() + "" + order.getUserId());
    }

}
