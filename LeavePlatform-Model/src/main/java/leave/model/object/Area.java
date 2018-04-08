package leave.model.object;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 白嘿嘿黑 on 2018/3/29.
 */
@Table(name = "area")
public class Area {
    /**
     * 主键
     */
    @Id
    private String id;
    /**
     * 区域Id
     */
    private String areaId;
    /**
     * 区域名字
     */
    private String areaName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
