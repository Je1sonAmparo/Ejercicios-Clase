
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Main.fxml"));

        Scene scene = new Scene(loader.load(), 900, 507);

        primaryStage.setTitle("Sistema Básico De Citas Medicas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
