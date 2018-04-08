package leave.service;

import leave.interfaces.IAreaService;
import leave.model.object.Area;
import leave.repository.AreaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by 白嘿嘿黑 on 2018/4/8.
 */
@Service
public class AreaService  implements IAreaService{
    private final AreaRepository areaRepository;

    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Override
    public void insert(Area area) {
        areaRepository.insert(area);
        System.out.println("添加完成");
    }
}
