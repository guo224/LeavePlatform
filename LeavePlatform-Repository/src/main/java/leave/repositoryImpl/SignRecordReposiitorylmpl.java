package leave.repositoryImpl;

import leave.mapper.SignRecordMapper;
import leave.model.object.SignRecord;
import leave.repository.SignRecordRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 白嘿嘿黑 on 2018/3/28.
 */
@Repository
public class SignRecordReposiitorylmpl implements SignRecordRepository {
    private final SignRecordMapper signRecordMapper;

    public SignRecordReposiitorylmpl(SignRecordMapper signRecordMapper) {
        this.signRecordMapper = signRecordMapper;
    }

    @Override
    public SignRecord getById(String id) {
        return null;
    }

    @Override
    public int insert(SignRecord signRecord) {
        return signRecordMapper.insert(signRecord);
    }

    @Override
    public int update(SignRecord entity) {
        return 0;
    }

    @Override
    public int delete(String id) {
        return 0;
    }
}
