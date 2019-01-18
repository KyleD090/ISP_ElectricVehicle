public class MotorController {
    double firstCurrent;
    double secondCurrent;
    Contactor c;
    int motorVoltage;
    Battery b;
    DCDC_Converter dc;
    CircuitBreaker cb;
    Motor m;
    public MotorController( Motor m, Contactor c, Battery b, DCDC_Converter dc, CircuitBreaker cb){
        motorVoltage = m.voltage;
        this.m = m;
        this.c = c;
        this.b = b;
        this.dc = dc;
        this.cb = cb;
    }

    void firstCurrentInput(double energy) {
        if (c.open && cb.breaker == false ) {
            if (motorVoltage >= b.minVoltage && motorVoltage <= b.maxVoltage) {
                firstCurrent = energy;
            } else {
                System.out.println("The battery and motor voltages do not match");
            }
        } else {
            System.out.println("Tried to receive energy from batteries with the contactor closed");
        }
    }

    //Amps = voltage / ohms (resistance)
    void secondCurrentInput(double resistance) {
        secondCurrent = motorVoltage / resistance;
    }

    void outputToMotor() {
        double total = firstCurrent + secondCurrent;
        if(total > 220){
            cb.pullBreaker();
            total = total - firstCurrent;
            cb.resetBreaker();
        }
        if (c.open == false) {
            firstCurrent = 0;
        }
        secondCurrent = 0;
        m.receiveEnergy(total);
    }

    void outputTo12Volt() {
        if (firstCurrent >= 25) {
            dc.convert(25);
        }
    }

}
