package com.lyj.hello;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2022-12-19 09:54
 **/
public class node extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Hello World");
        //添加node
        //Node通用属性
        // 设置坐标
        label.setLayoutX(200);
        label.setLayoutY(200);
        //背景颜色
        label.setStyle("-fx-background-color: red;-fx-border-color: blue;-fx-background-radius: 3px ");
        //高度
        label.setPrefHeight(50);
        //宽度
        label.setPrefWidth(200);
        //居中内容
        label.setAlignment(Pos.CENTER);
        //透明度
        label.setOpacity(0.5);
        //旋转
        label.setRotate(75);
        //横着移动多少
        label.setTranslateX(60);
        //竖着移动多少
        label.setTranslateY(100);
        AnchorPane root = new AnchorPane();
        root.getChildren().add(label);

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
