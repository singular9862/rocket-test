package com.pansoft.ssf.founder.rocket.constant;

/**
 * @author : LiuShuangXian
 * @date : 2023/3/3 20:56
 * @description : description
 */
public enum ProduceEnum {
    SERVICE_REQUEST_PRODUCE("SERVICE_REQUEST_PRODUCE","工单请求生产者"),
    SERVICE_DOWN_PRODUCE("SERVICE_DOWN_PRODUCE","处理结束生产者"),
    SINGULAR_TEST_PRODUCE("SINGULAR_TEST_PRODUCE","测试生产者");

    private String produceName;
    private String produceCode;

    ProduceEnum(String produceCode, String produceName) {
        this.produceName = produceName;
        this.produceCode = produceCode;
    }

    public String getProduceName() {
        return produceName;
    }

    public void setProduceName(String produceName) {
        this.produceName = produceName;
    }

    public String getProduceCode() {
        return produceCode;
    }

    public void setProduceCode(String produceCode) {
        this.produceCode = produceCode;
    }
}
