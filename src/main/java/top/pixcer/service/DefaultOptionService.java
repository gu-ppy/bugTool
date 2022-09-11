package top.pixcer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.pixcer.util.SystemUtil;

import java.net.URI;
import java.util.Optional;
import java.util.prefs.Preferences;

/**
 * Created by HectorPu
 * on 2022/9/10 17:25 <hr/>
 * Desc：
 **/
@Slf4j
@Service
public class DefaultOptionService implements OptionService {

    private final static String DEFAULT_WORKSPACE_KEY = "workspace";
    private final static String PREFERENCES_NODE_KEY = "pixcer.top";

    private final static String DEFAULT_WORKSPACE_LOCATION = System.getProperty("user.home") + "/bugTool";

    public DefaultOptionService() {
    }

    @Override
    public Optional<String> getOption(String key) {
        return Optional.empty();
    }

    @Override
    public void init() {
        // workspace init
        workspaceInit();
    }

    private void workspaceInit() {
        Preferences preferences = Preferences.userRoot();
        try {
            Preferences node = preferences.node(PREFERENCES_NODE_KEY);

            String workspace = node.get(DEFAULT_WORKSPACE_KEY, "");
            if (workspace.equals("")) {
                log.info("current workspace location is empty, so init workspace now !!");
                // possible  not exists ..
                String location = SystemUtil.normalWorkspacePath(DEFAULT_WORKSPACE_LOCATION);
                node.put(DEFAULT_WORKSPACE_KEY, location);
                node.sync();
                log.info("workspace init finish ,workspace is {} !!",location);
            } else {
                log.info("current workspace location is {} !!",workspace);
            }
        } catch (Exception e) {
            // pass
            // never impossible
            log.error("workspace initializing...An unknown error occurred..");
        }
//        preferences.
    }

    @Override
    public String getWorkSpace() {
        Preferences preferences = Preferences.userRoot();
        Preferences node = preferences.node("pixcer.top");
        String workSpace = node.get(DEFAULT_WORKSPACE_KEY, "");
        if (workSpace.equals("")) {
            // impossible
            throw new UnsupportedOperationException("application workspace was not init !!");
        }
        return workSpace;
    }

    @Override
    public void setWorkSpace(String value) {

        // check value is normal ..
        if (!StringUtils.hasText(value)) {
            throw new IllegalArgumentException("workSpace must not be null !!!");
        }

        // must be uri ..
        try {
            URI.create(value);
        } catch (Exception e) {
            // pass
            // illegal ..
            throw new IllegalArgumentException("workSpace must be uri !!!");
        }

        Preferences preferences = Preferences.userRoot();
        try {
            Preferences node = preferences.node("pixcer.top");
            node.put(DEFAULT_WORKSPACE_KEY, SystemUtil.normalWorkspacePath(value));
            node.sync();
        } catch (Exception e) {
            // pass
            // impossible ..
            log.error("setWorkSpace-ing...An unknown error occurred..");
        }
    }
}
