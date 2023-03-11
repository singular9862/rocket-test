package com.pansoft.ssf.founder.rocket.util;

import com.pansoft.ssf.founder.rocket.vo.MQConfigVo;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * @author : LiuShuangXian
 * @date : 2023/3/2 19:58
 * @description : description
 */
public class BaseGetConfigUtil {
    public static String  LocalUserHome = "/Users/liuzhengdong/project/hrssc/project-svn/CNPC-SSC/ssf-application/ssfServerDev/";
//    public static String  LocalUserHome = InitBootObject.LocalUserHome;
    public static MQConfigVo getConfig(String fileName) throws Exception {
        Properties properties = new Properties();
        String url = LocalUserHome+"WEB-INF"+System.getProperty("file.separator")+"classes"+System.getProperty("file.separator")
                +"BaseConfig"+System.getProperty("file.separator")+fileName;
        properties.load(Files.newInputStream(Paths.get(url)));
        MQConfigVo mqConfigVo = new MQConfigVo();
        mqConfigVo.setType(properties.getProperty("mq.type"));
        mqConfigVo.setConsumerGroupId(properties.getProperty("mq.rocketmq.consumerGroupId"));
        mqConfigVo.setProducerGroupId(properties.getProperty("mq.rocketmq.producerGroupId"));
        mqConfigVo.setTopic(properties.getProperty("mq.rocketmq.topic"));
        mqConfigVo.setServers(properties.getProperty("mq.rocketmq.servers"));

        return mqConfigVo;
    }
}
