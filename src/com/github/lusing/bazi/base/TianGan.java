
package com.github.lusing.bazi.base;

public class TianGan {
    public static final int JIA = 0;
    public static final int YI = 1;
    public static final int BING = 2;
    public static final int DING = 3;
    public static final int WU = 4;
    public static final int JI = 5;
    public static final int GENG = 6;
    public static final int XIN = 7;
    public static final int REN = 8;
    public static final int GUI = 9;
    
    public static final String sTianGan = "¼×ÒÒ±û¶¡Îì¼º¸ýÐÁÈÉ¹ï";
    
    public String toString(){
        return new String(sTianGan.charAt(tg)+"");
    }

    private int tg;

    public TianGan(int tg) {
        this.tg = tg;
    }

    public int getTianGan() {
        return tg;
    }

    public WuXing getXing() {
        return new WuXing((tg + 1) / 2 - 1);
    }

    public boolean isYang() {
        return tg % 2 == 0;
    }

    /**
     * Éú
     * @param tg2
     * @return
     */
    public boolean isSheng(TianGan tg2) {
        return getXing().isSheng(tg2.getXing());
    }

    /**
     * ¿Ë
     * @param tg2
     * @return
     */
    public boolean isKe(TianGan tg2) {
        return getXing().isKe(tg2.getXing());
    }

    /**
     * ³å
     * @param tg2
     * @return
     */
    public boolean isChong(TianGan tg2) {
        boolean zR = false;
        if (tg == JIA && tg2.getTianGan() == GENG || tg == YI && tg2.getTianGan() == XIN
                || tg == BING && tg2.getTianGan() == REN || tg == DING && tg2.getTianGan() == GUI)
            zR = true;
        return zR;
    }
    
    public WuXing isHe(TianGan tg2){
        if(tg == JIA && tg2.getTianGan()==JI)
            return new WuXing(WuXing.TU);
        else if(tg == YI && tg2.getTianGan()==GENG)
            return new WuXing(WuXing.JIN);
        else if(tg == BING && tg2.getTianGan()==XIN)
            return new WuXing(WuXing.SHUI);
        else if(tg == DING && tg2.getTianGan()==REN)
            return new WuXing(WuXing.MU);
        else if(tg == WU && tg2.getTianGan()==GUI)
            return new WuXing(WuXing.HUO);
        else 
            return null;
    }
}
