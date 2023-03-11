package com.pansoft.ssf.founder.rocket.constant;

import com.pansoft.ssf.founder.rocket.producer.service.MessageSendService;
import com.pansoft.ssf.founder.rocket.producer.service.impl.AsynTransServiceImpl;
import com.pansoft.ssf.founder.rocket.producer.service.impl.OneWayTransServicesImpl;
import com.pansoft.ssf.founder.rocket.producer.service.impl.SyncTransServiceImpl;

/**
 * @author : LiuShuangXian
 * @date : 2023/3/3 23:37
 * @description : description
 */
public enum ProducerEnum {

    SYNCHRONOUS_TRANSMISSION("SYNCHRONOUS_TRANSMISSION","同步发送", new SyncTransServiceImpl()),
    ASYNCHRONOUS_TRANSMISSION("ASYNCHRONOUS_TRANSMISSION","异步发送",new AsynTransServiceImpl()),
    ONE_WAY_TRANSMISSION("ONE_WAY_TRANSMISSION","单向发送",new OneWayTransServicesImpl()),
    TRANSACTION_MESSAGE("TRANSACTION_MESSAGE","事务型消息",null),
    SEQUENTIAL_MESSAGE_TRANSMISSION("SEQUENTIAL_MESSAGE_TRANSMISSION","发送顺序消息",null),
    DELAY_MESSAGE_TRANSMISSION("DELAY_MESSAGE_TRANSMISSION","发送延时消息",null),
    BULK_MESSAGES_TRANSMISSION("BULK_MESSAGES_TRANSMISSION","批量消息发送",null),
    FILTER_MESSAGES_TRANSMISSION("FILTER_MESSAGES_TRANSMISSION","过滤消息发送",null)


    ;
    private String messageBehavior;
    private String behaviorName;
    private MessageSendService service;

    ProducerEnum(String messageBehavior, String behaviorName, MessageSendService service) {
        this.messageBehavior = messageBehavior;
        this.behaviorName = behaviorName;
        this.service = service;

    }

    public String getMessageBehavior() {
        return messageBehavior;
    }

    public void setMessageBehavior(String messageBehavior) {
        this.messageBehavior = messageBehavior;
    }

    public String getBehaviorName() {
        return behaviorName;
    }

    public void setBehaviorName(String behaviorName) {
        this.behaviorName = behaviorName;
    }

    public MessageSendService getService() {
        return service;
    }

    public void setService(MessageSendService service) {
        this.service = service;
    }
}
