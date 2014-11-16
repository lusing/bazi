package com.github.lusing.qimen;

import com.github.lusing.bazi.base.WuXing;

/**
 *
 * @author Louis
 */
public class BaMen extends WuXing {

    /**
     * 休门 五行属水
     */
    public static final int XIU = 0;
    public static final int SHENG = 1;
    public static final int SHANG = 2;
    public static final int DU = 3;
    public static final int JING3 = 4;
    public static final int SI = 5;
    public static final int JING1 = 6;
    public static final int KAI = 7;

    public static final String sBaMen = "休生伤杜景死惊开";

    private final int mMen;

    public BaMen(int men) {
        super(getWuXing(men%8));
        mMen = men % 8;
    }

    private static int getWuXing(int men) {
        int xing = 0;
        switch (men%8) {
            case XIU:
                xing = WuXing.SHUI;
                break;
            case SHENG:
            case SI:
                xing = WuXing.TU;
                break;
            case SHANG:
            case DU:
                xing = WuXing.MU;
                break;
            case JING3:
                xing = WuXing.HUO;
                break;
            case JING1:
            case KAI:
                xing = WuXing.JIN;
                break;
        }
        return xing;
    }

    @Override
    public String toString() {
        return String.valueOf(sBaMen.charAt(mMen));
    }
}
