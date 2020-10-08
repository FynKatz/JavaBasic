package yan.demo.redis.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Other Topic订阅接收器
 *
 * @author yanjunhao
 * @date 2017年12月5日
 */
public class OtherReceiver {
    private Logger logger = LoggerFactory.getLogger(OtherReceiver.class);

    /**
     * 用于接收订阅消息
     * @param message 消息内容
     */
    public void receiveMessage(String message) {
        logger.info("Other Received <" + message + ">");
    }
}
