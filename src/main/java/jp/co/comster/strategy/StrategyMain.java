package jp.co.comster.strategy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.tinylog.Logger;

import jp.co.comster.strategy.hand.Hand;
import jp.co.comster.strategy.logic.ProbStrategy;
import jp.co.comster.strategy.logic.WinningStrategy;
import jp.co.comster.strategy.player.Player;

public class StrategyMain {
	public static void main(String[] args) {
		if (args.length != 2) {
			Logger.info("\n"
					+ "Usage: java Main randomseed1 randomseed2\n"
					+ "Example: java Main 314 15");
			System.exit(0);
		}
		int seed1 = Integer.parseInt(args[0]);
		int seed2 = Integer.parseInt(args[1]);
		Player player1 = new Player("Taro", new WinningStrategy(seed1));
		Player player2 = new Player("Hana", new ProbStrategy(seed2));
		for (int i = 0; i < 10000; i++) {
			Hand nextHand1 = player1.nextHand();
			Hand nextHand2 = player2.nextHand();
			if (nextHand1.isStrongerThan(nextHand2)) {
//				Logger.info("Winner:" + player1);
				player1.win();
				player2.lose();
			} else if (nextHand2.isStrongerThan(nextHand1)) {
//				Logger.info("Winner:" + player2);
				player1.lose();
				player2.win();
			} else {
//				Logger.info("Even...");
				player1.even();
				player2.even();
			}
		}
		Logger.info("Total result:");
		Logger.info(player1);
		Logger.info(player2);
		
		
		List<String> list = Arrays.asList("D", "B", "C", "E", "A");
		Logger.info("並べ替え対象：" + list);
		
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
		Logger.info("辞書式順序で小さい順" + list);
		list.sort(new Comparator<String>() {
		    @Override
		    public int compare(String s1, String s2) {
		        return s2.compareTo(s1);
		    }
		});
		Logger.info("辞書式順序で大きい順" + list);
	}
}
