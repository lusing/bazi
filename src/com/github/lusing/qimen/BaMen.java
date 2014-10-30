package com.github.lusing.qimen;

/**
 *
 * @author Louis
 */
public class BaMen {

    public static final int XIU = 0;
    public static final int SHENG = 1;
    public static final int SHANG = 2;
    public static final int DU = 3;
    public static final int JING3 = 4;
    public static final int SI = 5;
    public static final int JING1 = 6;
    public static final int KA = 7;

    public static final String sBaMen = "休生伤杜景死惊开";

    private int mMen;

    public BaMen(int men) {
        mMen = men % 8;
    }

    @Override
    public String toString() {
        return new String(sBaMen.charAt(mMen) + "");
    }
}
