package com.example.javafxhope;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import static com.example.javafxhope.HopeWinController.time;

public class LevelNineHopeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane gamePane;




    @FXML
    private Line line1;

    @FXML
    private Line line10;

    @FXML
    private Line line11;

    @FXML
    private Line line12;

    @FXML
    private Line line13;

    @FXML
    private Line line14;

    @FXML
    private Line line15;

    @FXML
    private Line line16;

    @FXML
    private Line line17;

    @FXML
    private Line line18;

    @FXML
    private Line line19;

    @FXML
    private Line line2;

    @FXML
    private Line line20;

    @FXML
    private Line line21;

    @FXML
    private Line line22;

    @FXML
    private Line line23;

    @FXML
    private Line line24;

    @FXML
    private Line line25;

    @FXML
    private Line line26;

    @FXML
    private Line line27;

    @FXML
    private Line line28;

    @FXML
    private Line line29;

    @FXML
    private Line line3;

    @FXML
    private Line line30;

    @FXML
    private Line line31;

    @FXML
    private Line line32;

    @FXML
    private Line line33;

    @FXML
    private Line line34;

    @FXML
    private Line line35;

    @FXML
    private Line line36;

    @FXML
    private Line line37;

    @FXML
    private Line line38;

    @FXML
    private Line line39;

    @FXML
    private Line line4;

    @FXML
    private Line line40;

    @FXML
    private Line line41;

    @FXML
    private Line line42;

    @FXML
    private Line line43;

    @FXML
    private Line line44;

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
    private Pane mainPane;

    @FXML
    private ImageView portal;


    @FXML
    private ImageView haunterRunning;
    private final ArrayList<Step> ghostSteps = new ArrayList<>();

    private final static int SIZE = 25;



    @FXML
    private ImageView squirrelRunning;
    private final ArrayList<Step> squirrelSteps = new ArrayList<>();
    private final ArrayList<Step> haunterSteps = new ArrayList<>();
    private final ArrayList<Step> haunterWalking = new ArrayList<>();

    private int[][] table = new int[400][600];
    public void upgradeTime(double interval) {
        time += interval;
    }


    @FXML
    void initialize() {
        Platform.runLater(() -> mainPane.requestFocus());
        Image image = new Image("file:///Users/ulianaboikova/IdeaProjects/JavaFXHope/src/main/java/com/example/javafxhope/assets/copy.png");
        squirrelRunning.setImage(image);

        Image image1 = new Image("file:///Users/ulianaboikova/IdeaProjects/JavaFXHope/src/main/java/com/example/javafxhope/assets/haunter.png");
        haunterRunning.setImage(image1);

        Image image2 = new Image("file:///Users/ulianaboikova/IdeaProjects/JavaFXHope/src/main/java/com/example/javafxhope/assets/XDZT.gif");
        portal.setImage(image2);

        fillTable();

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE); // Анимация будет бесконечной
        AtomicInteger i = new AtomicInteger();
        AtomicInteger x = new AtomicInteger();
        x.set(100);
        AtomicInteger y = new AtomicInteger();
        AtomicBoolean hope = new AtomicBoolean();
        hope.set(true);
        time = 0;


        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.015), event -> {
            upgradeTime(0.015);
            System.out.println("I am working!");
            System.out.println("Start Y: " + line13.getStartY());
            if (haunterRunning.getBoundsInParent().intersects(squirrelRunning.getBoundsInParent())) {
                timeline.stop();
                System.out.println("You win!");
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

            // Перемещение круга
            int newLocationX = 0;
            int newLocationY = 0;

            // Логика движения по Y
            if (squirrelRunning.getLayoutY() > haunterRunning.getLayoutY() && haunterRunning.getLayoutY() < 400) {
                newLocationY = 1; // Двигаться вниз
            } else if (squirrelRunning.getLayoutY() < haunterRunning.getLayoutY() && haunterRunning.getLayoutY() > 0) {
                newLocationY = -1; // Двигаться вверх
            }

            // Логика движения по X
            if (squirrelRunning.getLayoutX() > haunterRunning.getLayoutX() && haunterRunning.getLayoutX() < 600) {
                newLocationX = 1; // Двигаться вправо
            } else if (squirrelRunning.getLayoutX() < haunterRunning.getLayoutX() && haunterRunning.getLayoutX() > 0) {
                newLocationX = -1; // Двигаться влево
            }

            if (haunterRunning.getLayoutY() + SIZE < 400) {
                System.out.println("I am working STILL!");
                AlgorithmLi algorithm = new AlgorithmLi();
                int moveX = 0;
                int moveY = 0;
                cycle:
                for (int k = (int) squirrelRunning.getLayoutY(); k < squirrelRunning.getLayoutY() + SIZE; k++) {
                    for (int l = (int) squirrelRunning.getLayoutX(); l < squirrelRunning.getLayoutX() + SIZE; l++) {
                        List<int[]> path1 = algorithm.find(table, new int[]{(int) haunterRunning.getLayoutY() , (int)haunterRunning.getLayoutX()}, new int[]{(int) k , (int) l}, SIZE, SIZE);
                        if (path1 != null && path1.size() >= 2) {
                            moveX = path1.get(1)[1];
                            moveY = path1.get(1)[0];
                            break cycle;
                        }
                    }
                }

                haunterRunning.setLayoutX(moveX);
                haunterRunning.setLayoutY(moveY);


            }
            else {
                haunterRunning.setLayoutY(haunterRunning.getLayoutY() - 1);
            }

            ghostSteps.add(new Step((int) haunterRunning.getLayoutX(), (int) haunterRunning.getLayoutY()));


        });

        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        System.out.println();
        System.out.println("Проверка: " + squirrelRunning.getBoundsInParent().contains(squirrelRunning.getLayoutX(), squirrelRunning.getLayoutY() - 21));
    }









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
        lines.add(line14);
        lines.add(line15);
        lines.add(line16);
        lines.add(line17);
        lines.add(line18);
        lines.add(line19);
        lines.add(line20);
        lines.add(line21);
        lines.add(line22);
        lines.add(line23);
        lines.add(line24);
        lines.add(line25);
        lines.add(line26);
        lines.add(line27);
        lines.add(line28);
        lines.add(line29);
        lines.add(line30);
        lines.add(line31);
        lines.add(line32);
        lines.add(line33);
        lines.add(line34);
        lines.add(line35);
        lines.add(line36);
        lines.add(line37);
        lines.add(line38);
        lines.add(line39);
        lines.add(line40);
        lines.add(line41);
        lines.add(line42);
        lines.add(line43);
        lines.add(line44);
        return lines;
    }




    // Метод для проверки, лежит ли точка (px, py) на линии



    public void fillTable() {
        for (int i = 0; i < 400; i++) {
            for (int j = 0; j < 600; j++) {
                Line line = new Line(j, i, j, i);
                if (line.getBoundsInParent().intersects(line1.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line2.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line3.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line4.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line5.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line6.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line7.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line8.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line9.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line10.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line11.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line12.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line13.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line14.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line15.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line16.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line17.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line18.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line19.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line20.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line21.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line22.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line23.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line24.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line25.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line26.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line27.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line28.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line29.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line30.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line31.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line32.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line33.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line34.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line35.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line36.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line37.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line38.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line39.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line40.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line41.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line42.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line43.getBoundsInParent()) ||
                        line.getBoundsInParent().intersects(line44.getBoundsInParent())) {
                    table[i][j] = 1;
                }
                else table[i][j] = 0;
            }
        }
        for (int i = 0; i < 400; i++) {
            for (int j = 0; j < 600; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
    }





    private void setHaunterSteps(Step step) {
        for (int i = 5; i >= 1; i--) {
            haunterSteps.add(new Step(step.getX() / 5, step.getY() / 5));
        }
    }




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

    public void handleKeyPress(KeyEvent keyEvent) {
        System.out.println("Key Pressed: " + keyEvent.getCode()); // Печатаем нажатую клавишу
        switch (keyEvent.getCode()) {
            case UP:
                if (squirrelRunning.getScaleX() == 1) {
                    squirrelRunning.setRotate(270);
                } else {
                    squirrelRunning.setRotate(90);
                }
                if (!isLinesCrossed(squirrelRunning, -10, true)) {

                    Timeline timeline = new Timeline();
                    timeline.setCycleCount(9);

                    KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.005), event ->
                            squirrelRunning.setLayoutY(squirrelRunning.getLayoutY() - 1));

                    timeline.getKeyFrames().add(keyFrame);
                    timeline.play();
                } else {
                    for (int i = -9; i <= -1; i++) {
                        if (!isLinesCrossed(squirrelRunning, i, true)) {
                            Timeline timeline = new Timeline();
                            timeline.setCycleCount(Math.abs(i + 1));

                            KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.005), event -> {
                                squirrelRunning.setLayoutY(squirrelRunning.getLayoutY() - 1);
                            });
                            timeline.getKeyFrames().add(keyFrame);
                            timeline.play();
                            squirrelSteps.add(new Step(0, i + 1));
                            setHaunterSteps(new Step(0, i + 1));
                            break;
                        }
                    }
                }
                break;
            case DOWN:
                if (squirrelRunning.getScaleX() == 1) {
                    squirrelRunning.setRotate(90);
                } else {
                    squirrelRunning.setRotate(270);
                }
                if (!isLinesCrossed(squirrelRunning, 10, true)) {
                    Timeline timeline = new Timeline();
                    timeline.setCycleCount(9);

                    KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.005), event -> {
                        squirrelRunning.setLayoutY(squirrelRunning.getLayoutY() + 1);


                    });

                    timeline.getKeyFrames().add(keyFrame);
                    timeline.play();

                    squirrelSteps.add(new Step(0, 9));
                    setHaunterSteps(new Step(0, 9));
                } else {
                    for (int i = 9; i >= 1; i--) {
                        if (!isLinesCrossed(squirrelRunning, i, true)) {
                            Timeline timeline = new Timeline();
                            timeline.setCycleCount(i - 1);

                            KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.005), event -> {
                                squirrelRunning.setLayoutY(squirrelRunning.getLayoutY() + 1);


                            });
                            timeline.getKeyFrames().add(keyFrame);
                            timeline.play();

                            squirrelSteps.add(new Step(0, i - 1));
                            setHaunterSteps(new Step(0, i - 1));
                            break;
                        }
                    }
                }
                break;
            case LEFT:
                squirrelRunning.setRotate(0);
                squirrelRunning.setScaleX(-1);
                if (!isLinesCrossed(squirrelRunning, -10, false)) {
                    Timeline timeline = new Timeline();
                    timeline.setCycleCount(Math.abs(9));

                    KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.005), event -> {
                        squirrelRunning.setLayoutX(squirrelRunning.getLayoutX() - 1);


                    });
                    timeline.getKeyFrames().add(keyFrame);
                    timeline.play();


                    squirrelSteps.add(new Step(-9, 0));
                    setHaunterSteps(new Step(-9, 0));
                } else {
                    for (int i = -9; i <= -1; i++) {
                        if (!isLinesCrossed(squirrelRunning, i, false)) {
                            Timeline timeline = new Timeline();
                            timeline.setCycleCount(Math.abs(i + 1));

                            KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.005), event -> {
                                squirrelRunning.setLayoutX(squirrelRunning.getLayoutX() - 1);


                            });
                            timeline.getKeyFrames().add(keyFrame);
                            timeline.play();
                            squirrelSteps.add(new Step(i + 1, 0));
                            setHaunterSteps(new Step(i + 1, 0));
                            break;
                        }
                    }
                }
                break;
            case RIGHT:
                squirrelRunning.setScaleX(1);
                squirrelRunning.setRotate(0);
                if (!isLinesCrossed(squirrelRunning, 10, false)) {
                    Timeline timeline = new Timeline();
                    timeline.setCycleCount(Math.abs(9));

                    KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.005), event -> {
                        squirrelRunning.setLayoutX(squirrelRunning.getLayoutX() + 1);


                    });
                    timeline.getKeyFrames().add(keyFrame);
                    timeline.play();
                    squirrelSteps.add(new Step(9, 0));
                    setHaunterSteps(new Step(9, 0));
                } else {
                    for (int i = 9; i >= 1; i--) {
                        if (!isLinesCrossed(squirrelRunning, i, false)) {
                            Timeline timeline = new Timeline();
                            timeline.setCycleCount(Math.abs(i - 1));

                            KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.005), event -> {
                                squirrelRunning.setLayoutX(squirrelRunning.getLayoutX() + 1);


                            });
                            timeline.getKeyFrames().add(keyFrame);
                            timeline.play();
                            squirrelSteps.add(new Step(i - 1, 0));
                            setHaunterSteps(new Step(i - 1, 0));
                            break;
                        }
                    }
                }
                break;
            default:
                break; // Добавлено для обработки других клавиш
        }
    }
}
