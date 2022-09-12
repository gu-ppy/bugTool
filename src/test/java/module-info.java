/**
 * Created by HectorPu
 * on 2022/9/10 15:30 <hr/>
 * Desc：
 **/
module bugtool.test.base {
    requires spring.test;
    requires bugtool.base;
    requires junit;
    requires spring.core;
    requires spring.beans;
    requires spring.context;
    requires java.prefs;
    opens top.test.pixcer to spring.core;
    exports top.test.pixcer;
}