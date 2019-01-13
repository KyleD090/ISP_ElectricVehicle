import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Driver extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        Chassis explorerChassis = new Chassis("4-Door", "Front-Wheel-Drive", 113, 189, 72, 71, 4500);
        FlyWheel explorerFlyWheel = new FlyWheel();
        Clutch explorerClutch = new Clutch();
        Transmission explorerAutoTransmission = new AutomaticTransmission(explorerClutch, 3.22, 2.41, 1.54, 1, 0.75, 3.07, 15, 25, 35, 45, 65);
        Transmission explorerManualTransmission = new ManualTransmission(explorerClutch, 3.38, 2.04, 1.3, 1, 0.78, 3.48);
        Motor explorerMotor = new Motor(72);
        Contactor explorerContactor = new Contactor();
        MotorController explorerMotorController = new MotorController(explorerMotor, explorerContactor);
        Potentiometer explorerPotentiometer = new Potentiometer(explorerMotorController);
        Vehicle Explorer2002 = new Vehicle(explorerChassis, explorerManualTransmission, explorerFlyWheel, explorerClutch, explorerMotor, explorerMotorController, explorerPotentiometer, explorerContactor);

        primaryStage.setTitle("Java Vehicle Presentation");
        primaryStage.setMaximized(true);

        ListView<String> l = new ListView<String>();

        Button b1 = new Button();
        Button b2 = new Button();
        b1.setText("Start");
        b2.setText("pause");
        b1.setMinSize(150, 150);
        b2.setMinSize(150, 150);
        b1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                l.getItems().add(Explorer2002.openContactor());
                l.getItems().add(Explorer2002.batteryOutput(170));
                l.getItems().add(Explorer2002.pressPetal());
                l.getItems().add(Explorer2002.motorControllerOutput());
                l.getItems().add(Explorer2002.motorOutput());
            }
        });
        b2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

            }
        });

        VBox vb = new VBox(l, b1, b2);
        Scene scene = new Scene(vb);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
