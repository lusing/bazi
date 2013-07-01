
package luozhuanghehun;

/**
 * ±¾ÃüØÔºÏ»é
 * 
 * @author luozhuang ´óÊ¦¡áÂŞÇf
 * modified by liuziying
 */
public class Luozhuanghehun {

    enum sex {

        man, woman;
    }

    enum basicstring {

        ¿², À¤, Õğ, Ùã, Ç¬, ¶Ò, ôŞ, Àë;
    }

    public String hehun(String man, String woman) {
        if (man.length() != 4 || woman.length() != 4) {
            return "ÊäÈë²»ÕıÈ·";
        }

        return peihun(getnumber(man, sex.man), getnumber(woman, sex.woman));

    }

    public String peihun(String man, String woman) {
        return peihun(getnumber(man, sex.man), getnumber(woman, sex.woman));
    }

    private String peihun(int man, int woman) {
        basicstring mang = basicsnumber(man, sex.man);
        basicstring womang = basicsnumber(woman, sex.woman);

        // Ç¬ÃüÄĞÅäôŞÃüÅ® £¬ôŞÃüÄĞÅäÇ¬ÃüÅ®£»
        if (mang == basicstring.Ç¬ && womang == basicstring.ôŞ) {
            return "ÑÓÄê»é";
        }

        if (womang == basicstring.Ç¬ && mang == basicstring.ôŞ) {
            return "ÑÓÄê»é";
        }

        // ÕğÃüÄĞÅä¿²ÃüÅ®£¬¿²ÃüÄĞÅäÕğÃüÅ®£»
        if (mang == basicstring.Õğ && womang == basicstring.¿²) {
            return "ÑÓÄê»é";
        }
        if (womang == basicstring.Õğ && mang == basicstring.¿²) {
            return "ÑÓÄê»é";
        }

        // ¶ÒÃüÄĞÅäÀ¤ÃüÅ®£¬À¤ÃüÄĞÅä¶ÒÃüÅ®£»
        if (mang == basicstring.¶Ò && womang == basicstring.À¤) {
            return "ÑÓÄê»é";
        }
        if (womang == basicstring.¶Ò && mang == basicstring.À¤) {
            return "ÑÓÄê»é";
        }

        // ÙãÃüÄĞÅäÀëÃüÅ®£¬ÀëÃüÄĞÅäÙãÃüÅ®£»
        if (mang == basicstring.Ùã && womang == basicstring.Àë) {
            return "ÑÓÄê»é";
        }
        if (womang == basicstring.Ùã && mang == basicstring.Àë) {
            return "ÑÓÄê»é";
        }

        // ¿²ÃüÄĞÅäÙãÃüÅ®£¬ÙãÃüÄĞÅä¿²ÃüÅ®£»
        if (mang == basicstring.¿² && womang == basicstring.Ùã) {
            return "ÉúÆø»é";
        }
        if (womang == basicstring.¿² && mang == basicstring.Ùã) {
            return "ÉúÆø»é";
        }

        // ÕğÃüÄĞÅäÀëÃüÅ®£¬ÀëÃüÅ®ÅäÕğÃüÄĞ£»
        if (mang == basicstring.Õğ && womang == basicstring.Àë) {
            return "ÉúÆø»é";
        }
        if (womang == basicstring.Õğ && mang == basicstring.Àë) {
            return "ÉúÆø»é";
        }

        // Ç¬ÃüÄĞÅä¶ÒÃüÅ®£¬¶ÒÃüÄĞÅäÇ¬ÃüÅ®£»
        if (mang == basicstring.Ç¬ && womang == basicstring.¶Ò) {
            return "ÉúÆø»é";
        }
        if (womang == basicstring.Ç¬ && mang == basicstring.¶Ò) {
            return "ÉúÆø»é";
        }

        // ôŞÃüÄĞÅäÀ¤ÃüÅ®£¬À¤ÃüÄĞÅäôŞÃüÅ®¡£
        if (mang == basicstring.ôŞ && womang == basicstring.À¤) {
            return "ÉúÆø»é";
        }
        if (womang == basicstring.ôŞ && mang == basicstring.À¤) {
            return "ÉúÆø»é";
        }

        // ¿²ÃüÄĞÅäôŞÃüÅ®£¬ôŞÃüÄĞÅä¿²ÃüÅ®£»
        if (mang == basicstring.ôŞ && womang == basicstring.¿²) {
            return "ÌìÒ½»é";
        }
        if (womang == basicstring.ôŞ && mang == basicstring.¿²) {
            return "ÌìÒ½»é";
        }

        // À¤ÃüÄĞÅäÙãÃüÅ®£¬ÙãÃüÄĞÅäÀ¤ÃüÅ®£»
        if (mang == basicstring.À¤ && womang == basicstring.Ùã) {
            return "ÌìÒ½»é";
        }
        if (womang == basicstring.À¤ && mang == basicstring.Ùã) {
            return "ÌìÒ½»é";
        }

        // ÕğÃüÄĞÅäÇ¬ÃüÅ®£¬Ç¬ÃüÄĞÅäÕğÃüÅ®£»
        if (mang == basicstring.Õğ && womang == basicstring.Ç¬) {
            return "ÌìÒ½»é";
        }
        if (womang == basicstring.Õğ && mang == basicstring.Ç¬) {
            return "ÌìÒ½»é";
        }

        // ¶ÒÃüÄĞÅäÀëÃüÅ®£¬ÀëÃüÄĞÅä¶ÒÃüÅ®¡£
        if (mang == basicstring.¶Ò && womang == basicstring.Àë) {
            return "ÌìÒ½»é";
        }
        if (womang == basicstring.¶Ò && mang == basicstring.Àë) {
            return "ÌìÒ½»é";
        }

        // ¿²ÃüÄĞÅäÇ¬ÃüÅ®£¬Ç¬ÃüÄĞÅä¿²ÃüÅ®£»
        if (mang == basicstring.¿² && womang == basicstring.Ç¬) {
            return "ÁùÉ·»é";
        }
        if (womang == basicstring.¿² && mang == basicstring.Ç¬) {
            return "ÁùÉ·»é";
        }

        // ÕğÃüÄĞÅäôŞÃüÅ®£¬ôŞÃüÄĞÅäÕğÃüÅ®£»
        if (mang == basicstring.Õğ && womang == basicstring.ôŞ) {
            return "ÁùÉ·»é";
        }
        if (womang == basicstring.Õğ && mang == basicstring.ôŞ) {
            return "ÁùÉ·»é";
        }

        // ¶ÒÃüÄĞÅäÙãÃüÅ®£¬ÙãÃüÄĞÅä¶ÒÃüÅ®£»
        if (mang == basicstring.¶Ò && womang == basicstring.Ùã) {
            return "ÁùÉ·»é";
        }
        if (womang == basicstring.¶Ò && mang == basicstring.Ùã) {
            return "ÁùÉ·»é";
        }

        // ÀëÃüÄĞÅäÀ¤ÃüÅ®£¬À¤ÃüÄĞÅäÀëÃüÅ®¡£
        if (mang == basicstring.Àë && womang == basicstring.À¤) {
            return "ÁùÉ·»é";
        }
        if (womang == basicstring.Àë && mang == basicstring.À¤) {
            return "ÁùÉ·»é";
        }

        // ¿²ÃüÄĞÅäÀëÃüÅ®£¬ÀëÃüÄĞÅä¿²ÃüÅ®£»
        if (mang == basicstring.¿² && womang == basicstring.Àë) {
            return "»öº¦»é";
        }
        if (womang == basicstring.¿² && mang == basicstring.Àë) {
            return "»öº¦»é";
        }

        // ÙãÃüÄĞÅäÕğÃüÅ®£¬ÕğÃüÄĞÅäÙãÃüÅ®£»
        if (mang == basicstring.Ùã && womang == basicstring.Õğ) {
            return "»öº¦»é";
        }
        if (womang == basicstring.Ùã && mang == basicstring.Õğ) {
            return "»öº¦»é";
        }

        // Ç¬ÃüÄĞÅäÀ¤ÃüÅ®£¬À¤ÃüÄĞÅäÇ¬ÃüÅ®£»
        if (mang == basicstring.Ç¬ && womang == basicstring.À¤) {
            return "»öº¦»é";
        }
        if (womang == basicstring.Ç¬ && mang == basicstring.À¤) {
            return "»öº¦»é";
        }

        // ¶ÒÃüÄĞÅäÙãÃüÅ®£¬ÙãÃüÄĞÅä¶ÒÃüÅ®£»
        if (mang == basicstring.¶Ò && womang == basicstring.Ùã) {
            return "»öº¦»é";
        }
        if (womang == basicstring.¶Ò && mang == basicstring.Ùã) {
            return "»öº¦»é";
        }

        // ¿²ÃüÄĞÅä¿²ÃüÅ®£¬Ç¬ÃüÄĞÅäÇ¬ÃüÅ®£»
        //
        // À¤ÃüÄĞÅäÀ¤ÃüÅ®£¬¶ÒÃüÄĞÅä¶ÒÃüÅ®£»
        //
        // ÕğÃüÄĞÅäÕğÃüÅ®£¬ôŞÃüÄĞÅäôŞÃüÅ®£»
        //
        // ÙãÃüÄĞÅäÙãÃüÅ®£¬ÀëÃüÄĞÅäÀëÃüÅ®¡£

        if (mang == womang) {
            return "·üÎ»»é";
        }

        // ¿²ÃüÄĞÅä¶ÒÃüÅ®£¬¶ÒÃüÄĞÅä¿²ÃüÅ®£»
        if (mang == basicstring.¿² && womang == basicstring.¶Ò) {
            return "Îå¹í»é";
        }
        if (womang == basicstring.¿² && mang == basicstring.¶Ò) {
            return "Îå¹í»é";
        }

        // ÕğÃüÄĞÅäÀ¤ÃüÅ®£¬À¤ÃüÄĞÅäÕğÃüÅ®£»
        if (mang == basicstring.Õğ && womang == basicstring.À¤) {
            return "Îå¹í»é";
        }
        if (womang == basicstring.Õğ && mang == basicstring.À¤) {
            return "Îå¹í»é";
        }

        // ÀëÃüÄĞÅäôŞÃüÅ®£¬ôŞÃüÄĞÅäÀëÃüÅ®£»
        if (mang == basicstring.Àë && womang == basicstring.ôŞ) {
            return "Îå¹í»é";
        }
        if (womang == basicstring.Àë && mang == basicstring.ôŞ) {
            return "Îå¹í»é";
        }

        // Ç¬ÃüÄĞÅäÙãÃüÅ®£¬ÙãÃüÄĞÅäÇ¬ÃüÅ®¡££»
        if (mang == basicstring.Ç¬ && womang == basicstring.Ùã) {
            return "Îå¹í»é";
        }
        if (womang == basicstring.Ç¬ && mang == basicstring.Ùã) {
            return "Îå¹í»é";
        }

        // ¿²ÃüÄĞÅäÀ¤ÃüÅ®£¬À¤ÃüÄĞÅä¿²ÃüÅ®£»
        if (mang == basicstring.¿² && womang == basicstring.À¤) {
            return "¾øÃü»é";
        }
        if (womang == basicstring.¿² && mang == basicstring.À¤) {
            return "¾øÃü»é";
        }

        // ÕğÃüÄĞÅä¶ÒÃüÅ®£¬¶ÒÃüÄĞÅäÕğÃüÅ®£»
        if (mang == basicstring.Õğ && womang == basicstring.¶Ò) {
            return "¾øÃü»é";
        }
        if (womang == basicstring.Õğ && mang == basicstring.¶Ò) {
            return "¾øÃü»é";
        }

        // ÙãÃüÄĞÅäôŞÃüÅ®£¬ôŞÃüÄĞÅäÙãÃüÅ®£»
        if (mang == basicstring.Ùã && womang == basicstring.ôŞ) {
            return "¾øÃü»é";
        }
        if (womang == basicstring.Ùã && mang == basicstring.ôŞ) {
            return "¾øÃü»é";
        }

        // Ç¬ÃüÄĞÅäÀëÃüÅ®£¬ÀëÃüÄĞÅäÇ¬ÃüÅ®¡£
        if (mang == basicstring.Ç¬ && womang == basicstring.Àë) {
            return "¾øÃü»é";
        }
        if (womang == basicstring.Ç¬ && mang == basicstring.Àë) {
            return "¾øÃü»é";
        }
        return "ÊäÈë²»ÕıÈ·";

    }
    
    private String parseHun(String result){
        StringBuffer sb = new StringBuffer();
        
        if(result=="ÑÓÄê»é"){
            sb.append("ÑÓÄê»éÖ÷³¤ÊÙÓĞ¸££¬ÄĞÅ®ºÍĞ³£¬»ıµÂ»ıÇì£¬ÖÕÉú°²¿µ£¬ÉÏ¼ªÖ®Åä¡£");
        }else if(result=="ÉúÆø»é"){
            sb.append("ÉúÆø»éÖ÷¶à×Ó¶à¸££¬¶ùËïÂúÌÃ£¬×ÓĞ¢ËïÏÍ£¬ÓĞ¸£ÓĞÂ»£¬ÉÏ¼ªÖ®Åä¡£");
        }else if(result=="ÌìÒ½»é"){
            sb.append("ÌìÒ½»éÖ÷ÎŞÔÖÎŞ²¡£¬Ò»ÉúÆ½°²£¬¶ùÅ®ºÍÄÀ£¬ÎŞ¼éÎŞµÁ£¬ÉÏ¼ªÖ®Åä¡£");
        }else if(result=="ÁùÉ·»é"){
            sb.append("ÁùÉ·»éÖ÷»¯ÏÕÎªÒÄ£¬·òÆŞºÍË³£¬Ëä¸»²»´ï£¬·áÒÂ×ãÊ³¡£Ñ°³£Ö®Åä¡£");
        }else if(result=="»öº¦»é"){
            sb.append("»öº¦»éÖ÷ÓöÄÑ¿É½â£¬·êĞ×»¯¼ª£¬¿²¿ÀÀÍÂµ£¬¿É±£Ğ¡¿µ£¬Ñ°³£Ö®Åä¡£");
        }else if(result=="·üÎ»»é"){
            sb.append("·üÎ»»éÖ÷Ò»ÉúÆ½µ­£¬ÓĞ×ÓÓĞÅ®£¬ÍÅÔ²ºÍÆø£¬ÎŞ¾ªÎŞÏÕ£¬Ñ°³£Ö®Åä¡£");
        }else if(result=="Îå¹í»é"){
            sb.append("Îå¹í»éÖ÷¿ÚÉàÊÇ·Ç£¬Éú»î²»Äş£¬ÁÚÀï²»ºÍ£¬Ê±ÓĞ¹ÙË¾£¬´ÎĞ×Ö®Åä¡£");
        }else if(result=="¾øÃü»é"){
            sb.append("¾øÃü»éÖ÷Æ½Éú¿²¿À£¬ÉúÊÀ¼èĞÁ£¬¶«ÀëÎ÷×ß£¬¼ÒÔâĞ×»ö£¬´óĞ×Ö®Åä¡£");
        }
        
        return sb.toString();
    }

    /**
     * Êı×ÖÑ¡¹¬¹Ò
     * 
     * @param number Êı×Ö
     * @param isman ÄĞÈËÃ´
     * @return ÊôÓÚ¹¬¹Ò
     */
    public Luozhuanghehun.basicstring basicsnumber(int number, sex isman) {
        switch (number) {
            case 1:
                return basicstring.¿²;

            case 2:
                return basicstring.À¤;
            case 3:
                return basicstring.Õğ;
            case 4:
                return basicstring.Ùã;
            case 5:
                if (isman == sex.man) {
                    return basicstring.À¤;
                } else {
                    return basicstring.ôŞ;
                }
            case 6:
                return basicstring.Ç¬;
            case 7:
                return basicstring.¶Ò;
            case 8:
                return basicstring.ôŞ;
            case 9:
                return basicstring.Àë;

        }
        return null;
    }

    /**
     * ÄĞĞÔ£º11-³öÉúÄêºá¼Ó£¨Ò²ÎªÁ÷ÄêĞş¿Õ·ÉĞÇÈëÖĞ¹¬¼ÆËã¹«Ê½£© Å®ĞÔ£º4+³öÉúÄêºá¼Ó
     * 1989Äê³öÉúµÄÄĞĞÔ£º11-£¨1+9+8+9£©=11-£¨27£©=11-£¨2+7£©=2£¬¼´±¾ÃüØÔÎªÀ¤ØÔ
     * 
     * @param year ÊäÈëÄê·İ×Ö·û
     * @return ÖØÔØgetnumber
     */
    public int getnumber(String year, sex isman) throws NumberFormatException {

        int yearnumber = Short.parseShort(year);
        return getnumber(yearnumber, isman);

    }

    /**
     * ÄĞĞÔ£º11-³öÉúÄêºá¼Ó£¨Ò²ÎªÁ÷ÄêĞş¿Õ·ÉĞÇÈëÖĞ¹¬¼ÆËã¹«Ê½£© Å®ĞÔ£º4+³öÉúÄêºá¼Ó
     * 1989Äê³öÉúµÄÄĞĞÔ£º11-£¨1+9+8+9£©=11-£¨27£©=11-£¨2+7£©=2£¬¼´±¾ÃüØÔÎªÀ¤ØÔ
     * 
     * @param year ÊäÈëÄê·İÊı×Ö
     * @return ·µ»Ø½á¹û
     */
    public int getnumber(int year, sex isman) {

        int m = ((int) (year / 1000) % 10);
        int h = ((int) (year / 100) % 10);
        int s = ((int) (year / 10) % 10);
        int g = year % 10;
        int sum = m + h + g + s;
        int result;
        if (isman == sex.man) {
            result = 11 - ((int) (sum / 10) % 10) - (sum % 10);

        } else {
            result = 4 + ((int) (sum / 10) % 10) + (sum % 10);
        }
        if (result > 10) {
            result = result - 9;// Èç¹û³¬¹ı10£¬Ô­ÎÄÃ»ÓĞĞ´ÔõÃ´×ö£¬ÎÒ×Ô¼ºÍÆµÄ
        }
        return result;

    }

    /**
     * @param args the command line arguments
     */
    public static void main2(String[] args) {
        Luozhuanghehun my = new Luozhuanghehun();
        String result = my.hehun("1980", "1981");
        System.out.println(my.getnumber("1980", sex.man));
        System.out.println(my.basicsnumber(my.getnumber("1980", sex.man), sex.man));

        System.out.println(my.getnumber("1981", sex.woman));
        System.out.println(my.basicsnumber(my.getnumber("1981", sex.woman), sex.woman));
        System.out.println(result);
        System.out.println(my.parseHun(result));
    }
}
