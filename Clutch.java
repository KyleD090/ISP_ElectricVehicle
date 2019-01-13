public class Clutch {
    boolean heldDown;

    Clutch() {
        heldDown = false;
    }

    public void pressClutch() {
        heldDown = true;
    }

    public void releaseClutch() {
        heldDown = false;
    }
}
