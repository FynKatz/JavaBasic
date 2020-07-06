package yan.demo.redis.service;

import java.util.List;

/**
 * 常用redis方法定义
 *
 * @author yanjunhao
 * @date 2017年12月4日
 */
public interface IRedisService {
    /**
     * 保存到redis
     *
     * @param key   key
     * @param value value
     */
    void set(String key, String value);

    /**
     * 保存到redis并设置失效时间
     *
     * @param key    key
     * @param value  value
     * @param expire 失效时间，单位：秒
     */
    void set(String key, String value, long expire);

    /**
     * 从redis中获取内容
     *
     * @param key key
     * @return value
     */
    String get(String key);

    /**
     * 设置redis某个key的内容失效时间
     *
     * @param key    key
     * @param expire 失效时间，单位：秒
     */
    void expire(String key, long expire);

    /**
     * 把List转成json保存到redis中
     *
     * @param key  key
     * @param list list
     */
    <T> void setList(String key, List<T> list);

    /**
     * 从redis中获取List
     *
     * @param key key
     * @param clz class
     * @return 类型列表
     */
    <T> List<T> getList(String key, Class<T> clz);

    /**
     * 发布订阅消息
     * @param channel 订阅频道名
     * @param message 要发布的消息内容
     */
    void sendTopic(String channel,String message);

    /**
     * 移除
     * @param key key
     */
    void remove(String key);
}
