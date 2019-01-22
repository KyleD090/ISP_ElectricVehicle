public class Battery {
    double mAH;
    int mMinVoltage;
    int mMaxVoltage;
    int mTime;
    double mElapsedTime;
    Battery(int pAH, int pMinVoltage, int pMaxVoltage, int pTime){
        mAH = pAH;
        mMinVoltage = pMinVoltage;
        mMaxVoltage = pMaxVoltage;
        mTime = pTime;
        mElapsedTime = 0;
    }

    //mAH = T * ampOutput
    double outputAmps(){
        if(mElapsedTime < mTime) {
            mElapsedTime = mElapsedTime + 1;
            return mAH / mTime;
        }
        else {
        System.out.println("Batteries are empty");
        return 0;
        }
    }

    void receiveEnergy(double amps){
        if(amps <= 25){
            mElapsedTime--;
        }
        else{
            mElapsedTime = mElapsedTime - 2;
        }
    }
}
