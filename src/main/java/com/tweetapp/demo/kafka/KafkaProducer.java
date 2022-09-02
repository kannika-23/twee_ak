package com.tweetapp.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    //private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    public static final String TOPIC_NAME = "tweetTopic";
    public static final String GROUP_ID = "group_id";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Long> kafkaTemplate1;

    public void sendMessage(String message){
        //  LOGGER.info(String.format("Message sent -> %s", message));
        System.out.println("in kafka");
        kafkaTemplate.send(TOPIC_NAME, message);
    }

    public void sendId(Long id){
        //  LOGGER.info(String.format("Message sent -> %s", message));
        kafkaTemplate1.send("deleteTopic", id);
    }


}
