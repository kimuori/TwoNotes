module com.example.twonotes {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.twonotes to javafx.fxml;
    exports com.example.twonotes;
}