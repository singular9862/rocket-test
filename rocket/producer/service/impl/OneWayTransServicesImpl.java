package com.pansoft.ssf.founder.rocket.producer.service.impl;

import com.pansoft.ssf.founder.rocket.producer.BaseRocketProducer;
import com.pansoft.ssf.founder.rocket.producer.service.MessageSendService;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;

/**
 * @author : LiuShuangXian
 * @date : 2023/3/3 20:28
 * @description : description
 */
public class OneWayTransServicesImpl implements MessageSendService {
    @Override
    public List<SendResult> send(BaseRocketProducer mq, List<Message> messageVos, int messageCount) {


        messageVos.forEach((messageVo) -> {
            try {
                mq.sendOneway(messageVo);
            } catch (MQClientException | RemotingException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        return null;
    }
}
