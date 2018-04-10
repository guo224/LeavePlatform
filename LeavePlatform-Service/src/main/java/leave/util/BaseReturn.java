package leave.util;

import leave.model.contents.ReturnCode;
import leave.model.contents.ReturnMessage;

/**
 * Created by 白嘿嘿黑 on 2018/4/10.
 */
public class BaseReturn {
    public static String getEmptyMessage(){
        return new ReturnMessage(true, ReturnCode.NODATA, "查询为空", "").toJSONString();
    }

    public static String getNormalMessage(Object object){
        return new ReturnMessage(true, ReturnCode.SUCCESS, "查询成功", object).toJSONString();
    }

    public static String getErrorMessage(String message){
        return new ReturnMessage(false, ReturnCode.FAILED, message, "").toJSONString();

    }
}
