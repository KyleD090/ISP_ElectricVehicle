public class Vehicle {
    Chassis mChassis;
    Transmission mTransmission;
    FlyWheel mFlyWheel;
    Clutch mClutch;
    Motor mMotor;
    MotorController mMotorController;
    Potentiometer mPotentiometer;
    Contactor mContactor;
    Battery mBattery;
    CircuitBreaker mCircuitBreaker;
    DCDC_Converter mDCDC_Converter;

    Vehicle(Chassis pChassis, Transmission pTransmission, FlyWheel pFlyWheel, Clutch pClutch, Motor pMotor, MotorController pMotorController, Potentiometer pPotentiometer, Contactor pContactor, Battery pBattery, CircuitBreaker pCircuitBreaker, DCDC_Converter pDCDC_Converter) {
        mChassis = pChassis;
        mTransmission = pTransmission;
        mFlyWheel = pFlyWheel;
        mClutch = pClutch;
        mMotor = pMotor;
        mMotorController = pMotorController;
        mPotentiometer = pPotentiometer;
        mContactor = pContactor;
        mBattery = pBattery;
        mCircuitBreaker = pCircuitBreaker;
        mDCDC_Converter = pDCDC_Converter;
    }

    public String openContactor() {
        mTransmission.pressBrake();
        mContactor.openContactor();
        return "The Contactor is opened allowing electricity to flow through the vehicle";
    }

    public String outputFromBattery() {
        mMotorController.firstCurrentInput(mBattery.outputAmps());
        return "The main batteries output " + mBattery.outputAmps() + " amps to the Motor Controller";
    }

    public String outputFromMotorController() {
        mMotorController.outputTo12Volt();
        return "The Motor Controller outputs " + mMotorController.outputToMotor() + " amps to the motor and 25 amps to the secondary 12 Volt battery";
    }


    public String outputFromMotor() {
        return "The Motor converts the amps to " + mMotor.outputHorsepower() + " Horsepower and stores that energy in the FlyWheel";
    }

    public String outputFromFlyWheel() {
        mTransmission.receiveEnergy(mFlyWheel.releaseEnergy());
        return "The FlyWheel transfers the energy to the transmission";
    }

    public String outputRPM() {
        mTransmission.releaseBrake();
        return "The Brake is released allowing the transmission to use the Horsepower and Torque to calculate the engines Rotations per Minute which is " + mTransmission.outputRPM();
    }

    public String outputMPH() {
        return "The gear ratio, wheel axis ratio, and RPM is used to find that the vehicles speed is " + mTransmission.outputMPH() + " Miles Per Hour";
    }

    public String pressGasPedal(){
        return "The gas petal is pressed sending " + mMotorController.secondCurrentInput(0.2) + " amps to the Motor Controller";
    }

}
