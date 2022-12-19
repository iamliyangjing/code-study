package com.lyj.hello;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2022-12-19 10:20
 **/
public class event extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 500, 500);

        Label label = new Label("Hello world");
        label.setLayoutX(150);
        label.setLayoutY(200);
        label.setFont(new Font(30));

        Button button = new Button("向上移动");
        button.setLayoutY(200);
        button.setLayoutX(300);
        root.getChildren().addAll(button,label);

        //设置事件---点击按钮
        button.setOnAction(event -> {
            label.setLayoutY(label.getLayoutY()-5);
        });
        //设置事件--键盘抬起
        scene.setOnKeyPressed(event -> {
            KeyCode code = event.getCode();
            if (code.equals(KeyCode.DOWN)){
                label.setLayoutY(label.getLayoutY()+5);
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
