package com.example.techstore.view;

import com.example.techstore.controller.CreateCdController;
import com.example.techstore.controller.CreateUserController;
import com.example.techstore.view.abst.View;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class CreateCdView extends View {
    private AnchorPane anchorPane;
    private Button back;
    private TextField title;
    private TextField genre;
    private TextField buyPrice;
    private TextField sellPrice;
    private Button create;

    public CreateCdView() {
        anchorPane = new AnchorPane();
        back = new Button();
        title = new TextField();
        genre = new TextField();
        buyPrice = new TextField();
        sellPrice = new TextField();
        create = new Button();

        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        getStyleClass().add("main");
        getStylesheets().add("/com/example/techstore/static/style.css");

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setPrefWidth(1000.0);

        back.setLayoutX(14.0);
        back.setLayoutY(14.0);
        back.setMnemonicParsing(false);
        back.setOnAction(CreateCdController::back);
        back.setPrefHeight(40.0);
        back.setPrefWidth(200.0);
        back.getStyleClass().add("button-primary");
        back.setText("Back");

        title.setAlignment(javafx.geometry.Pos.CENTER);
        title.setLayoutX(351.0);
        title.setLayoutY(115.0);
        title.setPrefWidth(300.0);
        title.setPromptText("Title");

        genre.setAlignment(javafx.geometry.Pos.CENTER);
        genre.setLayoutX(351.0);
        genre.setLayoutY(200.0);
        genre.setPrefWidth(300.0);
        genre.setPromptText("Genre");

        buyPrice.setAlignment(javafx.geometry.Pos.CENTER);
        buyPrice.setLayoutX(351.0);
        buyPrice.setLayoutY(285.0);
        buyPrice.setPrefWidth(300.0);
        buyPrice.setPromptText("Buy Price");

        sellPrice.setAlignment(javafx.geometry.Pos.CENTER);
        sellPrice.setLayoutX(350.0);
        sellPrice.setLayoutY(370.0);
        sellPrice.setPrefWidth(300.0);
        sellPrice.setPromptText("Sell Price");

        create.setLayoutX(400.0);
        create.setLayoutY(470.0);
        create.setMnemonicParsing(false);
        create.setOnAction(CreateCdController::create);
        create.setPrefHeight(40.0);
        create.setPrefWidth(200.0);
        create.getStyleClass().add("button-secondary");
        create.setText("Create");

        anchorPane.getChildren().add(back);
        anchorPane.getChildren().add(title);
        anchorPane.getChildren().add(genre);
        anchorPane.getChildren().add(buyPrice);
        anchorPane.getChildren().add(sellPrice);
        anchorPane.getChildren().add(create);
        getChildren().add(anchorPane);
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public Button getBack() {
        return back;
    }

    public void setBack(Button back) {
        this.back = back;
    }

    public TextField getTitle() {
        return title;
    }

    public void setTitle(TextField title) {
        this.title = title;
    }

    public TextField getGenre() {
        return genre;
    }

    public void setGenre(TextField genre) {
        this.genre = genre;
    }

    public TextField getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(TextField buyPrice) {
        this.buyPrice = buyPrice;
    }

    public TextField getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(TextField sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Button getCreate() {
        return create;
    }

    public void setCreate(Button create) {
        this.create = create;
    }
}
