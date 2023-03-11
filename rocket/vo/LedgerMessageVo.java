package com.pansoft.ssf.founder.rocket.vo;

import java.util.UUID;

/**
 * @author:liushuanxgain
 * @date : 2023/3/2 20:52
 * @description : description
 */
public class LedgerMessageVo {
    private final String uuid = UUID.randomUUID().toString();

    private String packageName ;
    private String serviceKind ;


    public String getUuid() {
        return uuid;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getServiceKind() {
        return serviceKind;
    }

    public void setServiceKind(String serviceKind) {
        this.serviceKind = serviceKind;
    }



    @Override
    public String toString() {
        return "LedgerMessageVo{" +
                "uuid='" + uuid + '\'' +
                ", packageName='" + packageName + '\'' +
                ", serviceKind='" + serviceKind + '\'' +
                '}';
    }
}
