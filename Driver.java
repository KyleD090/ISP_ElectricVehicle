import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static java.lang.Thread.sleep;

public class Driver extends Application {
    int mStep = 0;
    boolean mtest = true;
    Vehicle mVehicle;



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
        Button playAllButton = new Button("Play All");
        Button exitButton = new Button("Exit");
        Button exitButton2 = new Button("Exit");
        Button space = new Button();
        Button space2 = new Button();

        explorerButton.setMinSize(100, 100);
        fordButton.setMinSize(100, 100);
        mazdaButton.setMinSize(100, 100);
        audiButton.setMinSize(100, 100);
        startButton.setMinSize(100, 100);
        playAllButton.setMinSize(100, 100);
        exitButton.setMinSize(100, 100);
        exitButton2.setMinSize(100, 100);
        space.setMinSize(350, 350);
        space2.setMinSize(550, 550);

        playAllButton.setVisible(false);
        VBox vb = new VBox(l, startButton, playAllButton, exitButton2);

        fordButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                HBox fordBox = new HBox(space2, explorerButton, exitButton);
                VBox vb = new VBox(space, fordBox);
                primaryStage.setScene(new Scene(vb, primaryStage.getWidth(), primaryStage.getHeight()));
            }
        });

        explorerButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Vehicle explorer2002 = createExplorer2002();
                mVehicle = explorer2002;
                primaryStage.setScene(new Scene(vb, primaryStage.getWidth(), primaryStage.getHeight()));
            }
        });

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                startButton.setText("Next Step");
                playAllButton.setVisible(true);
                    switch (mStep) {
                        case 0:
                            l.getItems().add("The Brake is held down and the key is inserted into the vehicle");
                            mStep++;
                            break;
                        case 1:
                            playAllButton.setVisible(false);
                            l.getItems().add(mVehicle.openContactor());
                            mStep++;
                            break;
                        case 2:
                            playAllButton.setVisible(false);
                            l.getItems().add(mVehicle.outputFromBattery());
                            mStep++;
                            break;
                        case 3:
                            playAllButton.setVisible(false);
                            l.getItems().add(mVehicle.outputFromMotorController());
                            mStep++;
                            break;
                        case 4:
                            playAllButton.setVisible(false);
                            l.getItems().add(mVehicle.outputFromMotor() );
                            mStep++;
                            break;
                        case 5:
                            playAllButton.setVisible(false);
                            l.getItems().add(mVehicle.outputFromFlyWheel() );
                            mStep++;
                            break;
                        case 6:
                            playAllButton.setVisible(false);
                            l.getItems().add(mVehicle.outputRPM() );
                            mStep++;
                            break;
                        case 7:
                            playAllButton.setVisible(false);
                            l.getItems().add(mVehicle.outputMPH() );
                            mStep++;
                            break;
                        case 8:
                            playAllButton.setVisible(false);
                            if(mtest) {
                                playAllButton.setVisible(false);
                                l.getItems().add(mVehicle.pressGasPedal() );
                                mStep = 3;
                                mtest = false;
                            }
                            else{mStep++;}
                            break;
                        case 9:
                            playAllButton.setVisible(false);
                            startButton.setVisible(false);
                            l.getItems().add("End" );
                            mStep = 0;
                            break;
                    }

            }
        });

        playAllButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                vb.getChildren().remove(startButton);
                playAllButton.setVisible(false);
                l.getItems().add(mVehicle.openContactor());
                l.getItems().add(mVehicle.outputFromBattery());
                l.getItems().add(mVehicle.outputFromMotorController());
                l.getItems().add(mVehicle.outputFromMotor() );
                l.getItems().add(mVehicle.outputFromFlyWheel() );
                l.getItems().add(mVehicle.outputRPM() );
                l.getItems().add(mVehicle.outputMPH() );
                l.getItems().add(mVehicle.pressGasPedal() );
                l.getItems().add(mVehicle.outputFromMotorController());
                l.getItems().add(mVehicle.outputFromMotor() );
                l.getItems().add(mVehicle.outputFromFlyWheel() );
                l.getItems().add(mVehicle.outputRPM() );
                l.getItems().add(mVehicle.outputMPH() );
                l.getItems().add("End" );
            }
        });

        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });

        exitButton2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });

        HBox hb = new HBox(space2, fordButton, mazdaButton, audiButton, exitButton);
        //hb.setSpacing(378);
        HBox empty = new HBox(space);
        VBox vb2 = new VBox(empty,  hb);
        Scene scene1 = new Scene(vb2);
        space.setVisible(false);
        space2.setVisible(false);

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

