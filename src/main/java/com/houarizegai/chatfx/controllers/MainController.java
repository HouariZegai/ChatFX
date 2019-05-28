package com.houarizegai.chatfx.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private void launchServer(MouseEvent e) {
        ((AnchorPane)e.getSource()).setDisable(true);
        
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/views/Server.fxml"));
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/images/server.png"));
        stage.setTitle("Server");

        stage.setOnHiding(event -> {

        });

        stage.show();
    }
    
    @FXML
    private void launchClient() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/views/Client.fxml"));
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/images/client.png"));
        stage.setTitle("Client");

        stage.setOnHiding(event -> {

        });

        stage.show();
    }
    
}
