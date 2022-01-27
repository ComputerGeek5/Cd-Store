package com.example.techstore.view;

import com.example.techstore.controller.CashierController;
import com.example.techstore.view.abst.View;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import static com.example.techstore.util.CashierViewUtil.fillComboBoxCdsOptions;
import static com.example.techstore.util.enumerator.CreateStaffViewUtil.fillComboBoxRolesOptions;

public class CashierView extends View {
    private AnchorPane anchorPane;
    private TextArea billInformation;
    private ComboBox cd;
    private TextField quantity;
    private Button addToBill;
    private Button checkOut;
    private Button removeLast;
    private Button back;

    public CashierView() {
        anchorPane = new AnchorPane();
        billInformation = new TextArea();
        cd = new ComboBox();
        quantity = new TextField();
        addToBill = new Button();
        checkOut = new Button();
        removeLast = new Button();
        back = new Button();

        fillComboBoxCdsOptions(cd);

        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        getStyleClass().add("main");
        getStylesheets().add("/com/example/techstore/static/style.css");

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setPrefWidth(1000.0);

        billInformation.setLayoutX(550.0);
        billInformation.setLayoutY(50.0);
        billInformation.setPrefHeight(500.0);
        billInformation.setPrefWidth(400.0);
        billInformation.setEditable(true);
        billInformation.setDisable(true);
        billInformation.setStyle("-fx-opacity: 1.0;");

        cd.setLayoutX(14.0);
        cd.setLayoutY(197.0);
        cd.setPrefHeight(50.0);
        cd.setPrefWidth(250.0);
        cd.setPromptText("CD");

        quantity.setAlignment(javafx.geometry.Pos.CENTER);
        quantity.setLayoutX(14.0);
        quantity.setLayoutY(272.0);
        quantity.setPrefHeight(50.0);
        quantity.setPrefWidth(250.0);
        quantity.setPromptText("Quantity");

        addToBill.setLayoutX(330.0);
        addToBill.setLayoutY(425.0);
        addToBill.setMnemonicParsing(false);
        addToBill.setOnAction(CashierController::addToBill);
        addToBill.setPrefHeight(40.0);
        addToBill.setPrefWidth(200.0);
        addToBill.getStyleClass().add("button-primary");
        addToBill.setText("Add To Bill");

        checkOut.setLayoutX(39.0);
        checkOut.setLayoutY(425.0);
        checkOut.setMnemonicParsing(false);
        checkOut.setOnAction(CashierController::checkOut);
        checkOut.setPrefHeight(40.0);
        checkOut.setPrefWidth(200.0);
        checkOut.getStyleClass().add("button-secondary");
        checkOut.setText("Check Out");

        removeLast.setLayoutX(330.0);
        removeLast.setLayoutY(500.0);
        removeLast.setMnemonicParsing(false);
        removeLast.setOnAction(CashierController::removeLast);
        removeLast.setPrefHeight(40.0);
        removeLast.setPrefWidth(200.0);
        removeLast.getStyleClass().add("button-danger");
        removeLast.setText("Remove Last");

        back.setLayoutX(14.0);
        back.setLayoutY(14.0);
        back.setMnemonicParsing(false);
        back.setOnAction(CashierController::back);
        back.setPrefHeight(40.0);
        back.setPrefWidth(200.0);
        back.getStyleClass().add("button-primary");
        back.setText("Back");

        anchorPane.getChildren().add(billInformation);
        anchorPane.getChildren().add(cd);
        anchorPane.getChildren().add(quantity);
        anchorPane.getChildren().add(addToBill);
        anchorPane.getChildren().add(checkOut);
        anchorPane.getChildren().add(removeLast);
        anchorPane.getChildren().add(back);
        getChildren().add(anchorPane);
    }

    public ComboBox getCd() {
        return cd;
    }

    public void setCd(ComboBox cd) {
        this.cd = cd;
    }

    public TextField getQuantity() {
        return quantity;
    }

    public void setQuantity(TextField quantity) {
        this.quantity = quantity;
    }

    public TextArea getBillInformation() {
        return billInformation;
    }

    public void setBillInformation(TextArea billInformation) {
        this.billInformation = billInformation;
    }
}
