package com.github.lusing.bazi.base;

/**
 *
 * @author Louis
 */
public class BaziResult {
    /**
     * 旺
     */
    public static final int WANG = 0;
    /**
     * 弱
     */
    public static final int RUO = 1;
    /**
     * 从强格
     */
    public static final int CONG_QIANG = 0x10;
    /**
     * 从弱格
     */
    public static final int CONG_RUO = 0x11;
    /**
     * 假从格
     */
    public static final int JIA_CONG = 0x12;
    
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
            case CONG_QIANG:
                sb.append("从强\n");
                break;
            case CONG_RUO:
                sb.append("从弱\n");
                break;
            case JIA_CONG:
                sb.append("假从\n");
            default:
                sb.append("未知\n");
                break;
        }
        sb.append("使用的方法是"+method);
        return sb.toString();
    }
}
