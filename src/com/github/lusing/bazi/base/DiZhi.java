package com.github.lusing.bazi.base;

public class DiZhi {
    public static final int ZI = 0;
    public static final int CHOU = 0;
    public static final int YIN = 0;
    public static final int MAO = 0;
    public static final int CHEN = 0;
    public static final int SI = 0;
    public static final int WU = 0;
    public static final int WEI = 0;
    public static final int SHEN = 0;
    public static final int YOU = 0;
    public static final int XU = 0;
    public static final int HAI = 0;
    
    public static final String sDiZhi = "子丑寅卯辰巳午未申酉戌亥";
    
    private int iDiZhi;
    
    public DiZhi(int idz){
        iDiZhi = idz;
    }
    public int getDiZhi(){
        return this.iDiZhi;
    }
    
    public String toString(){
        return new String(sDiZhi.charAt(iDiZhi)+"");
    }
}
