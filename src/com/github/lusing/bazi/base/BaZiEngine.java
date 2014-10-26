package com.github.lusing.bazi.base;

import java.util.ArrayList;

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

	public BaZiEngine(int[] bas) {
		if (bas == null || bas.length != 8) {
			return;
		} else {
			this.year_tg = bas[0];
			this.year_dz = bas[1];
			this.month_tg = bas[2];
			this.month_dz = bas[3];
			this.day_tg = bas[4];
			this.day_dz = bas[5];
			this.hour_tg = bas[6];
			this.hour_dz = bas[7];

			tgs = new TianGan[4];
			dzs = new DiZhi[4];

			tgs[0] = new TianGan(bas[0]);
			tgs[1] = new TianGan(bas[2]);
			tgs[2] = new TianGan(bas[4]);
			tgs[3] = new TianGan(bas[6]);

			dzs[0] = new DiZhi(bas[1]);
			dzs[1] = new DiZhi(bas[3]);
			dzs[2] = new DiZhi(bas[5]);
			dzs[3] = new DiZhi(bas[7]);
		}
	}

	public String run() {
		StringBuilder sb = new StringBuilder();
		sb.append(checkLiuQin());
		sb.append(checkWuXing());
		sb.append(mangRenDuan());
		sb.append(checkBaZhuan());
		return sb.toString();
	}

	private String mangRenDuan() {
		StringBuilder sb = new StringBuilder();
		sb.append(shiZhuDuan());
		sb.append(checkRiZhu());
		sb.append(checkShiShen());
		return sb.toString();
	}

	private String checkShiShen() {
		StringBuffer sb = new StringBuffer();
		int year_shishen_tg = ShiShen.getShiShen(tgs[DAY], tgs[YEAR])
				.getShiShen();
		int year_shishen_dz = ShiShen.getShiShen(tgs[DAY],
				dzs[YEAR].getBenQin()).getShiShen();
		int month_shishen_tg = ShiShen.getShiShen(tgs[DAY], tgs[MONTH])
				.getShiShen();
		int month_shishen_dz = ShiShen.getShiShen(tgs[DAY],
				dzs[MONTH].getBenQin()).getShiShen();
		int day_shishen_dz = ShiShen.getShiShen(tgs[DAY], dzs[DAY].getBenQin())
				.getShiShen();
		int hour_shishen_tg = ShiShen.getShiShen(tgs[DAY], tgs[HOUR])
				.getShiShen();
		int hour_shishen_dz = ShiShen.getShiShen(tgs[DAY],
				dzs[HOUR].getBenQin()).getShiShen();

		if (year_shishen_tg == ShiShen.ZHENGGUAN
				|| year_shishen_dz == ShiShen.ZHENGGUAN) {
			sb.append("年上正官，祖上比较富贵，有功名气象，有权势。");
			if (day_shishen_dz != ShiShen.SHANGGUAN) {
				// TODO: 判断冲
				sb.append("少年学业比较好.（要断冲）");
			}
			if (year_shishen_tg == ShiShen.ZHENGGUAN
					&& year_shishen_dz == ShiShen.ZHENGGUAN) {
				sb.append("从小读书非常用功，有成绩，如果不是头生子女，必然能接老人遗产。");
			}
		}
		if (year_shishen_tg == ShiShen.ZHENGYIN
				|| year_shishen_dz == ShiShen.ZHENGYIN) {
			sb.append("少年读书有成绩，老来也是个有福人。");
		}
		if (year_shishen_tg == ShiShen.QISHA
				|| year_shishen_dz == ShiShen.QISHA) {
			sb.append("年上七杀，对父母有克。年上偏官不是头生子，幼年家中贫困。");
		}
		if (year_shishen_tg == ShiShen.PIANCAI
				|| year_shishen_dz == ShiShen.PIANCAI) {
			sb.append("年上偏财，少年有福。");
			if ((year_shishen_tg == ShiShen.PIANCAI || year_shishen_dz == ShiShen.BIJIAN)) {
				sb.append("年上偏财支比肩，父母死在外边。");
			}
			if (year_shishen_tg == ShiShen.PIANCAI
					&& year_shishen_dz == ShiShen.PIANCAI) {
				sb.append("幼年克父克母。");
			}
		}
		if (year_shishen_tg == ShiShen.ZHENGCAI
				|| year_shishen_dz == ShiShen.ZHENGCAI) {
			sb.append("年上正财祖来强，家大业大借祖光，下有营地分三处，内有一处有力量。");
			if (month_shishen_tg == ShiShen.ZHENGCAI
					|| month_shishen_dz == ShiShen.ZHENGCAI) {
				sb.append("月上正财同来现，不是两妻就俩娘。");
			}
		}
		if (year_shishen_tg == ShiShen.SHANGGUAN
				|| year_shishen_dz == ShiShen.SHANGGUAN) {
			sb.append("年上伤官命不佳，祖业漂零没有啥。");
			if (month_shishen_tg == ShiShen.SHANGGUAN
					|| month_shishen_dz == ShiShen.SHANGGUAN) {
				sb.append("月上再把伤官见，不是克爹就克娘，若遇财运尚可解，一生事业有发达。");
			}
			if (hour_shishen_tg == ShiShen.SHANGGUAN
					|| hour_shishen_dz == ShiShen.SHANGGUAN) {
				sb.append("时上再把伤官见，刑妻克子定不养。");
			}
			if (year_shishen_tg == ShiShen.SHANGGUAN) {
				sb.append("年干为伤官，不论喜忌，皆主祖业漂零父母辈贫困多灾。");
			}
		}
		if (year_shishen_tg == ShiShen.SHISHEN
				|| year_shishen_dz == ShiShen.SHISHEN) {
			sb.append("年上食神，主少年不缺衣食，财源丰厚有福气，还主为人多自在，少年吃些好东西。");
			if (year_shishen_tg == ShiShen.SHISHEN
					&& year_shishen_dz == ShiShen.BIJIAN) {
				sb.append("干上食神支比肩，此人养子定无疑。");
			}
		}
		if (year_shishen_tg == ShiShen.PIANYIN
				|| year_shishen_dz == ShiShen.PIANYIN) {
			sb.append("年上偏印命不强，不是离父就离娘，自幼与母无缘份，缺少家教在命上。");
			if (year_shishen_tg == ShiShen.PIANYIN
					|| year_shishen_dz == ShiShen.BIJIAN) {
				sb.append("支为比肩为养子，少年名誉不太好，父母命硬克不动，疾病口舌不顺当。");
			}
		}
		if (year_shishen_tg == ShiShen.BIJIAN
				|| year_shishen_dz == ShiShen.BIJIAN) {
			if (year_shishen_tg == ShiShen.BIJIAN) {
				sb.append("年干比劫不利父。");
			}
			sb.append("年上比肩少远乡，生来就把父母克，父母命硬克不动，必有灾疾和口舌。祖业前程你没有，自力更生去生活，从小受苦受折磨.");
		}
		if (year_shishen_tg == ShiShen.JIECAI
				|| year_shishen_dz == ShiShen.JIECAI) {
			sb.append("年上劫财，祖业贫穷，靠自力更生创家业，为人心高气傲，讲义气，争强好胜。");
		}
		if ((tgs[YEAR].getTianGan() == TianGan.REN && tgs[HOUR].getTianGan() == TianGan.YI)
				|| (tgs[YEAR].getTianGan() == TianGan.YI && tgs[HOUR]
						.getTianGan() == TianGan.REN)) {
			sb.append("主母亲为偏房");
		}
		if ((dzs[YEAR].getDiZhi() == DiZhi.XU || dzs[YEAR].getDiZhi() == DiZhi.XU)
				&& isYin(dzs[YEAR])) {
			sb.append("主母亲或祖长多有宗教信仰或有懂五术玄学之人。");
		}
		sb.append("\n");
		if (month_shishen_tg == ShiShen.ZHENGGUAN
				|| month_shishen_dz == ShiShen.ZHENGGUAN) {
			sb.append("月上正官正气星，为人生来主聪明。");
		}
		if (month_shishen_tg == ShiShen.PIANGUAN
				|| month_shishen_dz == ShiShen.PIANGUAN) {
			sb.append("月上偏官.");
		}
		if (month_shishen_tg == ShiShen.PIANYIN
				|| month_shishen_dz == ShiShen.PIANYIN) {
			sb.append("月上偏印.");
		}
		if (month_shishen_tg == ShiShen.BIJIAN
				|| month_shishen_dz == ShiShen.BIJIAN) {
			sb.append("月上比肩兄弟多，兄弟多了不相合，兄弟常常不和睦，自力更生把事谋。");
		}
		if (month_shishen_tg == ShiShen.JIECAI
				|| month_shishen_dz == ShiShen.JIECAI) {
			sb.append("月上劫财，一生钱存不下，好为朋友破钱财，此人喜欢外表光华，爱穿爱戴投机取巧，不能和别人合伙做买卖，有钱就有事，好打架骂人。");
		}
		if (month_shishen_tg == ShiShen.SHISHEN
				|| month_shishen_dz == ShiShen.SHISHEN) {
			sb.append("月柱有食神，为人人缘好，一生有贵人助");
			if (month_shishen_dz == ShiShen.SHISHEN) {
				sb.append("月支食神一般身体好。");
			}
		}
		if (month_shishen_tg == ShiShen.SHANGGUAN
				&& month_shishen_dz == ShiShen.QISHA) {
			sb.append("月柱干伤官支坐七杀，女命逢之喝三眼井水之命。");
		}
		sb.append("\n");
		if (day_shishen_dz == ShiShen.SHANGGUAN) {
			sb.append("女命日坐伤官不论喜忌，必克夫婚姻不顺。");
		}
		if (day_shishen_dz == ShiShen.BIJIAN
				|| day_shishen_dz == ShiShen.JIECAI) {
			sb.append("男命坐比劫，必克妻，婚姻不顺。");
		}
		if ((tgs[DAY].getTianGan() == TianGan.JIA && dzs[DAY].getDiZhi() == DiZhi.YIN)
				|| (tgs[DAY].getTianGan() == TianGan.WU && dzs[DAY].getDiZhi() == DiZhi.SHEN)) {
			sb.append("女命甲寅、wu申日柱，夫有横死之灾。");
		}
		if (day_shishen_dz == ShiShen.PIANCAI) {
			sb.append("男命日坐偏财者主自己风流，不喜正妻偏爱小妾。");
		}
		if (day_shishen_dz == ShiShen.PIANYIN) {
			sb.append("男命日坐偏印必克妻且妻与母不合。");
		}
		if (dzs[DAY].getDiZhi() == dzs[MONTH].getDiZhi()) {
			sb.append("主配偶漂亮或能力强");
		} else {
			switch (dzs[DAY].getDiZhi()) {
			case DiZhi.ZI:
			case DiZhi.WU:
			case DiZhi.MAO:
			case DiZhi.YOU:
				sb.append("主配偶漂亮或能干");
				break;
			case DiZhi.YIN:
			case DiZhi.SHEN:
			case DiZhi.SI:
			case DiZhi.HAI:
				sb.append("主配偶长相一般，好说，聪明能干");
				break;
			case DiZhi.CHEN:
			case DiZhi.XU:
			case DiZhi.CHOU:
			case DiZhi.WEI:
				sb.append("主配偶朴素，敦厚。");
				break;

			}
		}

		return sb.toString() + "\n";
	}

	private String checkRiZhu() {
		TianGan sTG = tgs[DAY];
		DiZhi sDZ = dzs[DAY];
		StringBuffer sb = new StringBuffer();

		int ritg = sTG.getTianGan();

		switch (ritg) {
		case TianGan.JIA:
			sb.append("甲木日干：有组织能力，刚强，自律严厉，有领导才能，能获得多数人信赖\n");
			sb.append("偏财临身：能挣能花，从不计较个人得失，自主力强不依赖他人\n");
			break;
		case TianGan.YI:
			sb.append("乙木日干：外表懦弱谨慎，但内心固执，较为拘泥保守，感情脆弱\n");
			sb.append("正财临身：花钱多算计，计较个人利益，一心想财\n");
			break;
		case TianGan.BING:
			sb.append("丙火日干：文明有礼，美而敦厚，热情有朝气，活泼开朗乐天，但缺少毅力恒心，易被误解为好表现。\n");
			sb.append("七杀临身：性急躁，易发脾气，直来直去，易惹事非，孤刚斗狠，心高气傲，行为放纵\n");
			break;
		case TianGan.DING:
			sb.append("丁火日干：外柔内进，思想缜密，文明有礼，畏挫折，能胜不能败。\n");
			sb.append("谨小慎微，积极进取，稳重老成，奉公守法，责任心强。\n");
			break;
		case TianGan.WU:
			sb.append("诚实厚重，有社交力，喜打扮，没主见，与人处不久。\n");
			sb.append("偏印临身：耍小聪明，心胸狭窄，内中算计，性格多疑，感情用事\n");
			break;
		case TianGan.JI:
			sb.append("己土日干：为人心细，有规律，度量小，猜忌心强，好胜好强\n");
			sb.append("正印临身：仁慈宽厚，劳心劳累，多愁善感，宽以待人\n");
			break;
		case TianGan.GENG:
			sb.append("庚金日干：金主义者，略具文才，有经济手腕，善于处事，重物质享受\n");
			sb.append("比肩临身：朋友多，意志坚强，率真有重，内外团结，为人豪爽\n");
			break;
		case TianGan.XIN:
			sb.append("辛金日干：缺少魅力，顽固，能排除万难完成人，聪明\n");
			sb.append("劫财临身：刻板固执，打抱不平，常惹事非，花钱大，自高自大，一生操劳\n");
			break;
		case TianGan.REN:
			sb.append("壬水日干：有团结人的能力，能说服人，性暴，度量人，依赖性强，个性散乱，漫不经心\n");
			sb.append("食神临身：气质高雅，思想脱俗，反应快速，多才多艺\n");
			break;
		case TianGan.GUI:
			sb.append("正直廉洁，勤勉，处不顺境也会开拓道路，有生命力，能吃苦。\n");
			sb.append("伤官临身：不服约束，傲慢无礼，好表现自己，喜欢空想，行为诡秘，易受挫折\n");
			break;
		}

		if (sTG.getXing().getXing() == sDZ.getXing().getXing()) {
			sb.append("日柱比运转，克妻，主婚姻不顺\n");
		}
		if (sTG.getXing().isSheng(sDZ.getXing())) {
			sb.append("日干生日支夫妻感情好\n");
		}

		return sb.toString() + "\n";
	}

	private String shiZhuDuan() {
		int stg = tgs[HOUR].getTianGan();
		int sdz = dzs[HOUR].getDiZhi();
		StringBuffer sb = new StringBuffer();

		switch (sdz) {
		case DiZhi.ZI:
		case DiZhi.WU:
		case DiZhi.MAO:
		case DiZhi.YOU:
			sb.append("时初出生先亡父，时末先亡母，时中间多富饶\n");
			break;
		case DiZhi.YIN:
		case DiZhi.SHEN:
		case DiZhi.SI:
		case DiZhi.HAI:
			sb.append("时正兄弟四五个，时初时末也成双\n");
			break;
		case DiZhi.CHEN:
		case DiZhi.XU:
		case DiZhi.CHOU:
		case DiZhi.WEI:
			sb.append("时正多者先亡父，时初时末先亡母，兄弟少或无兄弟。此时辰出生的人克六亲\n");
			break;
		}

		switch (stg) {
		case TianGan.JIA:
		case TianGan.YI:
			sb.append("成家之后才能富贵，发达\n");
			break;
		case TianGan.BING:
		case TianGan.DING:
			sb.append("晚年家中多事，多烦恼\n");
			break;
		case TianGan.WU:
		case TianGan.JI:
			sb.append("自己富了发达了，但是六亲沾不到光\n");
			break;
		case TianGan.GENG:
		case TianGan.XIN:
			sb.append("一生多于动中谋生，善于交际门路广\n");
			break;
		case TianGan.REN:
		case TianGan.GUI:
			sb.append("一生做事多阻逆，多波折\n");
			break;
		}

		return sb.toString() + "\n";
	}

	private String checkBaZhuan() {
		StringBuilder sb = new StringBuilder();
		if (isBaZhuan(tgs[DAY], dzs[DAY])) {
			sb.append("日柱有淫欲煞，主有不正之妻\n");
		}
		if (isBaZhuan(tgs[HOUR], dzs[HOUR])) {
			sb.append("时柱有淫欲煞，主有不正之子\n");
		}
		if (isJiuChou(tgs[DAY], dzs[DAY]) || isJiuChou(tgs[HOUR], dzs[HOUR])) {
			sb.append("九丑，主夫妻不睦\n");
		}
		if (isRiZuoShangGuan()) {
			sb.append("日坐伤官，主风流好色\n");
		}
		if (isYinYangChaCuo()) {
			sb.append("阴阳差错日，主婚姻不顺\n");
		}
		if (isShiEDaBai()) {
			sb.append("十恶大败，主败祖业\n");
		}
		return sb.toString();
	}

	private boolean isBaZhuan(TianGan tg, DiZhi dz) {
		int tg1 = tg.getTianGan();
		int dz1 = dz.getDiZhi();

		if ((tg1 == TianGan.JIA && dz1 == DiZhi.YIN)
				|| (tg1 == TianGan.YI && dz1 == DiZhi.MAO)
				|| (tg1 == TianGan.JI && dz1 == DiZhi.WEI)
				|| (tg1 == TianGan.DING && dz1 == DiZhi.WEI)
				|| (tg1 == TianGan.GENG && dz1 == DiZhi.SHEN)
				|| (tg1 == TianGan.XIN && dz1 == DiZhi.YOU)
				|| (tg1 == TianGan.WU && dz1 == DiZhi.XU)
				|| (tg1 == TianGan.GUI && dz1 == DiZhi.CHOU)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isJiuChou(TianGan tg, DiZhi dz) {
		int tg1 = tg.getTianGan();
		int dz1 = dz.getDiZhi();

		if ((tg1 == TianGan.REN && dz1 == DiZhi.ZI)
				|| (tg1 == TianGan.REN && dz1 == DiZhi.WU)
				|| (tg1 == TianGan.WU && dz1 == DiZhi.ZI)
				|| (tg1 == TianGan.WU && dz1 == DiZhi.WU)
				|| (tg1 == TianGan.JI && dz1 == DiZhi.YOU)
				|| (tg1 == TianGan.JI && dz1 == DiZhi.MAO)
				|| (tg1 == TianGan.YI && dz1 == DiZhi.YOU)
				|| (tg1 == TianGan.YI && dz1 == DiZhi.MAO)
				|| (tg1 == TianGan.XIN && dz1 == DiZhi.MAO)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isRiZuoShangGuan() {
		int tg1 = tgs[DAY].getTianGan();
		int dz1 = dzs[DAY].getDiZhi();

		if ((tg1 == TianGan.JIA && dz1 == DiZhi.ZI)
				|| (tg1 == TianGan.YI && dz1 == DiZhi.SI)
				|| (tg1 == TianGan.GENG && dz1 == DiZhi.WU)
				|| (tg1 == TianGan.XIN && dz1 == DiZhi.HAI)
				|| (tg1 == TianGan.JIA && dz1 == DiZhi.WU)
				|| (tg1 == TianGan.GENG && dz1 == DiZhi.ZI)
				|| (tg1 == TianGan.GUI && dz1 == DiZhi.HAI)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isYinYangChaCuo() {
		int tg1 = tgs[DAY].getTianGan();
		int dz1 = dzs[DAY].getDiZhi();

		if ((tg1 == TianGan.XIN && dz1 == DiZhi.MAO)
				|| (tg1 == TianGan.REN && dz1 == DiZhi.CHEN)
				|| (tg1 == TianGan.GUI && dz1 == DiZhi.SI)
				|| (tg1 == TianGan.BING && dz1 == DiZhi.WU)
				|| (tg1 == TianGan.DING && dz1 == DiZhi.WEI)
				|| (tg1 == TianGan.WU && dz1 == DiZhi.SHEN)
				|| (tg1 == TianGan.XIN && dz1 == DiZhi.YOU)
				|| (tg1 == TianGan.REN && dz1 == DiZhi.XU)
				|| (tg1 == TianGan.GUI && dz1 == DiZhi.HAI)
				|| (tg1 == TianGan.BING && dz1 == DiZhi.ZI)
				|| (tg1 == TianGan.DING && dz1 == DiZhi.CHOU)
				|| (tg1 == TianGan.WU && dz1 == DiZhi.YIN)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isShiEDaBai() {
		int tg1 = tgs[DAY].getTianGan();
		int dz1 = dzs[DAY].getDiZhi();

		if ((tg1 == TianGan.JIA && dz1 == DiZhi.CHEN)
				|| (tg1 == TianGan.YI && dz1 == DiZhi.SI)
				|| (tg1 == TianGan.REN && dz1 == DiZhi.SHEN)
				|| (tg1 == TianGan.BING && dz1 == DiZhi.SHEN)
				|| (tg1 == TianGan.DING && dz1 == DiZhi.HAI)
				|| (tg1 == TianGan.GENG && dz1 == DiZhi.CHEN)
				|| (tg1 == TianGan.GUI && dz1 == DiZhi.HAI)
				|| (tg1 == TianGan.WU && dz1 == DiZhi.XU)
				|| (tg1 == TianGan.XIN && dz1 == DiZhi.SI)
				|| (tg1 == TianGan.JI && dz1 == DiZhi.CHOU)) {
			return true;
		} else {
			return false;
		}
	}

	private String checkLiuQin() {
		StringBuilder sb = new StringBuilder();
		sb.append("日主：" + tgs[2] + "\n");
		sb.append(tgs[0].toString() + dzs[0] + " " + tgs[1] + dzs[1] + " "
				+ tgs[2] + dzs[2] + " " + tgs[3] + dzs[3] + "\n");
		sb.append(tgs[0] + " " + ShiShen.getShiShen(tgs[2], tgs[0]).toString()
				+ "\n");
		sb.append(tgs[1] + " " + ShiShen.getShiShen(tgs[2], tgs[1]).toString()
				+ "\n");
		sb.append(tgs[3] + " " + ShiShen.getShiShen(tgs[2], tgs[3]).toString()
				+ "\n");

		sb.append("命宫：").append(DiZhi.getMingGong(dzs[1], dzs[3])).append("\n");

		int yins = 0;
		int bis = 0;
		int cais = 0;
		int guans = 0;
		int shangs = 0;

		ArrayList<TianGan> tgFull = new ArrayList<TianGan>();
		tgFull.add(tgs[YEAR]);
		tgFull.add(tgs[MONTH]);
		tgFull.add(tgs[HOUR]);
		for (int i = YEAR; i <= HOUR; i++) {
			tgFull.addAll(dzs[i].getCangGan());
		}

		for (TianGan tg : tgFull) {
			switch (ShiShen.getShiShen(tgs[DAY], tg).getShiShen()) {
			case ShiShen.ZHENGYIN:
			case ShiShen.PIANYIN:
				yins++;
				break;
			case ShiShen.BIJIAN:
			case ShiShen.JIECAI:
				bis++;
				break;
			case ShiShen.ZHENGCAI:
			case ShiShen.PIANCAI:
				cais++;
				break;
			case ShiShen.ZHENGGUAN:
			case ShiShen.QISHA:
				guans++;
				break;
			case ShiShen.SHISHEN:
			case ShiShen.SHANGGUAN:
				shangs++;
				break;
			}
		}
		sb.append("共有食伤:" + shangs + "个，财:" + cais + "个，官:" + guans + "个，印:"
				+ yins + "个，根比：" + bis + "个\n");
		return sb.toString();
	}

	private String checkWuXing() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tgs.length; i++) {
			sb.append(tgs[i].getXing().toString() + dzs[i].getXing() + "\t");
		}
		sb.append("\n");

		BaziResult br = checkWangShuai();
		sb.append(br);
		sb.append(getYongShen(br));
		return sb.toString();
	}

	/**
	 * 取用神
	 */
	private String getYongShen(BaziResult br) {
		StringBuffer sb = new StringBuffer();
		switch (br.status) {
		case BaziResult.RUO:
			sb.append("身弱用印比\n");
			break;
		case BaziResult.WANG:
			sb.append("身旺用财官伤\n");
			break;
		case BaziResult.CONG_QIANG:
			sb.append("印比帮扶为用神\n");
			break;
		case BaziResult.CONG_RUO:
			sb.append("财官伤食都是用神\n");
			break;
		case BaziResult.JIA_CONG:
			sb.append("随岁运变化而变\n");
			break;
		default:
			break;
		}

		return sb.toString();
	}

	/**
	 * 检查日主的旺衰
	 */
	private BaziResult checkWangShuai() {

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
		// System.out.println("本命共有根" + gens + "个，印" + yins + "个");
		/**
		 * 九. 印或根在命局地支中一次也不出现
		 */
		// 新23
		if (yins == 0 && gens == 0) {
			if (isAllBiOrYin()) {
				return new BaziResult(BaziResult.RUO, "新图23-弱，扶抑格");
			} else {
				// TODO
				return new BaziResult(BaziResult.CONG_RUO, "新图23-从弱格");
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
			return new BaziResult(BaziResult.CONG_QIANG, "新图21-从强格");
		}

		/**
		 * 六.印三次在命局地支出现
		 */
		if (yins == 3) {
			// TODO:
			if (isCai(dzs[YEAR]) || isCai(dzs[MONTH]) || isCai(dzs[HOUR])) {
				return new BaziResult(BaziResult.WANG, "新图20-特殊格局");
			} else if (isGuan(dzs[YEAR]) || isGuan(dzs[HOUR])) {
				return new BaziResult(BaziResult.WANG, "新图20-特殊格局");
			} else if (isGuan(dzs[MONTH])) {
				if (isTouBenQi(dzs[MONTH])) {
					return new BaziResult(BaziResult.JIA_CONG, "新图20-本气透出，假从印格");
				} else {
					return new BaziResult(BaziResult.CONG_QIANG,
							"新图20-本气不透，从印格");
				}
			} else if (isGuan(dzs[DAY])) {
				if (isTouBenQi(dzs[DAY])) {
					return new BaziResult(BaziResult.JIA_CONG, "新图20-本气透出，假从印格");
				} else {
					return new BaziResult(BaziResult.CONG_QIANG,
							"新图20-本气不透，从印格");
				}
			}
		}

		/**
		 * 五.根三次或 根印三次在命局地支出现
		 */
		if (gens + yins == 3) {
			if (isCai(dzs[YEAR]) || isGuan(dzs[YEAR]) || isShang(dzs[YEAR])) {
				return new BaziResult(BaziResult.WANG, "新图16-扶抑格身旺");
			} else if (isCai(dzs[HOUR]) || isGuan(dzs[HOUR])
					|| isShang(dzs[HOUR])) {
				return new BaziResult(BaziResult.WANG, "新图16-扶抑格身旺");
			} else if (isCai(dzs[MONTH])) {
				if (isYin(dzs[YEAR]) || isYin(dzs[DAY])) {
					return new BaziResult(BaziResult.WANG, "新图17-财一次被克，身旺");
				} else {
					if (isTouBenQi(dzs[MONTH])) {
						return new BaziResult(BaziResult.JIA_CONG, "新图17-假从强格");
					} else {
						return new BaziResult(BaziResult.CONG_QIANG,
								"新图17-真从强格");
					}
				}
			} else if (isGuan(dzs[MONTH])) {
				if (isYin(dzs[YEAR]) || isYin(dzs[DAY])) {
					return new BaziResult(BaziResult.WANG, "新图18-不从，按扶抑身旺论命");
				} else {
					if (isTouBenQi(dzs[MONTH])) {
						return new BaziResult(BaziResult.JIA_CONG, "新图18-假从强格");
					} else {
						return new BaziResult(BaziResult.CONG_QIANG,
								"新图18-真从强格");
					}
				}
			} else if (isShang(dzs[MONTH])) {
				if (isYin(dzs[YEAR]) || isYin(dzs[DAY])) {
					return new BaziResult(BaziResult.WANG,
							"新图19-食伤一次被克，不以从强格，身旺");
				} else {
					if (isTouBenQi(dzs[MONTH])) {
						return new BaziResult(BaziResult.JIA_CONG, "新图19-假从强格");
					} else {
						return new BaziResult(BaziResult.CONG_QIANG,
								"新图19-真从强格");
					}
				}
			} else if (isCai(dzs[DAY])) {
				if (isYin(dzs[MONTH]) || isYin(dzs[HOUR])) {
					return new BaziResult(BaziResult.WANG, "新图17-财一次被克，身旺");
				} else {
					if (isTouBenQi(dzs[DAY])) {
						return new BaziResult(BaziResult.JIA_CONG, "新图17-假从强格");
					} else {
						return new BaziResult(BaziResult.CONG_QIANG,
								"新图17-真从强格");
					}
				}
			} else if (isGuan(dzs[DAY])) {
				if (isYin(dzs[MONTH]) || isYin(dzs[HOUR])) {
					return new BaziResult(BaziResult.WANG, "新图18-不从，按扶抑身旺论命");
				} else {
					if (isTouBenQi(dzs[DAY])) {
						return new BaziResult(BaziResult.JIA_CONG, "新图18-假从强格");
					} else {
						return new BaziResult(BaziResult.CONG_QIANG,
								"新图18-真从强格");
					}
				}
			} else if (isShang(dzs[DAY])) {
				if (isYin(dzs[MONTH]) || isYin(dzs[HOUR])) {
					return new BaziResult(BaziResult.WANG,
							"新图19-食伤一次被克，不以从强格，身旺");
				} else {
					if (isTouBenQi(dzs[DAY])) {
						return new BaziResult(BaziResult.JIA_CONG, "新图19-假从强格");
					} else {
						return new BaziResult(BaziResult.CONG_QIANG,
								"新图19-真从强格");
					}
				}
			}
		}

		// 新8. 印星临年月以弱论。即使天干印比一片也弱。地支中印星同时出现两个，不论在何位置均以弱论。
		if (yins == 2) {
			return new BaziResult(BaziResult.RUO, "新图8-印星两次出现，不论组合，不看天干，皆以弱论");
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
			// 1. 根在年支或时支单独出现一次
			if (isGen(dzs[YEAR])) {
				if (dzs[YEAR].isSheng(dzs[MONTH])) {
					if (isTouBenQi(dzs[YEAR])) {
						return new BaziResult(BaziResult.RUO, "新图9-本气透出，身弱扶抑格");
					} else {
						return new BaziResult(BaziResult.CONG_RUO,
								"新图9-本气未透出，从弱");
					}
				} else {
					return new BaziResult(BaziResult.RUO, "新图9-未被月支泄，身弱");
				}
			} else if (isGen(dzs[HOUR])) {
				if (dzs[HOUR].isSheng(dzs[DAY])) {
					if (isTouBenQi(dzs[HOUR])) {
						return new BaziResult(BaziResult.RUO, "新图9-本气透出，身弱扶抑格");
					} else {
						return new BaziResult(BaziResult.CONG_RUO,
								"新图9-本气未透出，从弱");
					}
				} else {
					return new BaziResult(BaziResult.RUO, "新图9-未被月支泄，身弱");
				}
			} else if (isGen(dzs[MONTH])) {
				if (dzs[YEAR].isKe(dzs[MONTH]) && dzs[DAY].isKe(dzs[MONTH])) {
					if (isTouBenQi(dzs[MONTH])) {
						return new BaziResult(BaziResult.JIA_CONG,
								"新图12-本气透出，按假从论命");
					} else {
						return new BaziResult(BaziResult.CONG_RUO,
								"新图12-本气未透出，按从格论命");
					}
				} else if (dzs[MONTH].isSheng(dzs[YEAR])
						&& dzs[MONTH].isSheng(dzs[DAY])) {
					if (isTouBenQi(dzs[MONTH])) {
						return new BaziResult(BaziResult.JIA_CONG,
								"新图13-本气透出，按假从论命");
					} else {
						return new BaziResult(BaziResult.CONG_RUO,
								"新图13-本气未透出，按从格论命");
					}
				} else if (dzs[MONTH].isKe(dzs[YEAR])
						&& dzs[MONTH].isKe(dzs[DAY])) {
					return new BaziResult(BaziResult.CONG_RUO,
							"新图14-3-本气未透出，按从格论命");
				} else if ((dzs[YEAR].isKe(dzs[MONTH]) && dzs[MONTH]
						.isSheng(dzs[DAY]))
						|| (dzs[DAY].isKe(dzs[MONTH]) && dzs[MONTH]
								.isSheng(dzs[YEAR]))) {
					if (isTouBenQi(dzs[MONTH])) {
						return new BaziResult(BaziResult.RUO,
								"新图14-本气透出，按扶抑格身弱论命");
					} else {
						return new BaziResult(BaziResult.CONG_RUO,
								"新图14-本气未透出，按假从格论命");
					}
				} else if ((dzs[MONTH].isKe(dzs[YEAR]) && dzs[MONTH]
						.isSheng(dzs[DAY]))
						|| (dzs[MONTH].isKe(dzs[DAY]) && dzs[MONTH]
								.isSheng(dzs[YEAR]))) {
					if (isTouBenQi(dzs[MONTH])) {
						return new BaziResult(BaziResult.RUO,
								"新图14-2-一泄一耗，本气透出，按扶抑格身弱论命");
					} else {
						return new BaziResult(BaziResult.JIA_CONG,
								"新图14-2-一泄一耗，本气未透出，按假从格论命");
					}
				} else if ((dzs[YEAR].isKe(dzs[MONTH]) && dzs[MONTH]
						.isKe(dzs[DAY]))
						|| (dzs[DAY].isKe(dzs[MONTH]) && dzs[MONTH]
								.isKe(dzs[YEAR]))) {
					return new BaziResult(BaziResult.RUO, "新图14-1,一克一耗，以扶抑身弱论命");
				}
			} else if (isGen(dzs[DAY])) {
				if (dzs[MONTH].isKe(dzs[DAY]) && dzs[HOUR].isKe(dzs[DAY])) {
					if (isTouBenQi(dzs[DAY])) {
						return new BaziResult(BaziResult.JIA_CONG,
								"新图12-被两次克，本气透出，按假从论命");
					} else {
						return new BaziResult(BaziResult.CONG_RUO,
								"新图12-被两次克，本气未透出，按从格论命");
					}
				} else if (dzs[DAY].isSheng(dzs[MONTH])
						&& dzs[DAY].isSheng(dzs[HOUR])) {
					if (isTouBenQi(dzs[DAY])) {
						return new BaziResult(BaziResult.JIA_CONG,
								"新图13-本气透出，按假从论命");
					} else {
						return new BaziResult(BaziResult.CONG_RUO,
								"新图13-本气未透出，按从格论命");
					}
				} else if (dzs[DAY].isKe(dzs[MONTH])
						&& dzs[DAY].isKe(dzs[HOUR])) {
					return new BaziResult(BaziResult.CONG_RUO,
							"新图14-3-本气未透出，按从格论命");
				} else if ((dzs[MONTH].isKe(dzs[DAY]) && dzs[DAY]
						.isSheng(dzs[HOUR]))
						|| (dzs[HOUR].isKe(dzs[DAY]) && dzs[DAY]
								.isSheng(dzs[MONTH]))) {
					if (isTouBenQi(dzs[DAY])) {
						return new BaziResult(BaziResult.RUO,
								"新图14-一克一泄，本气透出，按扶抑格身弱论命");
					} else {
						return new BaziResult(BaziResult.JIA_CONG,
								"新图14-一克一泄，本气未透出，按假从格论命");
					}
				} else if ((dzs[DAY].isKe(dzs[MONTH]) && dzs[DAY]
						.isSheng(dzs[HOUR]))
						|| (dzs[DAY].isKe(dzs[HOUR]) && dzs[DAY]
								.isSheng(dzs[MONTH]))) {
					if (isTouBenQi(dzs[DAY])) {
						return new BaziResult(BaziResult.RUO,
								"新图14-2-一泄一耗，本气透出，按扶抑格身弱论命");
					} else {
						return new BaziResult(BaziResult.JIA_CONG,
								"新图14-2-一泄一耗，本气未透出，按假从格论命");
					}
				} else if ((dzs[MONTH].isKe(dzs[DAY]) && dzs[DAY]
						.isKe(dzs[HOUR]))
						|| (dzs[HOUR].isKe(dzs[DAY]) && dzs[DAY]
								.isKe(dzs[MONTH]))) {
					return new BaziResult(BaziResult.RUO, "新图14-1,一克一耗，以扶抑身弱论命");
				}
			}
		}

		/**
		 * 四.印单独一次在命局地支出现
		 */
		if (yins == 1) {
			if (isYin(dzs[YEAR]) || isYin(dzs[HOUR])) {
				return new BaziResult(BaziResult.RUO, "新图15-1,身弱");
			} else if (isYin(dzs[MONTH])) {
				int yin_kes = 0;
				if (dzs[YEAR].isKe(dzs[MONTH])) {
					yin_kes++;
				}
				if (dzs[DAY].isKe(dzs[MONTH])) {
					yin_kes++;
				}

				if (yin_kes == 1) {
					if (isTouBenQi(dzs[MONTH])) {
						return new BaziResult(BaziResult.JIA_CONG, "图15-2,假从");
					} else {
						return new BaziResult(BaziResult.CONG_RUO, "图15-2,论从");
					}
				} else if (yin_kes == 2) {
					return new BaziResult(BaziResult.CONG_RUO, "图15-3,从弱");
				} else {
					return new BaziResult(BaziResult.RUO, "图15-4,身弱?");
				}
			} else if (isYin(dzs[DAY])) {
				int yin_kes = 0;
				if (dzs[MONTH].isKe(dzs[DAY])) {
					yin_kes++;
				}
				if (dzs[HOUR].isKe(dzs[DAY])) {
					yin_kes++;
				}

				if (yin_kes == 1) {
					if (isTouBenQi(dzs[DAY])) {
						return new BaziResult(BaziResult.JIA_CONG, "图15-2,假从");
					} else {
						return new BaziResult(BaziResult.CONG_RUO, "图15-2,论从");
					}
				} else if (yin_kes == 2) {
					return new BaziResult(BaziResult.CONG_RUO, "图15-3,从弱");
				} else {
					return new BaziResult(BaziResult.RUO, "图15-4,身弱?");
				}
			}
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

	private boolean isCai(DiZhi dz) {
		return tgs[DAY].getXing().isKe(dz.getXing());
	}

	private boolean isGuan(DiZhi dz) {
		return dz.getXing().isKe(tgs[DAY].getXing());
	}

	private boolean isShang(DiZhi dz) {
		return tgs[DAY].getXing().isSheng(dz.getXing());
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

	private boolean isTouBenQi(DiZhi dz) {
		int qi = dz.getBenQin().getTianGan();
		return tgs[YEAR].getTianGan() == qi || tgs[MONTH].getTianGan() == qi
				|| tgs[HOUR].getTianGan() == qi;
	}

}
