public class Potentiometer {
    double outputOHMS;
    boolean pressed;
    MotorController m;

    public Potentiometer(MotorController m){
        pressed = false;
        this.m = m;
        outputOHMS = 5;
    }

    void pressPetal(double resistance) {
        pressed = true;
        if (resistance < 5) {
            outputOHMS = outputOHMS - resistance;
        } else {
            outputOHMS = 0;
            System.out.println("The petal is pressed to its max");
        }
        m.secondCurrentInput(outputOHMS);
    }

    void releasePetal() {
        pressed = false;
        outputOHMS = 5;
    }
}
