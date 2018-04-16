package leave.service;

import leave.interfaces.IUserService;
import leave.model.object.User;
import leave.repository.UserRepository;
import leave.util.BaseReturn;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 白嘿嘿黑 on 2018/3/28.
 */
@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void insert(User user) {
        userRepository.insert(user);
    }
    @Override
    public User getUserByUserId(String userId) {
        User user = userRepository.getUserByUserId(userId);
        return user;
    }

    @Override
    public String login(String userId, String passwWord) {
       User user = userRepository.getUserByUserId(userId);
       if(user == null){
           return BaseReturn.getEmptyMessage();
       }
       if(!user.getPassword().equals(passwWord)){
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





}
