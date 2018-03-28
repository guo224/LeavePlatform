package leave.service;

import leave.interfaces.IUserService;
import leave.model.object.User;
import leave.repository.UserRepository;
import org.springframework.stereotype.Service;

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
}
