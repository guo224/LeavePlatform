package leave.model.object;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by 白嘿嘿黑 on 2018/3/28.
 */
@Table(name = "leaverecord")
public class LeaveRecord {
    /**
     * 主键
     */
    @Id
    private String id;
    /**
     *用户id
     */
    private String userId;
    /**
     *状态
     */
    private Integer status;
    /**
     *创建时间
     */
    private Date createTime;
    /**
     *更新时间
     */
    private Date updateTime;
    /**
     *是否删除
     */
    private Integer isDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
