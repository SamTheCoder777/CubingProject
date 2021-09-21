package com.example.cubingproject;

import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("IamCubing");
        stage.setScene(scene);
        stage.setMinHeight(480);
        stage.setMinWidth(650);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}