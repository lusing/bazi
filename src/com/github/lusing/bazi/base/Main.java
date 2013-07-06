package com.github.lusing.bazi.base;

public class Main {

	public static void main(String[] args) {
		TianGan tg_jia = new TianGan(TianGan.JIA);

		for (int i = TianGan.JIA; i <= TianGan.GUI; i++) {
			// System.out.println(new TianGan(i));
			// System.out.println(new TianGan(i).getXing());
			// System.out.println(ShiShen.getShiShen(tg_jia,new TianGan(i)));

		}
		BaZiEngine bze1 = new BaZiEngine(TianGan.GENG, DiZhi.SHEN, TianGan.REN,
				DiZhi.WU, TianGan.REN, DiZhi.XU, TianGan.YI, DiZhi.SI);
		bze1.run();
		BaZiEngine bze2 = new BaZiEngine(TianGan.JI, DiZhi.HAI, TianGan.GUI,
				DiZhi.YOU, TianGan.GUI, DiZhi.MAO, TianGan.REN, DiZhi.XU);
		bze2.run();

		// 根印帮扶法
		// 例1,
		BaZiEngine bze3 = new BaZiEngine(TianGan.GUI, DiZhi.MAO, TianGan.BING,
				DiZhi.CHEN, TianGan.JI, DiZhi.CHOU, TianGan.YI, DiZhi.HAI);
		bze3.run();

		// 图3
		BaZiEngine bze_3 = new BaZiEngine(TianGan.JIA, DiZhi.WU, TianGan.JIA,
				DiZhi.XU, TianGan.GUI, DiZhi.HAI, TianGan.XIN, DiZhi.YOU);
		bze_3.run();

		BaZiEngine bze_3_2 = new BaZiEngine(TianGan.GENG, DiZhi.WU,
				TianGan.REN, DiZhi.XU, TianGan.GUI, DiZhi.HAI, TianGan.XIN,
				DiZhi.YOU);
		bze_3_2.run();

	}
}
