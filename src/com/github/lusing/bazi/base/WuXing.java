
package com.github.lusing.bazi.base;

public class WuXing{
    public static final int MU = 0;
    public static final int HUO = 1;
    public static final int TU = 2;
    public static final int JIN = 3;
    public static final int SHUI = 4;
    
    private int xing;
    
    public int getXing(){
        return xing;
    }
    
    public WuXing(int xing){
        this.xing = (xing+5) % 5;
    }
    
    public static final String getWuXingName(int xing) {
        switch (xing % 5) {
            case MU:
                return "木";
            case HUO:
                return "火";
            case TU:
                return "土";
            case JIN:
                return "金";
            case SHUI:
                return "水";
            default:
                return null;
        }
    }
    
    //生, 顺位而生
    public static final boolean isSheng(int xing1, int xing2){
        int x1 = (xing1+5) % 5;
        int x2 = (xing2+5) % 5;
        
        if((x2-x1+5)%5 == 1){
            return true;
        }
        return false;
    }
    
    //克,隔位相克
    public static final boolean isKe(int xing1, int xing2){
        int x1 = (xing1+5) % 5;
        int x2 = (xing2+5) % 5;
        
        if((x2-x1+5)%5 == 2){
            return true;
        }
        return false;
    }
    
    public boolean equals(WuXing other){
        return this.xing == other.getXing();
    }
    
    public boolean isSheng(WuXing xing2){
        return isSheng(this.xing,xing2.getXing());
    }
    
    public boolean isKe(WuXing xing2){
        return isKe(this.xing,xing2.getXing());
    }
    
    public String toString(){
        return getWuXingName(this.xing);
    }
    
    public String toStringLong(){
        StringBuffer sb = new StringBuffer();
        switch (xing % 5) {
            case MU:
                sb.append("木\n");
                sb.append("主仁\n");
                sb.append("肝脏\n");
                sb.append("绿色\n");
                break;
            case HUO:
                sb.append("火\n");
                sb.append("主礼\n");
                sb.append("心脏\n");
                sb.append("红色\n");
                break;
            case TU:
                sb.append("土\n");
                sb.append("主信\n");
                sb.append("脾脏\n");
                sb.append("黄色\n");
                break;
            case JIN:
                sb.append("金\n");
                sb.append("主义\n");
                sb.append("肺脏\n");
                sb.append("白色\n");
                break;
            case SHUI:
                sb.append("水\n");
                sb.append("主智\n");
                sb.append("肾脏\n");
                sb.append("黑色\n");
                break;
            default:
        }
        
        return sb.toString();
    }
    
}
