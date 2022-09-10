package top.test.pixcer;

import org.junit.Test;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Created by HectorPu
 * on 2022/9/10 17:57 <hr/>
 * Desc：
 **/
public class PreferencesTests {

    @Test
    public void test() throws BackingStoreException {
        Preferences preferences = Preferences.userRoot();
        for (String s : preferences.childrenNames()) {
            System.out.println(s);
        }

        System.out.println("------------------ key ");
        for (String key : preferences.keys()) {
            System.out.println(key);
        }

        System.out.println("-------- absolute path ------------");
        System.out.println(preferences.absolutePath());

        System.out.println(preferences.name());

        System.out.println(preferences.parent());

        Preferences node = preferences.node("pixcer.top");
        node.put("workspace","user.home");
        node.put("username","pqs");
        node.put("balance","一个亿");

        node.sync();

    }

    @Test
    public void readPreferences() {
        Preferences preferences = Preferences.userRoot();
        Preferences node = preferences.node("pixcer.top");
        System.out.println(node.get("username",""));

        System.out.println(node.get("wo rkspace", ""));

        System.out.println(node.get("balance", ""));
    }

    @Test
    public void removePreferences() throws BackingStoreException {
        Preferences preferences = Preferences.userRoot();
        Preferences system = preferences.node("system");
        system.sync();
        preferences.flush();
        preferences.remove("system");

        preferences.flush();

        try {
            System.out.println(preferences.node("system"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


}
