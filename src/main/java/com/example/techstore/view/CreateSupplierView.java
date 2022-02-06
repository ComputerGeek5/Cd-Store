package com.example.techstore.view;

import com.example.techstore.controller.CreateSupplierController;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import static com.example.techstore.util.CashierUtil.fillComboBoxCdsOptions;

public class CreateSupplierView extends VBox {
    private AnchorPane anchorPane;
    private Button back;
    private TextField name;
    private Button create;
    private ComboBox cds;
    private TextField quantity;

    public CreateSupplierView() {
        anchorPane = new AnchorPane();
        back = new Button();
        name = new TextField();
        create = new Button();
        cds = new ComboBox();
        quantity = new TextField();

        fillComboBoxCdsOptions(cds);

        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        getStyleClass().add("main");
        getStylesheets().add("/com/example/techstore/static/style.css");

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setPrefWidth(1000.0);

        back.setLayoutX(14.0);
        back.setLayoutY(14.0);
        
        back.setOnAction(CreateSupplierController::back);
        back.setPrefHeight(40.0);
        back.setPrefWidth(200.0);
        back.getStyleClass().add("button-primary");
        back.setText("Back");

        name.setAlignment(javafx.geometry.Pos.CENTER);
        name.setLayoutX(351.0);
        name.setLayoutY(115.0);
        name.setPrefWidth(300.0);
        name.setPromptText("Name");

        create.setLayoutX(400.0);
        create.setLayoutY(370.0);
        create.setOnAction(CreateSupplierController::create);
        create.setPrefHeight(40.0);
        create.setPrefWidth(200.0);
        create.getStyleClass().add("button-secondary");
        create.setText("Create");

        cds.setLayoutX(350.0);
        cds.setLayoutY(200.0);
        cds.setPrefWidth(300.0);
        cds.setPromptText("CD");

        quantity.setAlignment(javafx.geometry.Pos.CENTER);
        quantity.setLayoutX(351.0);
        quantity.setLayoutY(285.0);
        quantity.setPrefWidth(300.0);
        quantity.setPromptText("Quantity");

        anchorPane.getChildren().add(back);
        anchorPane.getChildren().add(name);
        anchorPane.getChildren().add(create);
        anchorPane.getChildren().add(cds);
        anchorPane.getChildren().add(quantity);
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

    public TextField getName() {
        return name;
    }

    public void setName(TextField name) {
        this.name = name;
    }

    public Button getCreate() {
        return create;
    }

    public void setCreate(Button create) {
        this.create = create;
    }

    public ComboBox getCds() {
        return cds;
    }

    public void setCds(ComboBox cds) {
        this.cds = cds;
    }

    public TextField getQuantity() {
        return quantity;
    }

    public void setQuantity(TextField quantity) {
        this.quantity = quantity;
    }
}
