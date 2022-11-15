package com.mycompany.graficadora_2;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application
{

    /**
     *
     * @param primaryStage
     *
     */
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException
    {
        scene = new Scene(loadFXML("Graficadora"), 1280, 800);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Graficadora");
        stage.getIcons().add(new Image(App.class.getResourceAsStream("icon2.png")));
        stage.setMinWidth(640);
        stage.setMinHeight(480);
        stage.centerOnScreen();
    }

    private static Parent loadFXML(String fxml) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args)
    {
        launch();
    }
}
