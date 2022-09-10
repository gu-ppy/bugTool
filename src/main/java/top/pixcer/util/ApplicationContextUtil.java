package top.pixcer.util;

import org.springframework.context.ApplicationContext;
import top.pixcer.Main;

/**
 * Created by HectorPu
 * on 2022/9/10 19:49 <hr/>
 * Desc：
 *
 * 作为获取applicationContext 的逃生仓写法  ....
 **/
public class ApplicationContextUtil {

    private final static ThreadLocal<ApplicationContext> threadLocal = new ThreadLocal<>(){
        @Override
        protected ApplicationContext initialValue() {
            return Main.getApplicationContext();
        }
    };

    public static void setApplicationContext(ApplicationContext applicationContext) {
        if(applicationContext == null) {
            threadLocal.remove();
            return ;
        }
        threadLocal.set(applicationContext);
    }

    public static ApplicationContext getApplicationContext() {
        ApplicationContext applicationContext = threadLocal.get();
        if(applicationContext == null) {
            threadLocal.remove();
        }

        return applicationContext;
    }
}
