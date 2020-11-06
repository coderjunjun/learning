package cn.junwork.learning.jmw.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import redis.clients.jedis.Jedis;

/**
 * @author coderjunjun@gmail.com
 * @date 2019-08-17
 */
@RestController
@RequestMapping("/redis")
public class RedisTestController {

    private Jedis jedis;

    private Logger logger = LoggerFactory.getLogger("logger");


    //public RedisTestController() {
    //    logger.info("创建Controller……");
    //    jedis = new Jedis("server0");
    //    jedis.set("key", "房间里的刷卡缴费来得快");
    //}


    @RequestMapping("/test")
    public String test() {
        return jedis.get("key");
    }
}
