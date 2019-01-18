public class Battery {
    double AH;
    int minVoltage;
    int maxVoltage;
    int time;
    double elapsedTime;
    Battery(int AH, int minVoltage, int maxVoltage, int time){
        this.AH = AH;
        this.minVoltage = minVoltage;
        this.maxVoltage = maxVoltage;
        this.time = time;
        this.elapsedTime = 0;
    }

    //AH = T * ampOutput
    double outputAmps(){
        if(elapsedTime < time) {
            elapsedTime = elapsedTime + 1;
            return AH / time;
        }
        else {
        System.out.println("Batteries are empty");
        return 0;
        }
    }

    void receiveEnergy(double amps){
        if(amps <= 25){
            elapsedTime--;
        }
        else{
            elapsedTime = elapsedTime - 2;
        }
    }
}
