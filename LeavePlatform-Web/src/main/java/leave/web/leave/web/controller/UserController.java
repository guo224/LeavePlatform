package leave.web.leave.web.controller;


import leave.interfaces.ILeaveRecordService;
import leave.model.object.LeaveRecord;
import leave.model.object.User;
import leave.service.UserService;
import leave.util.BaseReturn;
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
    final private ILeaveRecordService iLeaveRecordService;
    @Autowired
    public UserController(UserService userService, ILeaveRecordService iLeaveRecordService) {
        this.userService = userService;
        this.iLeaveRecordService = iLeaveRecordService;
    }
    @RequestMapping(value ="login",method = RequestMethod.POST)
    public String login(@RequestParam ("userId")String userId,@RequestParam("passWord")String passWord){
        logger.info("账号"+userId+"密码"+passWord);
        return userService.login(userId,passWord);
    }
    @RequestMapping(value = "submitLeave",method = RequestMethod.POST)
        public String submitLeave(@RequestParam("userId")String userId,@RequestParam("startTime")String startTime,@RequestParam("endTime")String endTime,@RequestParam("submitId")String submitId) {
        return iLeaveRecordService.submitLeave(userId,startTime,endTime,submitId);
    }
    @RequestMapping(value = "getAllTeacher",method = RequestMethod.POST)
    public String getAllTeacher(){
        return userService.getAllTeacher();
    }

}
