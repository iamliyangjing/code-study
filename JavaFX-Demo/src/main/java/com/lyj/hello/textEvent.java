package com.lyj.hello;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2022-12-19 10:28
 **/
public class textEvent extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 500, 500);

        TextField textField = new TextField();
        textField.setLayoutX(150);
        textField.setLayoutY(200);
        //显示图标箭头
        textField.setOnDragOver(event -> {
            event.acceptTransferModes(TransferMode.ANY);
        });

        textField.setOnDragDropped(event -> {
            Dragboard dragboard = event.getDragboard();
            if (dragboard.hasFiles()){
                String path = dragboard.getFiles().get(0).getAbsolutePath();
                textField.setText(path);
            }
        });

        root.getChildren().addAll(textField);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
