package leave.service;

import leave.interfaces.ISignRecordService;
import leave.model.object.SignRecord;
import leave.repository.SignRecordRepository;
import org.springframework.stereotype.Service;

/**
 * Created by 白嘿嘿黑 on 2018/3/28.
 */
@Service
public class SignRecordService implements ISignRecordService{
    private final SignRecordRepository signRecordRepository;

    public SignRecordService(SignRecordRepository signRecordRepository) {
        this.signRecordRepository = signRecordRepository;
    }

    @Override
    public void insert(SignRecord signRecord) {
        signRecordRepository.insert(signRecord);
        System.out.println("添加完成");
    }
}
