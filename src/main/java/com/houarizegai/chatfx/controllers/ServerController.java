package com.houarizegai.chatfx.controllers;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ServerController implements Initializable {

    @FXML
    private VBox root;

    @FXML
    private JFXListView<HBox> msgNodes;

    @FXML
    private JFXTextField msgField;
    
    /* Start Msg variables */
    
    public static ServerSocket ss;
    public static Socket s;
    public static DataInputStream din;
    public static DataOutputStream dout;
    
    /* End Msg variables */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        root.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) {
                sendMsg();
            }
        });

        (new Thread() {
            @Override
            public void run() {
                try {
                    ss = new ServerSocket(1201);
                    s = ss.accept();

                    din = new DataInputStream(s.getInputStream());
                    dout = new DataOutputStream(s.getOutputStream());

                    String msgin = "";
                    while (!msgin.equals("exit")) {
                        msgin = din.readUTF();
                        addMsg(msgin, false);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @FXML
    private void sendMsg() {
        if(msgField.getText() == null || msgField.getText().trim().isEmpty())
            return;
        
        try {
            dout.writeUTF(msgField.getText().trim());
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        addMsg(msgField.getText().trim(), true);
        msgField.setText(null);
        
    }

    @FXML
    private void emojiChooser() {

    }

    private void addMsg(String msg, boolean senderIsServer) {
        Label lbl = new Label(msg);
        lbl.setStyle("-fx-font-size: 16px;"
                + "-fx-background-color: #" + (senderIsServer ? "B00020" : "2196f3") + ";"
                + "-fx-text-fill: #FFF;"
                + "-fx-background-radius:25;"
                + "-fx-padding: 10px;");
        lbl.setWrapText(true);
        lbl.setMaxWidth(400);
        
        HBox container = new HBox();
        if(!senderIsServer) {
            container.getChildren().add(new ImageView(new Image("/images/client-48px.png")));
            container.setAlignment(Pos.CENTER_LEFT);
            container.setSpacing(10);
            container.setPadding(new Insets(0, 10, 0, 0));
        } else {
            container.setAlignment(Pos.CENTER_RIGHT);
            container.setPadding(new Insets(0, 10, 0, 10));
        }
        container.getChildren().add(lbl);
        container.setPrefHeight(40);

        msgNodes.getItems().add(container);
    }

}
