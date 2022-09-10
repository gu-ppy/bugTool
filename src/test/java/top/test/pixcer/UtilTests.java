package top.test.pixcer;

import org.junit.Test;
import top.pixcer.util.SystemUtil;

/**
 * Created by HectorPu
 * on 2022/9/10 19:27 <hr/>
 * Desc：
 **/
public class UtilTests {
    @Test
    public void test() {
        String path = "/C:/Users/HectorPu/dataSource/bugTool";

        System.out.println(SystemUtil.normalWorkspacePath(path));
    }
}
