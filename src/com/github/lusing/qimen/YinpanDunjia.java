package com.github.lusing.qimen;

import com.github.lusing.bazi.base.DiZhi;
import com.github.lusing.bazi.base.GanZhi;
import com.github.lusing.bazi.base.TianGan;
import com.github.lusing.bazi.base.YinYang;

/**
 * 王凤林阴盘奇门遁甲
 *
 * @author Louis
 *
 */
public class YinpanDunjia {

    private GanZhi yearGZ;
    private GanZhi monthGZ;
    private GanZhi dayGZ;
    private GanZhi hourGZ;

    public YinpanDunjia(GanZhi ygz, GanZhi mgz, GanZhi dgz, GanZhi hgz,
            int month, int day, boolean yang) {
        yearGZ = ygz;
        monthGZ = mgz;
        dayGZ = dgz;
        hourGZ = hgz;
        mMonth = month;
        mDay = day;
        mYang = yang;

        setJu();
        setDiPan();
    }

    /**
     * 月份
     */
    private int mMonth;
    /**
     * 阴历日期
     */
    private int mDay;

    /**
     * 局数
     */
    private int mJu;

    /**
     * 阴遁还是阳遁
     */
    private boolean mYang;

    /**
     * 地盘上的奇仪
     */
    private TianGan[] diPan_qiyi = new TianGan[9];

    private int[] houTianBaGua = {1, 8, 3, 4, 9, 2, 7, 6};

    private int[] yangDunOrder = {0, 5, 2, 3, 8, 7, 6, 1, 4};
    private int[] yinDunOrder = {0, 4, 1, 6, 7, 8, 3, 2, 5};

    private void setJu() {
        int yearNo = yearGZ.mDz.getDiZhi() + 1;
        int hourNo = hourGZ.mDz.getDiZhi() + 1;
        mJu = (yearNo + mMonth + mDay + hourNo) % 9;
    }

    private int getQiyi(int i) {
        switch (i % 9) {
            case 0:
                return TianGan.WU;
            case 1:
                return TianGan.JI;
            case 2:
                return TianGan.GENG;
            case 3:
                return TianGan.XIN;
            case 4:
                return TianGan.REN;
            case 5:
                return TianGan.GUI;
            case 6:
                return TianGan.DING;
            case 7:
                return TianGan.BING;
            case 8:
                return TianGan.YI;
        }
        return 0;
    }

    private void setDiPan() {
        if (mYang) {
            //阳遁，后天八卦
            for (int i = 0; i < 9; i++) {
                diPan_qiyi[(yangDunOrder[(i+mJu-1)%9])%9] = new TianGan(getQiyi(i));
            }
        } else {
            //阴遁
            for (int i = 0; i < 9; i++) {
                diPan_qiyi[(yinDunOrder[(i+mJu-1)%9])%9] = new TianGan(getQiyi(i));
            }
        }

        System.out.println("---------");
        System.out.println("|" + diPan_qiyi[3].toString() + "|" + diPan_qiyi[4].toString() + "|" + diPan_qiyi[5] + "|");
        System.out.println("---------");
        System.out.println("|" + diPan_qiyi[2].toString() + "|" + diPan_qiyi[8].toString() + "|" + diPan_qiyi[6] + "|");
        System.out.println("---------");
        System.out.println("|" + diPan_qiyi[1].toString() + "|" + diPan_qiyi[0].toString() + "|" + diPan_qiyi[7] + "|");
        System.out.println("---------");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append((new YinYang(mYang)).toString()).append("遁").append(mJu)
                .append("局");

        return sb.toString();
    }
}
