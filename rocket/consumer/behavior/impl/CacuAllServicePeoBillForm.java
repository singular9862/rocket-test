package com.pansoft.ssf.founder.rocket.consumer.behavior.impl;

import com.pansoft.ssf.founder.rocket.consumer.behavior.ConsumerBehavior;
import org.apache.rocketmq.common.message.Message;

/**
 * @author : LiuShuangXian
 * @date : 2023/3/10 21:18
 * @description : description
 */
public class CacuAllServicePeoBillForm implements ConsumerBehavior {
    @Override
    public void domain(Message message) {
        for (int i = 0; i < 100; i++) {
            System.out.println("业务代码");
        }
    }
}
