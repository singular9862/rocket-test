package com.pansoft.ssf.founder.rocket.consumer.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.pansoft.ssf.founder.rocket.constant.BaseServicesEnum;
import com.pansoft.ssf.founder.rocket.consumer.ConsumerService;
import com.pansoft.ssf.founder.rocket.consumer.behavior.ConsumerBehavior;
import com.pansoft.ssf.founder.rocket.util.BaseGetConfigUtil;
import com.pansoft.ssf.founder.rocket.vo.MQConfigVo;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

/**
 * @author : LiuShuangXian
 * @date : 2023/3/10 21:18
 * @description : 广播且推送
 */
public class BroadcastConsumerImpl implements ConsumerService {

    @Override
    public void start(List<String> tags) throws Exception {
        MQConfigVo config = BaseGetConfigUtil.getConfig("mq.properties");
        tags.forEach((tag)->{
            DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("BASE_TOPTC_"+config.getTopic()+"_"+tag);
            consumer.setNamesrvAddr(config.getServers());
            try {
                consumer.subscribe(config.getTopic(), tag);
            } catch (MQClientException e) {
                throw new RuntimeException(e);
            }
            consumer.setMessageModel(MessageModel.BROADCASTING);
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                    msgs.forEach(System.out::println);
                    msgs.forEach((messageExt -> {
                        HashMap hashMap = null;
                        try {
                            hashMap = JSONObject.parseObject(new String(messageExt.getBody(), RemotingHelper.DEFAULT_CHARSET), HashMap.class);
                        } catch (UnsupportedEncodingException e) {
                            throw new RuntimeException(e);
                        }
                       String serviceKind = (String) hashMap.get("serviceKind");
                        if (serviceKind != null) {
                            for (BaseServicesEnum value : BaseServicesEnum.values()) {
                                if (value.getServicesKind().equals(serviceKind)) {
                                    ConsumerBehavior consumerBehavior = value.getBehaviorClazz();
                                    consumerBehavior.domain(messageExt);
                                }
                            }
                        }

                    }));
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            try {
                consumer.start();
            } catch (MQClientException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
