package leave.repository;


import com.github.pagehelper.PageInfo;
import leave.model.object.User;

import java.util.List;

/**
 * Created by 白嘿嘿黑 on 2018/3/28.
 */
public interface UserRepository extends BaseRepository<User>{

    User getUserByUserId(String userId);

    User getUserById(String id);

    PageInfo<User> getAllUserType(String userType, String pageNum, String pageSize);

    PageInfo<User> searchTeacher(String pageNum, String pageSize);

    List<User> getAllTeacher();


}
