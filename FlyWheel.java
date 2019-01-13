public class FlyWheel {
    int storedEnergy;

    FlyWheel() {
        storedEnergy = 0;
    }

    //Stores Energy received from the engine
    public void storeEnergy(int inputEnergy) {
        storedEnergy = storedEnergy + inputEnergy;
    }

    //releases stored Energy to Transmission
    public int releaseEnergy() {
        int temp = storedEnergy;
        storedEnergy = 0;
        return temp;
    }


}
