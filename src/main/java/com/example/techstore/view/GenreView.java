package com.example.techstore.view;

import com.example.techstore.controller.EditGenreController;
import com.example.techstore.controller.GenreController;
import com.example.techstore.model.Genre;
import com.example.techstore.service.GenreService;
import com.example.techstore.view.abst.View;
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

public class GenreView extends View {
    private static final GenreService genreService;
    private static final int rowsPerPage;
    private static List<Genre> genres;

    static {
        genreService = new GenreService();
        rowsPerPage = 5;
    }

    private AnchorPane anchorPane;
    private TableView tableView = new TableView();
    TableColumn<Genre, Void> tableColumn1;
    private Button back;
    private Label label;
    private Button add;
    private Pagination pagination;

    public GenreView() {
        genres = new ArrayList<>();
        genres.addAll(genreService.findAll());

        anchorPane = new AnchorPane();
        back = new Button();
        label = new Label();
        add = new Button();
        pagination = new Pagination((genres.size() / rowsPerPage + 1), 0);
        pagination.setPageFactory(this::createTable);

        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        getStyleClass().add("main");
        getStylesheets().add("/com/example/techstore/static/style.css");

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setPrefWidth(1000.0);

        back.setLayoutX(14.0);
        back.setLayoutY(14.0);

        back.setOnAction(GenreController::back);
        back.setPrefHeight(40.0);
        back.setPrefWidth(200.0);
        back.getStyleClass().add("button-primary");
        back.setText("Back");

        TableColumn tableColumn = new TableColumn<>();

        tableColumn.setPrefWidth(500.0);
        tableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumn.setText("Name");

        tableView.getColumns().addAll(tableColumn);
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
        label.setText("Genres");

        add.setLayoutX(789.0);
        add.setLayoutY(14.0);
        add.setOnAction(GenreController::add);
        add.setPrefHeight(40.0);
        add.setPrefWidth(200.0);
        add.getStyleClass().add("button-secondary");
        add.setText("Add");

        anchorPane.getChildren().add(back);
        anchorPane.getChildren().add(tableView);
        anchorPane.getChildren().add(pagination);
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(add);
        getChildren().add(anchorPane);
    }

    private Node createTable(int pageIndex) {
        int fromIndex = pageIndex * rowsPerPage;
        int toIndex = Math.min(fromIndex + rowsPerPage, genres.size());
        tableView.setItems(FXCollections.observableArrayList(genres.subList(fromIndex, toIndex)));
        tableView.getColumns().remove(tableColumn1);
        addButtonColumn();
        return new AnchorPane();
    }

    private void addButtonColumn() {
        tableColumn1 = new TableColumn("Action");
        tableColumn1.setMinWidth(0.0);
        tableColumn1.setPrefWidth(470.0);

        Callback<TableColumn<Genre, Void>, TableCell<Genre, Void>> cellFactory = param -> {
            final TableCell<Genre, Void> cell = new TableCell<>() {
                private final Button button = new Button("Delete");

                {
                    button.setPrefHeight(30);
                    button.setPrefWidth(100.0);
                    button.getStyleClass().add("button-danger");
                    button.setOnAction((ActionEvent actionEvent) -> {
                        Genre genre = getTableView().getItems().get(getIndex());
                        EditGenreController.delete(actionEvent, genre.getId());
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


        tableColumn1.setCellFactory(cellFactory);
        tableView.getColumns().add(tableColumn1);
    }
}
