public class Driver {
    public static void main(String[] args){
        chassis explorerChassis = new chassis("4-Door", "Front-Wheel-Drive", 113, 189, 72, 71, 4500);
        flyWheel explorerflyWheel = new flyWheel();
        clutch explorerClutch = new clutch();
        transmission explorerAutoTransmission = new automaticTransmission(explorerClutch, 3.22, 2.41, 1.54, 1, 0.75, 3.07, 15, 25, 35, 45, 65);
        transmission explorerManualTransmission = new manualTransmission(explorerClutch, 3.38, 2.04, 1.3, 1, 0.78,3.48);
        vehicle Explorer2002 = new vehicle(explorerChassis, explorerManualTransmission, explorerflyWheel, explorerClutch);

        //pretend x is the torque created from the engine
        int x = 500;
        Explorer2002.test(x);
    }

}
