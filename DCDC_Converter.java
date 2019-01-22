public class DCDC_Converter {
    int mInputVoltage;
    int mOutputVoltage;
    Battery mBattery;
    DCDC_Converter(int pInputVoltage, int pOutputVoltage, Battery pBattery){
        mInputVoltage = pInputVoltage;
        mOutputVoltage = pOutputVoltage;
        mBattery = pBattery;
    }

    void convert(double amps){
        mBattery.receiveEnergy(amps);
    }
}
