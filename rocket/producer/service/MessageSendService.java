package com.pansoft.ssf.founder.rocket.producer.service;

import com.pansoft.ssf.founder.rocket.producer.BaseRocketProducer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;

/**
 * @author : LiuShuangXian
 * @date : 2023/3/3 21:17
 * @description : description
 */
public interface MessageSendService {

    List<SendResult> send(BaseRocketProducer mq, List<Message> messageVos, int messageCount) throws RemotingException, InterruptedException, MQClientException;

}
