package leave.model.contents;

import com.alibaba.fastjson.JSON;

/**
 * Created by kokoro on 2017/11/30.
 *
 * @author kokoro
 */
public class ReturnMessage {
    private Boolean result;

    private Integer code;

    private String message;

    private Object returnObject;

    public ReturnMessage() {
    }

    public ReturnMessage(Boolean result, Integer code, String message, Object returnObject) {
        this.result = result;
        this.code = code;
        this.message = message;
        this.returnObject = returnObject;
    }

    public String toJSONString(){
        return JSON.toJSONString(this);
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getReturnObject() {
        return returnObject;
    }

    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }
}
