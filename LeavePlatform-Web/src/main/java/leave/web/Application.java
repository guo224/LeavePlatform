package leave.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Created by yyb on 2018/3/26.
 */
@ComponentScan("leave")
@MapperScan("leave.mapper")
@EnableAutoConfiguration
@SpringBootApplication
@SpringBootConfiguration
public class Application {
    public  static void main(String []args){
        SpringApplication.run(Application.class, args);
//        System.out.println("HelloWorld");
    }

}
