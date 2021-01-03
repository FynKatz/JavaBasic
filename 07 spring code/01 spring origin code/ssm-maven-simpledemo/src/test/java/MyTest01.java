import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * @author yyhu
 * @create 2020-12-26-19:40
 **/
public class MyTest01 {
    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("test.xml");

        Class<?> clazz;
        try {
            clazz = Class.forName("com.huyy.beans.Teacher");
            try {
                clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
