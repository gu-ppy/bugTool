/**
 * Created by HectorPu
 * on 2022/9/7 21:37 <hr/>
 * Desc：
 **/
module HTest {
    requires com.h2database;
    requires spring.context;
    requires spring.beans;
    requires spring.jdbc;
    requires spring.core;
    requires java.sql;
    requires java.naming;
    requires java.prefs;
    requires lombok;
    requires org.slf4j;
    requires javafx.fxml;
    requires javafx.controls;

    opens top.pixcer.config to spring.core;
    opens top.pixcer to javafx.fxml;

    //     开放资源目录的访问权限（运行时）
    opens script;
    opens layout;
    exports top.pixcer.config;
    exports top.pixcer.service;
    exports top.pixcer.util;
    exports top.pixcer;
}