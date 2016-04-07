package com.dreamnight.mq.rocketmq;

import com.alibaba.rocketmq.client.producer.MQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.excalibur.data.mq.rocketmq.producer.RocketMQProducerBuilder;

public class RocketMqProducer {
	
	public static void main(String[] args) throws Exception {
		RocketMQProducerBuilder builder = new RocketMQProducerBuilder("10.3.254.40:9876;10.3.254.41:9876", "USERLOG");
		MQProducer producer = builder.build();
		
		Message msg = new Message("USERLOG",// topic
                "LOGIN",// tag
                "logintest1111",// key
                "{\"addition\":\"哈哈\",\"client\":99,\"comment\":\"测试\",\"createTime\":1458800464337,\"ip\":134744072,\"userid\":100011}".getBytes());// body
        SendResult result = producer.send(msg);
        System.out.println(result);
		
//		Message msg = new Message("PushTopic", "push", "1", "Just for test.".getBytes());
//
//		SendResult result = producer.send(msg);
//		System.out.println("id:" + result.getMsgId() + " result:" + result.getSendStatus());
//
//		msg = new Message("PushTopic", "push", "2", "Just for test.".getBytes());
//
//		result = producer.send(msg);
//		System.out.println("id:" + result.getMsgId() + " result:" + result.getSendStatus());
//
//		msg = new Message("PullTopic", "pull", "1", "Just for test.".getBytes());
//
//		result = producer.send(msg);
//		System.out.println("id:" + result.getMsgId() + " result:" + result.getSendStatus());
		
		producer.shutdown();
		
	}

}
