public class Contactor {
    boolean open;

    public Contactor() {
        open = false;
    }

    void openContactor() {
        open = true;
    }

    void closeContactor() {
        open = false;
    }
}
