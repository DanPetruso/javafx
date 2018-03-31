import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.*;

public class PressS extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Press S to Win");

        Button start = new Button("Start");
        Button help = new Button("Help");
        Label label = new Label("Press S to Win!");

        help.setOnAction(e -> help());
        start.setOnAction(e -> primaryStage.setScene(game()));

        GridPane layout = new GridPane();

        layout.add(label, 5, 3);
        layout.add(start, 4, 4);
        layout.add(help, 6, 4);

        label.setFont(new Font(20));

        layout.setHgap(1);
        layout.setVgap(10);

        Scene main = new Scene(layout, 250, 200);
        primaryStage.setScene(main);
        primaryStage.show();
    }

    public void help(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Help");

        Label label = new Label("This is a game where you must press S to win");

        StackPane layout = new StackPane();
        layout.getChildren().add(label);

        Scene scene = new Scene(layout, 250, 100);
        window.setScene(scene);
        window.showAndWait();
    }

    public Scene game(){
        Label label = new Label("Press S");
        label.setFont(new Font(30));
        StackPane layout = new StackPane();
        layout.getChildren().add(label);
        Scene scene = new Scene(layout, 250, 200);

        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.S)
                label.setText("Congrats,\nyou won!");
        });

        return scene;
    }


}