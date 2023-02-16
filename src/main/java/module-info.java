module com.example.expenseconsultantapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.expenseconsultantapp to javafx.fxml;
    exports com.example.expenseconsultantapp;
}