package yan.demo.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import yan.demo.redis.service.IRedisService;

import java.util.Arrays;

/**
 * 测试用
 *
 * @author yanjunhao
 * @date 2017年12月4日
 */
@RestController
@RequestMapping(value = "/demo")
public class DemoController {

    @Autowired
    private IRedisService redisService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity getBySystemId() throws Exception {
        redisService.set("hello","world222");
        redisService.expire("hello",5);
        redisService.setList("list", Arrays.asList("aaa","哈哈","ccc"));
        redisService.sendTopic("test","send message by spring-boot");
        return ResponseEntity.ok().body(redisService.getList("list",String.class));
    }
}
