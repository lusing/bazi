package com.github.lusing.qimen;

import com.github.lusing.bazi.base.WuXing;

/**
 *
 * @author Louis
 */
public class JiuXing extends WuXing{
    public static final int PENG = 0;
    public static final int REN = 1;
    public static final int CHONG = 2;
    public static final int FU = 3;
    public static final int YING = 4;
    public static final int RUI = 5;
    public static final int ZHU = 6;
    public static final int XIN = 7;

    public static final String sBaMen = "蓬任冲辅英芮柱心";

    private int mXing;

    public JiuXing(int xing) {
        super(getWuXing(xing));
        mXing = xing % 8;
    }

    @Override
    public String toString() {
        return new String(sBaMen.charAt(mXing) + "");
    }
    
        private static int getWuXing(int star) {
        int xing = 0;
        switch (star) {
            case PENG:
                xing = WuXing.SHUI;
                break;
            case REN:
            case RUI:
                xing = WuXing.TU;
                break;
            case CHONG:
            case FU:
                xing = WuXing.MU;
                break;
            case YING:
                xing = WuXing.HUO;
                break;
            case ZHU:
            case XIN:
                xing = WuXing.JIN;
                break;
        }
        return xing;
    }
}
