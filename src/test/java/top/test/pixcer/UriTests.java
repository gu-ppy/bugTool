package top.test.pixcer;

import org.junit.Test;

import java.net.URI;
import java.nio.file.Paths;

/**
 * Created by HectorPu
 * on 2022/9/10 15:28 <hr/>
 * Desc：
 **/
public class UriTests {
    @Test
    public void test() {
        URI uri = Paths.get("C:\\\\Data\\\\WorkSpace\\\\IdeaProjects\\\\H\\\\workspace")
                .toUri();

        System.out.println("schema: " + uri.getScheme());
        System.out.println("schemaSpecifPart: " + uri.getSchemeSpecificPart());
        System.out.println("raw: " + uri.getRawFragment());
        System.out.println("raw path: " + uri.getRawPath());
        System.out.println("path: " + uri.getPath());
    }
}
