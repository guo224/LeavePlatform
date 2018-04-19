package leave.repository;

import com.github.pagehelper.PageInfo;
import leave.model.object.LeaveRecord;

/**
 * Created by 白嘿嘿黑 on 2018/3/28.
 */
public interface LeaveRecordRepository extends BaseRepository<LeaveRecord> {

    PageInfo<LeaveRecord> getLeaveRecord(String userId, String pageNum, String pageSize);
}
