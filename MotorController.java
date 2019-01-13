public class MotorController {
    double firstCurrent;
    double secondCurrent;
    Contactor c;
    int motorVoltage;

    public MotorController( Motor m, Contactor c){
        motorVoltage = m.voltage;
        this.c = c;
    }

    void firstCurrentInput(double energy) {
        if (c.open) {
            firstCurrent = energy;
        } else {
            System.out.println("Tried to receive energy from batteries with the contactor closed");
        }
    }

    //Amps = voltage / ohms (resistance)
    void secondCurrentInput(double resistance) {
        secondCurrent = motorVoltage / resistance;
    }

    double outputAmps() {
        double total = firstCurrent + secondCurrent;
        if (c.open == false) {
            firstCurrent = 0;
        }
        secondCurrent = 0;
        if (total < 170) {
            System.out.println("Not enough energy");
            return 0;
        } else if (170 <= total && total < 180) {
            return 170;
        } else if (180 <= total && total < 205) {
            return 180;
        } else if (205 <= total && total < 220) {
            return 205;
        } else if (220 <= total && total < 250) {
            return 220;
        } else if (250 <= total && total < 300) {
            return 250;
        } else {
            return 300;
        }
    }

}
