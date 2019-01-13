public class Motor {
    int voltage;
    double inputAmp;
    double[] torque = new double[]{31.3, 33, 39.9, 43.5, 51.8, 66.5};

    //These are lists of horsepower in order on increasing amps (170, 180, 205, 220, 250, 300)
    double[] v48 = new double[]{9, 9.6, 10.9, 11.6, 13, 15,};
    double[] v72 = new double[]{15.3, 15.5, 17.7, 18.5, 20.9, 24.5,};
    double[] v90 = new double[]{19, 19.4, 22.1, 23.2, 26.1, 30.7};
    double[] v144 = new double[]{30.4, 31.1, 35.4, 37.1, 41.8, 49, 84.4};

    public Motor(int voltage) {
        this.voltage = voltage;
    }

    void receiveEnergy(double amps) {
        inputAmp = amps;
    }

    double outputHorsepower() {
        double[] myArray;
        if (voltage == 48) {
            myArray = v48;
        } else if (voltage == 72) {
            myArray = v72;
        } else if (voltage == 90) {
            myArray = v90;
        } else if (voltage == 144) {
            myArray = v144;
        } else {
            myArray = new double[5];
        }

        if (inputAmp == 170) {
            return myArray[0];
        } else if (inputAmp == 180) {
            return myArray[1];
        } else if (inputAmp == 205) {
            return myArray[2];
        } else if (inputAmp == 220) {
            return myArray[3];
        } else if (inputAmp == 250) {
            return myArray[4];
        } else if (inputAmp == 300) {
            return myArray[5];
        } else {
            return 0.0;
        }
    }

    double outputTorque() {
        if (inputAmp == 170) {
            return torque[0];
        } else if (inputAmp == 180) {
            return torque[1];
        } else if (inputAmp == 205) {
            return torque[2];
        } else if (inputAmp == 220) {
            return torque[3];
        } else if (inputAmp == 250) {
            return torque[4];
        } else if (inputAmp == 300) {
            return torque[5];
        } else {
            return 0.0;
        }
    }
}
