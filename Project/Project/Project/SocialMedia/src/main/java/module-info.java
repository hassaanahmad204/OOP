module com.socialmedia {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql; // For JDBC
    //requires mysql.connector.java; // MySQL driver module name

    // Open specific packages to JavaFX FXML
    opens com.socialmedia.Main to javafx.fxml;
    opens com.socialmedia.View to javafx.fxml;
    opens com.socialmedia.Controller to javafx.fxml;
    opens com.socialmedia.Model to javafx.fxml;

    // Export specific packages
    exports com.socialmedia.Main;
    exports com.socialmedia.View;
    exports com.socialmedia.Controller;
    exports com.socialmedia.Model;
}