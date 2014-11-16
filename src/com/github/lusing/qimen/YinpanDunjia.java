package com.github.lusing.qimen;

import com.github.lusing.bazi.base.BaGua;
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

    final private GanZhi yearGZ;
    final private GanZhi monthGZ;
    final private GanZhi dayGZ;
    final private GanZhi hourGZ;

    /**
     *
     * @param ygz 年干支
     * @param mgz 月干支
     * @param dgz 日干支
     * @param hgz 时干支
     * @param month 阴历月份
     * @param day 阴历日期
     * @param yang 阳遁还是阴遁
     */
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
    final private int mMonth;
    /**
     * 阴历日期
     */
    final private int mDay;

    /**
     * 局数
     */
    private int mJu;

    /**
     * 阴遁还是阳遁
     */
    final private boolean mYang;

    final private BaGua[] diPan_bagua = new BaGua[8];

    /**
     * 地盘上的奇仪
     */
    final private TianGan[] diPan_qiyi = new TianGan[9];

    final private TianGan[] tianPan_qiyi = new TianGan[9];

    final private JiuXing[] tianPan_Jiuxing = new JiuXing[8];

    final private BaMen[] tianPan_BaMen = new BaMen[8];

    final private BaShen[] baShen = new BaShen[8];

    final private TianGan[] yinGan = new TianGan[8];

    private int zhifu = -1;

    private TianGan mXunShou = null;

    final private String[] mKongMa = new String[8];

    //final private int[] houTianBaGua = {1, 8, 3, 4, 9, 2, 7, 6};
    final private int[] houTianBaGua_full = {1, 8, 3, 4, 9, 2, 7, 6, 5};

    final private int[] yangDunOrder = {0, 5, 2, 3, 8, 7, 6, 1, 4};
    final private int[] yinDunOrder = {0, 4, 1, 6, 7, 8, 3, 2, 5};

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
        int stg = hourGZ.mTg.getTianGan();
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

        //System.out.println("[值符落宫：]="+zhifu);
        //查找值符的后天八卦序数
        int htbgxs = houTianBaGua_full[zhifu];
        //System.out.println("[值符门后天八卦序数：]="+htbgxs);
        //时辰的天干落宫的后天八卦序数
        int sghtbg = (htbgxs + hourGZ.mTg.getTianGan()) % 9;
        //System.out.println("[时辰天干落宫的后天八卦序数：]="+sghtbg);

        //通过时干的后天八卦序数反查位置
        int zhishimen = 0;
        for (int i3 = 0; i3 < houTianBaGua_full.length; i3++) {
            if (houTianBaGua_full[i3] == sghtbg) {
                zhishimen = i3;
            }
        }

        //System.out.println("[值使门落宫：]="+zhishimen);
        for (int i4 = 0; i4 < 8; i4++) {
            this.tianPan_BaMen[(i4 + zhishimen) % 8] = new BaMen(i4 + zhifu);
        }

        int shiganluogong = 0;
        //值符随时干，查找时干落宫
        for (int i6 = 0; i6 < 8; i6++) {
            if (this.diPan_qiyi[i6].getTianGan() == stg) {
                shiganluogong = i6;
            }
        }

        for (int i1 = 0; i1 < 8; i1++) {
            this.tianPan_Jiuxing[(i1 + shiganluogong) % 8] = new JiuXing(zhifu + i1);
            this.tianPan_qiyi[(i1 + shiganluogong) % 8] = diPan_qiyi[(zhifu + i1) % 8];
            baShen[(i1 + shiganluogong) % 8] = new BaShen(i1);
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
            yinGan[(zhifu + i6) % 8] = diPan_qiyi[(yingan + i6) % 8];
        }

        getKongAndMa();

        System.out.println("---------");
        System.out.println("|" + yinGan[3].toString() + this.mKongMa[3] + "  |" + yinGan[4].toString() + this.mKongMa[4] + "  |" + yinGan[5] + this.mKongMa[5] + "  |");
        System.out.println("|" + baShen[3].toString() + "  |" + baShen[4].toString() + "  |" + baShen[5] + "  |");
        System.out.println("|" + tianPan_qiyi[3].toString() + tianPan_Jiuxing[3].toString() + "|" + tianPan_qiyi[4].toString() + tianPan_Jiuxing[4].toString() + "|"
                + tianPan_qiyi[5].toString() + tianPan_Jiuxing[5] + "|");
        System.out.println("|" + diPan_qiyi[3].toString() + tianPan_BaMen[3].toString() + "|" + diPan_qiyi[4].toString() + tianPan_BaMen[4].toString() + "|"
                + diPan_qiyi[5].toString() + tianPan_BaMen[5] + "|");
        System.out.println("---------");
        System.out.println("|" + yinGan[2].toString() + mKongMa[2] + "  |" + "  " + "  |" + yinGan[6] + mKongMa[6] + "  |");
        System.out.println("|" + baShen[2].toString() + " |" + "中 " + " |" + baShen[6] + " |");
        System.out.println("|" + tianPan_qiyi[2].toString() + tianPan_Jiuxing[2].toString() + "|" + tianPan_qiyi[8].toString() + "禽" + "|"
                + tianPan_qiyi[6].toString() + tianPan_Jiuxing[6] + "|");
        System.out.println("|" + diPan_qiyi[2].toString() + tianPan_BaMen[2].toString() + "|" + diPan_qiyi[8].toString() + "中" + "|"
                + diPan_qiyi[6].toString() + tianPan_BaMen[6] + "|");
        System.out.println("---------");
        System.out.println("|" + yinGan[1].toString() + mKongMa[1] + "  |" + yinGan[0].toString() + mKongMa[0] + "  |" + yinGan[7] + mKongMa[7] + "  |");
        System.out.println("|" + baShen[1].toString() + " |" + baShen[0].toString() + " |" + baShen[7] + " |");
        System.out.println("|" + tianPan_qiyi[1].toString() + tianPan_Jiuxing[1].toString() + "|" + tianPan_qiyi[0].toString() + tianPan_Jiuxing[0].toString() + "|"
                + tianPan_qiyi[7].toString() + tianPan_Jiuxing[7] + "|");
        System.out.println("|" + diPan_qiyi[1].toString() + tianPan_BaMen[1].toString() + "|" + diPan_qiyi[0].toString() + tianPan_BaMen[0].toString() + "|"
                + diPan_qiyi[7].toString() + tianPan_BaMen[7] + "|");
        System.out.println("---------");

        checkMenPo();
        checkJiXing();
    }

    /**
     * 检查是否有门迫 门迫为八门克所落之宫
     */
    private void checkMenPo() {
        for (int i = 0; i < 8; i++) {
            if (this.tianPan_BaMen[i].isKe(this.diPan_bagua[i])) {
                System.out.println("门迫：" + tianPan_BaMen[i] + "克" + diPan_bagua[i]);
                System.out.println(tianPan_BaMen[i].getXing() + "克" + diPan_bagua[i].getXing());
            }
        }
    }

    /**
     * 击刑：十干也所落之宫构成三刑。
     * <p>
     * 甲子戊落震三宫，子卯刑
     * <p>
     * 甲戌己落坤二宫，戌未刑
     * <p>
     * 甲申庚落艮八宫，申寅刑
     * <p>
     * 甲午辛落离九宫，午自刑
     * <p>
     * 甲辰壬落巽四宫，辰自刑
     * <p>
     * 甲寅癸落巽四宫，寅巳刑
     * <p>
     */
    private void checkJiXing() {
        for (int i = 0; i < 8; i++) {
            switch (this.tianPan_qiyi[i].getTianGan()) {
                case TianGan.WU:
                    if (this.diPan_bagua[i].getGua() == BaGua.ZHEN) {
                        System.out.println("甲子戊落震三宫，子卯刑");
                    }
                    break;
                case TianGan.JI:
                    if (this.diPan_bagua[i].getGua() == BaGua.KUN) {
                        System.out.println("甲戌己落坤二宫，戌未刑");
                    }
                    break;
                case TianGan.GENG:
                    if (this.diPan_bagua[i].getGua() == BaGua.GEN) {
                        System.out.println("甲申庚落艮八宫，申寅刑");
                    }
                    break;
                case TianGan.XIN:
                    if (this.diPan_bagua[i].getGua() == BaGua.LI) {
                        System.out.println("甲午辛落离九宫，午自刑");
                    }
                    break;
                case TianGan.REN:
                    if (this.diPan_bagua[i].getGua() == BaGua.XUN) {
                        System.out.println("甲辰壬落巽四宫，辰自刑");
                    }
                    break;
                case TianGan.GUI:
                    if (this.diPan_bagua[i].getGua() == BaGua.XUN) {
                        System.out.println("甲寅癸落巽四宫，寅巳刑");
                    }
                    break;
            }
        }
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

        //得到的差值是地支
        int value = (dz - tg + 12) % 12;
        //System.out.println("[Debug]value="+value);
        switch (value) {
            case 0:
                //甲子戊
                return new TianGan(TianGan.WU);
            case 10:
                //甲戌己
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
                //甲寅癸
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

        for (int i = 0; i < 8; i++) {
            diPan_bagua[i] = new BaGua(i + 1);
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
