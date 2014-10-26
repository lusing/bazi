package com.github.lusing.qimen;

import com.github.lusing.bazi.base.DiZhi;
import com.github.lusing.bazi.base.GanZhi;
import com.github.lusing.bazi.base.TianGan;

/**
 *
 * @author Louis
 */
public class QimenEngine {
    public static void run(){
        YinpanDunjia yd1 = new YinpanDunjia(
                new GanZhi(TianGan.BING,DiZhi.XU),
                new GanZhi(TianGan.GUI,DiZhi.SI),
                new GanZhi(TianGan.REN,DiZhi.ZI),
                new GanZhi(TianGan.GENG,DiZhi.XU),
                4,
                26,
                true
        );
        System.out.println(yd1);
    }    
}
