package com.pansoft.ssf.founder.rocket.consumer;

import com.pansoft.ssf.founder.rocket.constant.ConsumerEnum;
import com.pansoft.ssf.founder.rocket.constant.ProduceEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : LiuShuangXian
 * @date : 2023/3/10 20:51
 * @description : description
 */
public class ConsumerManager {
    //先判定需要什么消费模式，再选择单一消费还是并行消费
    public static void createConsumer(String consumer) throws Exception {
        List<String> tags = new ArrayList<>();
        Arrays.stream(ProduceEnum.values()).forEach((value)->{
            tags.add(value.getProduceCode());
        });
        ConsumerService consumerListener;
        for (ConsumerEnum value : ConsumerEnum.values()) {
            if (consumer.equals(value.getListener())) {
                consumerListener = value.getListenerService();
                consumerListener.start(tags);
            }
        }
    }
    public static void createConsumerAlone(String consumer,String tag) throws Exception {
        List<String> tags = new ArrayList<>();
        tags.add(tag);
        ConsumerService consumerListener;
        for (ConsumerEnum value : ConsumerEnum.values()) {
            if (consumer.equals(value.getListener())) {
                consumerListener = value.getListenerService();
                consumerListener.start(tags);
            }
        }
    }

}
