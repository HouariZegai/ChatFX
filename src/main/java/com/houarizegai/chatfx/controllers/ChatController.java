package com.houarizegai.chatfx.controllers;

import static com.houarizegai.chatfx.bot.ChatBot.responseBot;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ChatController implements Initializable {

    @FXML
    private VBox root;

    @FXML
    private JFXListView msgNodes;

    @FXML
    private JFXTextField msgField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        root.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) {
                sendMsg();
            }
        });
    }

    @FXML
    private void sendMsg() {
        if(msgField.getText() == null || msgField.getText().trim().isEmpty())
            return;
        
        addMsg(msgField.getText().trim(), false);
        String msg = responseBot.get(msgField.getText().trim().toLowerCase());
        msgField.setText(null);
        addMsg((msg == null) ? "what ?" : msg, true);
        
    }

    @FXML
    private void emojiChooser() {

    }

    private void addMsg(String msg, boolean senderIsRobot) {
        Label lbl = new Label(msg);
        lbl.setStyle("-fx-font-size: 16px;"
                + "-fx-background-color: #" + ((senderIsRobot) ? "B00020" : "2196f3") + ";"
                + "-fx-text-fill: #FFF;"
                + "-fx-background-radius:25;"
                + "-fx-padding: 10px;");
        lbl.setWrapText(true);
        lbl.setMaxWidth(400);
        HBox container = new HBox();
        container.setPrefHeight(40);
        container.setAlignment(Pos.CENTER_LEFT);
        container.setPadding(new Insets(0, 10, 0, 10));
        container.setSpacing(10);
        container.getChildren().add(lbl);

        msgNodes.getItems().add(container);
    }
}
