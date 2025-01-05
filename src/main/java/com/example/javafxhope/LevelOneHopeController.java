package com.example.javafxhope;

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
import javafx.stage.Stage;
import javafx.util.Duration;

import static com.example.javafxhope.HopeWinController.time;

public class LevelOneHopeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane gamePane;



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
    private final ArrayList<Step> ghostSteps = new ArrayList<>();



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


        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.04), event -> {
            upgradeTime(0.04);
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
            // haunterRunning.setLayoutY(haunterRunning.getLayoutY() + haunterSteps.get(i.get()).getY());
            // haunterRunning.setLayoutX(haunterRunning.getLayoutX() + haunterSteps.get(i.get()).getX());
            // i.getAndIncrement();
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

            if (haunterRunning.getLayoutY() + 40 < 400) {
                System.out.println("I am working STILL!");
                AlgorithmLi algorithm = new AlgorithmLi();
                int moveX = 0;
                int moveY = 0;
                cycle:
                for (int k = (int) squirrelRunning.getLayoutY(); k < squirrelRunning.getLayoutY() + 40; k++) {
                    for (int l = (int) squirrelRunning.getLayoutX(); l < squirrelRunning.getLayoutX() + 40; l++) {
                        List<int[]> path1 = algorithm.find(table, new int[]{(int) haunterRunning.getLayoutY() , (int)haunterRunning.getLayoutX()}, new int[]{(int) k , (int) l}, 40, 40);
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

    private List<int[]> cells() {
        List<int[]> cells = new ArrayList<>();
        for (int j = (int) haunterRunning.getLayoutX(); j <= haunterRunning.getLayoutX() + 39; j++) {
            for (int i = (int) haunterRunning.getLayoutY(); i <= haunterRunning.getLayoutY() + 39; i++) {
                cells.add(new int[]{i, j});
            }
        }
        return cells;
    }

    private boolean checkCrossing(double x, double y) {
        ImageView image;
        image = new ImageView();
        image.setFitWidth(40.0);
        image.setFitHeight(40.0);
        image.setLayoutX(x);
        image.setLayoutY(y);
        boolean result = false;
        Line line1 = new Line(image.getLayoutX(), image.getLayoutY(), image.getLayoutX() + 39, image.getLayoutY());
        Line line2 = new Line(image.getLayoutX() + 39, image.getLayoutY(), image.getLayoutX() + 39, image.getLayoutY() + 39);
        Line line3 = new Line(image.getLayoutX() + 39, image.getLayoutY() + 39, image.getLayoutX(), image.getLayoutY() + 39);
        Line line4 = new Line(image.getLayoutX(), image.getLayoutY() + 39, image.getLayoutX(), image.getLayoutY());
        for (Line line: lines()) {
            if (line1.getBoundsInParent().intersects(line.getBoundsInParent())) return true;
            if (line2.getBoundsInParent().intersects(line.getBoundsInParent())) return true;
            if (line3.getBoundsInParent().intersects(line.getBoundsInParent())) return true;
            if (line4.getBoundsInParent().intersects(line.getBoundsInParent())) return true;
        }
        return result;
    }
    private boolean checkCrossing1(double x, double y) {
        ImageView image;
        image = new ImageView();
        image.setFitWidth(40.0);
        image.setFitHeight(40.0);
        image.setLayoutX(x);
        image.setLayoutY(y);
        boolean result = false;
        Line line1 = new Line(image.getLayoutX(), image.getLayoutY(), image.getLayoutX() + 39, image.getLayoutY());
        Line line2 = new Line(image.getLayoutX() + 39, image.getLayoutY(), image.getLayoutX() + 39, image.getLayoutY() - 39);
        Line line3 = new Line(image.getLayoutX() + 39, image.getLayoutY() - 39, image.getLayoutX(), image.getLayoutY() - 39);
        Line line4 = new Line(image.getLayoutX(), image.getLayoutY() - 39, image.getLayoutX(), image.getLayoutY());
        for (Line line: lines()) {
            if (line1.getBoundsInParent().intersects(line.getBoundsInParent())) return true;
            if (line2.getBoundsInParent().intersects(line.getBoundsInParent())) return true;
            if (line3.getBoundsInParent().intersects(line.getBoundsInParent())) return true;
            if (line4.getBoundsInParent().intersects(line.getBoundsInParent())) return true;
        }
        return result;
    }

    public boolean isLinesCrossedNew(ImageView circle, Step step) {
        ImageView checkCircle;
        checkCircle = new ImageView();
        checkCircle.setLayoutX(circle.getLayoutX() + step.getX());
        checkCircle.setLayoutY(circle.getLayoutY() + step.getY());
        checkCircle.setFitWidth(40.0);
        checkCircle.setFitHeight(40.0);
        for (Line line: lines()) {
            if (checkCircle.getBoundsInParent().intersects(line.getBoundsInParent())) {
                return true;
            }
        }
        return false;
    }

    private boolean isObstacleBetween(ImageView squirrel, ImageView haunter) {
        Line checkLine = new Line(squirrel.getLayoutX(), squirrel.getLayoutY(), haunter.getLayoutX() + 39, haunter.getLayoutY() + 39);
        /*
        int x = (int) Math.min(squirrel.getLayoutX(), haunter.getLayoutX());
        int y = (int) Math.min(squirrel.getLayoutY(), haunter.getLayoutY());
        int width = (int) Math.max(squirrel.getLayoutX(), haunter.getLayoutX()) - (int) Math.min(squirrel.getLayoutX(), haunter.getLayoutX()) + 40;
        int height = (int) Math.max(squirrel.getLayoutY(), haunter.getLayoutY()) - (int) Math.min(squirrel.getLayoutY(), haunter.getLayoutY()) + 40;
        Rectangle checkLine = new Rectangle(x, y, width, height);

         */
        return (checkLine.getBoundsInParent().intersects(line1.getBoundsInParent()) ||
                checkLine.getBoundsInParent().intersects(line2.getBoundsInParent()) ||
                checkLine.getBoundsInParent().intersects(line3.getBoundsInParent()) ||
                checkLine.getBoundsInParent().intersects(line4.getBoundsInParent()) ||
                checkLine.getBoundsInParent().intersects(line5.getBoundsInParent()) ||
                checkLine.getBoundsInParent().intersects(line6.getBoundsInParent()) ||
                checkLine.getBoundsInParent().intersects(line7.getBoundsInParent()) ||
                checkLine.getBoundsInParent().intersects(line8.getBoundsInParent()) ||
                checkLine.getBoundsInParent().intersects(line9.getBoundsInParent()) ||
                checkLine.getBoundsInParent().intersects(line10.getBoundsInParent()) ||
                checkLine.getBoundsInParent().intersects(line11.getBoundsInParent()) ||
                checkLine.getBoundsInParent().intersects(line12.getBoundsInParent()) ||
                checkLine.getBoundsInParent().intersects(line13.getBoundsInParent()));
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
        return lines;
    }


    public void fillTable1() {
        // Размеры области (например, 400x600)
        int width = 600;
        int height = 400;

        // Массив для хранения результата
        table = new int[height][width];

        // Массив линий (предположим, что линии заданы координатами концов)
        Line[] lines = new Line[] {line1, line2, line3, line4, line5, line6, line7, line8, line9, line10,
                line11, line12, line13};

        // Проходим по всем пикселям области
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                boolean intersects = false;

                // Проверяем каждую линию
                for (Line line : lines) {
                    if (isPointOnLine(j, i, line)) {
                        intersects = true;
                        break;  // Если точка пересекает хотя бы одну линию, завершаем проверку
                    }
                }

                // Если точка пересекает хотя бы одну линию, ставим 1, иначе 0
                table[i][j] = intersects ? 1 : 0;
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
    }

    // Метод для проверки, лежит ли точка (px, py) на линии
    private boolean isPointOnLine(int px, int py, Line line) {
        double x1 = line.getStartX();
        double y1 = line.getStartY();
        double x2 = line.getEndX();
        double y2 = line.getEndY();

        // Для вертикальных линий
        if (x1 == x2) {
            return px == x1 && py >= Math.min(y1, y2) && py <= Math.max(y1, y2);
        }

        // Вычисляем угловой коэффициент прямой
        double m = (y2 - y1) / (x2 - x1);

        // Проверяем, лежит ли точка (px, py) на линии, используя уравнение прямой
        double expectedY = y1 + m * (px - x1);

        // Если y-координата точки близка к вычисленной, проверяем, лежит ли точка между концами отрезка
        return Math.abs(py - expectedY) < 0.5 && px >= Math.min(x1, x2) && px <= Math.max(x1, x2) && py >= Math.min(y1, y2) && py <= Math.max(y1, y2);
    }


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
                        line.getBoundsInParent().intersects(line13.getBoundsInParent())) {
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



    private ArrayList<Step> goAround(ImageView squirrel, ImageView haunter) {

        ImageView checkCircle;
        checkCircle = new ImageView();
        checkCircle.setLayoutX(haunterRunning.getLayoutX());
        checkCircle.setLayoutY(haunterRunning.getLayoutY());
        checkCircle.setFitWidth(40.0);
        checkCircle.setFitHeight(40.0);

        Line checkLine = new Line(squirrel.getLayoutX(), squirrel.getLayoutY(), haunter.getLayoutX(), haunter.getLayoutY());
        Line crossedLine = new Line();
        boolean isVertical = true;
        int newLocationX = 0;
        int newLocationY = 0;

        if (squirrelRunning.getLayoutY() > haunterRunning.getLayoutY() && haunterRunning.getLayoutY() < 400) {
            newLocationY = 5; // Двигаться вниз
        } else if (squirrelRunning.getLayoutY() < haunterRunning.getLayoutY() && haunterRunning.getLayoutY() > 0) {
            newLocationY = -5; // Двигаться вверх
        }

        if (squirrelRunning.getLayoutX() > haunterRunning.getLayoutX() && haunterRunning.getLayoutX() < 600) {
            newLocationX = 5; // Двигаться вправо
        } else if (squirrelRunning.getLayoutX() < haunterRunning.getLayoutX() && haunterRunning.getLayoutX() > 0) {
            newLocationX = -5; // Двигаться влево
        }

        Line priorityLine = new Line();
        double distance = 730;

        for (Line line: lines()) {
            if (checkLine.getBoundsInParent().intersects(line.getBoundsInParent()) && findIntersectionDistance(checkLine, line) < distance) {
                priorityLine = line;
                distance = findIntersectionDistance(checkLine, line);
            }
        }
        if (priorityLine.getStartX() == priorityLine.getEndX()) isVertical = false;

        ArrayList<Step> stepsVertical1 = new ArrayList<>();
        ArrayList<Step> stepsVertical2 = new ArrayList<>();

        int stepNumbers1 = 0;
        int stepNumbers2 = 0;

        boolean wrongWay = false;

        if (!isVertical) {
            System.out.println("VERTICAl");
            while (isLinesCrossed(checkCircle, newLocationX, false)) {
                System.out.println("WORKS Y DOWN");
                checkCircle.setLayoutY(checkCircle.getLayoutY() + 5);
                stepsVertical1.add(new Step(0, 5));
                if (checkCircle.getLayoutY() + 40 >= 400 || ((ghostSteps.size() >= 2) &&
                        (ghostSteps.get(ghostSteps.size() - 2).getY() == checkCircle.getLayoutY()))) {
                    wrongWay = true;
                }
                stepNumbers1++;
            }
            System.out.println(wrongWay + " UP");
            boolean wrongWay1 = false;
            checkCircle.setLayoutY(haunterRunning.getLayoutY());
            while (isLinesCrossed(checkCircle, newLocationX, false)) {
                System.out.println("WORKS Y UP");
                checkCircle.setLayoutY(checkCircle.getLayoutY() - 5);
                stepsVertical2.add(new Step(0, -5));
                if (checkCircle.getLayoutY() <= 0 || ((ghostSteps.size() >= 2) &&
                        (ghostSteps.get(ghostSteps.size() - 2).getY() == checkCircle.getLayoutY()))) {
                    wrongWay1 = true;
                }
                stepNumbers2++;
            }
            System.out.println(wrongWay1 + " DOWN");
            if ((stepNumbers1 <= stepNumbers2 && !wrongWay) || (stepNumbers1 >= stepNumbers2 && wrongWay1)) {
                checkCircle.setLayoutY(haunterRunning.getLayoutY() + 5 * stepNumbers1);
                stepsVertical1.add(new Step(newLocationX, 0));
                stepsVertical1.add(new Step(newLocationX, 0));
                return stepsVertical1;
            }
            else {
                stepsVertical2.add(new Step(newLocationX, 0));
                stepsVertical2.add(new Step(newLocationX, 0));
                return stepsVertical2;
            }
        }
        else {
            System.out.println("Horizontal");
            while (isLinesCrossed(checkCircle, newLocationY, true)) {
                System.out.println("WORKS X FORWARD");
                checkCircle.setLayoutX(checkCircle.getLayoutX() + 5);
                stepsVertical1.add(new Step(5, 0));
                if (checkCircle.getLayoutX() + 40 >= 600 || ((ghostSteps.size() >= 2) &&
                        (ghostSteps.get(ghostSteps.size() - 2).getX() == checkCircle.getLayoutX()))) {
                    wrongWay = true;
                }
                stepNumbers1++;
            }
            System.out.println(wrongWay + " BACK");
            boolean wrongWay1 = false;
            checkCircle.setLayoutX(haunterRunning.getLayoutX());
            while (isLinesCrossed(checkCircle, newLocationY, true)) {
                System.out.println("WORKS X BACK");
                checkCircle.setLayoutX(checkCircle.getLayoutX() - 5);
                stepsVertical2.add(new Step(-5, 0));
                if (checkCircle.getLayoutX() <= 0 || ((ghostSteps.size() >= 2) &&
                        (ghostSteps.get(ghostSteps.size() - 2).getX() == checkCircle.getLayoutX()))) {
                    wrongWay1 = true;
                }
                stepNumbers2++;
            }
            System.out.println(wrongWay1 + " FRONT");
            if ((stepNumbers1 <= stepNumbers2 && !wrongWay) || (stepNumbers1 >= stepNumbers2 && wrongWay1)) {
                checkCircle.setLayoutX(haunterRunning.getLayoutX() + 5 * stepNumbers1);
                stepsVertical1.add(new Step( 0, newLocationY));
                stepsVertical1.add(new Step( 0, newLocationY));
                return stepsVertical1;
            }
            else {
                stepsVertical2.add(new Step(0, newLocationY));
                stepsVertical2.add(new Step(0, newLocationY));
                return stepsVertical2;
            }
        }
    }


    private ArrayList<Step> recursiveStepsVertical(ImageView checkCircle, int newLocationX) {
        ArrayList<Step> stepsVertical1 = new ArrayList<>();
        ArrayList<Step> stepsVertical2 = new ArrayList<>();

        int stepNumbers1 = 0;
        int stepNumbers2 = 0;

        boolean wrongWay = false;

        System.out.println("VERTICAl");
        while (!(!isLinesCrossed(checkCircle, newLocationX, false) || wrongWay)) {
            System.out.println("WORKS Y DOWN");
            checkCircle.setLayoutY(checkCircle.getLayoutY() + 5);
            stepsVertical1.add(new Step(0, 5));
            if (checkCircle.getLayoutY() + 40 >= 400) wrongWay = true;
            stepNumbers1++;
        }
        System.out.println(wrongWay + " UP");
        boolean wrongWay1 = false;
        checkCircle.setLayoutY(haunterRunning.getLayoutY());
        while (!(!isLinesCrossed(checkCircle, newLocationX, false) || wrongWay1)) {
            System.out.println("WORKS Y UP");
            checkCircle.setLayoutY(checkCircle.getLayoutY() - 5);
            stepsVertical2.add(new Step(0, -5));
            if (checkCircle.getLayoutY() <= 0) wrongWay1 = true;
            stepNumbers2++;
        }
        System.out.println(wrongWay1 + " DOWN");
        if ((stepNumbers1 <= stepNumbers2 && !wrongWay) || (stepNumbers1 >= stepNumbers2 && wrongWay1)) {
            checkCircle.setLayoutY(haunterRunning.getLayoutY() + 5 * stepNumbers1);
            stepsVertical1.add(new Step(newLocationX, 0));
            return stepsVertical1;
        }
        else {
            stepsVertical2.add(new Step(newLocationX, 0));
            return stepsVertical2;
        }
    }

    private ArrayList<Step> recursiveStepsHorisontal(ImageView checkCircle, int newLocationY) {
        ArrayList<Step> stepsVertical1 = new ArrayList<>();
        ArrayList<Step> stepsVertical2 = new ArrayList<>();

        int stepNumbers1 = 0;
        int stepNumbers2 = 0;

        boolean wrongWay = false;

        System.out.println("Horizontal");
        while (!(!isLinesCrossed(checkCircle, newLocationY, true) || wrongWay)) {
            System.out.println("WORKS X FORWARD");
            checkCircle.setLayoutX(checkCircle.getLayoutX() + 5);
            stepsVertical1.add(new Step(5, 0));
            if (checkCircle.getLayoutX() + 40 >= 600) wrongWay = true;
            stepNumbers1++;
        }
        System.out.println(wrongWay + " BACK");
        boolean wrongWay1 = false;
        checkCircle.setLayoutX(haunterRunning.getLayoutX());
        while (!(!isLinesCrossed(checkCircle, newLocationY, true) || wrongWay1)) {
            System.out.println("WORKS X BACK");
            checkCircle.setLayoutX(checkCircle.getLayoutX() - 5);
            stepsVertical2.add(new Step(-5, 0));
            if (checkCircle.getLayoutX() <= 0) wrongWay1 = true;
            stepNumbers2++;
        }
        System.out.println(wrongWay1 + " FRONT");
        if ((stepNumbers1 <= stepNumbers2 && !wrongWay) || (stepNumbers1 >= stepNumbers2 && wrongWay1)) {
            checkCircle.setLayoutX(haunterRunning.getLayoutX() + 5 * stepNumbers1);
            stepsVertical1.add(new Step( 0, newLocationY));
            return stepsVertical1;
        }
        else {
            stepsVertical2.add(new Step(0, newLocationY));
            return stepsVertical2;
        }
    }


    public double findIntersectionDistance(Line line1, Line line2) {
        // Вычисляем коэффициенты для линий
        double x1 = line1.getStartX();
        double x2 = line1.getEndX();
        double x3 = line2.getStartX();
        double x4 = line2.getEndX();

        double y1 = line1.getStartY();
        double y2 = line1.getEndY();
        double y3 = line2.getStartY();
        double y4 = line2.getEndY();

        double denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

        double intersectX = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / denominator;
        double intersectY = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / denominator;

        return Math.sqrt(Math.pow(intersectX - haunterRunning.getLayoutX(), 2) + Math.pow(intersectY - haunterRunning.getLayoutY(), 2));
    }




    private void setHaunterSteps(Step step) {
        for (int i = 5; i >= 1; i--) {
            haunterSteps.add(new Step(step.getX() / 5, step.getY() / 5));
        }
    }

    private Step getSquirrelLocation() {
        int y = 330;
        int x = 5;
        for (Step step: haunterSteps) {
            y += step.getY();
            x += step.getX();
        }
        return new Step(x, y);
    }







    public boolean isLinesCrossed(ImageView circle, int step, boolean isY) {
        ImageView checkCircle;
        if (isY) {
            checkCircle = new ImageView();
            checkCircle.setLayoutX(circle.getLayoutX());
            checkCircle.setLayoutY(circle.getLayoutY() + step);
            checkCircle.setFitWidth(40.0);
            checkCircle.setFitHeight(40.0);
        } else {
            checkCircle = new ImageView();
            checkCircle.setLayoutX(circle.getLayoutX() + step);
            checkCircle.setLayoutY(circle.getLayoutY());
            checkCircle.setFitWidth(40.0);
            checkCircle.setFitHeight(40.0);
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







