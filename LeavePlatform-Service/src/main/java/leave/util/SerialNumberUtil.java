package leave.util;

import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by lizekun on 2018/2/22.
 *
 * @author lizekun
 */
@Service
public class SerialNumberUtil {
    /**
     * 生成Id
     *
     * @return String
     */
    public static String newSerialNumber() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    /**
     * 生成学号
     *
     * @param time           入学时间 yyyyMM 转学生的学号以同级生的入学时间为准
     * @param disciplineCode 系编号
     * @param classNumber    班级编号
     * @param studentNumber  学生编号
     * @return
     */
    public static String newSerialCode(String time, String disciplineCode, String classNumber, String studentNumber) {
        return time + disciplineCode + classNumber + studentNumber;
    }


}
