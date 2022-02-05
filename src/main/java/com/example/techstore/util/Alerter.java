package com.example.techstore.util;

import javafx.scene.control.Alert;

public class Alerter {
    private static final String errorHeader = "Error";
    private static final String warningHeader = "Error";

    private static class AlertFactory {
        static Alert createAlert(String type, String message) {
            Alert alert = null;

            if (type.equals("ERROR")) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(errorHeader);
            } else if (type.equals("WARNING")) {
                alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(warningHeader);
            }
            alert.setContentText(message);

            return alert;
        }
    }

    public static void showError(String message) {
        Alert alert = AlertFactory.createAlert("ERROR", message);
        alert.show();
    }
}
