package com.socialmedia.View;

import com.socialmedia.Controller.CreateUser;
import com.socialmedia.Model.Database;
import com.socialmedia.Model.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.Cursor;
import javafx.stage.Stage;

public class Welcome {
    private Database database;

    public Welcome(Database database, Stage stage) {
        this.database = database;
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #F5F5F5;");
        root.setPadding(new Insets(53, 84, 76, 84));

        StyledLabel title = new StyledLabel("Welcome", 40, GUIConstants.blue, 1);
        root.setTop(title);

        GridPane center = new GridPane();
        center.setStyle("-fx-background-color: transparent;");
        center.setPadding(new Insets(22, 231, 17, 231));
        center.setVgap(10);
        center.setHgap(10);

        HintTextField firstName = new HintTextField("First Name");
        HintTextField lastName = new HintTextField("Last Name");
        HintTextField email = new HintTextField("Email");
        HintTextField password = new HintTextField("Password");
        HintTextField confirmPassword = new HintTextField("Confirm Password");

        RoundedButton createAcc = new RoundedButton("Create Account", 45, 20);

        center.add(firstName, 0, 0);
        center.add(lastName, 0, 1);
        center.add(email, 0, 2);
        center.add(password, 0, 3);
        center.add(confirmPassword, 0, 4);
        center.add(createAcc, 0, 5);
        center.setAlignment(Pos.CENTER);
        root.setCenter(center);

        StyledLabel login = new StyledLabel("Already have an account? Login", 20, GUIConstants.black, 1); 
        login.setAlignment(Pos.CENTER);
        login.setCursor(Cursor.HAND);
        login.setOnMouseClicked(e -> {
            new Login(database, stage);
        });
        root.setBottom(login);
        BorderPane.setAlignment(login, Pos.CENTER);

        // Create Account action
        createAcc.setOnMouseClicked(e -> {
            if (firstName.isEmpty()) {
                new Alert("First Name cannot be empty", stage);
                return;
            }
            if (lastName.isEmpty()) {
                new Alert("Last Name cannot be empty", stage);
                return;
            }
            if (email.isEmpty()) {
                new Alert("Email cannot be empty", stage);
                return;
            }
            if(!email.getText().matches("^[A-Za-z0-9+_.-]+@gmail\\.com$")){
                new Alert("Please enter valid Email",stage);
                return;
            }
            if (password.isEmpty()) {
                new Alert("Password cannot be empty", stage);
                return;
            }
            if (password.getText().length() < 6) {
                new Alert("Password must contain at least 8 characters", stage);
                return;
            }
            String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{6,}$";
            if (!password.getText().matches(pattern)) {
                new Alert("Password must include at least one digit, one lowercase, one uppercase, one special character (@#$%^&+=!), and no spaces.", stage);
                return;
            }
            if (confirmPassword.isEmpty()) {
                new Alert("Please confirm password", stage);
                return;
            }
            if (!password.getText().equals(confirmPassword.getText())) {
                new Alert("Password doesn't match", stage);
                return;
            }
            User u = new User();
            u.setFirstName(firstName.getText());
            u.setLastName(lastName.getText());
            u.setEmail(email.getText());
            u.setPassword(password.getText());
            CreateUser create = new CreateUser(u, database);
            if (!create.isEmailUsed()) {
                create.create();
                u = create.getUser();
                new Home(u, database, stage);
            } else {
                new Alert("This email has been used before", stage);
            }
        });

        Scene scene = new Scene(root, 900, 625);
        stage.setScene(scene);
        stage.requestFocus();
    }
}