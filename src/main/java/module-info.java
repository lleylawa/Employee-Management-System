module org.example.management {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.management to javafx.fxml;
    exports org.example.management;
}