package main.gui.mainWindows;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.gui.menu.FXMenu;
import main.gui.settings.GUI_Settings_Variables;

public class MainGUIWindow extends Application implements GUI_Settings_Variables {

    public static void main(String[] args) {

        Application.launch();
        System.out.println("JJJJJJJ");
    }

    @Override
    public void start(Stage stage) {

        FXMLLoader fxmlLoader = new FXMLLoader(MainGUIWindow.class.getResource("gui.fxml"));
        Pane menuP = new Pane();
        menuP.getChildren().add(new FXMenu());

        Scene mainWindowScene = new Scene(menuP, 500, 500);


        stage.setTitle(strDefaultString);
        stage.setScene(mainWindowScene);

        System.out.println("JJJJJJJ");
        stage.show();
    }

}
