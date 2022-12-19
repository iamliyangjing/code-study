package com.lyj.hello;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2022-12-19 10:53
 **/
public class demoController {
    @FXML
    Label la;

    @FXML
    Button but;

    public void onUp(){
        la.setLayoutY(la.getLayoutY()-5);
    }
}
