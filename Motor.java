public class Motor {
    int mVoltage;
    double mInputAmp;
    FlyWheel mFlyWheel;


    public Motor(int pVoltage, FlyWheel pFlyWheel) {
        mVoltage = pVoltage;
        mFlyWheel = pFlyWheel;
    }

    void receiveEnergy(double pAmps) {
        mInputAmp = pAmps;
    }

    //Horsepower = (Volts * amps * 0.3) / 746
    double outputHorsepower(){
        double vTemp = (mVoltage * mInputAmp * 0.4) / 746;
        mFlyWheel.storeEnergy(vTemp);
        return (mVoltage * mInputAmp * 0.4) / 746;
    }
}

/*
double[] mTorque = new double[]{31.3, 33, 39.9, 43.5, 51.8, 66.5};

    //These are lists of mHorsepower in order on increasing amps (170, 180, 205, 220, 250, 300)
    double[] v48 = new double[]{9, 9.6, 10.9, 11.6, 13, 15,};
    double[] v72 = new double[]{15.3, 15.5, 17.7, 18.5, 20.9, 24.5,};
    double[] v90 = new double[]{19, 19.4, 22.1, 23.2, 26.1, 30.7};
    double[] v144 = new double[]{30.4, 31.1, 35.4, 37.1, 41.8, 49, 84.4};

    double outputHorsepower() {
        double[] myArray;
        if (mVoltage == 48) {
            myArray = v48;
        } else if (mVoltage == 72) {
            myArray = v72;
        } else if (mVoltage == 90) {
            myArray = v90;
        } else if (mVoltage == 144) {
            myArray = v144;
        } else {
            myArray = new double[5];
        }

        if (mInputAmp == 170) {
            return myArray[0];
        } else if (mInputAmp == 180) {
            return myArray[1];
        } else if (mInputAmp == 205) {
            return myArray[2];
        } else if (mInputAmp == 220) {
            return myArray[3];
        } else if (mInputAmp == 250) {
            return myArray[4];
        } else if (mInputAmp == 300) {
            return myArray[5];
        } else {
            return 0.0;
        }
    }

    double outputTorque() {
        if (mInputAmp == 170) {
            return mTorque[0];
        } else if (mInputAmp == 180) {
            return mTorque[1];
        } else if (mInputAmp == 205) {
            return mTorque[2];
        } else if (mInputAmp == 220) {
            return mTorque[3];
        } else if (mInputAmp == 250) {
            return mTorque[4];
        } else if (mInputAmp == 300) {
            return mTorque[5];
        } else {
            return 0.0;
        }
    }
    */
