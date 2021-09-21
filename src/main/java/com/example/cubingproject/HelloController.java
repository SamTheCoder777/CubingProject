package com.example.cubingproject;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class HelloController {

    @FXML
    Button sButton, rButton;

    @FXML
    Label text;

    @FXML
    ListView list;


    Timeline timeline;
    int mins = 0, secs = 0, millis = 0;
    boolean sos = true;
    String tempTime;
    int counting = 1;

    public void HelloController(){

    }

    @FXML
    private void initialize()
    {
        text.setFocusTraversable(false);
        sButton.setFocusTraversable(false);
        rButton.setFocusTraversable(false);
        list.setFocusTraversable(false);

        text.setText("00:00:000");
        timeline = new Timeline(new KeyFrame(Duration.millis(1), (ActionEvent event) -> {
            change(text);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
    }


    public void change(Label text) {
        if(millis == 1000) {
            secs++;
            millis = 0;
        }
        if(secs == 60) {
            mins++;
            secs = 0;
        }
        tempTime = (((mins/10) == 0) ? "0" : "") + mins + ":"
                + (((secs/10) == 0) ? "0" : "") + secs + ":"
                + (((millis/10) == 0) ? "00" : (((millis/100) == 0) ? "0" : "")) + millis++;
        text.setText(tempTime);
    }




        public void start() { //on action
            if (sos) {
                timeline.play();
                sos = false;
                sButton.setText("Stop");
            } else {
                list.getItems().add(counting + ". " + tempTime);
                counting++;
                tempTime = "";
                timeline.pause();
                sos = true;
                sButton.setText("Start");
                handle();
            }
        }

    public void handle() {
        mins = 0;
        secs = 0;
        millis = 0;
        timeline.pause();
        //text.setText("00:00:000");
        if(!sos) {
            sos = true;
            sButton.setText("Start");
        }
    }

}


