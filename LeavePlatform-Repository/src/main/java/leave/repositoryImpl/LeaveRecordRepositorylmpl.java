package leave.repositoryImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import leave.mapper.LeaveRecordMapper;
import leave.model.object.LeaveRecord;
import leave.repository.LeaveRecordRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 白嘿嘿黑 on 2018/3/28.
 */
@Repository
public class LeaveRecordRepositorylmpl implements LeaveRecordRepository{
    private final LeaveRecordMapper leaveRecordMapper;

    public LeaveRecordRepositorylmpl(LeaveRecordMapper leaveRecordMapper) {
        this.leaveRecordMapper = leaveRecordMapper;
    }

    @Override
    public LeaveRecord getById(String id) {
        return null;
    }

    @Override
    public int insert(LeaveRecord leaveRecord) {
        return leaveRecordMapper.insert(leaveRecord);
    }

    @Override
    public PageInfo<LeaveRecord> getLeaveRecord(String userId,String pageNum,String pageSize){
        PageHelper.startPage(Integer.valueOf(pageNum),Integer.valueOf(pageSize));
        List<LeaveRecord> list = leaveRecordMapper.getLeaveRecord(userId);
        return new PageInfo<>(list);
    }

    @Override
    public boolean revokeLeave(String leaveId,String status) {
        int num = leaveRecordMapper.applyEndLeave(leaveId,status);
       return num>0;
    }
    @Override
    public boolean applyEndLeave(String leaveId, String status){
        int num = leaveRecordMapper.applyEndLeave(leaveId,status);
        return num>0;
    }
    @Override
    public int update(LeaveRecord entity) {
        return 0;
    }

    @Override
    public int delete(String id) {
        return 0;
    }
}
