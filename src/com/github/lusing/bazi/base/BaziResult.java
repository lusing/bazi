package com.github.lusing.bazi.base;

/**
 *
 * @author Louis
 */
public class BaziResult {
    public static final int WANG = 0;
    public static final int RUO = 1;
    public static final int UNKNOWN = -1;
    String method;
    int status;
    
    public BaziResult(int wangStatus, String method){
        status = wangStatus;
        this.method = method;
    }
    
    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("日主旺衰情况为：");
        switch(status){
            case WANG:
                sb.append("旺\n");
                break;
            case RUO:
                sb.append("弱\n");
                break;
            default:
                sb.append("未知\n");
                break;
        }
        sb.append("使用的方法是"+method);
        return sb.toString();
    }
}
