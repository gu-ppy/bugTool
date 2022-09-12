package top.pixcer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by HectorPu
 * on 2022/9/12 22:39 <hr/>
 * Desc：问题信息
 **/
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BugInfo {
    private String ID;
    private String name;
    private String Ip;
    private String product;
    private String version;
    private String logDir;
    private String context;
}
