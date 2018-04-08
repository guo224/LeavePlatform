package leave.repositoryImpl;

import leave.mapper.AreaMapper;
import leave.model.object.Area;
import leave.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by 白嘿嘿黑 on 2018/4/8.
 */
@Repository
public class AreaRepositorylmpl implements AreaRepository {
    @Autowired
    private final AreaMapper areaMapper;

    public AreaRepositorylmpl(AreaMapper areaMapper) {
        this.areaMapper = areaMapper;
    }

    @Override
    public Area getById(String id) {
        return null;
    }

    @Override
    public int insert(Area area) {
      return areaMapper.insert(area);
    }

    @Override
    public int update(Area entity) {
        return 0;
    }

    @Override
    public int delete(String id) {
        return 0;
    }
}
