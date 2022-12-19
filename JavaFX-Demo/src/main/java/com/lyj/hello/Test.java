package com.lyj.hello;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Optional;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2022-12-18 00:05
 **/
public class Test extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button0 = new Button("窗口0");
        button0.setLayoutX(200);
        button0.setLayoutY(200);

//        取消操作系统默认退出事件
        Platform.setImplicitExit(false);
        primaryStage.setOnCloseRequest(event -> {
            //消费关闭事件，这样点击x没反应
            event.consume();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("退出程序");
            alert.setHeaderText(null);
            alert.setContentText("是否要退出程序?");
            // result
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get()==ButtonType.OK){
                Platform.exit();
            }
        });


        AnchorPane pane = new AnchorPane();
        pane.getChildren().addAll(button0);


        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello");
        //设置图标
        primaryStage.getIcons().add(new Image("/test.jpg"));
        //窗口大小是否可以改变
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.DECORATED);
        //无装饰
//        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

}
