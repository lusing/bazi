package com.github.lusing.bazi.base;

import java.util.ArrayList;

public class DiZhi {
    /**
     * 子
     */
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

    /**
     * 获取地支中的藏干
     * @return 
     */
    public ArrayList<TianGan> getCangGan(){
        ArrayList<TianGan> tgList = new ArrayList<TianGan>();
                switch (this.iDiZhi){
            case ZI:
                tgList.add(new TianGan(TianGan.GUI));
                break;
            case CHOU:
            	tgList.add(new TianGan(TianGan.JI));
            	tgList.add(new TianGan(TianGan.GUI));
            	tgList.add(new TianGan(TianGan.XIN));
                break;
            case YIN:
            	tgList.add(new TianGan(TianGan.JIA));
            	tgList.add(new TianGan(TianGan.BING));
            	tgList.add(new TianGan(TianGan.WU));
                break;
            case MAO:
            	tgList.add(new TianGan(TianGan.YI));
                break;
            case CHEN:
            	tgList.add(new TianGan(TianGan.WU));
            	tgList.add(new TianGan(TianGan.JI));
            	tgList.add(new TianGan(TianGan.GUI));
                break;
            case SI:
            	tgList.add(new TianGan(TianGan.BING));
            	tgList.add(new TianGan(TianGan.WU));
            	tgList.add(new TianGan(TianGan.GENG));
                break;
            case WU:
            	tgList.add(new TianGan(TianGan.DING));
            	tgList.add(new TianGan(TianGan.JI));
                break;
            case WEI:
            	tgList.add(new TianGan(TianGan.JI));
            	tgList.add(new TianGan(TianGan.YI));
            	tgList.add(new TianGan(TianGan.DING));
                break;
            case SHEN:
            	tgList.add(new TianGan(TianGan.GENG));
            	tgList.add(new TianGan(TianGan.REN));
            	tgList.add(new TianGan(TianGan.WU));
                break;
            case YOU:
            	tgList.add(new TianGan(TianGan.XIN));
                break;
            case XU:
            	tgList.add(new TianGan(TianGan.WU));
            	tgList.add(new TianGan(TianGan.XIN));
            	tgList.add(new TianGan(TianGan.DING));
                break;
            case HAI:
            	tgList.add(new TianGan(TianGan.REN));
            	tgList.add(new TianGan(TianGan.JIA));
                break;
            default:
                break;
        }

        return tgList;
    }

    public TianGan getBenQin(){
        int tg = -1;
        switch (this.iDiZhi){
            case ZI:
                tg = TianGan.GUI;
                break;
            case CHOU:
                tg = TianGan.JI;
                break;
            case YIN:
                tg = TianGan.JIA;
                break;
            case MAO:
                tg = TianGan.YI;
                break;
            case CHEN:
                tg = TianGan.WU;
                break;
            case SI:
                tg = TianGan.BING;
                break;
            case WU:
                tg = TianGan.DING;
                break;
            case WEI:
                tg = TianGan.JI;
                break;
            case SHEN:
                tg = TianGan.GENG;
                break;
            case YOU:
                tg = TianGan.XIN;
                break;
            case XU:
                tg = TianGan.WU;
                break;
            case HAI:
                tg = TianGan.REN;
                break;
            default:
                break;
        }
        //System.out.println(this.toString()+"的本气为"+new TianGan(tg).toString());
        return new TianGan(tg);
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
    
    public boolean isKe(DiZhi dz2){
        return getXing().isKe(dz2.getXing());
    }
    
    public boolean isSheng(DiZhi dz2){
        return getXing().isSheng(dz2.getXing());
    }

    /**
     * 通过月地支和时地支计算命宫
     * @param yueDZ - 月地支
     * @param shiDZ - 时地支
     * @return 命宫地支
     */
    public static DiZhi getMingGong(DiZhi yueDZ, DiZhi shiDZ) {
        int dzsum = yueDZ.getDiZhi()-1 + shiDZ.getDiZhi()-1;
        return new DiZhi((14 - dzsum +1) % 12);
    }
}
