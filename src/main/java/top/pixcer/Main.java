package top.pixcer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
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
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getClassLoader().getResource("layout/bugTool-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        // close ..
        applicationContext.close();
    }
}