package com.github.lusing.bazi.base;

/**
 * 干支
 *
 * @author Louis
 */
public class GanZhi {

    public TianGan mTg;
    public DiZhi mDz;

    public GanZhi(TianGan tg, DiZhi dz) {
        mTg = tg;
        mDz = dz;
    }
    
    public GanZhi(int tg, int dz){
        mTg = new TianGan(tg);
        mDz = new DiZhi(dz);
    }
}
