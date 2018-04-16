package leave.interfaces;

import leave.model.object.User;

import java.util.List;

/**
 * Created by 白嘿嘿黑 on 2018/3/28.
 */
public interface IUserService {
    /**
    * 插入用户数据
    *   @param user 用户实体
    **/
    void insert(User user);

    User getUserByUserId(String userId);

    String login(String userId,String passwWord);

}
