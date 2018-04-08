package leave.service;

import leave.interfaces.ILeaveRecordService;
import leave.model.object.LeaveRecord;
import leave.repository.LeaveRecordRepository;
import org.springframework.stereotype.Service;

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
}
