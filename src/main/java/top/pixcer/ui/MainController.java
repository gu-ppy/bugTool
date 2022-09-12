package top.pixcer.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import top.pixcer.entity.BugInfo;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by HectorPu
 * on 2022/9/10 19:47 <hr/>
 * Desc：
 **/
public class MainController implements Initializable {

    @FXML
    public Menu mainMenu;
    @FXML
    private Button mainAdd;

    @FXML
    private Button mainSearch;

    @FXML
    private TextField mainSearchText;

    @FXML
    private HBox mainStatusBar;
    @FXML
    private Label mainStatusLabel;
    @FXML
    private ProgressBar mainProgress;

    @FXML
    private TableView<BugInfo> mainTableView;

    @FXML
    private Label mainVersion;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
