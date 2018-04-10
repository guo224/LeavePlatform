package leave.web.leave.web.controller;


import leave.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 白嘿嘿黑 on 2018/4/10.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    final private Logger  logger = LoggerFactory.getLogger(this.getClass());
    final private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping(value ="login",method = RequestMethod.POST)
    public String login(@RequestParam ("userId")String userId,@RequestParam("passWord")String passWord){
        logger.info("账号"+userId+"密码"+passWord);
        return userService.login(userId,passWord);
    }
}
