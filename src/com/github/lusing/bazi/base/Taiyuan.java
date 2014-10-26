package com.github.lusing.bazi.base;

/**
 * 求胎元
 * @author Louis
 */
public class Taiyuan {
    /**
     * 胎元求法：以月为主，生月天干进一位地支进三位即是胎元。
     * 所谓胎元，指的是受精怀胎的月份，说明一个人在怀孕的月份禀受天干地支及五行之气，以此作为预测命运的一种重要参考依据。
     * 其法是以月柱的天干向前推一位就是胎元天干，月份的地支向前推三位就是胎元之地支。
     * 例如丙子月起胎元，丙加一为丁，子加三为卯，所以其胎元为丁卯。
     * @param tg - 月干
     * @param dz - 月支
     * @return 
     */
    public static GanZhi getTianyuan(TianGan tg, DiZhi dz){
        return new GanZhi (new TianGan(tg.getTianGan()+1),new DiZhi(dz.getDiZhi()+3));
    }
}
