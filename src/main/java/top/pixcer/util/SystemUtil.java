package top.pixcer.util;

import org.springframework.util.StringUtils;

import java.nio.file.Paths;
import java.util.regex.Pattern;

/**
 * Created by HectorPu
 * on 2022/9/10 19:10 <hr/>
 * Desc：
 * 系统工具类
 **/
public class SystemUtil {
    // \\
    private final static String pattern = "\\\\";
    private final static String reversePattern = "/";

    /**
     * normal workspace path
     *
     * replace all "\\" to "/",
     * and trim leading character '/' ..
     *
     * @param path path
     * @return normal path
     */
    public static String normalWorkspacePath(String path) {
        return StringUtils.trimLeadingCharacter(path.replaceAll(pattern,reversePattern),'/');
    }
}
