package com.example.javafxhope;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HopeWinController {

    @FXML
    private Button menuButton;

    @FXML
    private ImageView star1;

    @FXML
    private ImageView star2;

    @FXML
    private ImageView star3;

    @FXML
    private Button startOverButton;

    @FXML
    private ImageView winPicture;

    static double time;


    @FXML
    void initialize() {
        Image image = new Image("file:///Users/ulianaboikova/IdeaProjects/JavaFXHope/src/main/java/com/example/javafxhope/assets/Win.gif");
        winPicture.setImage(image);

        Image image1 = new Image("file:///Users/ulianaboikova/IdeaProjects/JavaFXHope/src/main/java/com/example/javafxhope/assets/star.png");
        star1.setImage(image1);

        Image image2 = new Image("file:///Users/ulianaboikova/IdeaProjects/JavaFXHope/src/main/java/com/example/javafxhope/assets/star.png");
        star2.setImage(image2);

        Image image3 = new Image("file:///Users/ulianaboikova/IdeaProjects/JavaFXHope/src/main/java/com/example/javafxhope/assets/star.png");
        star3.setImage(image3);


        if (HelloController.getLevelNumber() == 1) {
            if (time >= 50) {
                star1.setVisible(true);
                star2.setVisible(false);
                star3.setVisible(false);
            } else if (time < 50 && time >= 45) {
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(false);
            } else {
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(true);
            }
        }
        if (HelloController.getLevelNumber() == 2) {
            if (time >= 21) {
                star1.setVisible(true);
                star2.setVisible(false);
                star3.setVisible(false);
            } else if (time < 21 && time >= 16) {
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(false);
            } else {
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(true);
            }
        }
        if (HelloController.getLevelNumber() == 3) {
            if (time >= 27) {
                star1.setVisible(true);
                star2.setVisible(false);
                star3.setVisible(false);
            } else if (time < 27 && time >= 22) {
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(false);
            } else {
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(true);
            }
        }
        if (HelloController.getLevelNumber() == 4) {
            if (time >= 37) {
                star1.setVisible(true);
                star2.setVisible(false);
                star3.setVisible(false);
            } else if (time < 37 && time >= 30) {
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(false);
            } else {
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(true);
            }
        }
        if (HelloController.getLevelNumber() == 5) {
            if (time >= 55) {
                star1.setVisible(true);
                star2.setVisible(false);
                star3.setVisible(false);
            } else if (time < 55 && time >= 45) {
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(false);
            } else {
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(true);
            }
        }
        if (HelloController.getLevelNumber() == 6) {
            if (time >= 40) {
                star1.setVisible(true);
                star2.setVisible(false);
                star3.setVisible(false);
            } else if (time < 40 && time >= 27) {
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(false);
            } else {
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(true);
            }
        }
        if (HelloController.getLevelNumber() == 7) {
            if (time >= 48) {
                star1.setVisible(true);
                star2.setVisible(false);
                star3.setVisible(false);
            } else if (time < 48 && time >= 37) {
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(false);
            } else {
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(true);
            }
        }
        if (HelloController.getLevelNumber() == 8) {
            if (time >= 48) {
                star1.setVisible(true);
                star2.setVisible(false);
                star3.setVisible(false);
            } else if (time < 48 && time >= 32) {
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(false);
            } else {
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(true);
            }
        }
        if (HelloController.getLevelNumber() == 9) {
            if (time >= 40) {
                star1.setVisible(true);
                star2.setVisible(false);
                star3.setVisible(false);
            } else if (time < 40 && time >= 33) {
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(false);
            } else {
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(true);
            }
        }



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
            stage.show();;
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
            stage.show();;
        });



    }

}

