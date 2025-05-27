package com.socialmedia.View;

import com.socialmedia.Model.Database;
import com.socialmedia.Model.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SideButtons extends HBox {
    public SideButtons(String text, String pic, User user, Database database, Stage stage) {
        super(10);
        setPadding(new Insets(10));
        setAlignment(Pos.CENTER_LEFT);
        setMaxSize(182, 50);
        setStyle("-fx-background-color: " + toCssColor(GUIConstants.white) + ";");
        setCursor(Cursor.HAND);

        // Icon
        String imagePath = "/pics/" + pic + ".png"; // Classpath path
        Image image;
        try {
            // Load image from classpath
            image = new Image(getClass().getResource(imagePath).toExternalForm());
        } catch (NullPointerException e) {
            // Fallback to file system path
            image = new Image("file:pics/" + pic + ".png");
        }
        ImageView img = new ImageView(image);
        getChildren().add(img);

        StyledLabel label = new StyledLabel(text, 17, GUIConstants.textAreaHint, 1); // 1 = BOLD
        getChildren().add(label);

        // Hover effects
        setOnMouseEntered(e -> setStyle("-fx-background-color: " + toCssColor(GUIConstants.hover) + ";"));
        setOnMouseExited(e -> setStyle("-fx-background-color: " + toCssColor(GUIConstants.white) + ";"));

        setOnMouseClicked(e -> {
        });
    }

    // Convert javafx.scene.paint.Color to CSS hex
    private String toCssColor(javafx.scene.paint.Color color) {
        return String.format("#%02X%02X%02X",
                (int)(color.getRed() * 255),
                (int)(color.getGreen() * 255),
                (int)(color.getBlue() * 255));
    }
}