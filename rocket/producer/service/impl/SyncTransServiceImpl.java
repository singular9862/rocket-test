package com.pansoft.ssf.founder.rocket.producer.service.impl;

import com.pansoft.ssf.founder.rocket.producer.BaseRocketProducer;
import com.pansoft.ssf.founder.rocket.producer.service.MessageSendService;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LiuShuangXian
 * @date : 2023/3/3 21:56
 * @description : 同步发送
 */
public class SyncTransServiceImpl implements MessageSendService {
    @Override
    public List<SendResult> send(BaseRocketProducer mq, List<Message> messageVos, int sync) {
        ArrayList<SendResult> sendResults = new ArrayList<>();
        SendResult sendResult = null;
        for (Message vo : messageVos) {
            try {
                sendResult = mq.send(vo);
            } catch (MQClientException | RemotingException | MQBrokerException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        sendResults.add(sendResult);
        return sendResults;
    }


}
