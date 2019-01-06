public class clutch {
    boolean heldDown;
    clutch(){heldDown = false;}

    public void pressClutch(){heldDown = true;}

    public void releaseClutch(){heldDown = false;}
}
