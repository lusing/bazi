package com.github.lusing.bazi.base;

/**
 *
 * @author Louis
 */
public class BaGua extends WuXing{

    public static final int QIAN = 0;
    public static final int KAN = 1;
    public static final int GEN = 2;
    public static final int ZHEN = 3;
    public static final int XUN = 4;
    public static final int LI = 5;
    public static final int KUN = 6;
    public static final int DUI = 7;

    public static final String sBaGua = "乾坎艮震巽离坤兑";

    private final int mGua;

    public BaGua(int gua) {
        super(getWuXing(gua%8));
        mGua = gua % 8;
    }

    private static int getWuXing(int gua) {
        int xing = 0;
        switch (gua%8) {
            case KAN:
                xing = WuXing.SHUI;
                break;
            case KUN:
            case GEN:
                xing = WuXing.TU;
                break;
            case XUN:
            case ZHEN:
                xing = WuXing.MU;
                break;
            case LI:
                xing = WuXing.HUO;
                break;
            case QIAN:
            case DUI:
                xing = WuXing.JIN;
                break;
        }
        return xing;
    }
    
        @Override
    public String toString() {
        return String.valueOf(sBaGua.charAt(getGua()));
    }

    /**
     * @return the mGua
     */
    public int getGua() {
        return mGua;
    }
}
