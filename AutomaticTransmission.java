public class AutomaticTransmission extends Transmission {
    int mSpeed1, mSpeed2, mSpeed3, mSpeed4, mSpeed5;

    AutomaticTransmission(Clutch pClutch, Chassis pChassis, double pTorque, double pGear1, double pGear2, double pGear3, double pGear4, double pGear5, double pGear6, int pSpeed1, int pSpeed2, int pSpeed3, int pSpeed4, int pSpeed5) {
        super(pClutch, pChassis, pTorque, pGear1, pGear2, pGear3, pGear4, pGear5, pGear6);

        mSpeed1 = pSpeed1;
        mSpeed2 = pSpeed2;
        mSpeed3 = pSpeed3;
        mSpeed4 = pSpeed4;
        mSpeed5 = pSpeed5;
    }


    public void changeGear(int x) {
        if (mRPM < mSpeed1) {
            mGearRatio = 1;
        }
        if (mRPM < mSpeed2 && mRPM > mSpeed1) {
            mGearRatio = 2;
        }
        if (mRPM < mSpeed3 && mRPM > mSpeed2) {
            mGearRatio = 3;
        }
        if (mRPM < mSpeed4 && mRPM > mSpeed3) {
            mGearRatio = 4;
        }
        if (mRPM < mSpeed5 && mRPM > mSpeed4) {
            mGearRatio = 5;
        }
    }
}
