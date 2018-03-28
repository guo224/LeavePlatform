package leave.baseMapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by 白嘿嘿黑 on 2018/3/28.
 */
public interface MyBaseMapper<T> extends Mapper<T>,MySqlMapper<T> {
}
