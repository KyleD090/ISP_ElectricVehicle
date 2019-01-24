public class Contactor {
    boolean mOpen;

    public Contactor() {
        mOpen = false;
    }

    void openContactor() {
        mOpen = true;
    }

    void closeContactor() {
        mOpen = false;
    }
}
