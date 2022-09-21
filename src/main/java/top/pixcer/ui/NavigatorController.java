package top.pixcer.ui;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by HectorPu
 * on 2022/9/17 9:17 <hr/>
 * Desc：
 **/
@Slf4j
public class NavigatorController implements Initializable {

    @FXML
    private VBox layout;

    private final Pane content = new Pane();
    /**
     * 当点击naviBtn 的时候,切换 视图
     */
    private final SimpleBooleanProperty changeProperty = new SimpleBooleanProperty(false) {
        {
            addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                    //
                    Node view = null;
                    try {
                        view = (Node)new FXMLLoader(getClass().getClassLoader().getResource("layout/bugTool-view.fxml")).load();
                        content.getChildren().add(view);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    };



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initialize();
    }

    private void initialize() {
        ListView<Object> navView = new ListView<>();
        navView.getStyleClass().add("nav-list");
        navView.setItems(
                FXCollections.observableList(
                        Arrays.asList(
                                new Label("软件配置"),
                                new Label("bug ReView")
                        )
                )
        );

        navView.setPadding(new Insets(2.0));


        HBox box = new HBox(navView, content);

        content.getChildren().add(new HBox(new Label("nihao")));
        content.getChildren().add(new TextField("input"));

        // always grow
        HBox.setHgrow(content,Priority.ALWAYS);
        box.setPrefHeight(layout.getPrefHeight());
        layout.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                box.setPrefHeight(t1.doubleValue());
            }
        });
        layout.getChildren().add(box);
    }
}
