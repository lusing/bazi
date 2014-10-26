
package yunos.tech.panaimin.bazi;

import android.util.Log;

import java.util.ArrayList;

public class BaZi {
    class ZISTRENGTH {
        public ZISTRENGTH(char dizhi, char zhicang, double[] strength) {
            this.diZhi = dizhi;
            this.zhiCang = zhicang;
            this.strength = strength;
        }

        char diZhi;
        char zhiCang;
        double[] strength;
    };

    private ZISTRENGTH DiZhi_Strength[];

    public BaZi() {
        DiZhi_Strength = new ZISTRENGTH[24];

        DiZhi_Strength[0] = new ZISTRENGTH('子', '癸', new double[] {
                1.2, 1.1, 1.0, 1.0, 1.04, 1.06, 1.0, 1.0, 1.2, 1.2, 1.06, 1.14
        });

        DiZhi_Strength[1] = new ZISTRENGTH('丑', '癸', new double[] {
                0.36, 0.33, 0.3, 0.3, 0.312, 0.318, 0.3, 0.3, 0.36, 0.36, 0.318, 0.342
        });

        DiZhi_Strength[2] = new ZISTRENGTH('丑', '辛', new double[] {
                0.2, 0.228, 0.2, 0.2, 0.23, 0.212, 0.2, 0.22, 0.228, 0.248, 0.232, 0.2
        });

        DiZhi_Strength[3] = new ZISTRENGTH('丑', '己', new double[] {
                0.5, 0.55, 0.53, 0.5, 0.55, 0.57, 0.6, 0.58, 0.5, 0.5, 0.57, 0.5
        });

        DiZhi_Strength[4] = new ZISTRENGTH('寅', '丙', new double[] {
                0.3, 0.3, 0.36, 0.36, 0.318, 0.342, 0.36, 0.33, 0.3, 0.3, 0.342, 0.318
        });

        DiZhi_Strength[5] = new ZISTRENGTH('寅', '甲', new double[] {
                0.84, 0.742, 0.798, 0.84, 0.77, 0.7, 0.7, 0.728, 0.742, 0.7, 0.7, 0.84
        });

        DiZhi_Strength[6] = new ZISTRENGTH('卯', '乙', new double[] {
                1.2, 1.06, 1.14, 1.2, 1.1, 1.0, 1.0, 1.04, 1.06, 1.0, 1.0, 1.2
        });

        DiZhi_Strength[7] = new ZISTRENGTH('辰', '乙', new double[] {
                0.36, 0.318, 0.342, 0.36, 0.33, 0.3, 0.3, 0.312, 0.318, 0.3, 0.3, 0.36
        });

        DiZhi_Strength[8] = new ZISTRENGTH('辰', '癸', new double[] {
                0.24, 0.22, 0.2, 0.2, 0.208, 0.2, 0.2, 0.2, 0.24, 0.24, 0.212, 0.228
        });

        DiZhi_Strength[9] = new ZISTRENGTH('辰', '戊', new double[] {
                0.5, 0.55, 0.53, 0.5, 0.55, 0.6, 0.6, 0.58, 0.5, 0.5, 0.57, 0.5
        });

        DiZhi_Strength[10] = new ZISTRENGTH('巳', '庚', new double[] {
                0.3, 0.342, 0.3, 0.3, 0.33, 0.3, 0.3, 0.33, 0.342, 0.36, 0.348, 0.3
        });

        DiZhi_Strength[11] = new ZISTRENGTH('巳', '丙', new double[] {
                0.7, 0.7, 0.84, 0.84, 0.742, 0.84, 0.84, 0.798, 0.7, 0.7, 0.728, 0.742
        });

        DiZhi_Strength[12] = new ZISTRENGTH('午', '丁', new double[] {
                1.0, 1.0, 1.2, 1.2, 1.06, 1.14, 1.2, 1.1, 1.0, 1.0, 1.04, 1.06
        });

        DiZhi_Strength[13] = new ZISTRENGTH('未', '丁', new double[] {
                0.3, 0.3, 0.36, 0.36, 0.318, 0.342, 0.36, 0.33, 0.3, 0.3, 0.312, 0.318
        });

        DiZhi_Strength[14] = new ZISTRENGTH('未', '乙', new double[] {
                0.24, 0.212, 0.228, 0.24, 0.22, 0.2, 0.2, 0.208, 0.212, 0.2, 0.2, 0.24
        });

        DiZhi_Strength[15] = new ZISTRENGTH('未', '己', new double[] {
                0.5, 0.55, 0.53, 0.5, 0.55, 0.57, 0.6, 0.58, 0.5, 0.5, 0.57, 0.5
        });

        DiZhi_Strength[16] = new ZISTRENGTH('申', '壬', new double[] {
                0.36, 0.33, 0.3, 0.3, 0.312, 0.318, 0.3, 0.3, 0.36, 0.36, 0.318, 0.342
        });

        DiZhi_Strength[17] = new ZISTRENGTH('申', '庚', new double[] {
                0.7, 0.798, 0.7, 0.7, 0.77, 0.742, 0.7, 0.77, 0.798, 0.84, 0.812, 0.7
        });

        DiZhi_Strength[18] = new ZISTRENGTH('酉', '辛', new double[] {
                1.0, 1.14, 1.0, 1.0, 1.1, 1.06, 1.0, 1.1, 1.14, 1.2, 1.16, 1.0
        });

        DiZhi_Strength[19] = new ZISTRENGTH('戌', '辛', new double[] {
                0.3, 0.342, 0.3, 0.3, 0.33, 0.318, 0.3, 0.33, 0.342, 0.36, 0.348, 0.3
        });

        DiZhi_Strength[20] = new ZISTRENGTH('戌', '丁', new double[] {
                0.2, 0.2, 0.24, 0.24, 0.212, 0.228, 0.24, 0.22, 0.2, 0.2, 0.208, 0.212
        });

        DiZhi_Strength[21] = new ZISTRENGTH('戌', '戊', new double[] {
                0.5, 0.55, 0.53, 0.5, 0.55, 0.57, 0.6, 0.58, 0.5, 0.5, 0.57, 0.5
        });

        DiZhi_Strength[22] = new ZISTRENGTH('亥', '甲', new double[] {
                0.36, 0.318, 0.342, 0.36, 0.33, 0.3, 0.3, 0.312, 0.318, 0.3, 0.3, 0.36
        });

        DiZhi_Strength[23] = new ZISTRENGTH('亥', '壬', new double[] {
                0.84, 0.77, 0.7, 0.7, 0.728, 0.742, 0.7, 0.7, 0.84, 0.84, 0.724, 0.798
        });
    }

    public static final String sTianGan = "甲乙丙丁戊己庚辛壬癸";
    public static final String sDiZhi = "子丑寅卯辰巳午未申酉戌亥";
    public static final String sWuXingTable = "金木水火土";
    public static final int TianGan_WuXingProp[] = {
            1, 1, 3, 3, 4, 4, 0, 0, 2, 2
    };
    public static final int DiZhi_WuXingProp[] = {
            2, 4, 1, 1, 4, 3, 3, 4, 0, 0, 4, 2
    };
    public static final int GenerationSourceTable[] = {
            4, 2, 0, 1, 3
    };

    public static final double TianGan_Strength[][] = {
            {
                    1.2, 1.2, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.2, 1.2
            }, {
                    1.06, 1.06, 1.0, 1.0, 1.1, 1.1, 1.14, 1.14, 1.1, 1.1
            }, {
                    1.14, 1.14, 1.2, 1.2, 1.06, 1.06, 1.0, 1.0, 1.0, 1.0
            }, {
                    1.2, 1.2, 1.2, 1.2, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0
            }, {
                    1.1, 1.1, 1.06, 1.06, 1.1, 1.1, 1.1, 1.1, 1.04, 1.04
            }, {
                    1.0, 1.0, 1.14, 1.14, 1.14, 1.14, 1.06, 1.06, 1.06, 1.06
            }, {
                    1.0, 1.0, 1.2, 1.2, 1.2, 1.2, 1.0, 1.0, 1.0, 1.0
            }, {
                    1.04, 1.04, 1.1, 1.1, 1.16, 1.16, 1.1, 1.1, 1.0, 1.0
            }, {
                    1.06, 1.06, 1.0, 1.0, 1.0, 1.0, 1.14, 1.14, 1.2, 1.2
            }, {
                    1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.2, 1.2, 1.2, 1.2
            }, {
                    1.0, 1.0, 1.04, 1.04, 1.14, 1.14, 1.16, 1.16, 1.06, 1.06
            }, {
                    1.2, 1.2, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.14, 1.14
            }
    };

    public static ArrayList<String> getGanZhiList() {
        ArrayList<String> result = new ArrayList<String>();

        for (int i = 0; i < 60; i++) {
            result.add(sTianGan.charAt(i % 10) + "" + sDiZhi.charAt(i % 12));
        }

        return result;
    }

    // 将天干转为index
    int computeGanIndex(char gan) {
        int i;
        for (i = 0; i < 10; i++)
            if (sTianGan.charAt(i) == gan)
                break;
        if (i >= 10)
            return -1;
        return i;
    }

    // 将地支转为index
    int ComputeZhiIndex(char zhi) {
        int i;
        for (i = 0; i < 12; i++)
            if (sDiZhi.charAt(i) == zhi)
                break;
        if (i >= 12)
            return -1;
        return i;
    }

    public String evalBazi(String bazi) {
        StringBuffer sResultBuf = new StringBuffer();
        double[] strengthResult = new double[5];

        int monthIndex = ComputeZhiIndex(bazi.charAt(3));

        if (monthIndex == -1)
            return null;

        sResultBuf.append(bazi);

        sResultBuf.append("\n\n");

        for (int wuXing = 0; wuXing < 5; wuXing++) {

            double value1 = 0.0, value2 = 0.0;

            int i;

            // 扫描4个天干

            for (i = 0; i < 8; i += 2) {
                char gan = bazi.charAt(i);
                int index = computeGanIndex(gan);

                if (index == -1)
                    return null;

                if (TianGan_WuXingProp[index] == wuXing)
                    value1 += TianGan_Strength[monthIndex][index];
            }

            // 扫描支藏

            for (i = 1; i < 8; i += 2) {
                char zhi = bazi.charAt(i);
                for (int j = 0; j < DiZhi_Strength.length; j++) {
                    if (DiZhi_Strength[j].diZhi == zhi) {
                        int zhiCangIndex = computeGanIndex(DiZhi_Strength[j].zhiCang);
                        if (zhiCangIndex == -1)
                            return null;
                        if (TianGan_WuXingProp[zhiCangIndex] == wuXing) {
                            value2 += DiZhi_Strength[j].strength[monthIndex];
                            break;
                        }
                    }
                }
            }
            strengthResult[wuXing] = value1 + value2;
            // 输出一行计算结果
            {
                StringBuffer preStr = new StringBuffer();
                StringBuffer tmpBuf = new StringBuffer();

                Log.d("Aimin", "" + value1 + value2 + (value1 + value2));

                preStr.append(sWuXingTable.charAt(wuXing));
                sResultBuf.append(preStr + ":\t" + value1 + "+" + value2 + "=" + (value1 + value2));
                sResultBuf.append(tmpBuf + "\n");
            }
        }

        // 根据日干求命里属性

        int fateProp, srcProp;

        {
            StringBuffer tmpBuf = new StringBuffer();

            fateProp = TianGan_WuXingProp[computeGanIndex(bazi.charAt(4))];

            if (fateProp == -1)
                return null;

            tmpBuf.append("\n命属");

            tmpBuf.append(sWuXingTable.charAt(fateProp));

            sResultBuf.append(tmpBuf + "\n");

        }

        // 求同类和异类的强度值

        srcProp = GenerationSourceTable[fateProp];

        {
            StringBuffer preStr = new StringBuffer();
            StringBuffer tmpBuf = new StringBuffer();

            double tongLei = strengthResult[fateProp] + strengthResult[srcProp];
            double yiLei = 0.0;

            for (int i = 0; i < 5; i++)
                yiLei += strengthResult[i];

            yiLei -= tongLei;

            tmpBuf.append(Double.valueOf(strengthResult[fateProp]).toString() + "+");
            tmpBuf.append(Double.valueOf(strengthResult[srcProp]).toString() + "=");
            tmpBuf.append(Double.valueOf(tongLei).toString() + "\n");

            preStr.append("同类：");

            preStr.append(sWuXingTable.charAt(fateProp) + "+" + sWuXingTable.charAt(srcProp));

            sResultBuf.append(preStr);

            sResultBuf.append(tmpBuf);

            // tmpBuf.append((float) yiLei);

            sResultBuf.append("异类：总和为 ");

            sResultBuf.append(Double.valueOf(yiLei) + "\n");

        }

        return sResultBuf.toString();

    }
}
