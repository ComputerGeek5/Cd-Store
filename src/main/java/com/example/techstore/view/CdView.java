package com.example.techstore.view;

import com.example.techstore.controller.CdController;
import com.example.techstore.model.Cd;
import com.example.techstore.model.Genre;
import com.example.techstore.service.CdService;
import com.example.techstore.view.abst.View;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;

public class CdView extends View {
    private static final CdService cdService;
    private static final int rowsPerPage;
    private static List<Cd> cds;

    static {
        cdService = new CdService();
        rowsPerPage = 5;
    }

    private AnchorPane anchorPane;
    private TableView tableView = new TableView();
    TableColumn<Cd, Void> tableColumn5;
    private Button back;
    private Label label;
    private Button add;
    private Button genres;
    private Pagination pagination;

    public CdView() {
        cds = new ArrayList<>();
        cds.addAll(cdService.findAll());

        anchorPane = new AnchorPane();
        back = new Button();
        label = new Label();
        add = new Button();
        genres = new Button();
        pagination = new Pagination((cds.size() / rowsPerPage + 1), 0);
        pagination.setPageFactory(this::createTable);

        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        getStyleClass().add("main");
        getStylesheets().add("/com/example/techstore/static/style.css");

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setPrefWidth(1000.0);

        back.setLayoutX(14.0);
        back.setLayoutY(14.0);
        
        back.setOnAction(CdController::back);
        back.setPrefHeight(40.0);
        back.setPrefWidth(200.0);
        back.getStyleClass().add("button-primary");
        back.setText("Back");

        TableColumn tableColumn = new TableColumn<>();
        TableColumn<Cd, String> tableColumn0 = new TableColumn<>();
        TableColumn tableColumn1 = new TableColumn();
        TableColumn tableColumn2 = new TableColumn();
        TableColumn tableColumn3 = new TableColumn();
        TableColumn tableColumn4 = new TableColumn();

        tableColumn.setPrefWidth(130.0);
        tableColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        tableColumn.setText("Title");
        tableColumn0.setMinWidth(0.0);
        tableColumn0.setPrefWidth(139.0);
        tableColumn0.setCellValueFactory(data -> {
            Genre genre = data.getValue().getGenre();
            String name = genre.getName();
            return new ReadOnlyStringWrapper(name);
        });
        tableColumn0.setText("Genre");

        tableColumn1.setMinWidth(0.0);
        tableColumn1.setPrefWidth(140.0);
        tableColumn1.setCellValueFactory(new PropertyValueFactory<>("buyPrice"));
        tableColumn1.setText("Buy Price");

        tableColumn2.setMinWidth(0.0);
        tableColumn2.setPrefWidth(153.0);
        tableColumn2.setCellValueFactory(new PropertyValueFactory<>("boughtQuantity"));
        tableColumn2.setText("Bought");

        tableColumn3.setMinWidth(0.0);
        tableColumn3.setPrefWidth(167.0);
        tableColumn3.setCellValueFactory(new PropertyValueFactory<>("sellPrice"));
        tableColumn3.setText("Sell Price");

        tableColumn4.setMinWidth(0.0);
        tableColumn4.setPrefWidth(147.0);
        tableColumn4.setCellValueFactory(new PropertyValueFactory<>("soldQuantity"));
        tableColumn4.setText("Sold");

        tableView.getColumns().addAll(tableColumn, tableColumn0, tableColumn1, tableColumn2, tableColumn3, tableColumn4);
        addButtonColumn();

        tableView.setLayoutX(15.0);
        tableView.setLayoutY(180.0);
        tableView.setPrefHeight(350.0);
        tableView.setPrefWidth(970.0);

        pagination.setLayoutX(15.0);
        pagination.setLayoutY(530.0);

        label.setLayoutX(442.0);
        label.setLayoutY(80.0);
        label.getStyleClass().add("font-secondary");
        label.setText("CD-s");

        add.setLayoutX(789.0);
        add.setLayoutY(14.0);
        add.setOnAction(CdController::add);
        add.setPrefHeight(40.0);
        add.setPrefWidth(200.0);
        add.getStyleClass().add("button-secondary");
        add.setText("Add");

        genres.setLayoutX(789.0);
        genres.setLayoutY(75.0);
        genres.setOnAction(CdController::genres);
        genres.setPrefHeight(40.0);
        genres.setPrefWidth(200.0);
        genres.getStyleClass().add("button-primary");
        genres.setText("Genres");

        anchorPane.getChildren().add(back);
        anchorPane.getChildren().add(tableView);
        anchorPane.getChildren().add(pagination);
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(add);
        anchorPane.getChildren().add(genres);
        getChildren().add(anchorPane);
    }

    private Node createTable(int pageIndex) {
        int fromIndex = pageIndex * rowsPerPage;
        int toIndex = Math.min(fromIndex + rowsPerPage, cds.size());
        tableView.setItems(FXCollections.observableArrayList(cds.subList(fromIndex, toIndex)));
        tableView.getColumns().remove(tableColumn5);
        addButtonColumn();
        return new AnchorPane();
    }

    private void addButtonColumn() {
        tableColumn5 = new TableColumn("Action");
        tableColumn5.setMinWidth(0.0);
        tableColumn5.setPrefWidth(93.0);

        Callback<TableColumn<Cd, Void>, TableCell<Cd, Void>> cellFactory = param -> {
            final TableCell<Cd, Void> cell = new TableCell<>() {
                private final Button button = new Button("Edit");

                {
                    button.setPrefHeight(30);
                    button.setPrefWidth(80.0);
                    button.getStyleClass().add("button-primary");
                    button.setOnAction((ActionEvent actionEvent) -> {
                        Cd cd = getTableView().getItems().get(getIndex());
                        CdController.edit(actionEvent, cd.getId());
                    });
                }

                @Override
                public void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(button);
                    }
                }
            };

            return cell;
        };


        tableColumn5.setCellFactory(cellFactory);
        tableView.getColumns().add(tableColumn5);
    }
}
