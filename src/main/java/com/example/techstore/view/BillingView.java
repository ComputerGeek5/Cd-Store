package com.example.techstore.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class BillingView extends VBox {

    private final AnchorPane anchorPane;
    private final TextArea textArea;
    private final TextField itemName;
    private final TextField itemQuantity;
    private final Button addToBill;
    private final Button checkOut;
    private final Button removeLast;
    private final Button home;

    public BillingView() {

        anchorPane = new AnchorPane();
        textArea = new TextArea();
        itemName = new TextField();
        itemQuantity = new TextField();
        addToBill = new Button();
        checkOut = new Button();
        removeLast = new Button();
        home = new Button();

        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        getStyleClass().add("main");
        getStylesheets().add("/com/example/techstore/static/style.css");

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setPrefWidth(1000.0);

        textArea.setLayoutX(550.0);
        textArea.setLayoutY(50.0);
        textArea.setPrefHeight(500.0);
        textArea.setPrefWidth(400.0);

        itemName.setAlignment(javafx.geometry.Pos.CENTER);
        itemName.setLayoutX(14.0);
        itemName.setLayoutY(197.0);
        itemName.setPrefHeight(50.0);
        itemName.setPrefWidth(250.0);
        itemName.setPromptText("Item Name");

        itemQuantity.setAlignment(javafx.geometry.Pos.CENTER);
        itemQuantity.setLayoutX(14.0);
        itemQuantity.setLayoutY(272.0);
        itemQuantity.setPrefHeight(50.0);
        itemQuantity.setPrefWidth(250.0);
        itemQuantity.setPromptText("Item Quantity");

        addToBill.setLayoutX(330.0);
        addToBill.setLayoutY(425.0);
        addToBill.setMnemonicParsing(false);
        addToBill.setOnAction(this::addToBill);
        addToBill.setPrefHeight(40.0);
        addToBill.setPrefWidth(200.0);
        addToBill.getStyleClass().add("button-primary");
        addToBill.setText("Add To Bill");

        checkOut.setLayoutX(39.0);
        checkOut.setLayoutY(425.0);
        checkOut.setMnemonicParsing(false);
        checkOut.setOnAction(this::checkOut);
        checkOut.setPrefHeight(40.0);
        checkOut.setPrefWidth(200.0);
        checkOut.getStyleClass().add("button-secondary");
        checkOut.setText("Check Out");

        removeLast.setLayoutX(330.0);
        removeLast.setLayoutY(500.0);
        removeLast.setMnemonicParsing(false);
        removeLast.setOnAction(this::removeLast);
        removeLast.setPrefHeight(40.0);
        removeLast.setPrefWidth(200.0);
        removeLast.getStyleClass().add("button-danger");
        removeLast.setText("Remove Last");

        home.setLayoutX(14.0);
        home.setLayoutY(14.0);
        home.setMnemonicParsing(false);
        home.setOnAction(this::home);
        home.setPrefHeight(40.0);
        home.setPrefWidth(200.0);
        home.getStyleClass().add("button-primary");
        home.setText("Home");

        anchorPane.getChildren().add(textArea);
        anchorPane.getChildren().add(itemName);
        anchorPane.getChildren().add(itemQuantity);
        anchorPane.getChildren().add(addToBill);
        anchorPane.getChildren().add(checkOut);
        anchorPane.getChildren().add(removeLast);
        anchorPane.getChildren().add(home);
        getChildren().add(anchorPane);

    }

    private void addToBill(javafx.event.ActionEvent actionEvent) {

    }

    private void checkOut(javafx.event.ActionEvent actionEvent) {

    }

    private void removeLast(javafx.event.ActionEvent actionEvent) {

    }

    private void home(javafx.event.ActionEvent actionEvent) {

    }
}
