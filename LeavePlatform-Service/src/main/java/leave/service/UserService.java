package leave.service;

import leave.interfaces.IUserService;
import leave.model.object.User;
import leave.repository.UserRepository;
import leave.util.BaseReturn;
import leave.util.SerialNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by yyb on 2018/3/28.
 */
@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    @Autowired
    private SerialNumberUtil serialNumberUtil;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void insert(User user) {
        userRepository.insert(user);
    }
    @Override
    public void insertStudent(String userId, String name, String studentCode, String userType, String sex, String mobileNum, String passWord,String objectId){
        User user = new User();
        user.setId(serialNumberUtil.newSerialNumber());
        user.setUserId(userId);
        user.setName(name);
        user.setStudentCode(studentCode);
        user.setUserType(Integer.parseInt(userType));
        user.setSex(Integer.parseInt(sex));
        user.setMobileNum(mobileNum);
        user.setPassword(passWord);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setIsDelete(0);
        user.setObjectId(objectId);
        userRepository.insert(user);
    }
    @Override
    public User getUserByUserId(String userId) {
        User user = userRepository.getUserByUserId(userId);
        return user;
    }
    @Override
    public String login(String userId, String passWord) {
       User user = userRepository.getUserByUserId(userId);
       if(user == null){
           return BaseReturn.getEmptyMessage();
       }
       if(!user.getPassword().equals(passWord)){
           return BaseReturn.getErrorMessage("用户名密码错误");
       }
       return BaseReturn.getNormalMessage(user);
    }
    public String getAllTeacher() {
        List<User> user = userRepository.getAllTeacher();
        if(user == null||user.size() == 0 ){
            return BaseReturn.getEmptyMessage();
        }
        return BaseReturn.getNormalMessage(user);
    }
    @Override
    public String getUserById(String id){
        User user = userRepository.getUserById(id);
        if(user == null){
         return BaseReturn.getErrorMessage("id错误");
        }
        return BaseReturn.getNormalMessage(user);
    }





}
