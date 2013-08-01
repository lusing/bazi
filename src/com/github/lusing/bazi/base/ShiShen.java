
package com.github.lusing.bazi.base;

public class ShiShen extends LiuQin {
    protected int shishen;

    /**
     * 生我者为父母 / 印星 异性为正印 同性为偏印
     */
    public static final int YINXING = 0x1;
    public static final int ZHENGYIN = 0x10;
    public static final int PIANYIN = 0x11;
    /**
     * 我生者为儿女 / 食伤 异性为伤官 同性为食神
     */
    public static final int SHISHANG = 0x2;
    public static final int SHANGGUAN = 0x20;
    public static final int SHISHEN = 0x21;
    /**
     * 克我者为官杀 异性为正官 同性为七杀
     */
    public static final int ZHENGGUAN = 0x30;
    public static final int QISHA = 0x31;
    public static final int PIANGUAN = QISHA;
    
    /**
     * 我克者为妻财 / 财星 异性为正财 同性为偏财
     */
    public static final int CAIXING = 0x4;
    public static final int ZHENGCAI = 0x40;
    public static final int PIANCAI = 0x41;

    /**
     * 同我者为兄弟 / 比劫 异性为劫财 同性为比肩
     */
    public static final int BIJIE = 0x05;
    public static final int JIECAI = 0x50;
    public static final int BIJIAN = 0x51;

    public String toString() {
        StringBuffer sb = new StringBuffer();
        switch (shishen) {
            case ZHENGYIN:
                sb.append("正印（印绶）");
                //sb.append("\t生我者\t正母");
                break;
            case PIANYIN:
                sb.append("偏印（枭）");
                //sb.append("\t生我者\t养母");
                break;
            case SHANGGUAN:
                sb.append("伤官");
                //sb.append("\t我生者\t儿子(女看)");
                break;
            case SHISHEN:
                sb.append("食神");
                //sb.append("\t我生者\t子孙，女儿(女看)");
                break;
            case ZHENGGUAN:
                sb.append("正官");
                //sb.append("\t克我者\t丈夫，");
                break;
            case QISHA:
                sb.append("七杀(偏官)");
                //sb.append("\t克我者\t情夫，儿子（男）");
                break;
            case ZHENGCAI:
                sb.append("正财");
                //sb.append("\t我克者\t正妻，金钱");
                break;
            case PIANCAI:
                sb.append("偏财");
                //sb.append("\t我克者\t父，妾");
                break;
            case BIJIAN:
                sb.append("比肩");
                //sb.append("\t兄弟姐妹");
                break;
            case JIECAI:
                sb.append("劫财");
                //sb.append("\t义兄弟");
                break;
            default:
                break;
        }
        return sb.toString();
    }

    public int getShiShen() {
        return shishen;
    }

    public static ShiShen getShiShen(TianGan me, TianGan other) {
        ShiShen ss1 = new ShiShen();
        int sum = me.getTianGan() + other.getTianGan();
        boolean isSame = sum % 2 == 0;
        if (other.isSheng(me)) {
            ss1.liuqin = LiuQin.FUMU;
            if (isSame) {
                ss1.shishen = ShiShen.ZHENGYIN;
            } else {
                ss1.shishen = ShiShen.PIANYIN;
            }
        } else if (me.isSheng(other)) {
            ss1.liuqin = LiuQin.ERNV;
            if (isSame) {
                ss1.shishen = ShiShen.SHISHEN;
            } else {
                ss1.shishen = ShiShen.SHANGGUAN;
            }
        } else if (other.isKe(me)) {
            ss1.liuqin = LiuQin.GUANSHA;
            if (isSame) {
                ss1.shishen = ShiShen.QISHA;
            } else {
                ss1.shishen = ShiShen.ZHENGGUAN;
            }
        } else if (me.isKe(other)) {
            ss1.liuqin = LiuQin.QICAI;
            if (isSame) {
                ss1.shishen = ShiShen.PIANCAI;
            } else {
                ss1.shishen = ShiShen.ZHENGCAI;
            }
        } else {
            ss1.liuqin = LiuQin.XIONGDI;
            if (isSame) {
                ss1.shishen = ShiShen.BIJIAN;
            } else {
                ss1.shishen = ShiShen.JIECAI;
            }
        }
        return ss1;
    }
}
