package leave.mapper;

import leave.baseMapper.MyBaseMapper;
import leave.model.object.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 白嘿嘿黑 on 2018/3/28.
 */
@Mapper
public interface UserMapper extends MyBaseMapper<User> {
    User getUserByUserId(@Param("userId")String userId);


    List<User> getAllTeacher();

    List<User> getAllStudent(@Param("userType") String userTyper);

    User getUserById(@Param("id") String id);


}
