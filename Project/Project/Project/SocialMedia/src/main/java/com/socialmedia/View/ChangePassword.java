package com.socialmedia.View;

import com.socialmedia.Controller.ChangePass;
import com.socialmedia.Controller.CreateUser;
import com.socialmedia.Model.Database;
import com.socialmedia.Model.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ChangePassword {
    public ChangePassword(User user, Database database, Stage stage) {

        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #F5F5F5;");
        root.setPadding(new Insets(83, 99, 175, 99));

        StyledLabel title = new StyledLabel("Change Password", 40, GUIConstants.blue, 1);
        root.setTop(title);

        GridPane center = new GridPane();
        center.setStyle("-fx-background-color: transparent;");
        center.setPadding(new Insets(58, 216, 0, 216));
        center.setVgap(10);
        center.setHgap(10);

        HintTextField oldPass = new HintTextField("Old Password");
        center.add(oldPass, 0, 0);

        HintTextField newPass = new HintTextField("New Password");
        center.add(newPass, 0, 1);

        HintTextField confirmPass = new HintTextField("Confirm Password");
        center.add(confirmPass, 0, 2);

        RoundedButton submit = new RoundedButton("Submit", 45, 20);
        submit.setOnMouseClicked(e -> {
            if (oldPass.isEmpty()) {
                new Alert("Please enter your old password", stage);
                return;
            }
            if (!oldPass.getText().equals(user.getPassword())) {
                new Alert("Old password doesn't match", stage);
                return;
            }
            if (newPass.isEmpty()) {
                new Alert("Please enter new password", stage);
                return;
            }
            if (newPass.getText().length() < 6) {
                new Alert("Password must contain at least 8 characters", stage);
                return;
            }
            String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{6,}$";
            if (!newPass.getText().matches(pattern)) {
                new Alert("Password must include at least one digit, one lowercase, one uppercase, one special character (@#$%^&+=!), and no spaces.", stage);
                return;
            }
            if (confirmPass.isEmpty()) {
                new Alert("Please confirm password", stage);
                return;
            }
            if (!newPass.getText().equals(confirmPass.getText())) {
                new Alert("Password doesn't match", stage);
                return;
            }
            ChangePass changePass = new ChangePass(newPass.getText(), user.getId(), database);
            if (changePass.change()) {
                new CreateUser(user, database);
                new Alert("Password changed successfully", stage);
                new Home(user, database, stage);
            }
        });
        center.add(submit, 0, 3);
        center.setAlignment(Pos.CENTER);
        root.setCenter(center);

        Scene scene = new Scene(root, 900, 625);
        stage.setScene(scene);
        stage.requestFocus();
    }
}