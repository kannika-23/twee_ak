package com.tweetapp.demo.kafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class kafkaConsumer {
    //private static final Logger LOGGER = LoggerFactory.getLogger(KafKaConsumer.class);
    public static final String TOPIC_NAME = "tweetTopic";
    public static final String GROUP_ID = "group_id";
//
//    @KafkaListener(topics = TOPIC_NAME,
//            groupId = GROUP_ID)
//    public void consume(String message){
//        // LOGGER.info(String.format("Message received -> %s", message));
//        System.out.println(message);
//    }

    @KafkaListener(topics = "deleteTopic",
            groupId = GROUP_ID)
    public void consume(Long id){
        // LOGGER.info(String.format("Message received -> %s", message));
        System.out.println(id);
    }
}
