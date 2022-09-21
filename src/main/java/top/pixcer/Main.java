package top.pixcer;

import cn.hutool.extra.ftp.Ftp;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.extra.ssh.JschUtil;
import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.pixcer.config.SpringConfig;

/**
 * Created by HectorPu
 * on ${DATE} ${TIME} <hr/>
 * Desc：
 **/
public class Main extends Application {

    private static ConfigurableApplicationContext applicationContext;

    /**
     * get applicationContext ...
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Main.applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getClassLoader().getResource("layout/navigator-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960, 680);
        stage.setTitle("BUG TOOL");

        stage.setScene(scene);

        stage.show();
//        new Ftp();

    }

    @Override
    public void stop() throws Exception {
        super.stop();
        // close ..
        applicationContext.close();
    }
}