package leave.repository;


import leave.model.object.User;

/**
 * Created by 白嘿嘿黑 on 2018/3/28.
 */
public interface UserRepository extends BaseRepository<User>{

    User getUserByUserId(String userId);


}
