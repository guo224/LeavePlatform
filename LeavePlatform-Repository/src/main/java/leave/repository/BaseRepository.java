package leave.repository;

/**
 * Created by 白嘿嘿黑 on 2018/3/28.
 */
public interface BaseRepository<T> {
    /**
     * 获取单条数据
     *
     * @param id
     * @return
     */
    T getById(String id);

    /**
     * 插入数据
     *
     * @param entity
     * @return
     */
    int insert(T entity);

    /**
     * 更新数据（根据主键）
     *
     * @param entity
     * @return
     */
    int update(T entity);

    /**
     * 物理删除数据
     *
     * @return
     */
    int delete(String id);
}
