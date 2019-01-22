public class MotorController {
    double mFirstCurrent;
    double mSecondCurrent;
    Contactor mContactor;
    int mMotorVoltage;
    Battery mBattery;
    DCDC_Converter mDCDC_Converter;
    CircuitBreaker mCircuitBreaker;
    Motor mMotor;
    public MotorController(Motor pMotor, Contactor pContactor, Battery pBattery, DCDC_Converter pDCDC_Converter, CircuitBreaker pCircuitBreaker){
        mMotor = pMotor;
        mMotorVoltage = mMotor.mVoltage;
        mContactor = pContactor;
        mBattery = pBattery;
        mDCDC_Converter = pDCDC_Converter;
        mCircuitBreaker = pCircuitBreaker;
    }

    void firstCurrentInput(double pEnergy) {
        if (mContactor.mOpen && mCircuitBreaker.mBreaker == false ) {
            if (mMotorVoltage >= mBattery.mMinVoltage && mMotorVoltage <= mBattery.mMaxVoltage) {
                mFirstCurrent = pEnergy;
            } else {
                System.out.println("The battery and motor voltages do not match");
            }
        } else {
            System.out.println("Tried to receive energy from batteries with the contactor closed");
        }
    }

    //Amps = mVoltage / ohms (resistance)
    double secondCurrentInput(double pResistance) {
        mSecondCurrent = mMotorVoltage / pResistance;
        return mSecondCurrent;
    }

    double outputToMotor() {
        double total = mFirstCurrent + mSecondCurrent;
        if(total > 220){
            mCircuitBreaker.pullBreaker();
            total = total - mFirstCurrent;
            mCircuitBreaker.resetBreaker();
        }
        if (mContactor.mOpen == false) {
            mFirstCurrent = 0;
        }
        mSecondCurrent = 0;
        mMotor.receiveEnergy(total);
        return total;
    }

    void outputTo12Volt() {
        if (mFirstCurrent >= 25) {
            mDCDC_Converter.convert(25);
        }
    }

}
