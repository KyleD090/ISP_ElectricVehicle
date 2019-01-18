import java.util.*;
public abstract class Transmission {
    double torque;
    double horsepower;
    double rpm;
    int gearRatio;
    Dictionary<Integer, Double> ratios = new Hashtable<Integer, Double>();
    Clutch c;

    //Transmission receives torque from flywheel and horsepower from engine. The gearRatios have initialized values.
    Transmission(Clutch c, double g1, double g2, double g3, double g4, double g5, double g6) {
        torque = 0;
        rpm = 1;
        gearRatio = 1;
        this.c = c;
        ratios.put(1, g1);
        ratios.put(2, g2);
        ratios.put(3, g3);
        ratios.put(4, g4);
        ratios.put(5, g5);
        ratios.put(6, g6);
    }

    //Saves the energy received from the FlyWheel
    public void receiveEnergy(double h) {
        horsepower = h;

    }

    //Calculates RPM for wheels
    public double outputRPM() {
        torque = (horsepower * 5252) / rpm;
        double outputRPM = (horsepower * 5252) / torque;
        rpm = outputRPM;
        return outputRPM * ratios.get(gearRatio);
    }

    //How the gearRatio is determined
    abstract void changeGear(int x);

}
