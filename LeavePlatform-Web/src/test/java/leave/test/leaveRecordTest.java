package leave.test;

import leave.interfaces.ILeaveRecordService;
import leave.model.object.LeaveRecord;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by 白嘿嘿黑 on 2018/3/28.
 */
public class leaveRecordTest extends TestBase {
    @Autowired
    private ILeaveRecordService iLeaveRecordService;
    @Test
    public void test1(){
        LeaveRecord leaveRecord = new LeaveRecord();
        leaveRecord.setId("23452");
        leaveRecord.setUserId("1234563");
        leaveRecord.setStatus(1);
        Date date = new Date();
        leaveRecord.setCreateTime(date);
        leaveRecord.setUpdateTime(date);
        leaveRecord.setIsDelete(0);
        iLeaveRecordService.insert(leaveRecord);
    }
    @Test
    public void  test2(){
        iLeaveRecordService.revokeLeave("2345");
    }
}
