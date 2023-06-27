module com.example.opt3v10 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.opt3v10 to javafx.fxml;
    exports com.example.opt3v10;
}