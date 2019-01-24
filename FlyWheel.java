public class FlyWheel {
    double mStoredEnergy;

    FlyWheel() {
        mStoredEnergy = 0;
    }

    //Stores Energy received from the engine in the form of mHorsepower
    public void storeEnergy(double inputEnergy) {
        mStoredEnergy = mStoredEnergy + inputEnergy;
    }

    //releases stored Energy to Transmission
    double releaseEnergy() {
        double temp = mStoredEnergy;
        mStoredEnergy = 0;
        return temp;
    }


}
