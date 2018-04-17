package leave.repositoryImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import leave.mapper.UserMapper;
import leave.model.object.User;
import leave.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 白嘿嘿黑 on 2018/3/28.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    private  final UserMapper  userMapper;

    public UserRepositoryImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getById(String id) {
        return null;
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int update(User entity) {
        return 0;
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    @Override
    public User getUserByUserId(String userId) {
      User user = userMapper.getUserByUserId(userId);
      return user;
    }

    @Override
    public PageInfo<User> searchTeacher(final String pageNum, final String pageSize){
        PageHelper.startPage(Integer.valueOf(pageNum),Integer.valueOf(pageSize));
        List<User> list = userMapper.getAllTeacher();
        if(null == list){
            return null;
        }
        return new PageInfo<>(list);
    }

    @Override
    public List<User> getAllTeacher() {
         return userMapper.getAllTeacher();
    }
}
