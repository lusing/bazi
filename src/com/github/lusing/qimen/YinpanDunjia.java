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

    private void setJu() {
        int yearNo = yearGZ.mDz.getDiZhi() + 1;
        int hourNo = hourGZ.mDz.getDiZhi() + 1;
        mJu = (yearNo + mMonth + mDay + hourNo) % 9;
    }

    private void setDiPan() {
        if (!mYang) {
            //阳遁，后天八卦
            diPan_qiyi[0] = new TianGan(TianGan.WU);
            diPan_qiyi[5] = new TianGan(TianGan.JI);
            diPan_qiyi[2] = new TianGan(TianGan.GENG);
            diPan_qiyi[3] = new TianGan(TianGan.XIN);
            diPan_qiyi[8] = new TianGan(TianGan.REN);
            diPan_qiyi[7] = new TianGan(TianGan.GUI);
            diPan_qiyi[6] = new TianGan(TianGan.DING);
            diPan_qiyi[1] = new TianGan(TianGan.BING);
            diPan_qiyi[4] = new TianGan(TianGan.YI);
        } else {
            //阴遁
            diPan_qiyi[0] = new TianGan(TianGan.WU);
            diPan_qiyi[4] = new TianGan(TianGan.JI);
            diPan_qiyi[1] = new TianGan(TianGan.GENG);
            diPan_qiyi[6] = new TianGan(TianGan.XIN);
            diPan_qiyi[7] = new TianGan(TianGan.REN);
            diPan_qiyi[8] = new TianGan(TianGan.GUI);
            diPan_qiyi[3] = new TianGan(TianGan.DING);
            diPan_qiyi[2] = new TianGan(TianGan.BING);
            diPan_qiyi[5] = new TianGan(TianGan.YI);
        }
        
        System.out.println("---------");
        System.out.println("|"+diPan_qiyi[3].toString()+"|"+diPan_qiyi[4].toString()+"|"+diPan_qiyi[5]+"|");
        System.out.println("---------");
        System.out.println("|"+diPan_qiyi[2].toString()+"|"+diPan_qiyi[8].toString()+"|"+diPan_qiyi[6]+"|");
        System.out.println("---------");
        System.out.println("|"+diPan_qiyi[1].toString()+"|"+diPan_qiyi[0].toString()+"|"+diPan_qiyi[7]+"|");
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
