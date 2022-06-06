package com.internshala.connect4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Controller controller;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane = loader.load();
        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        MenuBar menuBar = createMenuBar();
        menuBar.prefWidthProperty().bind(stage.widthProperty());
        menuPane.getChildren().add(menuBar);
        controller = loader.getController();
        controller.createPlayGround();

        Scene scene = new Scene(rootGridPane);
        stage.setScene(scene);
        stage.setTitle("Connect Four");
        stage.setResizable(false);
        stage.show();
    }
    private MenuBar createMenuBar() {

        Menu fileMenu = new Menu("File");
        MenuItem newGame = new MenuItem("New Game");
        newGame.setOnAction(event -> controller.resetGame());

        MenuItem resetGame = new MenuItem("Reset Game");
        resetGame.setOnAction(event -> controller.resetGame());

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });

        fileMenu.getItems().addAll(newGame, resetGame, separatorMenuItem, exit);

        Menu helpMenu = new Menu("Help");
        MenuItem aboutGame = new MenuItem("About Game");
        aboutGame.setOnAction(event -> aboutConnect4());

        SeparatorMenuItem separatorMenuItem1 = new SeparatorMenuItem();

        MenuItem aboutMe = new MenuItem("About Me");
        aboutMe.setOnAction(event -> aboutMe());

        helpMenu.getItems().addAll(aboutGame, separatorMenuItem1, aboutMe);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);
        return menuBar;
    }



    private void aboutMe() {

        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("About the Developer");
        alertDialog.setHeaderText("Ajay Kumbhar");
        alertDialog.setContentText("I love programming and solving puzzles. Connect four is" +
                " the game that I made why learning Java from Internshala trainings. Connect" +
                " four is one of the game that I play in my free time with my family and friends.");
        alertDialog.show();

    }

    private void aboutConnect4() {

        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("About Connect Four");
        alertDialog.setHeaderText("How to Play?");
        alertDialog.setContentText("Connect Four is a two-player connection game in which the " +
                "players first choose a color and then take turns dropping colored discs from" +
                " the top into a seven-column, six-row vertically suspended grid. The pieces" +
                " fall straight down, occupying the next available space within the column. The" +
                " objective of the game is to be the first to form a horizontal, vertical, or" +
                " diagonal line of four of one's own discs. Connect Four is a solved game. The" +
                " first player can always win by playing the right moves.");
        alertDialog.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alertDialog.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}