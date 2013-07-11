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

	private int dz_gens = 0;
	private int dz_yins = 0;

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
		// 先算算根印各有多少个
		int yins = 0;
		int gens = 0;
		for (int i = YEAR; i <= HOUR; i++) {
			if (isYin(dzs[i])) {
				yins++;
			}
			if (isGen(dzs[i])) {
				gens++;
			}
		}
		System.out.println("本命共有根" + gens + "个，印" + yins + "个");
		/**
		 * 九. 印或根在命局地支中一次也不出现
		 */
		// 新23
		if (yins == 0 && gens == 0) {
			if (isAllBiOrYin()) {
				return new BaziResult(BaziResult.RUO, "新图23-扶抑格");
			} else {
				// TODO
				return new BaziResult(BaziResult.RUO, "新图23-从弱格");
			}
		}

		/**
		 * 八.印在命局地支四次出现
		 */
		// 新22
		if (yins == 4) {
			return new BaziResult(BaziResult.RUO, "新图22-从印格");
		}

		/**
		 * 七.根四次在地支出现或根印混杂在地支中出现4次
		 */
		// 新21
		if (gens + yins == 4) {
			return new BaziResult(BaziResult.WANG, "新图21-从强格");
		}

		/**
		 * 六.印三次在命局地支出现
		 */
		if (yins == 3) {
			// TODO:
			return new BaziResult(BaziResult.WANG, "图6");
		}

		/**
		 * 五.根三次或 根印三次在命局地支出现
		 */
		if (gens + yins == 3) {

		}

		// 新8. 印星临年月以弱论。即使天干印比一片也弱。地支中印星同时出现两个，不论在何位置均以弱论。
		if (yins == 2) {
			return new BaziResult(BaziResult.RUO, "新图8");
		}

		/**
		 * <b>一，根印或根根组合，两次在地支中出现</b>
		 */
		if (yins + gens == 2) {

			// 1.1 根印相邻，两次在地支中出现
			// 图1,2 根印帮扶
			// 1.2.日主在月令得根或印一次便是有旺的可能，再得年支或日支根一次便以旺论, 不必再看天干。
			// 新图1
			// 年和月支不能共同为印，否则为弱
			if (isGenYin(dzs[MONTH]) && isGenYin(dzs[YEAR])) {
				return new BaziResult(BaziResult.WANG, "新图1");
			}

			// 新图2
			if (isGenYin(dzs[MONTH]) && isGenYin(dzs[DAY])) {
				return new BaziResult(BaziResult.WANG, "新图2");
			}

			// 新图3，图4
			if (isGenYin(dzs[DAY]) && isGenYin(dzs[HOUR])) {
				if (isAllBiOrYin()) {
					// 4. 如果天干全是印比则以身旺论。
					return new BaziResult(BaziResult.WANG, "新图4");
				} else {
					// 3.日主根印临日时支以身弱论命。
					return new BaziResult(BaziResult.RUO, "新图3");
				}
			}
			// 新图5
			if (isGenYin(dzs[YEAR]) && isGenYin(dzs[DAY])) {
				// 年干与月干为印比
				if (isYinBi(tgs[YEAR]) && isYinBi(tgs[MONTH])) {
					return new BaziResult(BaziResult.WANG, "新图5-年干与月干为印比");
				} else if (isWuHe(tgs[YEAR], tgs[MONTH])) {
					return new BaziResult(BaziResult.WANG,
							"新图5-年干与月干得天干五合，合化后为印比");
				} else {
					return new BaziResult(BaziResult.RUO, "新图5-年支和日支同时得根印,弱");
				}
			}

			// 新图6
			if (isGenYin(dzs[MONTH]) && isGenYin(dzs[HOUR])) {
				// 年干与月干为印比
				if (isYinBi(tgs[MONTH]) && isYinBi(tgs[HOUR])) {
					return new BaziResult(BaziResult.WANG, "新图6-月干与时干为印比");
				} else if (isWuHe(tgs[MONTH], tgs[DAY]) && isYinBi(tgs[HOUR])) {
					return new BaziResult(BaziResult.WANG,
							"新图6-月干与日主得天干五合，合化后为印比");
				} else if (isWuHe(tgs[DAY], tgs[HOUR]) && isYinBi(tgs[MONTH])) {
					return new BaziResult(BaziResult.WANG,
							"新图6-时干与日主得天干五合，合化后为印比");
				} else {
					return new BaziResult(BaziResult.RUO, "新图6-月支和时支同时得根印,弱");
				}
			}

			// 新图7
			if (isGenYin(dzs[YEAR]) && isGenYin(dzs[HOUR])) {
				// 年干与月干为印比
				if (isYinBi(tgs[YEAR]) && isYinBi(tgs[MONTH])
						&& isYinBi(tgs[HOUR])) {
					return new BaziResult(BaziResult.WANG, "新图7-年干月干与时干为印比");
				} else if (isWuHe(tgs[YEAR], tgs[MONTH]) && isYinBi(tgs[HOUR])) {
					return new BaziResult(BaziResult.WANG,
							"新图7-年干与月干得天干五合，合化后为印比");
				} else if (isYinBi(tgs[YEAR]) && isWuHe(tgs[MONTH], tgs[DAY])
						&& isYinBi(tgs[HOUR])) {
					return new BaziResult(BaziResult.WANG,
							"新图7-月干与日主得天干五合，合化后为印比");
				} else if (isYinBi(tgs[YEAR]) && isWuHe(tgs[DAY], tgs[HOUR])
						&& isYinBi(tgs[MONTH])) {
					return new BaziResult(BaziResult.WANG,
							"新图7-时干与日主得天干五合，合化后为印比");
				} else {
					return new BaziResult(BaziResult.RUO, "新图7-月支和时支同时得根印,弱");
				}
			}
		}

		/**
		 * 三. 根单独一次在命局地支中出现
		 */
		if (gens == 1) {
            //1. 根在年支或时支单独出现一次
            if(isGen(dzs[YEAR])){
                if(dzs[YEAR].isSheng(dzs[MONTH])){
                    if(isTouBenQi(dzs[YEAR])){
                        return new BaziResult(BaziResult.RUO, "新图9-本气透出，身弱扶抑格");
                    }else{
                        return new BaziResult(BaziResult.RUO, "新图9-本气未透出，从弱");
                    }
                }else{
                    return new BaziResult(BaziResult.RUO, "新图9-未被月支泄，身弱");
                }
            }else if(isGen(dzs[HOUR])){
                if(dzs[HOUR].isSheng(dzs[DAY])){
                    if(isTouBenQi(dzs[HOUR])){
                        return new BaziResult(BaziResult.RUO, "新图9-本气透出，身弱扶抑格");
                    }else{
                        return new BaziResult(BaziResult.RUO, "新图9-本气未透出，从弱");
                    }
                }else{
                    return new BaziResult(BaziResult.RUO, "新图9-未被月支泄，身弱");
                }                
            }
		}

		/**
         * 四.印单独一次在命局地支出现
         */
        if (yins == 1) {

		}

		// 8.年支或时支临印星以身弱论
		if (isYin(dzs[YEAR]) || isYin(dzs[HOUR])) {
			return new BaziResult(BaziResult.RUO, "图8");
		}

		// 9.根在年支或时支出现一个以身弱论
		// 根的本气如透出，则不从弱
		if (isGen(dzs[YEAR]) || isGen(dzs[HOUR])) {
			if (isGen(dzs[YEAR])) {
				if (isGen(dzs[YEAR].getBenQin())) {
					return new BaziResult(BaziResult.WANG, "图9-3,本气透出");
				} else {
					return new BaziResult(BaziResult.RUO, "图9");
				}
			} else if (isGen(dzs[HOUR])) {
				if (isGen(dzs[HOUR].getBenQin())) {
					return new BaziResult(BaziResult.WANG, "图9-3");
				} else {
					return new BaziResult(BaziResult.RUO, "图9");
				}
			}
		}

		// 10. 印星在月日地支中一次出现，一次被克从弱。本气秀出假从。两次被克从弱，即使本气透出也从弱。
		int kes_m = 0;
		if (dzs[YEAR].isKe(dzs[MONTH])) {
			kes_m++;
		}
		if (dzs[DAY].isKe(dzs[MONTH])) {
			kes_m++;
		}

		int kes_d = 0;
		if (dzs[MONTH].isKe(dzs[DAY])) {
			kes_d++;
		}
		if (dzs[HOUR].isKe(dzs[DAY])) {
			kes_d++;
		}

		if (isYin(dzs[MONTH])) {
			if (isGen(dzs[MONTH].getBenQin()) && kes_m == 1) {
				return new BaziResult(BaziResult.WANG, "图10-月支被克一次，假从弱");
			} else {
				return new BaziResult(BaziResult.RUO, "图10-月支被克" + kes_m + "次");
			}
		} else if (isYin(dzs[DAY])) {
			if (isGen(dzs[DAY].getBenQin()) && kes_m == 1) {
				return new BaziResult(BaziResult.WANG, "图10-日支被克一次，假从弱");
			} else {
				return new BaziResult(BaziResult.RUO, "图10-日支被克" + kes_m + "次");
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

	private boolean isGenYin(DiZhi dz) {
		return isGen(dz) || isYin(dz);
	}

	private boolean isBi(TianGan tg) {
		return tgs[DAY].getXing().getXing() == tg.getXing().getXing();
	}

	private boolean isGen(TianGan tg) {
		return tgs[DAY].getTianGan() == tg.getTianGan();
	}

	private boolean isYin(TianGan tg) {
		return tg.isSheng(tgs[DAY]);
	}

	private boolean isGen(WuXing xing) {
		if (xing == null) {
			return false;
		} else {
			return tgs[DAY].getXing().getXing() == xing.getXing();
		}
	}

	private boolean isYin(WuXing xing) {
		if (xing == null)
			return false;
		else
			return xing.isSheng(tgs[DAY].getXing());
	}

	private boolean isGenYin(WuXing xing) {
		return isGen(xing) || isYin(xing);
	}

	private boolean isYinBi(TianGan tg) {
		return isYin(tg) || isBi(tg);
	}

	private boolean isWuHe(TianGan tg1, TianGan tg2) {
		return isGenYin(tg1.isHe(tg2));
	}

	private boolean isAllBiOrYin() {
		boolean result = true;
		for (int i = YEAR; i <= HOUR; i++) {
			result = result && (isYin(tgs[i]) || isBi(tgs[i]));
		}
		return result;
	}

	/**
	 * 11.年支和日支同时得根印，只有两种组合为旺 12.根印在月时和年时时，以此类推
	 * 
	 * @param dz1
	 * @param dz2
	 * @return
	 */
	private BaziResult method_5(int c1, int c2) {
		if (isGenYin(dzs[c1]) && isGenYin(dzs[c2])) {
			// 年干与月干为印比
			if (isYinBi(tgs[YEAR]) && isYinBi(tgs[MONTH])) {
				return new BaziResult(BaziResult.WANG, "新图5-年干与月干为印比");
			} else if (isWuHe(tgs[YEAR], tgs[MONTH])) {
				return new BaziResult(BaziResult.WANG, "新图5-年干与月干得天干五合，合化后为印比");
			} else {
				return new BaziResult(BaziResult.RUO, "新图5-年支和日支同时得根印,弱");
			}
		} else {
			return new BaziResult(BaziResult.UNKNOWN, "");
		}
	}

	private BaziResult method_13(int c1, int c2) {
		if (isGenYin(dzs[c1]) && isGenYin(dzs[c2])) {

			if (isYinBi(tgs[MONTH]) && isYinBi(tgs[HOUR])) {
				return new BaziResult(BaziResult.WANG, "图13-月干与时干为印比");
			} else if (isWuHe(tgs[MONTH], tgs[DAY])) {
				return new BaziResult(BaziResult.WANG, "图13-月干与日干得天干五合，合化后为印比");
			} else if (isWuHe(tgs[DAY], tgs[HOUR])) {
				return new BaziResult(BaziResult.WANG, "图13-日干与时干得天干五合，合化后为印比");
			} else if (isWuHe(tgs[MONTH], tgs[HOUR])) {
				return new BaziResult(BaziResult.WANG, "图13-月干与时干得天干五合，合化后为印比");
			} else {
				return new BaziResult(BaziResult.RUO, "图13-月支和时支同时得根印,弱");
			}
		} else {
			return new BaziResult(BaziResult.UNKNOWN, "");
		}
	}
    
    private boolean isTouBenQi(DiZhi dz){
        int qi = dz.getBenQin().getTianGan();
        return tgs[YEAR].getTianGan()== qi || tgs[MONTH].getTianGan()== qi || tgs[HOUR].getTianGan()== qi; 
    }

}
