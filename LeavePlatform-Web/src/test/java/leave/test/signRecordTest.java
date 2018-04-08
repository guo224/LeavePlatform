package leave.test;

import leave.interfaces.ISignRecordService;
import leave.model.object.SignRecord;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by 白嘿嘿黑 on 2018/3/28.
 */
public class signRecordTest extends TestBase {

    @Autowired
    private ISignRecordService iSignRecordService;
    @Test
    public void test1(){
        SignRecord signRecord = new SignRecord();
        signRecord.setId("98072");
        signRecord.setUserId("123456");
        signRecord.setStatus(1);
        Date date = new Date();
        signRecord.setCreateTime(date);
        signRecord.setUpdateTime(date);
        signRecord.setIsDelete(0);
        iSignRecordService.insert(signRecord);
    }
}
