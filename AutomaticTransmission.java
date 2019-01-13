public class AutomaticTransmission extends Transmission {
    int speed1, speed2, speed3, speed4, speed5;

    AutomaticTransmission(Clutch c, double g1, double g2, double g3, double g4, double g5, double g6, int s1, int s2, int s3, int s4, int s5) {
        super(c, g1, g2, g3, g4, g5, g6);
        speed1 = s1;
        speed2 = s2;
        speed3 = s3;
        speed4 = s4;
        speed5 = s5;
    }


    public void changeGear(int x) {
        if (torqueInput < speed1) {
            gearRatio = 1;
        }
        if (torqueInput < speed2 && torqueInput > speed1) {
            gearRatio = 2;
        }
        if (torqueInput < speed3 && torqueInput > speed2) {
            gearRatio = 3;
        }
        if (torqueInput < speed4 && torqueInput > speed3) {
            gearRatio = 4;
        }
        if (torqueInput < speed5 && torqueInput > speed4) {
            gearRatio = 5;
        }
    }
}
