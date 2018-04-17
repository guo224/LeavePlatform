package leave.repositoryImpl;

import leave.mapper.LeaveRecordMapper;
import leave.model.object.LeaveRecord;
import leave.repository.LeaveRecordRepository;
import org.springframework.stereotype.Repository;

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
    public int update(LeaveRecord entity) {
        return 0;
    }

    @Override
    public int delete(String id) {
        return 0;
    }
}
