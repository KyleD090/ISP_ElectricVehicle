public class Vehicle {
    Chassis c;
    Transmission t;
    FlyWheel f;
    Clutch cl;
    Motor m;
    MotorController mc;
    Potentiometer p;
    Contactor co;

    Vehicle(Chassis c, Transmission t, FlyWheel f, Clutch cl, Motor m, MotorController mc, Potentiometer p, Contactor co) {
        this.c = c;
        this.t = t;
        this.f = f;
        this.cl = cl;
        this.m = m;
        this.mc = mc;
        this.p = p;
        this.co = co;
    }

    public String openContactor() {
        co.openContactor();
        return "The contactor is opened";
    }

    public String batteryOutput(int amp) {
        mc.firstCurrentInput(amp);
        return "The motor controller receives " + amp + " amps";
    }

    public String pressPetal() {
        p.pressPetal(2.5);
        return "The accelerator petal is pressed";
    }

    public String motorControllerOutput() {
        m.receiveEnergy(mc.outputAmps());
        return "The engine receives amps from the motor controller";
    }

    public String motorOutput() {
        return "The motor produces " + m.outputHorsepower() + " Horsepower and " + m.outputTorque() + " torque";
    }
}
