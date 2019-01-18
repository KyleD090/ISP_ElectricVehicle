public class Vehicle {
    Chassis c;
    Transmission t;
    FlyWheel f;
    Clutch cl;
    Motor m;
    MotorController mc;
    Potentiometer p;
    Contactor co;
    Battery b;
    CircuitBreaker cb;
    DCDC_Converter dc;

    Vehicle(Chassis c, Transmission t, FlyWheel f, Clutch cl, Motor m, MotorController mc, Potentiometer p, Contactor co, Battery b, CircuitBreaker cb, DCDC_Converter dc) {
        this.c = c;
        this.t = t;
        this.f = f;
        this.cl = cl;
        this.m = m;
        this.mc = mc;
        this.p = p;
        this.co = co;
        this.b = b;
        this.cb = cb;
        this.dc = dc;
    }

    public void test(){
        co.openContactor();
        mc.firstCurrentInput(b.outputAmps());
        mc.outputToMotor();
        f.storeEnergy(m.outputHorsepower());
        t.receiveEnergy(f.releaseEnergy());
        System.out.println("The rpm is " + t.outputRPM());
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



    public String motorOutput() {
        return "The motor produces " + m.outputHorsepower() + " Horsepower";
    }
}
