package yan.demo.redis.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test Topic订阅接收器
 *
 * @author yanjunhao
 * @date 2017年12月5日
 */
public class TestReceiver {
    private Logger logger = LoggerFactory.getLogger(TestReceiver.class);

    /**
     * 用于接收订阅消息
     * @param message 消息内容
     */
    public void receiveMessage(String message) {
        logger.info("Test Received <" + message + ">");
    }
}
