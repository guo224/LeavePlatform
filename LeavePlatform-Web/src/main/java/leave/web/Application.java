package leave.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yyb on 2018/3/26.
 */

@SpringBootApplication

public class Application {
    public  static void main(String []args){
        SpringApplication.run(Application.class, args);
//        System.out.println("HelloWorld");
    }

}
