package com.pansoft.ssf.founder.rocket.producer.service;


import org.apache.rocketmq.common.message.Message;

import java.util.List;
import java.util.Map;

/**
 * @author : LiuShuangXian
 * @date : 2023/3/2 20:10
 * @description : description
 */
public interface ProduceService {
     void start(String mqSecret);
     void start();
     void shutdown(String mqSecret);
     void shutdown();
     String checkStatus(String mqSecret);
     Map<String,String> checkStatus();

    void sent(List<Message> messageVos, String mqSecret, String behavior, int messageCount);
}
