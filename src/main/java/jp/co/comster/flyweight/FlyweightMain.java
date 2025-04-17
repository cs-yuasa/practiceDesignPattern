package jp.co.comster.flyweight;

import org.tinylog.Logger;

import jp.co.comster.flyweight.bignumber.BigString;

public class FlyweightMain {
	private static BigString[] bsarray = new BigString[10000];
	
	public static void main(String[] args) {
		if (args.length == 0) {
			Logger.info("\n"
					+ "Usage: java Main digits\n"
					+ "Example: java Main 1212123");
			System.exit(0);
		}
		
		
		Logger.info("共有した場合: ");
		for (int i = 0; i < bsarray.length; i++) {
			bsarray[i] = new BigString(args[0], true);
		}
		showMemory();
		Logger.info("共有しない場合: ");
		for (int i = 0; i < bsarray.length; i++) {
			bsarray[i] = new BigString(args[0], false);
		}
		showMemory();
		
		BigString bs = new BigString(args[0], true);
		bs.print();
	}
	
	public static void showMemory() {
		Runtime.getRuntime().gc();
		long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		Logger.info("使用メモリ = " + used);
	}
}
