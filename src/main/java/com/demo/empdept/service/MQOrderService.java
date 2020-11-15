package com.demo.empdept.service;

import com.demo.empdept.config.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQOrderService {

    private Logger logger = LoggerFactory.getLogger(MQOrderService.class);

    @Autowired
    private StockService stockService;

    @RabbitListener(queues = RabbitMQConfig.STORY_QUEUE)
    public void handleStock(String stockName){
        logger.info("");


    }

}
