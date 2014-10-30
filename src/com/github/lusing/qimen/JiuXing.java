package com.github.lusing.qimen;

/**
 *
 * @author Louis
 */
public class JiuXing {
    public static final int PENG = 0;
    public static final int REN = 1;
    public static final int CHONG = 2;
    public static final int FU = 3;
    public static final int YING = 4;
    public static final int RUI = 5;
    public static final int ZHUI = 6;
    public static final int XIN = 7;

    public static final String sBaMen = "蓬任冲辅英芮柱心";

    private int mXing;

    public JiuXing(int xing) {
        mXing = xing % 8;
    }

    @Override
    public String toString() {
        return new String(sBaMen.charAt(mXing) + "");
    }    
}
