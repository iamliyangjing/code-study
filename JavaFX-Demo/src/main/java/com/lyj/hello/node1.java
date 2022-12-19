package com.lyj.hello;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @program: code-study
 * @description: UI控件绑定
 * @author: lyj
 * @create: 2022-12-19 10:09
 **/
public class node1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Circle circle = new Circle();
        circle.setCenterX(250);
        circle.setCenterY(250);
        circle.setRadius(100);
        circle.setFill(Color.rgb(255,0,0));

        AnchorPane root = new AnchorPane();

        Scene scene = new Scene(root,500,500);
        circle.centerXProperty().bind(scene.widthProperty().divide(2));
        circle.centerXProperty().bind(scene.heightProperty().divide(2));

        circle.centerXProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("x 轴中心点改变了，原来是："+oldValue+"现在是+"+newValue);
            }
        });

        root.getChildren().add(circle);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
