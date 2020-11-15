package com.demo.empdept.controller;

import com.demo.empdept.config.RabbitMQConfig;
import com.demo.empdept.entity.Order;
import com.demo.empdept.model.ResultMessage;
import com.demo.empdept.service.OrderService;
import com.demo.empdept.service.RedisService;
import com.demo.empdept.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecKillController {
    private Logger logger = LoggerFactory.getLogger(SecKillController.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RedisService redisService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private StockService stockService;


    @RequestMapping(name="/sec", method= RequestMethod.POST)
    public ResultMessage secKillMqRedis(@RequestParam("stockName") String stockName,
                                        @RequestParam("userName") String userName){
        ResultMessage msg = new ResultMessage();

        // Get the value from redis, if the redis is break-up
        long descResult = redisService.decrBy("watch");
        if(descResult >= 0){
            logger.info("user {} is now get the watch");
            // send the msg to message queue
            rabbitTemplate.convertAndSend(
                    RabbitMQConfig.STORY_EXCHANGE,
                    RabbitMQConfig.STORY_ROUTING_KEY,
                    stockName
            );

            // create the order obj and save to db
            Order order = new Order();
            order.setProdName(stockName);
            order.setUserName(userName);
            rabbitTemplate.convertAndSend(
                    RabbitMQConfig.ORDER_EXCHANGE,
                    RabbitMQConfig.ORDER_ROUTING_KEY,
                    order
            );

            msg.setErrCode(100);
            msg.setErrMsg("秒殺成功！");
        }else{
            logger.info("");

            msg.setErrCode(101);
            msg.setErrMsg("秒殺失敗！");

        }
        // if the method call failed, this will

        return msg;
    }
}
