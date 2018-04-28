package leave.web.leave.web.controller;


import com.github.pagehelper.StringUtil;
import com.mysql.jdbc.StringUtils;
import leave.interfaces.ILeaveRecordService;
import leave.mapper.UserMapper;
import leave.model.object.User;
import leave.service.UserService;
import leave.util.BaseReturn;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * Created by 白嘿嘿黑 on 2018/4/10.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    final private Logger  logger = LoggerFactory.getLogger(this.getClass());
    final private UserService userService;
    final private ILeaveRecordService iLeaveRecordService;
    private final UserMapper userMapper;
    @Autowired
    public UserController(UserService userService, ILeaveRecordService iLeaveRecordService, UserMapper userMapper) {
        this.userService = userService;
        this.iLeaveRecordService = iLeaveRecordService;
        this.userMapper = userMapper;
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


    @RequestMapping(value = "getLeaveRecord",method = RequestMethod.POST)
    public String getLeaveRecord(@RequestParam("userId") String userId) {
        logger.info(iLeaveRecordService.getLeaveRecord(userId, null, null));
        return iLeaveRecordService.getLeaveRecord(userId, null, null);
    }
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public String addStudent(@RequestParam("userId") String userId, @RequestParam("name") String name, @RequestParam("sex") String sex, @RequestParam("mobileNum") String mobileNum, @RequestParam("userType") String userType, @RequestParam("passWord") String passWord, @RequestParam("objectId") String objectId){
          userService.insertStudent(userId,name,userId,userType,sex,mobileNum,passWord, objectId);
          return BaseReturn.getNormalMessage(null);
    }

    @RequestMapping(value = "getUserById",method = RequestMethod.POST)
    public String getUserById(@RequestParam("id")String id){
        return userService.getUserById(id);
    }



    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    public String updateUser(@RequestParam("id") String id,@RequestParam("userId") String userId,@RequestParam("name") String name,@RequestParam("sex") String sex,@RequestParam("mobileNum") String mobileNum,@RequestParam("passWord") String passWord,@RequestParam("objectId") String objectId,@RequestParam("isDelete") String isDelete){
    User user = userService.getUserByUserId(id);
        if(StringUtil.isNotEmpty(userId)) {
            user.setUserId(userId);
            user.setStudentCode(userId);
        }
        if(StringUtil.isNotEmpty(name)) {
            user.setName(name);
        }
        if(StringUtil.isNotEmpty(sex)) {
            user.setSex(Integer.parseInt(sex));
        }
        if(StringUtil.isNotEmpty(mobileNum)){
        user.setMobileNum(mobileNum);
        }
        user.setUpdateTime(new Date());
        user.setPassword(passWord);
        user.setObjectId(objectId);
        if(StringUtil.isNotEmpty(isDelete)){
        user.setIsDelete(Integer.parseInt(isDelete));
        }
        userMapper.updateByPrimaryKey(user);
        return BaseReturn.getNormalMessage("null");
    }


}
