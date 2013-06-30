package com.github.lusing.bazi.base;

public class DiZhi {
    public static final int ZI = 0;
    public static final int CHOU = 1;
    public static final int YIN = 2;
    public static final int MAO = 3;
    public static final int CHEN = 4;
    public static final int SI = 5;
    public static final int WU = 6;
    public static final int WEI = 7;
    public static final int SHEN = 8;
    public static final int YOU = 9;
    public static final int XU = 10;
    public static final int HAI = 11;
    
    public static final String sDiZhi = "子丑寅卯辰巳午未申酉戌亥";
    
    private int iDiZhi;
    
    public DiZhi(int idz){
        iDiZhi = (idz+12) % 12 ;
    }
    public int getDiZhi(){
        return this.iDiZhi;
    }
    
    public String toString(){
        return new String(sDiZhi.charAt(iDiZhi)+"");
    }
    
    public WuXing getXing(){
        int xing = -1;
        switch(this.iDiZhi){
            case YIN:
            case MAO:
                xing = WuXing.MU;
                break;
            case SI:
            case WU:
                xing = WuXing.HUO;
                break;
            case CHEN:
            case XU:
            case CHOU:
            case WEI:
                xing = WuXing.TU;
                break;
            case SHEN:
            case YOU:
                xing = WuXing.JIN;
                break;
            case HAI:
            case ZI:
                xing = WuXing.SHUI;
                break;
            default:
                return null;
        }        
        
        return new WuXing(xing);
    }
    
    public static WuXing isHe(int dz1, int dz2){
        int xing = -1;
        if(dz1==YIN && dz2 == HAI){
            xing = WuXing.MU;
        }else if(dz1 ==MAO && dz2 == XU){
            xing = WuXing.HUO;
        }
        return new WuXing(xing);
    }
}
