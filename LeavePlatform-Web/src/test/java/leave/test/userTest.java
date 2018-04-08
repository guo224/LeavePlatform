package leave.test;

import leave.interfaces.IUserService;
import leave.model.object.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by 白嘿嘿黑 on 2018/3/28.
 */
public class userTest extends TestBase {
    @Autowired
    private IUserService userService;


    @Test
    public void tesi1(){
        User user = new User();
    user.setId("123457");
    user.setName("岳耀博");
    user.setStudentCode("14021740015");
    user.setSex(1);
    user.setUserType(0);
    user.setMobileNum("15662501839");
    user.setPassword("123456");
    Date date = new Date();
    user.setCreateTime(date);
    user.setUpdateTime(date);
    user.setIsDelete(0);
     userService.insert(user);

    }
}
