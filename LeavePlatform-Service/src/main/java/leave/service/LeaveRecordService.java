package leave.service;

import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.StringUtils;
import leave.interfaces.ILeaveRecordService;
import leave.interfaces.IUserService;
import leave.model.object.LeaveRecord;
import leave.model.object.User;
import leave.repository.LeaveRecordRepository;
import leave.util.BaseReturn;
import leave.util.SerialNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 白嘿嘿黑 on 2018/3/28.
 */
@Service
public class LeaveRecordService implements ILeaveRecordService {
    private final LeaveRecordRepository leaveRecordRepository;
    @Autowired
    private IUserService iUserService;
    @Autowired
    private SerialNumberUtil serialNumberUtil;

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
            LeaveRecord leaveRecord = studentLeaveApprove(userId, startTime, endTime, submitId);
            leaveRecordRepository.insert(leaveRecord);
            return BaseReturn.getNormalMessage(null);
        } catch (ParseException e) {
            return BaseReturn.getErrorMessage("程序错误");
        }
    }

    @Override
    public String getLeaveRecord(String userId,String pageNum,String pageSize){
        if (StringUtils.isNullOrEmpty(pageNum)){
            pageNum = "1";
        }
        if(StringUtils.isNullOrEmpty(pageSize)){
            pageSize = "15";
        }
        PageInfo<LeaveRecord> leaveRecordList = leaveRecordRepository.getLeaveRecord(userId,pageNum,pageSize);
        List<LeaveRecord> list = leaveRecordList.getList();
        for(LeaveRecord leaveRecord :list){
            User user = iUserService.getUserByUserId(leaveRecord.getUserId());
            leaveRecord.setStartTime1(leaveRecord.getUpdateTime().toString());
            if(user != null ) {
                leaveRecord.setName(user.getName());
            }else{
                leaveRecord.setName("无姓名");
            }
        }

        return BaseReturn.getNormalMessage(list);
    }
    private LeaveRecord studentLeaveApprove(String userId, String startTime, String endTime, String submitId) throws ParseException {
        Date beginTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime);
        Date endTime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime);
        LeaveRecord leaveRecord = new LeaveRecord();
        leaveRecord.setId(serialNumberUtil.newSerialNumber());
        leaveRecord.setUserId(userId);
        leaveRecord.setStatus(1);
        leaveRecord.setStartTime(beginTime);
        leaveRecord.setEndTime(endTime1);
        leaveRecord.setSubmitId(submitId);
        leaveRecord.setCreateTime(new Date());
        leaveRecord.setUpdateTime(new Date());
        leaveRecord.setIsDelete(0);
        return leaveRecord;
    }
}
