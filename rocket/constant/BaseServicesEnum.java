package com.pansoft.ssf.founder.rocket.constant;

import com.pansoft.ssf.founder.rocket.consumer.behavior.ConsumerBehavior;
import com.pansoft.ssf.founder.rocket.consumer.behavior.impl.CacuAllServicePeoBillForm;

/**
 * @author : LiuShuangXian
 * @date : 2023/3/3 20:17
 * @description : description
 */
public enum BaseServicesEnum {
    LEDGER_ONLINE_BILL_FORM("LEDGER_ONLINE_BILL_FORM","线上工单台账",null),
    LEDGER_EVALUATION_BILL_FORM("LEDGER_EVALUATION_BILL_FORM","服务评价台账",new CacuAllServicePeoBillForm()),
    INDEX_SEND_MESSAGE("INDEX_SEND_MESSAGE","首页消息推送",null);
    private String servicesKind;
    private String servicesName;
    public ConsumerBehavior behaviorClazz;

    BaseServicesEnum(String servicesKind, String servicesName, ConsumerBehavior behaviorClazz) {
        this.servicesKind = servicesKind;
        this.servicesName = servicesName;
        this.behaviorClazz = behaviorClazz;
    }

    public String getServicesKind() {

        return servicesKind;
    }

    public void setServicesKind(String servicesKind) {
        this.servicesKind = servicesKind;
    }

    public String getServicesName() {
        return servicesName;
    }

    public void setServicesName(String servicesName) {
        this.servicesName = servicesName;
    }

    public ConsumerBehavior getBehaviorClazz() {
        return behaviorClazz;
    }

    public void setBehaviorClazz(ConsumerBehavior behaviorClazz) {
        this.behaviorClazz = behaviorClazz;
    }
}
