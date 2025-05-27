package com.socialmedia.View;

import com.socialmedia.Controller.CreatePost;
import com.socialmedia.Controller.ReadUserPosts;
import com.socialmedia.Model.Database;
import com.socialmedia.Model.Post;
import com.socialmedia.Model.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Home {
    private User user;
    private Database database;

    public Home(User user, Database database, Stage stage) {
        this.user = user;
        this.database = database;

        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #E8E8E8;");

        VBox sideBar = new VBox();
        sideBar.setStyle("-fx-background-color: " + toCssColor(GUIConstants.white) + ";");
        sideBar.setPrefWidth(182);
        sideBar.setMinWidth(182);
        sideBar.setMaxWidth(182);
        sideBar.setSpacing(3);

        sideBar.getChildren().add(new javafx.scene.layout.Region());
        VBox.setMargin(sideBar.getChildren().get(0), new Insets(10, 0, 0, 0));

        HBox profile = new HBox(10);
        profile.setAlignment(Pos.CENTER_LEFT);
        profile.setPadding(new Insets(10));
        profile.setMaxWidth(182);
        profile.setStyle("-fx-background-color: " + toCssColor(GUIConstants.white) + ";");

        Image modifyImage = new Image(getClass().getResourceAsStream("/pics/modify.png"));
        ImageView modifyIcon = new ImageView(modifyImage);
        modifyIcon.setFitWidth(20);
        modifyIcon.setFitHeight(20);
        Button modifyButton = new Button("", modifyIcon);
        modifyButton.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");
        modifyButton.setOnAction(e -> new Modify(user, database, stage));

        StyledLabel profileLabel = new StyledLabel(user.getName(), 20, GUIConstants.black, 1);
        profileLabel.setWrapText(true);
        profileLabel.setMaxWidth(142);
        profile.getChildren().addAll(modifyButton, profileLabel);

        sideBar.getChildren().add(profile);
        sideBar.getChildren().add(new SideButtons("Posts", "myposts", user, database, stage));
        sideBar.getChildren().add(new javafx.scene.layout.Region());
        VBox.setMargin(sideBar.getChildren().get(sideBar.getChildren().size() - 1), new Insets(3, 0, 0, 0));
        sideBar.getChildren().add(new SideButtons("Comments", "mycomments", user, database, stage));
        sideBar.getChildren().add(new javafx.scene.layout.Region());
        VBox.setMargin(sideBar.getChildren().get(sideBar.getChildren().size() - 1), new Insets(3, 0, 0, 0));
        sideBar.getChildren().add(new SideButtons("Likes", "mylikes", user, database, stage));
        sideBar.getChildren().add(new javafx.scene.layout.Region());
        VBox.setMargin(sideBar.getChildren().get(sideBar.getChildren().size() - 1), new Insets(3, 0, 0, 0));
        sideBar.getChildren().add(new SideButtons("Friends", "friends", user, database, stage));

        root.setLeft(sideBar);

        // Main content area
        VBox panel = new VBox();
        panel.setStyle("-fx-background-color: transparent;");
        BorderPane.setAlignment(panel, Pos.CENTER);

        VBox header = new VBox();
        header.setStyle("-fx-background-color: " + toCssColor(GUIConstants.white) + ";");
        header.setPadding(new Insets(10, 15, 10, 15));
        header.setPrefSize(500, 159);
        header.setMinSize(500, 159);
        header.setMaxSize(500, 159);

        StyledLabel homeLabel = new StyledLabel("Home", 20, GUIConstants.blue, 1);
        homeLabel.setPadding(new Insets(0, 0, 10, 0));

        TextArea postIn = new TextArea("Share your thoughts...");
        postIn.setFont(Font.font("New Times Roman", FontWeight.NORMAL, 15));
        postIn.setWrapText(true);

        String placeholder = "Share your thoughts...";
        postIn.focusedProperty().addListener((obs, oldVal, newVal) -> {
            String text = postIn.getText().trim();
            if (newVal) {
                if (text.equals(placeholder)) {
                    postIn.setText("");
                    postIn.setStyle(
                            "-fx-border-color: transparent;" +
                                    "-fx-background-insets: 0;" +
                                    "-fx-focus-color: transparent;" +
                                    "-fx-text-fill: black;"
                    );
                }
            } else {
                if (text.isEmpty()) {
                    postIn.setText(placeholder);
                    postIn.setStyle(
                            "-fx-border-color: transparent;" +
                                    "-fx-background-insets: 0;" +
                                    "-fx-focus-color: transparent;" +
                                    "-fx-text-fill: grey;"
                    );
                }
            }
        });

        RoundedButton postBtn = new RoundedButton("Post", 45, 15);
        VBox postsContainer = new VBox(10);
        postsContainer.setStyle("-fx-background-color: transparent;");
        postsContainer.setPadding(new Insets(10, 0, 0, 0));

        postBtn.setOnAction(e -> {
            String text = postIn.getText().trim();
            if (text.isEmpty() || text.equals("Share your thoughts...")) {
                new Alert("Cannot publish empty post", stage);
                return;
            }
            Post post = new Post(postIn.getText(), user);
            if (new CreatePost(post, database).posted()) {
                new Alert("Posted successfully", stage);
                postIn.setText("");
                // Refresh posts
                postsContainer.getChildren().clear();
                ReadUserPosts userPosts = new ReadUserPosts(user, database);
                ArrayList<Post> posts = userPosts.getPosts();
                for (Post postItem : posts) {
                    Posts postView = new Posts(user, postItem, database, stage);
                    postsContainer.getChildren().add(postView);
                }
            }
        });

        VBox contentArea = new VBox(10);
        contentArea.setStyle("-fx-background-color: transparent;");
        HBox buttonArea = new HBox();
        buttonArea.setAlignment(Pos.CENTER_RIGHT);
        buttonArea.getChildren().add(postBtn);
        contentArea.getChildren().addAll(postIn, buttonArea);

        header.getChildren().addAll(homeLabel, contentArea);

        // Fetch initial posts
        ReadUserPosts userPosts = new ReadUserPosts(user, database);
        ArrayList<Post> posts = userPosts.getPosts();
        for (Post post : posts) {
            Posts postView = new Posts(user, post, database, stage);
            postsContainer.getChildren().add(postView);
        }

        panel.getChildren().addAll(header, postsContainer);
        root.setCenter(panel);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(panel);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent;");
        BorderPane.setMargin(scrollPane, new Insets(0, 0, 0, 20));
        BorderPane.setAlignment(scrollPane, Pos.CENTER); 
        root.setCenter(scrollPane);

        Scene scene = new Scene(root, 900, 625);
        stage.setScene(scene);
        stage.requestFocus();
    }

    // Utility method to convert Color to CSS hex string
    private String toCssColor(javafx.scene.paint.Color color) {
        return String.format("#%02X%02X%02X",
                (int)(color.getRed() * 255),
                (int)(color.getGreen() * 255),
                (int)(color.getBlue() * 255));
    }
}