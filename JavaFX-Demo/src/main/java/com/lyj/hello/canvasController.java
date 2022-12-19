package com.lyj.hello;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2022-12-19 14:21
 **/
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.MenuItem;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class canvasController {

    @FXML
    private MenuItem savemune;

    @FXML
    private Canvas canvas;

    private double x;
    private double y;

    @FXML
    void canvasdragged(MouseEvent event) {
        double x2 = event.getX();
        double y2 = event.getY();
        canvas.getGraphicsContext2D().strokeLine(x,y,x2,y2);
        x=x2;
        y=y2;
    }

    @FXML
    void canvaspressed(MouseEvent event) {
        x = event.getX();
        y = event.getY();
    }

    @FXML
    void savefile(ActionEvent event) throws IOException {
    //用writeimage 接收
        WritableImage image = canvas.snapshot(null, null);
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image,null);

        //弹出保存窗口
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("保存canvas图片");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG",".png"));
        //文件 保存
        File file = fileChooser.showSaveDialog(canvas.getScene().getWindow());

        if (file!=null){
            ImageIO.write(bufferedImage,"PNG",file);
        }

    }

}
