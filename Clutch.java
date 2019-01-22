public class Clutch {
    boolean mHeldDown;

    Clutch() {
        mHeldDown = false;
    }

    public void pressClutch() {
        mHeldDown = true;
    }

    public void releaseClutch() {
        mHeldDown = false;
    }
}
