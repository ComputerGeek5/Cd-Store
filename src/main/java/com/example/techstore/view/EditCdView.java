package com.example.techstore.view;

import com.example.techstore.controller.EditCdController;
import com.example.techstore.model.Cd;
import com.example.techstore.model.Genre;
import com.example.techstore.service.CdService;
import com.example.techstore.service.GenreService;
import com.example.techstore.view.abst.View;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.StringConverter;

import static com.example.techstore.util.CreateCdViewUtil.fillComboBoxGenresOptions;

public class EditCdView extends View {
    private static final CdService cdService;

    static {
        cdService = new CdService();
    }

    private AnchorPane anchorPane;
    private static final GenreService genreService;

    static {
        genreService = new GenreService();
    }

    private Button back;
    private TextField title;
    private ComboBox<Genre> genres;
    private TextField buyPrice;
    private TextField sellPrice;
    private Button update;
    private Button delete;
    private final String id;
    private final Cd cd;

    public EditCdView(String id) {
        this.id = id;
        this.cd = cdService.findById(id);

        anchorPane = new AnchorPane();
        back = new Button();
        title = new TextField();
        genres = new ComboBox<>();
        buyPrice = new TextField();
        sellPrice = new TextField();
        update = new Button();
        delete = new Button();

        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        getStyleClass().add("main");
        getStylesheets().add("/com/example/techstore/static/style.css");

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setPrefWidth(1000.0);

        back.setLayoutX(14.0);
        back.setLayoutY(14.0);

        back.setOnAction(EditCdController::back);
        back.setPrefHeight(40.0);
        back.setPrefWidth(200.0);
        back.getStyleClass().add("button-primary");
        back.setText("Back");

        title.setAlignment(javafx.geometry.Pos.CENTER);
        title.setLayoutX(350.0);
        title.setLayoutY(115.0);
        title.setPrefWidth(300.0);
        title.setPromptText("Title");
        title.setText(cd.getTitle());
        title.setDisable(true);
        title.setStyle("-fx-opacity: 0.75;");

        genres.setLayoutX(350.0);
        genres.setLayoutY(200.0);
        genres.setPrefWidth(300.0);
        genres.setPromptText("Genre");
        fillComboBoxGenresOptions(genres);
        Callback<ListView<Genre>, ListCell<Genre>> factory = lv -> new ListCell<>() {
            @Override
            protected void updateItem(Genre genre, boolean empty) {
                super.updateItem(genre, empty);
                if (genre == null || empty) {
                    setGraphic(null);
                } else {
                    setText(genre.getName());
                }
            }
        };
        genres.setConverter(new StringConverter<>() {
            @Override
            public String toString(Genre genre) {
                return genre.getName();
            }

            @Override
            public Genre fromString(String name) {
                return genreService.findGenreByName(name);
            }
        });
        genres.setCellFactory(factory);
        genres.setDisable(true);
        genres.setStyle("-fx-opacity: 1.0;");

        buyPrice.setAlignment(javafx.geometry.Pos.CENTER);
        buyPrice.setLayoutX(350.0);
        buyPrice.setLayoutY(285.0);
        buyPrice.setPrefWidth(300.0);
        buyPrice.setPromptText("Buy Price");
        buyPrice.setText(String.valueOf(cd.getBuyPrice()));

        sellPrice.setAlignment(javafx.geometry.Pos.CENTER);
        sellPrice.setLayoutX(350.0);
        sellPrice.setLayoutY(370.0);
        sellPrice.setPrefWidth(300.0);
        sellPrice.setPromptText("Sell Price");
        sellPrice.setText(String.valueOf(cd.getSellPrice()));

        update.setLayoutX(400.0);
        update.setLayoutY(455);
        update.setOnAction(e -> EditCdController.update(e, this.id));
        update.setPrefHeight(40.0);
        update.setPrefWidth(200.0);
        update.getStyleClass().add("button-secondary");
        update.setText("Update");

        delete.setLayoutX(400.0);
        delete.setLayoutY(530);
        delete.setOnAction(e -> EditCdController.delete(e, this.id));
        delete.setPrefHeight(40.0);
        delete.setPrefWidth(200.0);
        delete.getStyleClass().add("button-danger");
        delete.setText("Delete");

        anchorPane.getChildren().add(back);
        anchorPane.getChildren().add(title);
        anchorPane.getChildren().add(genres);
        anchorPane.getChildren().add(buyPrice);
        anchorPane.getChildren().add(sellPrice);
        anchorPane.getChildren().add(update);
        anchorPane.getChildren().add(delete);
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

    public ComboBox<Genre> getGenres() {
        return genres;
    }

    public void setGenres(ComboBox<Genre> genres) {
        this.genres = genres;
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

    public Button getUpdate() {
        return update;
    }

    public void setUpdate(Button update) {
        this.update = update;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }
}
