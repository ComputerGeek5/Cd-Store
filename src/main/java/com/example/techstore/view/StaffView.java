package com.example.techstore.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class StaffView extends VBox {

    private final AnchorPane anchorPane;
    private final Button back;
    private final TableView tableView;
    private final TableColumn tableColumn;
    private final TableColumn tableColumn0;
    private final TableColumn tableColumn1;
    private final TableColumn tableColumn2;
    private final TableColumn tableColumn3;
    private final TableColumn tableColumn4;
    private final TableColumn tableColumn5;
    private final Label label;

    public StaffView() {

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
        back.setOnAction(this::admin);
        back.setPrefHeight(40.0);
        back.setPrefWidth(200.0);
        back.getStyleClass().add("button-primary");
        back.setText("Back");

        tableView.setLayoutX(14.0);
        tableView.setLayoutY(168.0);
        tableView.setPrefHeight(420.0);
        tableView.setPrefWidth(970.0);

        tableColumn.setPrefWidth(151.0);
        tableColumn.setText("Name");

        tableColumn0.setPrefWidth(152.0);
        tableColumn0.setText("Birthday");

        tableColumn1.setPrefWidth(142.0);
        tableColumn1.setText("Phone");

        tableColumn2.setPrefWidth(149.0);
        tableColumn2.setText("Email");

        tableColumn3.setPrefWidth(153.0);
        tableColumn3.setText("Salary");

        tableColumn4.setPrefWidth(113.0);
        tableColumn4.setText("Role");

        tableColumn5.setPrefWidth(109.0);
        tableColumn5.setText("Action");

        label.setLayoutX(385.0);
        label.setLayoutY(78.0);
        label.getStyleClass().add("font-secondary");
        label.setText("Employees");

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

    private void admin(javafx.event.ActionEvent actionEvent) {

    }
}
