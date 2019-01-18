public class FlyWheel {
    double storedEnergy;

    FlyWheel() {
        storedEnergy = 0;
    }

    //Stores Energy received from the engine in the form of horsepower
    public void storeEnergy(double inputEnergy) {
        storedEnergy = storedEnergy + inputEnergy;
    }

    //releases stored Energy to Transmission
    double releaseEnergy() {
        double temp = storedEnergy;
        storedEnergy = 0;
        return temp;
    }


}
