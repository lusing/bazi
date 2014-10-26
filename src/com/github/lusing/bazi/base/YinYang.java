/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lusing.bazi.base;

/**
 *
 * @author Louis
 */
public class YinYang {
    private boolean mYang;
    public YinYang(boolean yang){
        mYang = yang;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        if(mYang){
            sb.append("阳");
        }else{
            sb.append("阴");
        }
        return sb.toString();
    }
}
