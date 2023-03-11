package com.pansoft.ssf.founder.rocket.producer.service.impl;

import com.pansoft.ssf.founder.rocket.producer.BaseRocketProducer;
import com.pansoft.ssf.founder.rocket.producer.service.MessageSendService;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.CountDownLatch2;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LiuShuangXian
 * @date : 2023/3/3 20:24
 * @description : description
 */
public class AsynTransServiceImpl  implements MessageSendService {
    @Override
    public List<SendResult> send(BaseRocketProducer mq, List<Message> messageVos, int messageCount)  {
        ArrayList<SendResult> sendResults = new ArrayList<>();
        mq.setRetryTimesWhenSendAsyncFailed(0);
        // 根据消息数量实例化倒计时计算器
        final CountDownLatch2 countDownLatch = new CountDownLatch2(messageCount);
        messageVos.forEach((messageVo) -> {
            try {
                mq.send(messageVo, new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        countDownLatch.countDown();
                        sendResults.add(sendResult);
                    }
                    @Override
                    public void onException(Throwable e) {
                        countDownLatch.countDown();
                        e.printStackTrace();
                    }
                });
            } catch (MQClientException | RemotingException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return sendResults;
    }

}
