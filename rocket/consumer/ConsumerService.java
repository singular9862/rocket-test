package com.pansoft.ssf.founder.rocket.consumer;

import java.util.List;

/**
 * @author : LiuShuangXian
 * @date : 2023/3/10 21:10
 * @description : description
 */
public interface ConsumerService {
    void start(List<String> tags) throws Exception;

}
