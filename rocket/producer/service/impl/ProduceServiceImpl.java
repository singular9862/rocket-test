package com.pansoft.ssf.founder.rocket.producer.service.impl;

import com.pansoft.ssf.founder.rocket.constant.ProducerEnum;
import com.pansoft.ssf.founder.rocket.producer.BaseRocketProducer;
import com.pansoft.ssf.founder.rocket.producer.ProducerManager;
import com.pansoft.ssf.founder.rocket.producer.service.MessageSendService;
import com.pansoft.ssf.founder.rocket.producer.service.ProduceService;
import org.apache.rocketmq.common.message.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : LiuShuangXian
 * @date : 2023/3/2 20:10
 * @description : description
 */
public class ProduceServiceImpl implements ProduceService {
    @Override
    public void start(String mqSecret) {
        try {
            BaseRocketProducer mq = ProducerManager.getMq(mqSecret);
            mq.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void start() {
        Map<String, BaseRocketProducer> mqMap = ProducerManager.MQ_MAP;
        mqMap.keySet().forEach((mqSecret)->{
            try {
                BaseRocketProducer mq = ProducerManager.getMq(mqSecret);
                mq.start();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

    }

    @Override
    public void shutdown(String mqSecret) {
        try {
            BaseRocketProducer mq = ProducerManager.getMq(mqSecret);
            mq.shutdown();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void shutdown() {
        Map<String, BaseRocketProducer> mqMap = ProducerManager.MQ_MAP;
        mqMap.keySet().forEach((mqSecret)->{
            try {
                BaseRocketProducer mq = ProducerManager.getMq(mqSecret);
                mq.shutdown();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

    }

    @Override
    public String checkStatus(String mqSecret) {
        try {
            BaseRocketProducer mq = ProducerManager.getMq(mqSecret);
            if (mq!=null) {
                return "running";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "stop";
    }

    @Override
    public HashMap<String,String> checkStatus() {
        HashMap<String, String> returnMap = new HashMap<>();
        Map<String, BaseRocketProducer> mqMap = ProducerManager.MQ_MAP;
        mqMap.keySet().forEach((mqSecret)->{
            try {
                BaseRocketProducer mq = ProducerManager.getMq(mqSecret);
                if (mq !=null) {
                  returnMap.put(mqSecret,"running");
                }else {
                    returnMap.put(mqSecret,"stop");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return returnMap;
    }

    @Override
    public void sent(List<Message> messageVos, String mqSecret, String behavior, int messageCount) {
        try {
            BaseRocketProducer mq = ProducerManager.getMq(mqSecret);
            MessageSendService messageSendService = null;
            for (ProducerEnum value : ProducerEnum.values()) {
                if (behavior.equals(value.getMessageBehavior())) {
                    messageSendService=value.getService();
                    messageSendService.send(mq,messageVos,messageCount);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
