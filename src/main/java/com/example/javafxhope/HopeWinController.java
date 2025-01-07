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

    private static int starAmountLevel1 = 0;
    private static int starAmountLevel2 = 0;
    private static int starAmountLevel3 = 0;
    private static int starAmountLevel4 = 0;
    private static int starAmountLevel5 = 0;
    private static int starAmountLevel6 = 0;
    private static int starAmountLevel7 = 0;
    private static int starAmountLevel8 = 0;
    private static int starAmountLevel9 = 0;

    private static int allStars = 0;


    static double time;

    public static int getAllStars() {
        return allStars;
    }

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
                if (starAmountLevel1 < 1) starAmountLevel1 = 1;
                star1.setVisible(true);
                star2.setVisible(false);
                star3.setVisible(false);
            } else if (time < 50 && time >= 45) {
                if (starAmountLevel1 < 2) starAmountLevel1 = 2;
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(false);
            } else {
                if (starAmountLevel1 < 3) starAmountLevel1 = 3;
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(true);
            }
        }
        if (HelloController.getLevelNumber() == 2) {
            if (time >= 21) {
                if (starAmountLevel2 < 1) starAmountLevel2 = 1;
                star1.setVisible(true);
                star2.setVisible(false);
                star3.setVisible(false);
            } else if (time < 21 && time >= 16) {
                if (starAmountLevel2 < 2) starAmountLevel2 = 2;
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(false);
            } else {
                if (starAmountLevel2 < 3) starAmountLevel2 = 3;
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(true);
            }
        }
        if (HelloController.getLevelNumber() == 3) {
            if (time >= 27) {
                if (starAmountLevel3 < 1) starAmountLevel3 = 1;
                star1.setVisible(true);
                star2.setVisible(false);
                star3.setVisible(false);
            } else if (time < 27 && time >= 22) {
                if (starAmountLevel3 < 2) starAmountLevel3 = 2;
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(false);
            } else {
                if (starAmountLevel3 < 3) starAmountLevel3 = 3;
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(true);
            }
        }
        if (HelloController.getLevelNumber() == 4) {
            if (time >= 37) {
                if (starAmountLevel4 < 1) starAmountLevel4 = 1;
                star1.setVisible(true);
                star2.setVisible(false);
                star3.setVisible(false);
            } else if (time < 37 && time >= 30) {
                if (starAmountLevel4 < 2) starAmountLevel4 = 2;
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(false);
            } else {
                if (starAmountLevel4 < 3) starAmountLevel4 = 3;
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(true);
            }
        }
        if (HelloController.getLevelNumber() == 5) {
            if (time >= 55) {
                if (starAmountLevel5 < 1) starAmountLevel5 = 1;
                star1.setVisible(true);
                star2.setVisible(false);
                star3.setVisible(false);
            } else if (time < 55 && time >= 45) {
                if (starAmountLevel5 < 2) starAmountLevel5 = 2;
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(false);
            } else {
                if (starAmountLevel5 < 3) starAmountLevel5 = 3;
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(true);
            }
        }
        if (HelloController.getLevelNumber() == 6) {
            if (time >= 40) {
                if (starAmountLevel6 < 1) starAmountLevel6 = 1;
                star1.setVisible(true);
                star2.setVisible(false);
                star3.setVisible(false);
            } else if (time < 40 && time >= 27) {
                if (starAmountLevel6 < 2) starAmountLevel6 = 2;
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(false);
            } else {
                if (starAmountLevel6 < 3) starAmountLevel6 = 3;
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(true);
            }
        }
        if (HelloController.getLevelNumber() == 7) {
            if (time >= 48) {
                if (starAmountLevel7 < 1) starAmountLevel7 = 1;
                star1.setVisible(true);
                star2.setVisible(false);
                star3.setVisible(false);
            } else if (time < 48 && time >= 37) {
                if (starAmountLevel7 < 2) starAmountLevel7 = 2;
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(false);
            } else {
                if (starAmountLevel7 < 3) starAmountLevel7 = 3;
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(true);
            }
        }
        if (HelloController.getLevelNumber() == 8) {
            if (time >= 48) {
                if (starAmountLevel8 < 1) starAmountLevel8 = 1;
                star1.setVisible(true);
                star2.setVisible(false);
                star3.setVisible(false);
            } else if (time < 48 && time >= 32) {
                if (starAmountLevel8 < 2) starAmountLevel8 = 2;
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(false);
            } else {
                if (starAmountLevel8 < 3) starAmountLevel8 = 3;
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(true);
            }
        }
        if (HelloController.getLevelNumber() == 9) {
            if (time >= 40) {
                if (starAmountLevel9 < 1) starAmountLevel9 = 1;
                star1.setVisible(true);
                star2.setVisible(false);
                star3.setVisible(false);
            } else if (time < 40 && time >= 33) {
                if (starAmountLevel9 < 2) starAmountLevel9 = 2;
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(false);
            } else {
                if (starAmountLevel9 < 3) starAmountLevel9 = 3;
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(true);
            }
        }

        allStars = starAmountLevel1 + starAmountLevel2 + starAmountLevel3 +
                starAmountLevel4 + starAmountLevel5 + starAmountLevel6 +
                starAmountLevel7 + starAmountLevel8 + starAmountLevel9;


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

