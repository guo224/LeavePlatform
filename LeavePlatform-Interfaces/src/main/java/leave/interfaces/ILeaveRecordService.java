package leave.interfaces;

import leave.model.object.LeaveRecord;

/**
 * Created by 白嘿嘿黑 on 2018/3/28.
 */
public interface ILeaveRecordService {
    /**
     * 插入用户数据
     *  @param leaveRecord 请假用户实体
     **/
    void insert(LeaveRecord leaveRecord);
}
                                                  