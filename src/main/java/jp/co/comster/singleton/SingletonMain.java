package jp.co.comster.singleton;

import org.tinylog.Logger;

import jp.co.comster.singleton.instance.TicketMaster;
import jp.co.comster.singleton.instance.Triple;

public class SingletonMain {
	public static void main(String[] args) {
		Logger.info("TickMaster Start.");
		for (int i = 0; i < 10; i++) {
			Logger.info(i + ":" + TicketMaster.getInstance().getNextTicketNumber());
		}
		Logger.info("TickMaster End.");
		
		Logger.info("Triple Start.");
		Triple a1 = Triple.getInstance("ALPHA");
		Triple b1 = Triple.getInstance("BETA");
		Triple c1 = Triple.getInstance("GAMMA");
		Triple a2 = Triple.getInstance("ALPHA");
		Triple b2 = Triple.getInstance("BETA");
		Triple c2 = Triple.getInstance("GAMMA");
		// 同じインスタンスかどうか
		if (a1 == a2) {
			Logger.info("a1 == a2 (" + a1 + ")");
		} else {
			Logger.info("a1 != a2");
		}
		if (b1 == b2) {
			Logger.info("b1 == b2 (" + b1 + ")");
		} else {
			Logger.info("b1 != b2");
		}
		if (c1 == c2) {
			Logger.info("c1 == c2 (" + c1 + ")");
		} else {
			Logger.info("c1 != c2");
		}
		Logger.info("Triple End.");
	}
}
