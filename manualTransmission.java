public class manualTransmission extends transmission {

    manualTransmission(clutch c, double g1, double g2, double g3, double g4, double g5, double g6){
        super(c, g1, g2, g3, g4, g5, g6);
    }


    public void changeGear(int x){
        if(c.heldDown){gearRatio = x;}
        else{System.out.println("Tried to change gear without holding clutch");}
    }
}
