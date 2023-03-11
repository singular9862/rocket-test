package com.pansoft.ssf.founder.rocket.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;

/**
 * @author : LiuShuangXian
 * @date : 2023/3/2 20:14
 * @description : description
 */
public class BaseRocketProducer extends DefaultMQProducer{
    private static BaseRocketProducer baseRocketProducer = null;
    private static final String MQ_KEY = "BASE_PRODUCER";
    public  String mqSecret =null;

    private BaseRocketProducer(String mqSecret){
        this.mqSecret = mqSecret;
    };

    public static synchronized BaseRocketProducer getInstance(String mqSecret){
        if (baseRocketProducer == null){
            baseRocketProducer = new BaseRocketProducer(MQ_KEY+"_"+mqSecret);
        }
        return baseRocketProducer;
    };
}
