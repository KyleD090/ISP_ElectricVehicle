public class Chassis {
    final String bodyType;
    final String layout;
    final int wheelBase;
    final int length;
    final int width;
    final int height;
    final int weight;

    //measured in inches, except weight which is in pounds
    Chassis(String bt, String l, int wb, int l2, int w, int h, int w2) {
        bodyType = bt;
        layout = l;
        wheelBase = wb;
        length = l2;
        width = w;
        height = h;
        weight = w2;
    }

    }

