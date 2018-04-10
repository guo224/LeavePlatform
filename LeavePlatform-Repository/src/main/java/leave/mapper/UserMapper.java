package leave.mapper;

import leave.baseMapper.MyBaseMapper;
import leave.model.object.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by 白嘿嘿黑 on 2018/3/28.
 */
@Mapper
public interface UserMapper extends MyBaseMapper<User> {
    User getUserByUserId(@Param("userId")String userId);

}