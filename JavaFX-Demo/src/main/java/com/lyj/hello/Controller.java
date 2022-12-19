package com.lyj.hello;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import sun.dc.pr.PRError;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2022-12-19 12:25
 **/
public class Controller {

    @FXML
    private Circle ci;

    public void  circile(Scene scene){
        ci.centerXProperty().bind(scene.widthProperty().divide(2));
        ci.centerXProperty().bind(scene.heightProperty().divide(2));
    }
}
