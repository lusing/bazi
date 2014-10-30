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
        setTianPan();
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

    private TianGan[] tianPan_qiyi = new TianGan[9];

    private JiuXing[] tianPan_Jiuxing = new JiuXing[8];

    private BaMen[] tianPan_BaMen = new BaMen[8];

    private BaShen[] baShen = new BaShen[8];

    private TianGan[] yinGan = new TianGan[8];

    private int zhifu = -1;

    private TianGan mXunShou = null;

    private String[] mKongMa = new String[8];

    private int[] houTianBaGua = {1, 8, 3, 4, 9, 2, 7, 6};
    private int[] houTianBaGua_full = {1, 8, 3, 4, 9, 2, 7, 6, 5};

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

    private void setTianPan() {
        mXunShou = findXunShou(hourGZ);
        System.out.println("旬首为" + mXunShou);
        zhifu = -1;
        int xunshou = mXunShou.getTianGan();
        for (int i = 0; i < diPan_qiyi.length; i++) {
            if (diPan_qiyi[i].getTianGan() == xunshou) {
                zhifu = i;
            }
        }
        System.out.println("值符为:" + new JiuXing(zhifu));
        System.out.println("值使门为:" + new BaMen(zhifu));
        int shigan = -1;
        for (int i2 = 0; i2 < 8; i2++) {
            if (diPan_qiyi[i2].getTianGan() == hourGZ.mTg.getTianGan()) {
                shigan = i2;
            }
        }
        //时辰的天干
        int stg = shigan + hourGZ.mTg.getTianGan();
        //查找值符门的后天八卦序数
        int htbg = 0;
        for (int i3 = 0; i3 < houTianBaGua_full.length; i3++) {
            if (houTianBaGua_full[i3] == zhifu) {
                htbg = i3;
            }
        }
        int zhishimen = houTianBaGua_full[(htbg + stg) % 9];
        for (int i4 = 0; i4 < 8; i4++) {
            this.tianPan_BaMen[(i4 + zhishimen) % 8] = new BaMen(i4 + zhifu);
        }
        for (int i1 = 0; i1 < 8; i1++) {
            this.tianPan_Jiuxing[(i1 + shigan) % 8] = new JiuXing(zhifu + i1);
            this.tianPan_qiyi[(i1 + shigan) % 8] = diPan_qiyi[(zhifu + i1) % 8];
            baShen[(i1 + shigan) % 8] = new BaShen(i1);
            //this.tianPan_BaMen[(i1+)%8]=new BaMen(i1);
        }
        tianPan_qiyi[8] = this.diPan_qiyi[8];

        //排隐干
        int yingan = 0;
        for (int i5 = 0; i5 < diPan_qiyi.length; i5++) {
            if (diPan_qiyi[i5].getTianGan() == stg) {
                yingan = i5;
            }
        }
        for (int i6 = 0; i6 < 8; i6++) {
            yinGan[(zhifu + i6) % 8] = diPan_qiyi[yingan + i6];
        }
        
        getKongAndMa();

        System.out.println("---------");
        System.out.println("|" + yinGan[3].toString()+this.mKongMa[3] + "  |" + yinGan[4].toString()+this.mKongMa[4] + "  |" + yinGan[5] +this.mKongMa[5]+ "  |");
        System.out.println("|" + baShen[3].toString() + "  |" + baShen[4].toString() + "  |" + baShen[5] + "  |");
        System.out.println("|" + tianPan_qiyi[3].toString() + tianPan_Jiuxing[3].toString() + "|" + tianPan_qiyi[4].toString() + tianPan_Jiuxing[4].toString() + "|"
                + tianPan_qiyi[5].toString() + tianPan_Jiuxing[5] + "|");
        System.out.println("|" + diPan_qiyi[3].toString() + tianPan_BaMen[3].toString() + "|" + diPan_qiyi[4].toString() + tianPan_BaMen[4].toString() + "|"
                + diPan_qiyi[5].toString() + tianPan_BaMen[5] + "|");
        System.out.println("---------");
        System.out.println("|" + yinGan[2].toString()+mKongMa[2] + "  |" + "  " + "  |" + yinGan[6]+mKongMa[6] + "  |");
        System.out.println("|" + baShen[2].toString() + " |" + "中 " + " |" + baShen[6] + " |");
        System.out.println("|" + tianPan_qiyi[2].toString() + tianPan_Jiuxing[2].toString() + "|" + tianPan_qiyi[8].toString() + "禽" + "|"
                + tianPan_qiyi[6].toString() + tianPan_Jiuxing[6] + "|");
        System.out.println("|" + diPan_qiyi[2].toString() + tianPan_BaMen[2].toString() + "|" + diPan_qiyi[8].toString() + "中" + "|"
                + diPan_qiyi[6].toString() + tianPan_BaMen[6] + "|");
        System.out.println("---------");
        System.out.println("|" + yinGan[1].toString()+mKongMa[1] + "  |" + yinGan[0].toString()+mKongMa[0] + "  |" + yinGan[7] +mKongMa[7]+ "  |");
        System.out.println("|" + baShen[1].toString() + " |" + baShen[0].toString() + " |" + baShen[7] + " |");
        System.out.println("|" + tianPan_qiyi[1].toString() + tianPan_Jiuxing[1].toString() + "|" + tianPan_qiyi[0].toString() + tianPan_Jiuxing[0].toString() + "|"
                + tianPan_qiyi[7].toString() + tianPan_Jiuxing[7] + "|");
        System.out.println("|" + diPan_qiyi[1].toString() + tianPan_BaMen[1].toString() + "|" + diPan_qiyi[0].toString() + tianPan_BaMen[0].toString() + "|"
                + diPan_qiyi[7].toString() + tianPan_BaMen[7] + "|");
        System.out.println("---------");
    }

    private void getKongAndMa() {
        for (int i = 0; i < 8; i++) {
            StringBuilder sb = new StringBuilder(2);
            if (isKongWang(i)) {
                sb.append("空");
            }
            if (isMaXing(i)) {
                sb.append("马");
            }
            mKongMa[i] = sb.toString();
        }
    }

    private boolean isKongWang(int gong) {
        int xunshou = findXunShou(hourGZ).getTianGan();
        switch (xunshou) {
            case TianGan.WU:
                return gong == 7;
            case TianGan.JI:
                return gong == 5 || gong == 6;
            case TianGan.GENG:
                return gong == 4 || gong == 5;
            case TianGan.XIN:
                return gong == 3;
            case TianGan.REN:
                return gong == 1 || gong == 2;
            case TianGan.GUI:
                return gong == 0 || gong == 1;
        }
        return false;
    }

    private boolean isMaXing(int gong) {
        int shiZhi = hourGZ.mDz.getDiZhi();
        switch (shiZhi % 4) {
            case 0:
                return gong == 1;
            case 1:
                return gong == 7;
            case 2:
                return gong == 5;
            case 3:
                return gong == 3;
        }
        return false;
    }

    /**
     * 寻找旬首
     *
     * @return
     */
    private TianGan findXunShou(GanZhi shiZhu) {
        int tg = shiZhu.mTg.getTianGan();
        int dz = shiZhu.mDz.getDiZhi();

        int value = (dz - tg) % 10;
        switch (value) {
            case 0:
                //甲子
                return new TianGan(TianGan.WU);
            case 10:
                //甲 己
                return new TianGan(TianGan.JI);
            case 8:
                //甲申庚
                return new TianGan(TianGan.GENG);
            case 6:
                //甲午辛
                return new TianGan(TianGan.XIN);
            case 4:
                //甲辰壬
                return new TianGan(TianGan.REN);
            case 2:
                //甲寅
                return new TianGan(TianGan.GUI);
        }
        return null;
    }

    /**
     * 设置地盘六仪三奇
     */
    private void setDiPan() {
        if (mYang) {
            //阳遁，后天八卦
            for (int i = 0; i < 9; i++) {
                diPan_qiyi[(yangDunOrder[(i + mJu - 1) % 9]) % 9] = new TianGan(getQiyi(i));
            }
        } else {
            //阴遁
            for (int i = 0; i < 9; i++) {
                diPan_qiyi[(yinDunOrder[(i + mJu - 1) % 9]) % 9] = new TianGan(getQiyi(i));
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
