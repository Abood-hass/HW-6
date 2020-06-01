package com.AboodHass.HW_6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hw6Application  extends Application{

	public static void main(String[] args){
//              SpringApplication.run(Hw6Application.class, args);
              launch(args);  
	}

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/The_GUI.fxml"));
        loader.setControllerFactory(SpringApplication.run(Hw6Application.class)::getBean);
        Pane pane = loader.load();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Spring Boot");
        primaryStage.show();
    }

}
