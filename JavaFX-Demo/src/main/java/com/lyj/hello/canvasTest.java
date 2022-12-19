package com.lyj.hello;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2022-12-19 13:53
 **/
public class canvasTest extends Application {
    public static final double WIDTH=800,HEIGHT=600;
    private static Canvas canvas = new Canvas(WIDTH,HEIGHT);
    private GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

    private Image background =  new Image("test.jpg");

    private Image slef = new Image("0.png");
    private double x=400;
    private double y=300;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        update();
        AnchorPane root = new AnchorPane(canvas);
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();

            switch (keyCode){
                case UP:
                    y-=5;
                    System.out.println(" y-=5;");
                    break;
                case DOWN:
                    y+=5;
                    System.out.println("y+=5");
                    break;
                case LEFT:
                    x-=5;
                    System.out.println("x-=5");
                    break;
                case RIGHT:
                    x+=5;
                    System.out.println(x+=5);
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void paint(){
        graphicsContext.drawImage(background,0,0);
        graphicsContext.drawImage(slef,x,y);
    }

    private void update(){
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                paint();
            }
        };
        animationTimer.start();
    }

    static {
        canvas.setLayoutX(0);
        canvas.setLayoutY(0);
    }
}
