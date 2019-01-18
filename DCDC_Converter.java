public class DCDC_Converter {
    int inputVoltage;
    int outputVoltage;
    Battery b;
    DCDC_Converter(int inputVoltage, int outputVoltage, Battery b){
        this.inputVoltage = inputVoltage;
        this.outputVoltage = outputVoltage;
        this.b = b;
    }

    void convert(double amps){
        b.receiveEnergy(amps);
    }
}
