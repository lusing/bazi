package com.github.lusing.bazi.base;

/**
 * 天干代表所见到的表面，外性格。性格、行为举止、容颜、六亲状况、有钱、凶灾。
 * <p/>
 * 地支代表内心，内环境。善恶、忠奸、心中想法。
 * 
 * @author Louis
 */

public class BaZiEngine {
	public static final int YEAR = 0;
	public static final int MONTH = 1;
	public static final int DAY = 2;
	public static final int HOUR = 3;

	int year_tg;
	int year_dz;
	int month_tg;
	int month_dz;
	int day_tg;
	int day_dz;
	int hour_tg;
	int hour_dz;
	TianGan[] tgs;
	DiZhi[] dzs;

	public BaZiEngine(int y1, int y2, int m1, int m2, int d1, int d2, int h1,
			int h2) {
		this.year_tg = y1;
		this.year_dz = y2;
		this.month_tg = m1;
		this.month_dz = m2;
		this.day_tg = d1;
		this.day_dz = d2;
		this.hour_tg = h1;
		this.hour_dz = h2;

		tgs = new TianGan[4];
		dzs = new DiZhi[4];

		tgs[0] = new TianGan(y1);
		tgs[1] = new TianGan(m1);
		tgs[2] = new TianGan(d1);
		tgs[3] = new TianGan(h1);

		dzs[0] = new DiZhi(y2);
		dzs[1] = new DiZhi(m2);
		dzs[2] = new DiZhi(d2);
		dzs[3] = new DiZhi(h2);

	}

	public void run() {
		checkLiuQin();
		checkWuXing();
	}

	private void checkLiuQin() {
		System.out.println("日主：" + tgs[2]);
		System.out.println(tgs[0] + " "
				+ ShiShen.getShiShen(tgs[2], tgs[0]).toString());
		System.out.println(tgs[1] + " "
				+ ShiShen.getShiShen(tgs[2], tgs[1]).toString());
		System.out.println(tgs[3] + " "
				+ ShiShen.getShiShen(tgs[2], tgs[3]).toString());
	}

	private void checkWuXing() {
		for (int i = 0; i < tgs.length; i++) {
			System.out.print(tgs[i].getXing().toString() + dzs[i].getXing()
					+ "\t");
		}
		System.out.println();

		System.out.println(checkWangShuai());
	}

	/**
	 * 检查日主的旺衰
	 */
	private BaziResult checkWangShuai() {
		return checkGenYinXiangFu();
	}

	/**
	 * 根印帮扶法
	 */
	private BaziResult checkGenYinXiangFu() {
		boolean isWang = false;
		// 1.2.日主在月令得根或印一次便是有旺的可能，再得年支或日支根一次便以旺论, 不必再看天干。
		int gen = tgs[DAY].getXing().getXing();

        //图5，地支中印星同时出现两个，不论在任何位置皆以弱论
        int yins = 0;
        for(int i=YEAR;i<=HOUR;i++){
            if(isYin(dzs[i])){
                yins++;
            }
        }
        
		// 5. 印星临年月以弱论。即使天干印比一片也弱。地支中印星同时出现两个，不论在何位置均以弱论。
        if(yins==2){
            return new BaziResult(BaziResult.RUO, "图5");
        }
        if(yins>=3){
            return new BaziResult(BaziResult.WANG, "图6");
        }
        
     //11.年支和日支同时得根印，只有两种组合为旺
        BaziResult brTemp = method_11(YEAR,DAY);
        if(brTemp.status!=BaziResult.UNKNOWN){
            return brTemp;
        }
        
        //12.根印在月时和年时时，以此类推
        /* 月时交与图13解决
          brTemp = method_11(MONTH,HOUR);
        if(brTemp.status!=BaziResult.UNKNOWN){
            return brTemp;
        }*/
        
        brTemp = method_11(YEAR,HOUR);
        if(brTemp.status!=BaziResult.UNKNOWN){
            return brTemp;
        }
        
        //13.月支与时支得根印，也以弱论。
        //除非月干与时干临印比，或月干，时干与日干合化后是印比
        brTemp = method_13(MONTH,HOUR);
        if(brTemp.status!=BaziResult.UNKNOWN){
            return brTemp;
        }
                
        //图1,2 根印帮扶
		if (isGenYin(dzs[MONTH])) {
			if (isGenYin(dzs[YEAR]) || isGenYin(dzs[DAY]))
				return new BaziResult(BaziResult.WANG, "图1~2");
		}

		if (isGenYin(dzs[DAY])) {
			if(isGenYin(dzs[HOUR])){
				if(isAllBiOrYin()){
                    // 4. 如果天干全是印比则以身旺论。
					return new BaziResult(BaziResult.WANG, "图4");
				}
				else{
                    // 3.日主根印临日时支以身弱论命。
					return new BaziResult(BaziResult.RUO, "图3");
				}
			}
		}
		
		//8.年支或时支临印星以身弱论
		if(isYin(dzs[YEAR]) || isYin(dzs[HOUR])){
			return new BaziResult(BaziResult.RUO, "图8");
		}
        
        //9.根在年支或时支出现一个以身弱论
        //根的本气如透出，则不从弱
		if(isGen(dzs[YEAR]) || isGen(dzs[HOUR])){
            if(isGen(dzs[YEAR])){
                if(isGen(dzs[YEAR].getBenQin())){
                    return new BaziResult(BaziResult.WANG, "图9-3,本气透出");
                }
                else{
                    return new BaziResult(BaziResult.RUO, "图9");
                }
            }else if(isGen(dzs[HOUR])){
                if(isGen(dzs[HOUR].getBenQin())){
                    return new BaziResult(BaziResult.WANG, "图9-3");
                }
                else{
                    return new BaziResult(BaziResult.RUO, "图9");
                }
            }
		}
        
        //10. 印星在月日地支中一次出现，一次被克从弱。本气秀出假从。两次被克从弱，即使本气透出也从弱。
        int kes_m = 0;
        if(dzs[YEAR].isKe(dzs[MONTH])){
            kes_m++;
        }
        if(dzs[DAY].isKe(dzs[MONTH])){
            kes_m++;
        }

        int kes_d = 0;
        if(dzs[MONTH].isKe(dzs[DAY])){
            kes_d++;
        }
        if(dzs[HOUR].isKe(dzs[DAY])){
            kes_d++;
        }

        if(isYin(dzs[MONTH])){
            if(isGen(dzs[MONTH].getBenQin()) && kes_m==1){
                return new BaziResult(BaziResult.WANG, "图10-月支被克一次，假从弱");
            }else{
                return new BaziResult(BaziResult.RUO, "图10-月支被克"+kes_m+"次");
            }            
        }else if(isYin(dzs[DAY])){
                     if(isGen(dzs[DAY].getBenQin()) && kes_m==1){
                return new BaziResult(BaziResult.WANG, "图10-日支被克一次，假从弱");
            }else{
                return new BaziResult(BaziResult.RUO, "图10-日支被克"+kes_m+"次");
            }    
        }

		return new BaziResult(BaziResult.UNKNOWN, "暂时还处理不了");
	}

	private boolean isGen(DiZhi dz) {
		return dz.getXing().getXing() == tgs[DAY].getXing().getXing();
	}

	private boolean isYin(DiZhi dz) {
		return dz.getXing().isSheng(tgs[DAY].getXing());
	}
	
	private boolean isGenYin(DiZhi dz){
		return isGen(dz) || isYin(dz);
	}
	
	private boolean isBi(TianGan tg){
		return tgs[DAY].getXing().getXing() == tg.getXing().getXing();
	}
    
    private boolean isGen(TianGan tg){
        return tgs[DAY].getTianGan() == tg.getTianGan();
    }
	
	private boolean isYin(TianGan tg){
		return tg.isSheng(tgs[DAY]);
	}
    
    private boolean isGen(WuXing xing){
        if(xing==null){
            return false;
        }else{
            return tgs[DAY].getXing().getXing() == xing.getXing();
        }
    }
    
    private boolean isYin(WuXing xing){
        if(xing==null)
            return false;
        else
            return xing.isSheng(tgs[DAY].getXing());
    }
    
    private boolean isGenYin(WuXing xing){
        return isGen(xing) || isYin(xing);
    }
    
    private boolean isYinBi(TianGan tg){
        return isYin(tg) || isBi(tg);
    }
    
    private boolean isWuHe(TianGan tg1, TianGan tg2){
         return isGenYin(tg1.isHe(tg2));
    }
	
	private boolean isAllBiOrYin(){
		boolean result = true;
		for(int i=YEAR;i<=HOUR;i++){
			result = result && (isYin(tgs[i]) || isBi(tgs[i]));
		}
		return result;
	}
    
    /**
     * 11.年支和日支同时得根印，只有两种组合为旺
     * 12.根印在月时和年时时，以此类推
     * @param dz1
     * @param dz2
     * @return 
     */
    private BaziResult method_11(int c1, int c2){
        if(isGenYin(dzs[c1])&&isGenYin(dzs[c2])){
            //年干与月干为印比
            if(isYinBi(tgs[YEAR])&&isYinBi(tgs[MONTH])){
                return new BaziResult(BaziResult.WANG, "图11-年干与月干为印比");
            }else if(isWuHe(tgs[YEAR],tgs[MONTH])){
                return new BaziResult(BaziResult.WANG, "图11-年干与月干得天干五合，合化后为印比");
            }else{
                return new BaziResult(BaziResult.RUO, "图11-年支和日支同时得根印,弱");
            }
        }else{
            return new BaziResult(BaziResult.UNKNOWN,"");
        }
    }
    
    private BaziResult method_13(int c1, int c2){
        if(isGenYin(dzs[c1])&&isGenYin(dzs[c2])){
            
            if(isYinBi(tgs[MONTH])&&isYinBi(tgs[HOUR])){
                return new BaziResult(BaziResult.WANG, "图13-月干与时干为印比");
            }else if(isWuHe(tgs[MONTH],tgs[DAY])){
                return new BaziResult(BaziResult.WANG, "图13-月干与日干得天干五合，合化后为印比");
            }else if(isWuHe(tgs[DAY],tgs[HOUR])){
                return new BaziResult(BaziResult.WANG, "图13-日干与时干得天干五合，合化后为印比");
            }else if(isWuHe(tgs[MONTH],tgs[HOUR])){
                return new BaziResult(BaziResult.WANG, "图13-月干与时干得天干五合，合化后为印比");
            }else{
                return new BaziResult(BaziResult.RUO, "图13-月支和时支同时得根印,弱");
            }
        }else{
            return new BaziResult(BaziResult.UNKNOWN,"");
        }
    }

}
