public class vehicle {
    chassis c;
    transmission t;
    flyWheel f;
    clutch cl;
    vehicle(chassis c, transmission t, flyWheel f, clutch cl){this.c = c; this.t = t; this.f = f; this.cl = cl;}
    public void startEngine(){System.out.println("The engine is starting");}
    public void pressGas(){System.out.println("The gas pedal is being pressed");}
    public void pressBrake(){System.out.println("The brake pedal is being pressed");}

    public void test(int torque){
        System.out.println("500 torque is sent from the motor to the fly wheel");
        f.storeEnergy(torque);
        System.out.println("The fly wheel is storing the energy");
        t.recieveEnergy( f.releaseEnergy(), 210);
        System.out.println("the fly wheel outputs the energy to the transmission");
        cl.pressClutch();
        System.out.println("The driver holds down the clutch petal");
        t.changeGear(2);
        System.out.println("The driver moves the stick shift to 2nd gear");
        cl.releaseClutch();
        System.out.println("The driver releases the clutch petal");
        System.out.println("The trasnmission converts the torque to RPM for the wheels");
        System.out.println("The RPM for the wheels is " + t.outputRPM());

    }
}
