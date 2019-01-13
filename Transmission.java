import java.util.*;
public abstract class Transmission {
    int torqueInput;
    int horsepower;
    int gearRatio;
    Dictionary<Integer, Double> ratios = new Hashtable<Integer, Double>();
    Clutch c;

    //Transmission receives torque from flywheel and horsepower from engine. The gearRatios have initialized values.
    Transmission(Clutch c, double g1, double g2, double g3, double g4, double g5, double g6) {
        torqueInput = 0;
        gearRatio = 0;
        this.c = c;
        ratios.put(1, g1);
        ratios.put(2, g2);
        ratios.put(3, g3);
        ratios.put(4, g4);
        ratios.put(5, g5);
        ratios.put(6, g6);
    }

    //Saves the energy received from the FlyWheel
    public void receiveEnergy(int e, int h) {
        torqueInput = e;
        horsepower = h;
    }

    //Calculates RPM for wheels
    public double outputRPM() {
        int engineRPM = (horsepower * 5252) / torqueInput;
        return engineRPM * ratios.get(gearRatio);
    }

    //How the gearRatio is determined
    abstract void changeGear(int x);

}
