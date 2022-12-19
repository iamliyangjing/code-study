package com.lyj.hello;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2022-12-19 10:50
 **/
public class fxmlTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = FXMLLoader.load(getClass().getResource("/canvas.fxml"));
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("app");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
