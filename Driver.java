import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static java.lang.Thread.sleep;

public class Driver extends Application {
    boolean mPaused = false;
    int mStep = 0;

    public static void main(String[] args) {
        Chassis explorerChassis = new Chassis("4-Door", "Front-Wheel-Drive", 113, 189, 72, 71, 4500);
        FlyWheel explorerFlyWheel = new FlyWheel();
        Clutch explorerClutch = new Clutch();
        Transmission explorerAutoTransmission = new AutomaticTransmission(explorerClutch, 3.22, 2.41, 1.54, 1, 0.75, 3.07, 150, 250, 350, 450, 650);
        Transmission explorerManualTransmission = new ManualTransmission(explorerClutch, 3.38, 2.04, 1.3, 1, 0.78, 3.48);
        Motor explorerMotor = new Motor(72);
        Contactor explorerContactor = new Contactor();
        Battery explorerMainBattery = new Battery(180, 70, 90,7);
        Battery explorerSecondayBattery = new Battery(7, 11, 13, 2);
        DCDC_Converter explorerDC_Converter = new DCDC_Converter(72, 12, explorerSecondayBattery);
        CircuitBreaker explorerCircuitBreaker = new CircuitBreaker(explorerMainBattery);
        MotorController explorerMotorController = new MotorController(explorerMotor, explorerContactor, explorerMainBattery, explorerDC_Converter, explorerCircuitBreaker);
        Potentiometer explorerPotentiometer = new Potentiometer(explorerMotorController);
        Vehicle explorer2002 = new Vehicle(explorerChassis, explorerManualTransmission, explorerFlyWheel, explorerClutch, explorerMotor, explorerMotorController, explorerPotentiometer, explorerContactor, explorerMainBattery, explorerCircuitBreaker, explorerDC_Converter);
        explorer2002.test();
        //launch(args);
    }


    public void start(Stage primaryStage) throws InterruptedException {

         /*
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
                if (mPaused) {
                    switch (mStep) {
                        case 0:
                            l.getItems().add(Explorer2002.openContactor());
                            mStep++;
                            break;
                        case 1:
                            l.getItems().add(Explorer2002.batteryOutput(170));
                            mStep++;
                            break;
                        case 2:
                            l.getItems().add(Explorer2002.pressPetal());
                            mStep++;
                            break;
                        case 3:
                            l.getItems().add(Explorer2002.motorControllerOutput());
                            mStep++;
                            break;
                        case 4:
                            l.getItems().add(Explorer2002.motorOutput());
                            mStep = 0;
                            break;
                    }
                } else {
                    l.getItems().add(Explorer2002.openContactor());
                    l.getItems().add(Explorer2002.batteryOutput(170));
                    l.getItems().add(Explorer2002.pressPetal());
                    l.getItems().add(Explorer2002.motorControllerOutput());
                    l.getItems().add(Explorer2002.motorOutput());
                }
            }
        });
        b2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (mPaused == true)
                    mPaused = false;
                else
                    mPaused = true;

            }
        });

        VBox vb = new VBox(l, b1, b2);
        Scene scene = new Scene(vb);
        primaryStage.setScene(scene);
        primaryStage.show();
 */
    }

}

