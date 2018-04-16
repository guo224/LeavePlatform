package leave.service;

import leave.interfaces.ILeaveRecordService;
import leave.model.object.LeaveRecord;
import leave.repository.LeaveRecordRepository;
import leave.util.BaseReturn;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 白嘿嘿黑 on 2018/3/28.
 */
@Service
public class LeaveRecordService implements ILeaveRecordService {
    private final LeaveRecordRepository leaveRecordRepository;

    public LeaveRecordService(LeaveRecordRepository leaveRecordRepository) {
        this.leaveRecordRepository = leaveRecordRepository;
    }

    @Override
    public void insert(LeaveRecord leaveRecord) {
        leaveRecordRepository.insert(leaveRecord);
        System.out.println("添加完成");

    }
    @Override
    public String submitLeave(String userId,String startTime,String endTime,String submitId){
        try {
            Date beginTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime);
            Date endTime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime);
            LeaveRecord leaveRecord = new LeaveRecord();
            leaveRecord.setId("2385298");
            leaveRecord.setUserId(userId);
            leaveRecord.setStatus(1);
            leaveRecord.setStartTime(beginTime);
            leaveRecord.setEndTime(endTime1);
            leaveRecord.setSubmitId(submitId);
            leaveRecord.setCreateTime(new Date());
            leaveRecord.setUpdateTime(new Date());
            leaveRecord.setIsDelete(0);
            leaveRecordRepository.insert(leaveRecord);
            return BaseReturn.getNormalMessage(null);
        } catch (ParseException e) {
            return BaseReturn.getErrorMessage("程序错误");
        }

    }
}
