public class Potentiometer {
    double mOutputOHMS;
    boolean mPressed;
    MotorController mMotorController;

    public Potentiometer(MotorController pMotorController){
        mPressed = false;
        this.mMotorController = pMotorController;
        mOutputOHMS = 5;
    }

    void pressPetal(double pResistance) {
        mPressed = true;
        if (pResistance < 5) {
            mOutputOHMS = mOutputOHMS - pResistance;
        } else {
            mOutputOHMS = 0;
            System.out.println("The petal is mPressed to its max");
        }
        mMotorController.secondCurrentInput(mOutputOHMS);
    }

    void releasePetal() {
        mPressed = false;
        mOutputOHMS = 5;
    }
}
