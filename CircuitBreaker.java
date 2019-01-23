public class CircuitBreaker {
    boolean mBreaker;
    double mTemp;
    Battery mBattery;
    CircuitBreaker(Battery pBattery){
        mBattery = pBattery;
        mBreaker = false;
    }

    void pullBreaker(){
        mBreaker = true;
        mTemp = mBattery.mElapsedTime;
        mBattery.mElapsedTime = mBattery.mTime++;
    }

    void resetBreaker(){
        mBreaker = false;
        mBattery.mElapsedTime = mTemp;
    }
}
