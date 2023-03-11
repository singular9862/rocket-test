package com.pansoft.ssf.founder.rocket.consumer.behavior;

import org.apache.rocketmq.common.message.Message;

/**
 * @author : LiuShuangXian
 * @date : 2023/3/10 21:17
 * @description : description
 */
public interface ConsumerBehavior {
    void domain(Message message);
}
