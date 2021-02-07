package com.kafka.producer.web;

import com.alibaba.fastjson.JSON;
import com.kafka.producer.entity.MsgLog;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
public class ProducerWeb {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("/send")
    public String sendMsg () {
        MsgLog msgLog = new MsgLog(1,"消息生成",
                                 1,"消息日志",new Date()) ;
        String msg = JSON.toJSONString(msgLog) ;
        // 这里Topic如果不存在，会自动创建
        kafkaTemplate.send("demo_0207", msg);
        return msg ;
    }

}
