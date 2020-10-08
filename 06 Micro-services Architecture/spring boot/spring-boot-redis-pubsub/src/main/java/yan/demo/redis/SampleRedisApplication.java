package yan.demo.redis;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 * @author yanjunhao
 * @date 2017年12月5日
 */
@SpringBootApplication
@ComponentScan
public class SampleRedisApplication {

    public static void main(String[] args) throws Exception {
        // Close the context so it doesn't stay awake listening for redis
        SpringApplication.run(SampleRedisApplication.class, args);
    }

}
