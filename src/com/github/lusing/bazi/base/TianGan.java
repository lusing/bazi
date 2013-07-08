
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
    
    public static final String sTianGan = "甲乙丙丁戊己庚辛壬癸";
    
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
        return new WuXing(tg / 2);
    }

    public boolean isYang() {
        return tg % 2 == 0;
    }

    /**
     * 生
     * @param tg2
     * @return
     */
    public boolean isSheng(TianGan tg2) {
        return getXing().isSheng(tg2.getXing());
    }

    /**
     * 克
     * @param tg2
     * @return
     */
    public boolean isKe(TianGan tg2) {
        return getXing().isKe(tg2.getXing());
    }

    /**
     * 冲
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
    
    public static WuXing isHe(TianGan tg1, TianGan tg2){
        if(tg1.getTianGan() == JIA && tg2.getTianGan()==JI)
            return new WuXing(WuXing.TU);
        else if(tg1.getTianGan() == YI && tg2.getTianGan()==GENG)
            return new WuXing(WuXing.JIN);
        else if(tg1.getTianGan() == BING && tg2.getTianGan()==XIN)
            return new WuXing(WuXing.SHUI);
        else if(tg1.getTianGan() == DING && tg2.getTianGan()==REN)
            return new WuXing(WuXing.MU);
        else if(tg1.getTianGan() == WU && tg2.getTianGan()==GUI)
            return new WuXing(WuXing.HUO);
        else 
            return null;        
    }
    
    public WuXing isHe(TianGan tg2){
        if(isHe(this,tg2)==null){
            return isHe(tg2,this);
        }else{
            return isHe(this,tg2);
        }
    }
}
