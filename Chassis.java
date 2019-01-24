public class Chassis {
    final String mBodyType;
    final String mLayout;
    final int mWheelBase;
    final int mLength;
    final int mWidth;
    final int mHeight;
    final int mWeight;
    final double mWheelDiameter;
    final double mWheelAxisRatio;
    //measured in inches, except mWeight which is in pounds
    Chassis(String pBodyType, String pLayout, int pWheelBase, int pLength, int pWidth, int pHeight, int pWeight, double pWheelDiameter, double pWheelAxisRatio) {
        mBodyType = pBodyType;
        mLayout = pLayout;
        mWheelBase = pWheelBase;
        mLength = pLength;
        mWidth = pWidth;
        mHeight = pHeight;
        mWeight = pWeight;
        mWheelDiameter = pWheelDiameter;
        mWheelAxisRatio = pWheelAxisRatio;
    }

    }

