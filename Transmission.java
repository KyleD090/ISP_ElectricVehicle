import java.util.*;
public abstract class Transmission {
    double mTorque;
    double mHorsepower;
    double mRPM;
    int mGearRatio;
    Dictionary<Integer, Double> mRatios = new Hashtable<Integer, Double>();
    Clutch mClutch;
    Chassis mChassis;
    boolean mBrake;

    //Transmission receives mTorque from flywheel and mHorsepower from engine. The gearRatios have initialized values.
    Transmission(Clutch pClutch, Chassis pChassis, double pGear1, double pGear2, double pGear3, double pGear4, double pGear5, double pGear6) {
        mTorque = 0;
        mRPM = 1;
        mGearRatio = 1;
        mBrake = false;
        mClutch = pClutch;
        mChassis = pChassis;
        mRatios.put(1, pGear1);
        mRatios.put(2, pGear2);
        mRatios.put(3, pGear3);
        mRatios.put(4, pGear4);
        mRatios.put(5, pGear5);
        mRatios.put(6, pGear6);
    }

    //Saves the energy received from the FlyWheel
    public void receiveEnergy(double pHorsepower) {
        mHorsepower = pHorsepower;

    }

    //Calculates RPM for wheels
    public double outputRPM() {
        if(mBrake == false) {
            mTorque = (mHorsepower * 5252)  / (mRPM + 25);
            double outputRPM = (mHorsepower * 5252) / mTorque;
            mRPM = outputRPM + 25;
            return outputRPM * mRatios.get(mGearRatio);
        }
        else {
        return 0;
        }
    }

    public double outputMPH() {
        double circumference = mChassis.mWheelDiameter * 3.14;
        return (circumference * mRPM * 60) / (5280 * 12);
    }

    void releaseBrake(){
        mBrake = false;
    }

    void pressBrake(){
        mBrake = true;
    }
    //How the mGearRatio is determined
    abstract void changeGear(int x);

}
