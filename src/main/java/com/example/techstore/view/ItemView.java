package com.example.techstore.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public abstract class ItemView extends VBox {

    protected final AnchorPane anchorPane;
    protected final Button back;
    protected final TableView tableView;
    protected final TableColumn tableColumn;
    protected final TableColumn tableColumn0;
    protected final TableColumn tableColumn1;
    protected final TableColumn tableColumn2;
    protected final TableColumn tableColumn3;
    protected final TableColumn tableColumn4;
    protected final TableColumn tableColumn5;
    protected final Label label;

    public ItemView() {

        anchorPane = new AnchorPane();
        back = new Button();
        tableView = new TableView();
        tableColumn = new TableColumn();
        tableColumn0 = new TableColumn();
        tableColumn1 = new TableColumn();
        tableColumn2 = new TableColumn();
        tableColumn3 = new TableColumn();
        tableColumn4 = new TableColumn();
        tableColumn5 = new TableColumn();
        label = new Label();

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
        tableView.setLayoutY(180.0);
        tableView.setPrefHeight(420.0);
        tableView.setPrefWidth(970.0);

        tableColumn.setPrefWidth(130.0);
        tableColumn.setText("Name");

        tableColumn0.setMinWidth(0.0);
        tableColumn0.setPrefWidth(139.0);
        tableColumn0.setText("Category");

        tableColumn1.setMinWidth(0.0);
        tableColumn1.setPrefWidth(140.0);
        tableColumn1.setText("Buy Price");

        tableColumn2.setMinWidth(0.0);
        tableColumn2.setPrefWidth(153.0);
        tableColumn2.setText("Bought");

        tableColumn3.setMinWidth(0.0);
        tableColumn3.setPrefWidth(167.0);
        tableColumn3.setText("Sell Price");

        tableColumn4.setMinWidth(0.0);
        tableColumn4.setPrefWidth(147.0);
        tableColumn4.setText("Sold");

        tableColumn5.setMinWidth(0.0);
        tableColumn5.setPrefWidth(93.0);
        tableColumn5.setText("Action");

        label.setLayoutX(442.0);
        label.setLayoutY(80.0);
        label.getStyleClass().add("font-secondary");
        label.setText("Items");

        anchorPane.getChildren().add(back);
        tableView.getColumns().add(tableColumn);
        tableView.getColumns().add(tableColumn0);
        tableView.getColumns().add(tableColumn1);
        tableView.getColumns().add(tableColumn2);
        tableView.getColumns().add(tableColumn3);
        tableView.getColumns().add(tableColumn4);
        tableView.getColumns().add(tableColumn5);
        anchorPane.getChildren().add(tableView);
        anchorPane.getChildren().add(label);
        getChildren().add(anchorPane);

    }

    protected abstract void store(javafx.event.ActionEvent actionEvent);

}
