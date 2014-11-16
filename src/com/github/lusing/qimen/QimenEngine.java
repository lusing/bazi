package com.github.lusing.qimen;

import com.github.lusing.bazi.base.DiZhi;
import com.github.lusing.bazi.base.GanZhi;
import com.github.lusing.bazi.base.TianGan;

/**
 *
 * @author Louis
 */
public class QimenEngine {

    public static void run() {
        /*
        YinpanDunjia yd1 = new YinpanDunjia(
                new GanZhi(TianGan.BING, DiZhi.XU),
                new GanZhi(TianGan.GUI, DiZhi.SI),
                new GanZhi(TianGan.REN, DiZhi.ZI),
                new GanZhi(TianGan.GENG, DiZhi.XU),
                4,
                26,
                true
        );
        System.out.println(yd1);
        YinpanDunjia yd2 = new YinpanDunjia(
                new GanZhi(TianGan.YI, DiZhi.HAI),
                new GanZhi(TianGan.REN, DiZhi.WU),
                new GanZhi(TianGan.GUI, DiZhi.YOU),
                new GanZhi(TianGan.DING, DiZhi.SI),
                5,
                14,
                true
        );
        System.out.println(yd2);
        YinpanDunjia yd3 = new YinpanDunjia(
                new GanZhi(TianGan.YI, DiZhi.YOU),
                new GanZhi(TianGan.JI, DiZhi.MAO),
                new GanZhi(TianGan.GUI, DiZhi.SI),
                new GanZhi(TianGan.WU, DiZhi.WU),
                2,
                1,
                true
        );
        System.out.println(yd3);*/
        
        //例题，测病3
        YinpanDunjia yd4 = new YinpanDunjia(
                new GanZhi(TianGan.BING, DiZhi.XU),
                new GanZhi(TianGan.GUI, DiZhi.SI),
                new GanZhi(TianGan.YI, DiZhi.CHOU),
                new GanZhi(TianGan.GUI, DiZhi.WEI),
                5,
                10,
                true
        );
        System.out.println(yd4);
    }
}
