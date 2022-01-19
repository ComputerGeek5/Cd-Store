package com.example.techstore.controller;

import com.example.techstore.Application;
import com.example.techstore.view.HomeView;
import com.example.techstore.view.SignInView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class AuthController {
    public static void signIn(ActionEvent actionEvent) {
        SignInView signIn = (SignInView) actionEvent.getSource();
        String username = signIn.getUsernameField().getText();
        String password = signIn.getPasswordField().getText();

    }

    private static void doSignIn(String username, String password) {

    }
}
