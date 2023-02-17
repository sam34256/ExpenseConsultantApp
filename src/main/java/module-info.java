module src.ay_ics499_2023 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.expenseconsultantapp to javafx.fxml;
    exports com.example.expenseconsultantapp;

//    opens main to javafx.fxml;
//    exports main;
    opens main.gui.mainWindows to javafx.fxml;
    exports main.gui.mainWindows;
}


//module src.ay_ics499_2023{
//        requires javafx.controls;
//        requires javafx.fxml;
//
//
//        opens main to javafx.fxml;
//        exports main;
//        }