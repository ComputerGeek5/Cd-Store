package com.example.techstore.view;

import com.example.techstore.controller.StatisticsController;
import com.example.techstore.view.abst.View;
import javafx.collections.FXCollections;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.util.List;

import static com.example.techstore.util.CdStatisticUtil.*;

public class StatisticsView extends View {
    private static List<PieChart.Data> cdsBoughtByGenre;
    private static List<PieChart.Data> cdsSoldByGenre;

    private AnchorPane anchorPane;
    private Button back;
    private Button search;
    private PieChart cdsSoldByGenrePieChart;
    private PieChart cdsBoughtByGenrePieChart;
    private DatePicker fromDatePicker;
    private DatePicker toDatePicker;

    public StatisticsView(boolean searching, LocalDate fromDate, LocalDate toDate) {
        anchorPane = new AnchorPane();
        back = new Button();
        search = new Button();
        fromDatePicker = new DatePicker();
        toDatePicker = new DatePicker();

        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        getStyleClass().add("main");
        getStylesheets().add("/com/example/techstore/static/style.css");

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setPrefWidth(1000.0);

        back.setLayoutX(14.0);
        back.setLayoutY(14.0);
        back.setOnAction(StatisticsController::back);
        back.setPrefHeight(40.0);
        back.setPrefWidth(200.0);
        back.getStyleClass().add("button-primary");
        back.setText("Back");

        search.setLayoutX(764.0);
        search.setLayoutY(14.0);
        search.setOnAction(StatisticsController::search);
        search.setPrefHeight(40.0);
        search.setPrefWidth(200.0);
        search.getStyleClass().add("button-secondary");
        search.setText("Search");

        fromDatePicker.setLayoutX(264.0);
        fromDatePicker.setLayoutY(14.0);
        fromDatePicker.setPrefWidth(200.0);
        fromDatePicker.setPromptText("From Date");
        fromDatePicker.setValue(fromDate);

        toDatePicker.setLayoutX(514.0);
        toDatePicker.setLayoutY(14.0);
        toDatePicker.setPrefWidth(200.0);
        toDatePicker.setPromptText("To Date");
        toDatePicker.setValue(toDate);

        if (searching) {
            LocalDate fromDateValue = fromDatePicker.getValue();
            LocalDate toDateValue = toDatePicker.getValue();

            cdsBoughtByGenre = searchCdsBoughtByGenre(fromDateValue, toDateValue);
            cdsSoldByGenre = searchCdsSoldByGenre(fromDateValue, toDateValue);

            fromDatePicker.setValue(null);
            toDatePicker.setValue(null);
        } else {
            cdsBoughtByGenre = searchCdsBoughtByGenre(null, null);
            cdsSoldByGenre = searchCdsSoldByGenre(null, null);
        }

        cdsSoldByGenrePieChart = new PieChart(FXCollections.observableList(cdsSoldByGenre));
        cdsSoldByGenrePieChart.setLayoutX(15.0);
        cdsSoldByGenrePieChart.setLayoutY(100.0);
        cdsSoldByGenrePieChart.setPrefHeight(450.0);
        cdsSoldByGenrePieChart.setPrefWidth(450.0);
        cdsSoldByGenrePieChart.setTitle("Cds Sold By Genre");

        cdsBoughtByGenrePieChart = new PieChart(FXCollections.observableList(cdsBoughtByGenre));
        cdsBoughtByGenrePieChart.setLayoutX(535.0);
        cdsBoughtByGenrePieChart.setLayoutY(100.0);
        cdsBoughtByGenrePieChart.setPrefHeight(450.0);
        cdsBoughtByGenrePieChart.setPrefWidth(450.0);
        cdsBoughtByGenrePieChart.setTitle("Cds Bought By Genre");

        anchorPane.getChildren().add(back);
        anchorPane.getChildren().add(cdsSoldByGenrePieChart);
        anchorPane.getChildren().add(cdsBoughtByGenrePieChart);
        anchorPane.getChildren().add(fromDatePicker);
        anchorPane.getChildren().add(toDatePicker);
        anchorPane.getChildren().add(search);
        getChildren().add(anchorPane);
    }

    public DatePicker getFromDatePicker() {
        return fromDatePicker;
    }

    public void setFromDatePicker(DatePicker fromDatePicker) {
        this.fromDatePicker = fromDatePicker;
    }

    public DatePicker getToDatePicker() {
        return toDatePicker;
    }

    public void setToDatePicker(DatePicker toDatePicker) {
        this.toDatePicker = toDatePicker;
    }
}
