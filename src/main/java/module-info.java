module com.home.kurshome81 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.home.kurshome81 to javafx.fxml;
    exports com.home.kurshome81;
}