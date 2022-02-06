package com.example.techstore;

import com.example.techstore.view.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.techstore.util.Constant.appTitle;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
//        AdminView view = new AdminView();
        HomeView view = new HomeView();
        Scene scene = new Scene(view, 1000, 600);
        stage.getIcons().add(new Image(String.valueOf(this.getClass().getResource("static/img/favicon.png"))));
        stage.setTitle(appTitle);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }
}