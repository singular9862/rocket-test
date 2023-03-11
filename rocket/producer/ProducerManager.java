package com.pansoft.ssf.founder.rocket.producer;

import com.google.common.collect.Maps;
import com.pansoft.pub.util.StringUtil;
import com.pansoft.ssf.founder.rocket.util.BaseGetConfigUtil;
import com.pansoft.ssf.founder.rocket.vo.MQConfigVo;

import java.util.Map;

/**
 * @author : LiuShuangXian
 * @date : 2023/3/2 20:06
 * @description : description
 */
public class ProducerManager {
    public static final Map<String, BaseRocketProducer> MQ_MAP = Maps.newHashMap();

    public ProducerManager() {
    }

    public static BaseRocketProducer getMq() throws Exception {
        return getMq("");
    }

    public static BaseRocketProducer getMq(String name) throws Exception {
        String mqKey = "BASE_PRODUCER";
        if (StringUtil.isNotBlank(name)) {
            mqKey = mqKey+"_"+name;
        }

        BaseRocketProducer mq = (BaseRocketProducer)MQ_MAP.get(mqKey);
        if (mq != null) {
            return mq;
        } else {
            synchronized(ProducerManager.class) {
                mq = (BaseRocketProducer)MQ_MAP.get(mqKey);
                if (mq == null) {
                    MQConfigVo config = BaseGetConfigUtil.getConfig("mq.properties");
                    if ("rocketmq".equals(config.getType())) {
                        mq = BaseRocketProducer.getInstance(name);
                        mq.setNamesrvAddr(config.getServers());
                        mq.setProducerGroup(config.getProducerGroupId());
                        mq.start();
                        MQ_MAP.put(mq.mqSecret, mq);
                    }
                }
                return mq;
            }
        }
    }

}
