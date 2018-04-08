package leave.interfaces;


import leave.model.object.SignRecord;

/**
 * Created by 白嘿嘿黑 on 2018/3/28.
 */
public interface ISignRecordService {
    /**
     * 插入用户数据
     * @param signRecord 销假实体
     **/
    void insert(SignRecord signRecord);
}
