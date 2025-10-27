package com.example.javafxhope;

import java.io.IOException;
import java.util.*;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import static com.example.javafxhope.HopeWinController.time;
import static javafx.scene.input.KeyCode.*;
import static javafx.scene.input.KeyCode.RIGHT;

public class LevelOneHopeController {

    @FXML
    private Line line1;

    @FXML
    private Line line2;

    @FXML
    private Line line3;

    @FXML
    private Line line4;

    @FXML
    private Line line5;

    @FXML
    private Line line6;

    @FXML
    private Line line7;

    @FXML
    private Line line8;

    @FXML
    private Line line9;

    @FXML
    private Line line10;

    @FXML
    private Line line11;

    @FXML
    private Line line12;

    @FXML
    private Line line13;

    @FXML
    private Pane mainPane;

    @FXML
    private ImageView portal;


    @FXML
    private ImageView haunterRunning;



    @FXML
    private ImageView squirrelRunning;

    private final int[][] table = new int[400][600];
    private final static int SIZE = 40;

    public void upgradeTime(double interval) {
        time += interval;
    }


    /**
     Main method that runs this page, starts animation and builds the logic of this level.
     */
    @FXML
    void initialize() {
        Platform.runLater(() -> mainPane.requestFocus());
        // Loading pictures of the squirrel, the ghost and the portal
        Image image = new Image(
                "file:///Users/ulianaboikova/IdeaProjects/JavaFXHope/src/main/java/com/example/javafxhope/assets/copy.png");
        squirrelRunning.setImage(image);

        Image image1 = new Image(
                "file:///Users/ulianaboikova/IdeaProjects/JavaFXHope/src/main/java/com/example/javafxhope/assets/haunter.png");
        haunterRunning.setImage(image1);

        Image image2 = new Image(
                "file:///Users/ulianaboikova/IdeaProjects/JavaFXHope/src/main/java/com/example/javafxhope/assets/XDZT.gif");
        portal.setImage(image2);

        // Filling the table with obstacles, each cell is a pixel
        fillTable();

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        time = 0;


        // Starting an animation of the haunter(ghost)
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.0175), event -> {
            upgradeTime(0.0175);
            // if the haunter reached the player stop the game and show the loser page
            if (haunterRunning.getBoundsInParent().intersects(squirrelRunning.getBoundsInParent())) {
                timeline.stop();
                squirrelRunning.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/com/example/javafxhope/hope-lose.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }
            // if the player reached the portal stop the game and show the winner page
            if (squirrelRunning.getBoundsInParent().intersects(portal.getBoundsInParent())) {
                timeline.stop();
                System.out.println("You win!");
                squirrelRunning.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/com/example/javafxhope/hope-win.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }


            // Looking for the first step for the haunter to reach the player
            if (haunterRunning.getLayoutY() + SIZE < 400) {
                AlgorithmLi algorithm = new AlgorithmLi();
                int moveX = 0;
                int moveY = 0;
                cycle:
                for (int k = (int) squirrelRunning.getLayoutY(); k < squirrelRunning.getLayoutY() + SIZE; k++) {
                    for (int l = (int) squirrelRunning.getLayoutX(); l < squirrelRunning.getLayoutX() + SIZE; l++) {
                        List<int[]> path1 = algorithm.find(table, new int[]{(int) haunterRunning.getLayoutY(),
                                (int)haunterRunning.getLayoutX()}, new int[]{k, l}, SIZE, SIZE);
                        if (path1 != null && path1.size() >= 2) {
                            moveX = path1.get(1)[1];
                            moveY = path1.get(1)[0];
                            break cycle;
                        }
                    }
                }

                // Moving haunter closer to the player
                haunterRunning.setLayoutX(moveX);
                haunterRunning.setLayoutY(moveY);


            }
            else {
                // While haunter is not on the stage, just move it up
                haunterRunning.setLayoutY(haunterRunning.getLayoutY() - 1);
            }
        });

        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        System.out.println();
    }


    /**
     This method collects all obstacles lines to the same list.
     @return list of lines
     */
    private ArrayList<Line> lines() {
        ArrayList<Line> lines = new ArrayList<>();
        lines.add(line1);
        lines.add(line2);
        lines.add(line3);
        lines.add(line4);
        lines.add(line5);
        lines.add(line6);
        lines.add(line7);
        lines.add(line8);
        lines.add(line9);
        lines.add(line10);
        lines.add(line11);
        lines.add(line12);
        lines.add(line13);
        return lines;
    }


    /**
     This method builds the table of obstacles
     */
    public void fillTable() {
        for (int i = 0; i < 400; i++) {
            for (int j = 0; j < 600; j++) {
                Line line = new Line(j, i, j, i);
                for (Line line1: lines()) {
                    if (line.getBoundsInParent().intersects(line1.getBoundsInParent())) {
                        table[i][j] = 1;
                        break;
                    }
                }
                if (table[i][j] != 1) table[i][j] = 0;
            }
        }
        for (int i = 0; i < 400; i++) {
            for (int j = 0; j < 600; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
    }


    /**
     Checks if player cross any line if he does certain step to needed direction
     * @param circle player
     * @param step amount of pixels
     * @param isY vertical ot horizontal (if vertical - true, if horizontal - false)
     * @return
     */
    public boolean isLinesCrossed(ImageView circle, int step, boolean isY) {
        ImageView checkCircle;
        if (isY) {
            checkCircle = new ImageView();
            checkCircle.setLayoutX(circle.getLayoutX());
            checkCircle.setLayoutY(circle.getLayoutY() + step);
            checkCircle.setFitWidth(SIZE);
            checkCircle.setFitHeight(SIZE);
        } else {
            checkCircle = new ImageView();
            checkCircle.setLayoutX(circle.getLayoutX() + step);
            checkCircle.setLayoutY(circle.getLayoutY());
            checkCircle.setFitWidth(SIZE);
            checkCircle.setFitHeight(SIZE);
        }
        for (Line line: lines()) {
            if (checkCircle.getBoundsInParent().intersects(line.getBoundsInParent())) {
                return true;
            }
        }
        return false;
    }

    /**
     Handles a button press.
     @param keyEvent certain button
     */
    public void handleKeyPress(KeyEvent keyEvent) {
        System.out.println("Key Pressed: " + keyEvent.getCode());
        if (keyEvent.getCode() == UP) {
            // Turn squirrel to the needed direction
            if (squirrelRunning.getScaleX() == 1) {
                squirrelRunning.setRotate(270);
            } else {
                squirrelRunning.setRotate(90);
            }
            // if line is not crossed, make ten pixels step
            if (!isLinesCrossed(squirrelRunning, -10, true)) {

                Timeline timeline = new Timeline();
                timeline.setCycleCount(9);
                // smooth animation
                KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.005), event ->
                        squirrelRunning.setLayoutY(squirrelRunning.getLayoutY() - 1));

                timeline.getKeyFrames().add(keyFrame);
                timeline.play();
            } // if player cross line in 10 pixel, do the biggest step without crossing the line
            else {
                for (int i = -9; i <= -1; i++) {
                    if (!isLinesCrossed(squirrelRunning, i, true)) {
                        Timeline timeline = new Timeline();
                        timeline.setCycleCount(Math.abs(i + 1));
                        // smooth animation
                        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.005),
                                event -> squirrelRunning.setLayoutY(squirrelRunning.getLayoutY() - 1));
                        timeline.getKeyFrames().add(keyFrame);
                        timeline.play();
                        break;
                    }
                }
            }
        }
        // for step down
        if (keyEvent.getCode() == DOWN) {
            if (squirrelRunning.getScaleX() == 1) {
                squirrelRunning.setRotate(90);
            } else {
                squirrelRunning.setRotate(270);
            }
            if (!isLinesCrossed(squirrelRunning, 10, true)) {
                Timeline timeline = new Timeline();
                timeline.setCycleCount(9);

                KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.005),
                        event -> squirrelRunning.setLayoutY(squirrelRunning.getLayoutY() + 1));

                timeline.getKeyFrames().add(keyFrame);
                timeline.play();
            } else {
                for (int i = 9; i >= 1; i--) {
                    if (!isLinesCrossed(squirrelRunning, i, true)) {
                        Timeline timeline = new Timeline();
                        timeline.setCycleCount(i - 1);

                        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.005),
                                event -> squirrelRunning.setLayoutY(squirrelRunning.getLayoutY() + 1));
                        timeline.getKeyFrames().add(keyFrame);
                        timeline.play();
                        break;
                    }
                }
            }
        }
        // for step left
        if (keyEvent.getCode() == LEFT) {
            squirrelRunning.setRotate(0);
            squirrelRunning.setScaleX(-1);
            if (!isLinesCrossed(squirrelRunning, -10, false)) {
                Timeline timeline = new Timeline();
                timeline.setCycleCount(Math.abs(9));

                KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.005),
                        event -> squirrelRunning.setLayoutX(squirrelRunning.getLayoutX() - 1));
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();

            } else {
                for (int i = -9; i <= -1; i++) {
                    if (!isLinesCrossed(squirrelRunning, i, false)) {
                        Timeline timeline = new Timeline();
                        timeline.setCycleCount(Math.abs(i + 1));

                        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.005),
                                event -> squirrelRunning.setLayoutX(squirrelRunning.getLayoutX() - 1));
                        timeline.getKeyFrames().add(keyFrame);
                        timeline.play();
                        break;
                    }
                }
            }
        }
        // for step right
        if (keyEvent.getCode() == RIGHT) {
            squirrelRunning.setScaleX(1);
            squirrelRunning.setRotate(0);
            if (!isLinesCrossed(squirrelRunning, 10, false)) {
                Timeline timeline = new Timeline();
                timeline.setCycleCount(Math.abs(9));

                KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.005),
                        event -> squirrelRunning.setLayoutX(squirrelRunning.getLayoutX() + 1));
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();
            } else {
                for (int i = 9; i >= 1; i--) {
                    if (!isLinesCrossed(squirrelRunning, i, false)) {
                        Timeline timeline = new Timeline();
                        timeline.setCycleCount(Math.abs(i - 1));

                        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.005),
                                event -> squirrelRunning.setLayoutX(squirrelRunning.getLayoutX() + 1));
                        timeline.getKeyFrames().add(keyFrame);
                        timeline.play();
                        break;
                    }
                }
            }
        }
    }
}








