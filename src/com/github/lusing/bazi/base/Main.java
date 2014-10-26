package com.github.lusing.bazi.base;

public class Main {

	public static void main(String[] args) {

		BaZiEngine bze0 = new BaZiEngine(TianGan.GENG, DiZhi.SHEN, TianGan.REN,
				DiZhi.WU, TianGan.REN, DiZhi.XU, TianGan.YI, DiZhi.SI);
		System.out.println(bze0.run());
        
        System.out.println("===图1,旺===");
		BaZiEngine bze1 = new BaZiEngine(TianGan.JI, DiZhi.HAI, TianGan.GUI,
				DiZhi.YOU, TianGan.GUI, DiZhi.MAO, TianGan.REN, DiZhi.XU);
		bze1.run();

		// 根印帮扶法
		// 例1,
        System.out.println("===图2,旺===");
		BaZiEngine bze2 = new BaZiEngine(TianGan.GUI, DiZhi.MAO, TianGan.BING,
				DiZhi.CHEN, TianGan.JI, DiZhi.CHOU, TianGan.YI, DiZhi.HAI);
		bze2.run();

		// 图3
        System.out.println("===图3,弱===");
		BaZiEngine bze_3 = new BaZiEngine(TianGan.JIA, DiZhi.WU, TianGan.JIA,
				DiZhi.XU, TianGan.GUI, DiZhi.HAI, TianGan.XIN, DiZhi.YOU);
		bze_3.run();

		// 图4
        System.out.println("===图4,旺===");
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
        System.out.println("===新图8,弱===");
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
        System.out.println("===图10-1===");
        BaZiEngine bze_10 = new BaZiEngine(TianGan.BING, DiZhi.CHEN, TianGan.BING,
				DiZhi.SHEN, TianGan.REN, DiZhi.YIN, TianGan.XIN, DiZhi.CHOU);
		bze_10.run();
        
        System.out.println("===图10-2===");
        BaZiEngine bze_10_2 = new BaZiEngine(TianGan.DING, DiZhi.SI, TianGan.WU,
				DiZhi.SHEN, TianGan.DING, DiZhi.WEI, TianGan.XIN, DiZhi.CHOU);
		bze_10_2.run();

        System.out.println("===图11===");
        BaZiEngine bze_11 = new BaZiEngine(TianGan.REN, DiZhi.ZI, TianGan.DING,
				DiZhi.WEI, TianGan.JIA, DiZhi.YIN, TianGan.WU, DiZhi.CHEN);
		bze_11.run();
        
        System.out.println("===图12-1,弱===");
        BaZiEngine bze_12_1 = new BaZiEngine(TianGan.GUI, DiZhi.HAI, TianGan.JIA,
				DiZhi.YIN, TianGan.GUI, DiZhi.HAI, TianGan.JIA, DiZhi.YIN);
		bze_12_1.run();

        System.out.println("===图12-3,旺===");
        BaZiEngine bze_12_3 = new BaZiEngine(TianGan.REN, DiZhi.ZI, TianGan.REN,
				DiZhi.YIN, TianGan.GUI, DiZhi.HAI, TianGan.GUI, DiZhi.YOU);
		bze_12_3.run();

        System.out.println("===图12-4,旺===");
        BaZiEngine bze_12_4 = new BaZiEngine(TianGan.REN, DiZhi.ZI, TianGan.GUI,
				DiZhi.CHOU, TianGan.WU, DiZhi.SHEN, TianGan.GUI, DiZhi.CHOU);
		bze_12_4.run();

        System.out.println("===图13,旺===");
        BaZiEngine bze_13 = new BaZiEngine(TianGan.REN, DiZhi.ZI, TianGan.GUI,
				DiZhi.CHOU, TianGan.WU, DiZhi.ZI, TianGan.GUI, DiZhi.CHOU);
		bze_13.run();

        System.out.println("===新图7,旺===");
        BaZiEngine bze_n7 = new BaZiEngine(TianGan.XIN, DiZhi.HAI, TianGan.GUI,
				DiZhi.SI, TianGan.GUI, DiZhi.MAO, TianGan.GUI, DiZhi.HAI);
		bze_n7.run();

        System.out.println("===新图9,从弱===");
        BaZiEngine bze_n9 = new BaZiEngine(TianGan.JI, DiZhi.WEI, TianGan.DING,
				DiZhi.CHOU, TianGan.JIA, DiZhi.WU, TianGan.DING, DiZhi.MAO);
		bze_n9.run();

        System.out.println("===新图加1,从弱===");
        BaZiEngine bze_n_p1 = new BaZiEngine(TianGan.DING, DiZhi.SI, TianGan.JIA,
				DiZhi.CHEN, TianGan.XIN, DiZhi.CHOU, TianGan.XIN, DiZhi.MAO);
		bze_n_p1.run();

        System.out.println("===新图加2,弱极===");
        BaZiEngine bze_n_p2 = new BaZiEngine(TianGan.WU, DiZhi.ZI, TianGan.XIN,
				DiZhi.YOU, TianGan.BING, DiZhi.SHEN, TianGan.WU, DiZhi.XU);
		bze_n_p2.run();

        System.out.println("===图31-1,不从强===");
        BaZiEngine bze_31_1 = new BaZiEngine(TianGan.XIN, DiZhi.SI, TianGan.XIN,
				DiZhi.CHOU, TianGan.XIN, DiZhi.YOU, TianGan.JI, DiZhi.CHOU);
		bze_31_1.run();

        System.out.println("===论格局高低1,不从强===");
        BaZiEngine bze_gd_1 = new BaZiEngine(TianGan.GENG, DiZhi.SHEN, TianGan.JI,
				DiZhi.MAO, TianGan.GENG, DiZhi.YIN, TianGan.GENG, DiZhi.CHEN);
		bze_gd_1.run();

        System.out.println("===论格局高低2,不从强===");
        BaZiEngine bze_gd_2 = new BaZiEngine(TianGan.YI, DiZhi.SI, TianGan.DING,
				DiZhi.HAI, TianGan.JIA, DiZhi.XU, TianGan.JIA, DiZhi.ZI);
		bze_gd_2.run();

        System.out.println("===论格局高低3,===");
        BaZiEngine bze_gd_3 = new BaZiEngine(TianGan.REN, DiZhi.YIN, TianGan.WU,
				DiZhi.SHEN, TianGan.JIA, DiZhi.WU, TianGan.JIA, DiZhi.ZI);
		bze_gd_3.run();

        System.out.println("===论格局高低4,===");
        BaZiEngine bze_gd_4 = new BaZiEngine(TianGan.XIN, DiZhi.CHOU, TianGan.GUI,
				DiZhi.SI, TianGan.REN, DiZhi.YIN, TianGan.WU, DiZhi.SHEN);
		bze_gd_4.run();
        
        //===
        System.out.println("===用神判定1,===");
        BaZiEngine bze_ys_1 = new BaZiEngine(TianGan.JI, DiZhi.YOU, TianGan.YI,
                DiZhi.HAI, TianGan.REN, DiZhi.CHEN, TianGan.YI, DiZhi.SI);
        bze_ys_1.run();
        
        System.out.println("===曾欢===");
        BaZiEngine bze_zenghuan = new BaZiEngine(TianGan.GUI, DiZhi.HAI, TianGan.BING,
                DiZhi.CHEN, TianGan.WU, DiZhi.CHEN, TianGan.JIA, DiZhi.YIN);
        System.out.println(bze_zenghuan.run());

        System.out.println("===勾阳===");
        BaZiEngine bze_gouyang = new BaZiEngine(TianGan.JIA, DiZhi.ZI, TianGan.DING,
                DiZhi.CHOU, TianGan.XIN, DiZhi.HAI, TianGan.GUI, DiZhi.SI);
        System.out.println(bze_gouyang.run());
        System.out.println("===喜超===");
        BaZiEngine bze_xichao = new BaZiEngine(TianGan.GENG, DiZhi.SHEN, TianGan.BING,
                DiZhi.XU, TianGan.JIA, DiZhi.YIN, TianGan.XIN, DiZhi.WEI);
        System.out.println(bze_xichao.run());
        System.out.println("===林方君===");
        BaZiEngine bze_fangjun = new BaZiEngine(TianGan.YI, DiZhi.CHOU, TianGan.JIA,
                DiZhi.SHEN, TianGan.XIN, DiZhi.MAO, TianGan.XIN, DiZhi.MAO);
        System.out.println(bze_fangjun.run());
        System.out.println("===乔俊琪===");
        BaZiEngine bze_junqi = new BaZiEngine(TianGan.WU, DiZhi.WU, TianGan.GENG,
                DiZhi.SHEN, TianGan.GUI, DiZhi.MAO, TianGan.BING, DiZhi.CHEN);
        System.out.println(bze_junqi.run());
        System.out.println("===厉育锦===");
        BaZiEngine bze_yujin = new BaZiEngine(TianGan.WU, DiZhi.WU, TianGan.YI,
                DiZhi.MAO, TianGan.GENG, DiZhi.YIN, TianGan.BING, DiZhi.ZI);
        System.out.println(bze_yujin.run());
        System.out.println("===张强===");
        BaZiEngine bze_zq = new BaZiEngine(TianGan.JIA, DiZhi.ZI, TianGan.DING,
                DiZhi.CHOU, TianGan.DING, DiZhi.WEI, TianGan.WU, DiZhi.SHEN);
        System.out.println(bze_zq.run());
        System.out.println("===张连育===");
        BaZiEngine bze_lianyu = new BaZiEngine(TianGan.GUI, DiZhi.HAI, TianGan.YI,
                DiZhi.MAO, TianGan.DING, DiZhi.YOU, TianGan.REN, DiZhi.YIN);
        System.out.println(bze_lianyu.run());
        System.out.println("===陈功===");
        BaZiEngine bze_chengong = new BaZiEngine(TianGan.XIN, DiZhi.YOU, TianGan.REN,
                DiZhi.CHEN, TianGan.GUI, DiZhi.HAI, TianGan.BING, DiZhi.CHEN);
        System.out.println(bze_chengong.run());
        System.out.println("===小冬===");
        BaZiEngine bze_xiaodong = new BaZiEngine(TianGan.BING, DiZhi.YIN, TianGan.BING,
                DiZhi.SHEN, TianGan.DING, DiZhi.WEI, TianGan.WU, DiZhi.SHEN);
        System.out.println(bze_xiaodong.run());

        System.out.println("===孙中山===");
        BaZiEngine bze_zhongshan = new BaZiEngine(TianGan.YI, DiZhi.CHOU, TianGan.DING,
                DiZhi.HAI, TianGan.DING, DiZhi.YOU, TianGan.REN, DiZhi.YIN);
        System.out.println(bze_zhongshan.run());
        System.out.println("===黄兴===");
        BaZiEngine bze_huangxing = new BaZiEngine(TianGan.JIA, DiZhi.XU, TianGan.JIA,
                DiZhi.XU , TianGan.JIA, DiZhi.YIN, TianGan.JIA, DiZhi.XU);
        System.out.println(bze_huangxing.run());
        System.out.println("===袁世凯===");
        BaZiEngine bze_ysk = new BaZiEngine(TianGan.JI, DiZhi.WEI, TianGan.GUI,
                DiZhi.YOU , TianGan.DING, DiZhi.SI, TianGan.DING, DiZhi.WEI);
        System.out.println(bze_ysk.run());
        System.out.println("===无名氏===");
        BaZiEngine bze_g1 = new BaZiEngine(TianGan.JIA, DiZhi.ZI, TianGan.DING,
                DiZhi.MAO , TianGan.GENG, DiZhi.SHEN, TianGan.YI, DiZhi.YOU);
        bze_g1.run();
        System.out.println("===儿子===");
        BaZiEngine bze_son = new BaZiEngine(TianGan.WU, DiZhi.ZI, TianGan.YI,
                DiZhi.CHOU , TianGan.JI, DiZhi.SI, TianGan.REN, DiZhi.SHEN);
        System.out.println(bze_son.run());
        
        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("===某宰相===");
        BaZiEngine bze_zaixiang = new BaZiEngine(TianGan.JIA, DiZhi.SHEN, TianGan.REN,
                DiZhi.SHEN, TianGan.JI, DiZhi.CHOU, TianGan.BING, DiZhi.YIN);
        bze_zaixiang.run();
        System.out.println("===某尚书===");
        BaZiEngine bze_shangshu = new BaZiEngine(TianGan.DING, DiZhi.CHOU, TianGan.YI,
                DiZhi.SI, TianGan.JI, DiZhi.MAO, TianGan.GENG, DiZhi.WU);
        bze_shangshu.run();
        System.out.println("===某宰相2===");
        BaZiEngine bze_zaixiang2 = new BaZiEngine(TianGan.YI, DiZhi.CHOU, TianGan.WU,
                DiZhi.ZI, TianGan.GENG, DiZhi.WU, TianGan.DING, DiZhi.CHOU);
        bze_zaixiang2.run();
        System.out.println("===某礼部尚书===");
        BaZiEngine bze_lbss = new BaZiEngine(TianGan.GENG, DiZhi.SHEN, TianGan.JIA,
                DiZhi.SHEN, TianGan.XIN, DiZhi.WEI, TianGan.REN, DiZhi.CHEN);
        bze_lbss.run();

    }
}
