package com.lyj.hello.TEST;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2022-12-19 13:41
 **/
public class Main0 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("姓名是？");
        label.setLayoutX(200);
        label.setLayoutY(350);

        Button button = new Button("获取");
        button.setLayoutX(200);
        button.setLayoutY(400);

        button.setOnAction(event -> {
            new Thread(()->{
                //只有在队列里面才能执行任务，不报错
                Platform.runLater(()->{
                    String newValue = "lyj";
                    label.setText(newValue);
                });
            }).start();
        });


        AnchorPane pane = new AnchorPane();
        pane.getChildren().addAll(button,label);
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("hello");
        primaryStage.show();
    }
}
