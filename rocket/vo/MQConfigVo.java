package com.pansoft.ssf.founder.rocket.vo;

/**
 * @author : LiuShuangXian
 * @date : 2023/3/3 20:59
 * @description : description
 */
public class MQConfigVo {
    public String type;
    public String consumerGroupId;
    public String producerGroupId;
    public String topic;
    public String servers;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConsumerGroupId() {
        return consumerGroupId;
    }

    public void setConsumerGroupId(String consumerGroupId) {
        this.consumerGroupId = consumerGroupId;
    }

    public String getProducerGroupId() {
        return producerGroupId;
    }

    public void setProducerGroupId(String producerGroupId) {
        this.producerGroupId = producerGroupId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getServers() {
        return servers;
    }

    public void setServers(String servers) {
        this.servers = servers;
    }

    @Override
    public String toString() {
        return "MQConfigVo{" +
                "type='" + type + '\'' +
                ", consumerGroupId='" + consumerGroupId + '\'' +
                ", producerGroupId='" + producerGroupId + '\'' +
                ", topic='" + topic + '\'' +
                ", servers='" + servers + '\'' +
                '}';
    }
}
