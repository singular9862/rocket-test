package com.pansoft.ssf.founder.rocket.constant;

import com.pansoft.ssf.founder.rocket.consumer.ConsumerService;
import com.pansoft.ssf.founder.rocket.consumer.service.impl.BroadcastConsumerImpl;

/**
 * @author : LiuShuangXian
 * @date : 2023/3/3 23:37
 * @description : description
 */
public enum ConsumerEnum {

    CONSUMPTION_MESSAGE("CONSUMPTION_MESSAGE","推送且广播",new BroadcastConsumerImpl()),
    SEQUENTIAL_MESSAGE_CONSUMPTION("SEQUENTIAL_MESSAGE_CONSUMPTION","接收顺序消息",null),
    DELAY_MESSAGE_CONSUMPTION("DELAY_MESSAGE_CONSUMPTION","接收延时消息",null),
    BULK_MESSAGES_CONSUMPTION("BULK_MESSAGES_CONSUMPTION","批量消息接收",null),
    FILTER_MESSAGES_CONSUMPTION("FILTER_MESSAGES_CONSUMPTION","过滤消息接收",null)


    ;
    private String listener;
    private String listenerName;
    private ConsumerService listenerService;

    ConsumerEnum(String listener, String listenerName, ConsumerService listenerService) {
        this.listener = listener;
        this.listenerName = listenerName;
        this.listenerService = listenerService;
    }

    public String getListener() {
        return listener;
    }

    public void setListener(String listener) {
        this.listener = listener;
    }

    public String getListenerName() {
        return listenerName;
    }

    public void setListenerName(String listenerName) {
        this.listenerName = listenerName;
    }

    public ConsumerService getListenerService() {
        return listenerService;
    }

    public void setListenerService(ConsumerService listenerService) {
        this.listenerService = listenerService;
    }
}
