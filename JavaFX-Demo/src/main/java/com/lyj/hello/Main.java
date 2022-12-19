package com.lyj.hello;

import com.lyj.hello.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2022-12-19 12:17
 **/
public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/hello.fxml"));

        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Controller controller = fxmlLoader.getController();
        controller.circile(scene);

        primaryStage.setTitle("hello");
        primaryStage.setScene(scene);
        primaryStage.show();;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
