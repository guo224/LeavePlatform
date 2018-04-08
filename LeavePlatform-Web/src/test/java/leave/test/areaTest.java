package leave.test;

import leave.interfaces.IAreaService;
import leave.model.object.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 白嘿嘿黑 on 2018/4/8.
 */
public class areaTest extends TestBase {
    @Autowired
    private IAreaService iAreaService;
    @Test
    public void test1(){
        Area area = new Area();
        area.setId("234");
        area.setAreaName("12");
        area.setAreaId("23");
        iAreaService.insert(area);
        System.out.println("Over");

    }
}
