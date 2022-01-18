package com.example.techstore.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public abstract class CashierView extends VBox {

    protected final AnchorPane anchorPane;
    protected final Button back;
    protected final TableView tableView;
    protected final TableColumn tableColumn;
    protected final TableColumn tableColumn0;
    protected final TableColumn tableColumn1;
    protected final TableColumn tableColumn2;
    protected final Label cashiers;

    public CashierView() {

        anchorPane = new AnchorPane();
        back = new Button();
        tableView = new TableView();
        tableColumn = new TableColumn();
        tableColumn0 = new TableColumn();
        tableColumn1 = new TableColumn();
        tableColumn2 = new TableColumn();
        cashiers = new Label();

        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        getStyleClass().add("main");
        getStylesheets().add("/com/example/techstore/static/style.css");

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setPrefWidth(1000.0);

        back.setLayoutX(14.0);
        back.setLayoutY(14.0);
        back.setMnemonicParsing(false);
        back.setOnAction(this::store);
        back.setPrefHeight(40.0);
        back.setPrefWidth(200.0);
        back.getStyleClass().add("button-primary");
        back.setText("Back");

        tableView.setLayoutX(15.0);
        tableView.setLayoutY(166.0);
        tableView.setPrefHeight(420.0);
        tableView.setPrefWidth(970.0);

        tableColumn.setPrefWidth(231.0);
        tableColumn.setText("Name");

        tableColumn0.setMinWidth(0.0);
        tableColumn0.setPrefWidth(232.0);
        tableColumn0.setText("Billls Issued");

        tableColumn1.setMinWidth(0.0);
        tableColumn1.setPrefWidth(221.0);
        tableColumn1.setText("Items Sold");

        tableColumn2.setMinWidth(0.0);
        tableColumn2.setPrefWidth(285.0);
        tableColumn2.setText("Profit");

        cashiers.setLayoutX(442.0);
        cashiers.setLayoutY(80.0);
        cashiers.getStyleClass().add("font-secondary");
        cashiers.setText("Cashiers");

        anchorPane.getChildren().add(back);
        tableView.getColumns().add(tableColumn);
        tableView.getColumns().add(tableColumn0);
        tableView.getColumns().add(tableColumn1);
        tableView.getColumns().add(tableColumn2);
        anchorPane.getChildren().add(tableView);
        anchorPane.getChildren().add(cashiers);
        getChildren().add(anchorPane);

    }

    protected abstract void store(javafx.event.ActionEvent actionEvent);

}
