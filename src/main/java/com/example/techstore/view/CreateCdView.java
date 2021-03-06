package com.example.techstore.view;

import com.example.techstore.controller.CreateCdController;
import com.example.techstore.model.Genre;
import com.example.techstore.service.GenreService;
import com.example.techstore.view.abst.View;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.StringConverter;

import static com.example.techstore.util.CreateCdViewUtil.fillComboBoxGenresOptions;

public class CreateCdView extends View {
    private static final GenreService genreService;

    static {
        genreService = new GenreService();
    }

    private AnchorPane anchorPane;
    private Button back;
    private TextField title;
    private ComboBox<Genre> genres;
    private TextField buyPrice;
    private TextField sellPrice;
    private Button create;

    public CreateCdView() {
        anchorPane = new AnchorPane();
        back = new Button();
        title = new TextField();
        genres = new ComboBox<>();
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

        genres.setLayoutX(351.0);
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
        create.setOnAction(CreateCdController::create);
        create.setPrefHeight(40.0);
        create.setPrefWidth(200.0);
        create.getStyleClass().add("button-secondary");
        create.setText("Create");

        anchorPane.getChildren().add(back);
        anchorPane.getChildren().add(title);
        anchorPane.getChildren().add(genres);
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

    public Button getCreate() {
        return create;
    }

    public void setCreate(Button create) {
        this.create = create;
    }
}
