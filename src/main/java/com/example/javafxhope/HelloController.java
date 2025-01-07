package com.example.javafxhope;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HelloController {

    private static byte levelNumber;


    @FXML
    private Button level1Button;

    @FXML
    private Button level2Button;

    @FXML
    private Button level3Button;

    @FXML
    private Button level4Button;

    @FXML
    private Button level5Button;

    @FXML
    private Button level6Button;

    @FXML
    private Button level7Button;

    @FXML
    private Button level8Button;

    @FXML
    private Button level9Button;


    @FXML
    private Label scoreStars;

    @FXML
    private ImageView starPicture;

    public void setLevelNumber(byte number) {
        levelNumber = number;
    }

    public static byte getLevelNumber() {
        return levelNumber;
    }

    @FXML
    void initialize() {
        Image image = new Image("file:///Users/ulianaboikova/IdeaProjects/JavaFXHope/src/main/java/com/example/javafxhope/assets/star.png");
        starPicture.setImage(image);
        scoreStars.setText(String.valueOf(HopeWinController.getAllStars()));
        level1Button.setOnAction(event -> {
            setLevelNumber((byte) 1);
            level1Button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/javafxhope/last-last-hope.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        level2Button.setOnAction(event -> {
            setLevelNumber((byte) 2);
            level2Button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/javafxhope/level-two-hope.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        level3Button.setOnAction(event -> {
            setLevelNumber((byte) 3);
            level2Button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/javafxhope/level-three-hope.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        level4Button.setOnAction(event -> {
            setLevelNumber((byte) 4);
            level2Button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/javafxhope/level-four-hope.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        level5Button.setOnAction(event -> {
            setLevelNumber((byte) 5);
            level2Button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/javafxhope/level-five-hope.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        level6Button.setOnAction(event -> {
            setLevelNumber((byte) 6);
            level2Button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/javafxhope/level-six-hope.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        level7Button.setOnAction(event -> {
            setLevelNumber((byte) 7);
            level2Button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/javafxhope/level-seven-hope.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        level8Button.setOnAction(event -> {
            setLevelNumber((byte) 8);
            level2Button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/javafxhope/level-eight-hope.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        level9Button.setOnAction(event -> {
            setLevelNumber((byte) 9);
            level2Button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/javafxhope/level-nine-hope.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

}






