package luozhuanghehun;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 根据西元的生日时辰获取某个人的生辰八字，以及农历生日
 *@author kongqz 
 * */
public class BaZi {
	private int year;
	private int month;
	private int day;
	private boolean leap;
	Date baseDate = null;
	public int bazi[] = null;
    final static String chineseNumber[] = {"正", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "腊"};
   public final static String[] Gan = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
   public final static String[] Zhi = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};
    static SimpleDateFormat chineseDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    final static long[] lunarInfo = new long[]{0x04bd8, 0x04ae0, 0x0a570, 0x054d5, 0x0d260, 0x0d950, 0x16554, 0x056a0, 0x09ad0, 0x055d2,
        0x04ae0, 0x0a5b6, 0x0a4d0, 0x0d250, 0x1d255, 0x0b540, 0x0d6a0, 0x0ada2, 0x095b0, 0x14977,
        0x04970, 0x0a4b0, 0x0b4b5, 0x06a50, 0x06d40, 0x1ab54, 0x02b60, 0x09570, 0x052f2, 0x04970,
        0x06566, 0x0d4a0, 0x0ea50, 0x06e95, 0x05ad0, 0x02b60, 0x186e3, 0x092e0, 0x1c8d7, 0x0c950,
        0x0d4a0, 0x1d8a6, 0x0b550, 0x056a0, 0x1a5b4, 0x025d0, 0x092d0, 0x0d2b2, 0x0a950, 0x0b557,
        0x06ca0, 0x0b550, 0x15355, 0x04da0, 0x0a5d0, 0x14573, 0x052d0, 0x0a9a8, 0x0e950, 0x06aa0,
        0x0aea6, 0x0ab50, 0x04b60, 0x0aae4, 0x0a570, 0x05260, 0x0f263, 0x0d950, 0x05b57, 0x056a0,
        0x096d0, 0x04dd5, 0x04ad0, 0x0a4d0, 0x0d4d4, 0x0d250, 0x0d558, 0x0b540, 0x0b5a0, 0x195a6,
        0x095b0, 0x049b0, 0x0a974, 0x0a4b0, 0x0b27a, 0x06a50, 0x06d40, 0x0af46, 0x0ab60, 0x09570,
        0x04af5, 0x04970, 0x064b0, 0x074a3, 0x0ea50, 0x06b58, 0x055c0, 0x0ab60, 0x096d5, 0x092e0,
        0x0c960, 0x0d954, 0x0d4a0, 0x0da50, 0x07552, 0x056a0, 0x0abb7, 0x025d0, 0x092d0, 0x0cab5,
        0x0a950, 0x0b4a0, 0x0baa4, 0x0ad50, 0x055d9, 0x04ba0, 0x0a5b0, 0x15176, 0x052b0, 0x0a930,
        0x07954, 0x06aa0, 0x0ad50, 0x05b52, 0x04b60, 0x0a6e6, 0x0a4e0, 0x0d260, 0x0ea65, 0x0d530,
        0x05aa0, 0x076a3, 0x096d0, 0x04bd7, 0x04ad0, 0x0a4d0, 0x1d0b6, 0x0d250, 0x0d520, 0x0dd45,
        0x0b5a0, 0x056d0, 0x055b2, 0x049b0, 0x0a577, 0x0a4b0, 0x0aa50, 0x1b255, 0x06d20, 0x0ada0
    };
    
	/**
	 * @return the month
	 */
	public String getMonth() {
		return chineseNumber[month - 1];
	}

    /**
     * @return the year
     */
    public String getYear() {
        return getYearStr(year);
    }
    
     /**
     * @return the year
     */
    public int getnumberYear() {
        return year;
    }
    
       /**
     * @return the year
     */
    public int getnumbermonth() {
        return month;
    }
        /**
     * @return the year 返回年的顺序，子0 丑2
     */
    public int getYearindex() {
          return (year - 4) % 12;
    }

    /**
     * @return the day
     */
    public String getDay() {
        return getChinaDayString(day);
    }
    /**
     * 六十甲子
     */
    public static final String[] jiazhi = {
        "甲子", "乙丑", "丙寅", "丁卯", "戊辰", "己巳", "庚午", "辛未", "壬申", "癸酉",
        "甲戌", "乙亥", "丙子", "丁丑", "戊寅", "己卯", "庚辰", "辛巳", "壬午", "癸未",
        "甲申", "乙酉", "丙戌", "丁亥", "戊子", "己丑", "庚寅", "辛卯", "壬辰", "癸巳",
        "甲午", "乙未", "丙申", "丁酉", "戊戌", "己亥", "庚子", "辛丑", "壬寅", "癸卯",
        "甲辰", "乙巳", "丙午", "丁未", "戊申", "己酉", "庚戌", "辛亥", "壬子", "癸丑",
        "甲寅", "乙卯", "丙辰", "丁巳", "戊午", "己未", "庚申", "辛酉", "壬戌", "癸亥"
    };
    private Calendar cal;
    /**
     * @param hour 这里的时间范围是1-12，具体几点到几点是子时、丑时请参考相关文档
     * 具体的选择如下 "子：1", "丑：2", "寅：3", "卯：4", "辰：5", "巳：6", "午：7", "未：8", "申：9", "酉：10", "戌：11", "亥：12" 
     * @author kongqz
     * */
    public String getYearGanZhi(int hour) {
    	if(bazi==null){
    		bazi = new int[8];
    	}
        //1864年是甲子年，每隔六十年一个甲子
        int idx = (year - 1864) % 60;
        //没有过春节的话那么年还算上一年的，此处求的年份的干支
        String y = jiazhi[idx];
        
        //Xulun
        bazi[0] = idx % 10;
        bazi[1] = idx % 12;
        
        String m="";
        String d="";
        String h="";
        idx = idx % 5;
        int idxm=0;
        /**
         * 年上起月
         * 甲己之年丙作首，乙庚之岁戊为头，
         * 丙辛必定寻庚起，丁壬壬位顺行流，
         * 更有戊癸何方觅，甲寅之上好追求。
         */
        idxm=(idx+1)*2;
        if(idxm==10) idxm=0;
        //求的月份的干支
        m=Gan[(idxm+month-1)%10]+Zhi[(month+2-1)%12];
        
        //Xulun
        bazi[2]=(idxm+month-1)%10;
        bazi[3]=(month+2-1)%12;
        
        /*求出和1900年1月31日甲辰日相差的天数 
         * 甲辰日是第四十天
        */
        int offset = (int) ((cal.getTime().getTime() - baseDate.getTime()) / 86400000L);
        offset=(offset+40)%60;
        //求的日的干支
        d=jiazhi[offset];
        
        //Xulun
        bazi[4]= offset%10;
        bazi[5]= offset%12;
        
        /**
         * 日上起时
         * 甲己还生甲，乙庚丙作初，
         * 丙辛从戊起，丁壬庚子居，
         * 戊癸何方发，壬子是真途。  
         */ 
        
        offset=(offset % 5 )*2;
        //求得时辰的干支   
        h=Gan[(offset+hour)%10]+Zhi[hour];
        
        //Xulun 
        bazi[6]=(offset+hour)%10;
        bazi[7]=hour;
        
        //在此处输出我们的年月日时的天干地支
        //return y+","+m+","+d+","+h;
        return y+m+d+h;
    }
    public String getShichenFromDay(int offset){
       
        return null;
    }
//====== 传回农历 y年的总天数
    final private static int yearDays(int y) {
        int i,  sum = 348;
        for (i = 0x8000; i > 0x8; i >>= 1) {
            if ((lunarInfo[y - 1900] & i) != 0) {
                sum += 1;
            }
        }
        return (sum + leapDays(y));
    }
//====== 传回农历 y年闰月的天数
    final private static int leapDays(int y) {
        if (leapMonth(y) != 0) {
            if ((lunarInfo[y - 1900] & 0x10000) != 0) {
                return 30;
            } else {
                return 29;
            }
        } else {
            return 0;
        }
    }
//====== 传回农历 y年闰哪个月 1-12 , 没闰传回 0
    final private static int leapMonth(int y) {
        return (int) (lunarInfo[y - 1900] & 0xf);
    }
//====== 传回农历 y年m月的总天数
    final private static int monthDays(int y, int m) {
        if ((lunarInfo[y - 1900] & (0x10000 >> m)) == 0) {
            return 29;
        } else {
            return 30;
        }
    }
/*** 
 * @return 传回农历 y年的生肖
 */
    final public String animalsYear() {
        final String[] Animals = new String[]{"鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪"};
        return Animals[(year - 4) % 12];
    }
//====== 传入 月日的offset 传回干支, 0=甲子
    final private static String cyclicalm(int num) {
        return (Gan[num % 10] + Zhi[num % 12]);
    }
//====== 传入 offset 传回干支, 0=甲子
    final public String cyclical() {
        int num = year - 1900 + 36;
        return (cyclicalm(num));
    }
    /**
     * 传出y年m月d日对应的农历.
     * yearCyl3:农历年与1864的相差数 ?
     * monCyl4:从1900年1月31日以来,闰月数
     * dayCyl5:与1900年1月31日相差的天数,再加40 ?
     *
     * @param cal
     * @return
     */
    public BaZi(Calendar cal) {
        this.cal=cal;
        int yearCyl,  monCyl,  dayCyl;
        int leapMonth = 0;
        
        try {
            baseDate = chineseDateFormat.parse("1900-1-31");
        } catch (ParseException e) {
            e.printStackTrace(); //To change body of catch statement use Options | File Templates.
        }
//求出和1900年1月31日相差的天数
        int offset = (int) ((cal.getTime().getTime() - baseDate.getTime()) / 86400000L);
        dayCyl = offset + 40;
        monCyl = 14;
//用offset减去每农历年的天数
// 计算当天是农历第几天
//i最终结果是农历的年份
//offset是当年的第几天
        int iYear,  daysOfYear = 0;
        for (iYear = 1900; iYear < 2050 && offset > 0; iYear++) {
            daysOfYear = yearDays(iYear);
            offset -= daysOfYear;
            monCyl += 12;
        }
        if (offset < 0) {
            offset += daysOfYear;
            iYear--;
            monCyl -= 12;
        }
//农历年份
        year = iYear;
        yearCyl = iYear - 1864;
        leapMonth = leapMonth(iYear); //闰哪个月,1-12
        leap = false;
//用当年的天数offset,逐个减去每月（农历）的天数，求出当天是本月的第几天
        int iMonth,  daysOfMonth = 0;
        for (iMonth = 1; iMonth < 13 && offset > 0; iMonth++) {
//闰月
            if (leapMonth > 0 && iMonth == (leapMonth + 1) && !leap) {
                --iMonth;
                leap = true;
                daysOfMonth = leapDays(year);
            } else {
                daysOfMonth = monthDays(year, iMonth);
            }
            offset -= daysOfMonth;
//解除闰月
            if (leap && iMonth == (leapMonth + 1)) {
                leap = false;
            }
            if (!leap) {
                monCyl++;
            }
        }
//offset为0时，并且刚才计算的月份是闰月，要校正
        if (offset == 0 && leapMonth > 0 && iMonth == leapMonth + 1) {
            if (leap) {
                leap = false;
            } else {
                leap = true;
                --iMonth;
                --monCyl;
            }
        }
//offset小于0时，也要校正
        if (offset < 0) {
            offset += daysOfMonth;
            --iMonth;
            --monCyl;
        }
        month = iMonth;
        day = offset + 1;
    }
    public static String getChinaDayString(int day) {
        String chineseTen[] = {"初", "十", "廿", "卅"};
        int n = day % 10 == 0 ? 9 : day % 10 - 1;
        if (day > 30) {
            return "";
        }
        if (day == 10) {
            return "初十";
        } else {
            return chineseTen[day / 10] + chineseNumber[n];
        }
    }
    public String toString() {
        return getYearStr(year) + "年" + (leap ? "闰" : "") + chineseNumber[month - 1] + "月" + getChinaDayString(day);
    }
    
    public String getYearStr(int year) {
        String[] chineseword = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        String ys = "";
        int index = year / 1000;
        ys += chineseword[index];
        year = year % 1000;
        index = year / 100;
        ys += chineseword[index];
        year = year % 100;
        index = year / 10;
        ys += chineseword[index];
        year = year % 10;
        index = year;
        ys += chineseword[index];
        return ys;
    }
    public static String getSixtyDay() {
        String temp = "";
        for (int i = 0; i < 60; i++) {
            temp += ",/" + cyclicalm(i) + "/";
        }
        return temp;
    }
    
    /**
     * 针对一个在西元 1983-01-10 中午12：30生的人的计算。
     * 这里12点半在中国的古代历书中算是午时
     * 子时24.00－2.00,丑时2.00－4.00,寅时4.00－6.00,卯时6.00－8.00,
     * 辰时8.00－10.00,巳时10.00－12.00,午时12.00－14.00,未时14.00－16.00
     * 申时16.00－18.00,酉时18.00－20.00,戌时20.00－22.00,亥时22.00－24.00
     * */
    public static void main(String[] args){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        try {
                //设定此人的西元时间为1983-01-10
                cal.setTime(sdf.parse("1980-06-18"));
                BaZi lunar = new BaZi(cal);
                System.out.println("此人农历的日期【"+lunar.toString()+"】");
                //此处是为了获取时间在中国的八字学说上的显示，此人是午时生的
                System.out.println("此人八字【"+lunar.getYearGanZhi(5)+"】");
                //获取生肖
                System.out.println("此人的农历生肖【"+lunar.animalsYear()+"】");
                
                Luozhuanghehun.main2(args);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
