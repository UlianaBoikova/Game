package com.example.javafxhope;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HopeLoseController {

    @FXML
    private Button menuButton;

    @FXML
    private Button startOverButton;

    @FXML
    private ImageView losePicture;

    @FXML
    void initialize() {

        Image image = new Image("file:///Users/ulianaboikova/IdeaProjects/JavaFXHope/src/main/java/com/example/javafxhope/assets/Lose.gif");
        losePicture.setImage(image);

        menuButton.setOnAction(event -> {
            menuButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/javafxhope/last-hope.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        startOverButton.setOnAction(event -> {
            startOverButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            if (HelloController.getLevelNumber() == 1) {
                loader.setLocation(getClass().getResource("/com/example/javafxhope/last-last-hope.fxml"));
            }
            else if (HelloController.getLevelNumber() == 2) {
                loader.setLocation(getClass().getResource("/com/example/javafxhope/level-two-hope.fxml"));
            }
            else if (HelloController.getLevelNumber() == 3) {
                loader.setLocation(getClass().getResource("/com/example/javafxhope/level-three-hope.fxml"));
            }
            else if (HelloController.getLevelNumber() == 4) {
                loader.setLocation(getClass().getResource("/com/example/javafxhope/level-four-hope.fxml"));
            }
            else if (HelloController.getLevelNumber() == 5) {
                loader.setLocation(getClass().getResource("/com/example/javafxhope/level-five-hope.fxml"));
            }
            else if (HelloController.getLevelNumber() == 6) {
                loader.setLocation(getClass().getResource("/com/example/javafxhope/level-six-hope.fxml"));
            }
            else if (HelloController.getLevelNumber() == 7) {
                loader.setLocation(getClass().getResource("/com/example/javafxhope/level-seven-hope.fxml"));
            }
            else if (HelloController.getLevelNumber() == 8) {
                loader.setLocation(getClass().getResource("/com/example/javafxhope/level-eight-hope.fxml"));
            }
            else if (HelloController.getLevelNumber() == 9) {
                loader.setLocation(getClass().getResource("/com/example/javafxhope/level-nine-hope.fxml"));
            }
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }
}
