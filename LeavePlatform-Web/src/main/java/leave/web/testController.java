package leave.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 白嘿嘿黑 on 2018/3/27.
 */
@RestController
@RequestMapping("hello")
public class testController {
    @RequestMapping(value = "/say",method = RequestMethod.GET)
    public String say(){
        return "SpringBoot HelloWord!";
    }
    @GetMapping("/helloword")
    public String helloword(){
        return "helloword";

    }
}
