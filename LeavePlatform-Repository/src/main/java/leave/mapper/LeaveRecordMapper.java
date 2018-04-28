package leave.mapper;

import leave.baseMapper.MyBaseMapper;
import leave.model.object.LeaveRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 白嘿嘿黑 on 2018/3/28.
 */
@Mapper
public interface LeaveRecordMapper extends MyBaseMapper<LeaveRecord> {
    List<LeaveRecord> getLeaveRecord(@Param("userId")String userId);

    int revokeLeave(@Param("id") String id);

    int applyEndLeave(@Param("id") String id,@Param("status") String status);
}
