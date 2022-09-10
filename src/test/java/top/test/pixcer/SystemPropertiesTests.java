package top.test.pixcer;

import org.junit.Test;
import top.pixcer.util.SystemUtil;

/**
 * Created by HectorPu
 * on 2022/9/10 17:26 <hr/>
 * Desc：
 **/
public class SystemPropertiesTests {

    @Test
    public void test() {
//        System.getProperties().forEach((key,value) -> System.out.println(key));
        String property = System.getProperty("user.home");
        System.out.println(property);

        System.out.println(SystemUtil.normalWorkspacePath(property));
    }
}
