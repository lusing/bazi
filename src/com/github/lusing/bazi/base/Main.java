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

		// 图4
		BaZiEngine bze_3_2 = new BaZiEngine(TianGan.GENG, DiZhi.WU,
				TianGan.REN, DiZhi.XU, TianGan.GUI, DiZhi.HAI, TianGan.XIN,
				DiZhi.YOU);
		bze_3_2.run();

		BaZiEngine bze_3_3 = new BaZiEngine(TianGan.JIA, DiZhi.CHEN,
				TianGan.JI, DiZhi.SI, TianGan.GUI, DiZhi.YOU, TianGan.REN,
				DiZhi.ZI);
		bze_3_3.run();

		BaZiEngine bze_3_4 = new BaZiEngine(TianGan.WU, DiZhi.SHEN,
				TianGan.GENG, DiZhi.SHEN, TianGan.JIA, DiZhi.YIN, TianGan.YI,
				DiZhi.HAI);
		bze_3_4.run();

		// 图5，有且仅有两个印，以弱论
		BaZiEngine bze_5 = new BaZiEngine(TianGan.BING, DiZhi.XU, TianGan.YI,
				DiZhi.WEI, TianGan.XIN, DiZhi.HAI, TianGan.JI, DiZhi.HAI);
		bze_5.run();

		// 图6，如果有3个印，按旺论
		BaZiEngine bze_6 = new BaZiEngine(TianGan.YI, DiZhi.MAO, TianGan.YI,
				DiZhi.MAO, TianGan.BING, DiZhi.YIN, TianGan.WU, DiZhi.XU);
		bze_6.run();
        
        //图7
		BaZiEngine bze_7 = new BaZiEngine(TianGan.YI, DiZhi.MAO, TianGan.GUI,
				DiZhi.WEI, TianGan.BING, DiZhi.CHEN, TianGan.JI, DiZhi.HAI);
		bze_7.run(); 
        
        //图8
		BaZiEngine bze_8 = new BaZiEngine(TianGan.WU, DiZhi.XU, TianGan.JI,
				DiZhi.WEI, TianGan.YI, DiZhi.SI, TianGan.DING, DiZhi.HAI);
		bze_8.run();
        
        //图9
        System.out.println("===图9-1===");
		BaZiEngine bze_9_1 = new BaZiEngine(TianGan.YI, DiZhi.MAO, TianGan.BING,
				DiZhi.XU, TianGan.YI, DiZhi.WEI, TianGan.DING, DiZhi.CHOU);
		bze_9_1.run();    

        System.out.println("===图9-2===");
        BaZiEngine bze_9_2 = new BaZiEngine(TianGan.YI, DiZhi.MAO, TianGan.JIA,
				DiZhi.SHEN, TianGan.JIA, DiZhi.WU, TianGan.YI, DiZhi.CHOU);
		bze_9_2.run();    
        
        System.out.println("===图9-3===");
        BaZiEngine bze_9_3 = new BaZiEngine(TianGan.JI, DiZhi.MAO, TianGan.JI,
				DiZhi.SI, TianGan.JIA, DiZhi.XU, TianGan.YI, DiZhi.CHOU);
		bze_9_3.run();    

        //图10
        BaZiEngine bze_10 = new BaZiEngine(TianGan.WU, DiZhi.XU, TianGan.JI,
				DiZhi.WEI, TianGan.YI, DiZhi.SI, TianGan.DING, DiZhi.HAI);
		bze_10.run();    

	}
}
