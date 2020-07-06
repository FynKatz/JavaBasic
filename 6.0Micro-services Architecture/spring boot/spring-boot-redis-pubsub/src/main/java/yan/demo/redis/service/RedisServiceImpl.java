package yan.demo.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import yan.demo.redis.util.JsonUtils;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * redis服务实现类
 *
 * @author yanjunhao
 * @date 2017年12月5日
 */
@Service
public class RedisServiceImpl implements IRedisService {
    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public RedisServiceImpl(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void set(final String key, final String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void set(String key, String value, long expire) {
        redisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
    }

    @Override
    public String get(String key) {
        if (redisTemplate.hasKey(key)) {
            return redisTemplate.opsForValue().get(key);
        }
        return null;
    }

    @Override
    public void expire(String key, long expire) {
        redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    @Override
    public <T> void setList(String key, List<T> list) {
        this.set(key, JsonUtils.object2Json(list));
    }

    @Override
    public <T> List<T> getList(String key, Class<T> clz) {
        try {
            return JsonUtils.json2List(this.get(key), clz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void sendTopic(String channel, String message) {
        redisTemplate.convertAndSend(channel, message);
    }

    @Override
    public void remove(String key) {
        redisTemplate.delete(key);
    }
}
