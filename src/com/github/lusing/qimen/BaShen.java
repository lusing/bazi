/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lusing.qimen;

/**
 *
 * @author Louis
 */
public class BaShen {

    public static final int FU = 0;
    public static final int SHE = 1;
    public static final int YIN = 2;
    public static final int LIU = 3;
    public static final int BAI = 4;
    public static final int XUAN = 5;
    public static final int DI = 6;
    public static final int TIAN = 7;

    public static final String sBaShen = "符蛇阴六白玄地天";

    private int mShen;

    public BaShen(int shen) {
        mShen = shen % 8;
    }

    @Override
    public String toString() {
        return new String(sBaShen.charAt(mShen) + "");
    }
}
