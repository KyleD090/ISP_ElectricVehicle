public class ManualTransmission extends Transmission {

    ManualTransmission(Clutch pClutch, Chassis pChassis, double pGear1, double pGear2, double pGear3, double pGear4, double pGear5, double pGear6){
        super(pClutch, pChassis, pGear1, pGear2, pGear3, pGear4, pGear5, pGear6);
    }


    public void changeGear(int x) {
        if (mClutch.mHeldDown) {
            mGearRatio = x;
        } else {
            System.out.println("Tried to change gear without holding Clutch");
        }
    }
}
