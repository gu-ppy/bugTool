package top.pixcer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by HectorPu
 * on 2022/9/13 1:13 <hr/>
 * Desc：
 **/
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Ret<T> {
    public static final int OK = 0;
    public static final int ERROR = 1;
    private int code;
    private String msg;
    private T t;
    public static Ret<Object> okRet(String msg){
        return new Ret<Object>(OK, msg, null);
    }
    public static Ret<Object> errorRet(String msg){
        return new Ret<Object>(ERROR, msg, null);
    }
}
