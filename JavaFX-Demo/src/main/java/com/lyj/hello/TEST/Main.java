package cn.zxl.AlertWindow;

import com.lyj.hello.TEST.AlertWindow;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @Description: //TODO 主类
 * @Author: zhangxueliang
 * @Create: 2021-05-27 09:50
 * @Version: 1.0
 **/
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn = new Button("弹出窗口");
        btn.setOnMouseClicked(event -> {
            System.out.println(AlertWindow.display("新窗口", "是否关闭窗口"));
        });
        VBox vBox = new VBox();
        vBox.getChildren().add(btn);
        //设置居中显示
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 400, 400);
        primaryStage.setTitle("弹出窗口示例");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

