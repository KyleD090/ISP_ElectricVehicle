import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static java.lang.Thread.sleep;

public class Driver extends Application {
    int mStep = 0;
    boolean mtest = true;
    Vehicle mVehicle;
    Vehicle explorer2002 = createExplorer2002();


    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage primaryStage) throws InterruptedException {

        primaryStage.setTitle("Java Vehicle Presentation");
        primaryStage.setMaximized(true);

        ListView<String> l = new ListView<String>();

        Button explorerButton = new Button("Ford Explorer 2002");
        Button fordButton = new Button("Ford");
        Button mazdaButton = new Button("Mazda");
        Button audiButton = new Button("Audi");
        Button startButton = new Button("Start");

        explorerButton.setMinSize(150, 150);
        fordButton.setMinSize(150, 150);
        mazdaButton.setMinSize(150, 150);
        audiButton.setMinSize(150, 150);
        startButton.setMinSize(150, 150);

        VBox vb = new VBox(l, startButton);
        Scene scene3 = new Scene(vb);

        fordButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                HBox fordBox = new HBox(explorerButton);
                Scene scene2 = new Scene(fordBox);
                primaryStage.setScene(scene2);
            }
        });

        explorerButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                mVehicle = explorer2002;
                primaryStage.setScene(scene3);
            }
        });

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                startButton.setText("Next Step");
                    switch (mStep) {
                        case 0:
                            l.getItems().add("The Brake is held down and the key is inserted into the vehicle");
                            mStep++;
                            break;
                        case 1:
                            l.getItems().add(mVehicle.openContactor());
                            mStep++;
                            break;
                        case 2:
                            l.getItems().add(mVehicle.outputFromBattery());
                            mStep++;
                            break;
                        case 3:
                            l.getItems().add(mVehicle.outputFromMotorController());
                            mStep++;
                            break;
                        case 4:
                            l.getItems().add(mVehicle.outputFromMotor() );
                            mStep++;
                            break;
                        case 5:
                            l.getItems().add(mVehicle.outputFromFlyWheel() );
                            mStep++;
                            break;
                        case 6:
                            l.getItems().add(mVehicle.outputRPM() );
                            mStep++;
                            break;
                        case 7:
                            l.getItems().add(mVehicle.outputMPH() );
                            mStep++;
                            break;
                        case 8:

                            if(mtest) {
                                l.getItems().add(mVehicle.pressGasPedal() );
                                mStep = 3;
                                mtest = false;
                            }
                            else{mStep++;}
                            break;
                        case 9:
                            l.getItems().add("End" );
                            mStep = 0;
                            break;
                    }

            }
        });

        HBox hb = new HBox(fordButton, mazdaButton, audiButton);
        Scene scene1 = new Scene(hb);

        primaryStage.setScene(scene1);
        primaryStage.show();

    }

    public Vehicle createExplorer2002(){
        Chassis explorerChassis = new Chassis("4-Door", "Front-Wheel-Drive", 113, 189, 72, 71, 4500, 29.5, 3.27);
        FlyWheel explorerFlyWheel = new FlyWheel();
        Clutch explorerClutch = new Clutch();
        Transmission explorerAutoTransmission = new AutomaticTransmission(explorerClutch, explorerChassis, 250, .22, 2.41, 1.54, 1, 0.75, 3.07, 150, 250, 350, 450, 650);
        Transmission explorerManualTransmission = new ManualTransmission(explorerClutch, explorerChassis, 250, 3.38, 2.04, 1.3, 1, 0.78, 3.48);
        Motor explorerMotor = new Motor(72, explorerFlyWheel);
        Contactor explorerContactor = new Contactor();
        Battery explorerMainBattery = new Battery(180, 70, 90,7);
        Battery explorerSecondayBattery = new Battery(7, 11, 13, 2);
        DCDC_Converter explorerDC_Converter = new DCDC_Converter(72, 12, explorerSecondayBattery);
        CircuitBreaker explorerCircuitBreaker = new CircuitBreaker(explorerMainBattery);
        MotorController explorerMotorController = new MotorController(explorerMotor, explorerContactor, explorerMainBattery, explorerDC_Converter, explorerCircuitBreaker);
        Potentiometer explorerPotentiometer = new Potentiometer(explorerMotorController);
        Vehicle explorer2002 = new Vehicle(explorerChassis, explorerManualTransmission, explorerFlyWheel, explorerClutch, explorerMotor, explorerMotorController, explorerPotentiometer, explorerContactor, explorerMainBattery, explorerCircuitBreaker, explorerDC_Converter);
         return explorer2002;
    }

}

