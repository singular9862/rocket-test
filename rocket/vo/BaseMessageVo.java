package com.pansoft.ssf.founder.rocket.vo;

import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.UnsupportedEncodingException;

/**
 * @author : LiuShuangXian
 * @date : 2023/3/3 20:15
 * @description : description
 */
public class BaseMessageVo extends Message {
  public static final String TOPIC = "PROJECT_TOPIC";
  public String tag = null;
  public Object baseMessageVo =null;



    public Message baseMessageVo() throws UnsupportedEncodingException {
        return new Message(TOPIC,tag, JSONObject.toJSONString(baseMessageVo).getBytes(RemotingHelper.DEFAULT_CHARSET));
    }

    public BaseMessageVo(String produceCode, Object baseMessageVo) {
        this.tag = produceCode;
        this.baseMessageVo = baseMessageVo;
    }
}
