package com.socialmedia.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import com.socialmedia.Model.Database;
import com.socialmedia.Model.User;
import com.socialmedia.Model.Post;
import javafx.stage.Stage;

public class Posts extends VBox {

    private Post post;
    private Database database;
    private User user;

    public Posts(User u, Post post, Database database, Stage stage) {
        this.post = post;
        this.database = database;
        this.user = u;

        setStyle("-fx-background-color: " + toCssColor(GUIConstants.white) + ";");
        setPadding(new Insets(15, 25, 15, 15));
        setSpacing(7);

        HBox header = new HBox();
        header.setStyle("-fx-background-color: transparent;");

        StyledLabel author = new StyledLabel(post.getUser().getName(), 20, GUIConstants.post, 1);
        StyledLabel date = new StyledLabel(post.getDateToString(), 15, GUIConstants.post, 0);

        header.getChildren().addAll(author, date);
        HBox.setHgrow(author, javafx.scene.layout.Priority.ALWAYS);
        header.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(date, new Insets(0, 0, 0, 10));

        HBox center = new HBox();
        center.setStyle("-fx-background-color: transparent;");

        TextArea content = new TextArea(post.getContent());
        content.setFont(javafx.scene.text.Font.font("New Times Roman", javafx.scene.text.FontWeight.NORMAL, 18));
        content.setStyle(
                "-fx-border-width: 0;" +
                        "-fx-background-insets: 0;" +
                        "-fx-focus-color: transparent;"
        );
        content.setStyle(
                "-fx-border-width: 0;" +
                        "-fx-background-insets: 0;" +
                        "-fx-focus-color: transparent;" +
                        "-fx-text-fill: " + toCssColor(GUIConstants.post) + ";"
        );
        content.setWrapText(true);
        content.setEditable(false);

        center.getChildren().add(content);
        center.setAlignment(Pos.CENTER_LEFT);

        HBox bottom = new HBox();
        bottom.setStyle("-fx-background-color: transparent;");


        getChildren().addAll(header, center, bottom);

        double height = 115 + content.getBoundsInLocal().getHeight();
        setPrefSize(500, height);
        setMinSize(500, height);
        setMaxSize(500, height);
    }

    // Utility method to convert Color to CSS hex string
    private String toCssColor(javafx.scene.paint.Color color) {
        return String.format("#%02X%02X%02X",
                (int)(color.getRed() * 255),
                (int)(color.getGreen() * 255),
                (int)(color.getBlue() * 255));
    }
}