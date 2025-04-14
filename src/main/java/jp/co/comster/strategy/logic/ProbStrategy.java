package jp.co.comster.strategy.logic;

import java.util.Random;

import jp.co.comster.strategy.hand.Hand;

/**
 * ConcreteStrategy<br>
 * Strategyインターフェースを実装している
 */
public class ProbStrategy implements Strategy {
	private Random random;
	/** 前回出した手 */
	private int prevHandValue = 0;
	/** 今回出す手 */
	private int currentHandValue = 0;
	/**
	 * 過去の勝ち数の表<br>
	 * history[前回出した手][今回出す手]<br>
	 * history[0][0]　グー、グーと自分が出した時の過去の勝ち数<br>
	 * history[0][1]　グー、チョキと自分が出した時の過去の勝ち数<br>
	 * history[0][2]　グー、パーと自分が出した時の過去の勝ち数
	 */
	private int[][] history = {
		{ 1, 1, 1, },
		{ 1, 1, 1, },
		{ 1, 1, 1, },
	};
	
	/**
	 * 乱数を生成するコンストラクタ
	 *  
	 * @param seed 初期シード値
	 */
	public ProbStrategy(int seed) {
		random = new Random(seed);
	}
	
	/**
	 * 過去の勝ち数から、勝率が高い手を出す確率を上げ、次に出す手を得る
	 * 
	 * @return じゃんけんの手を表すenum定数
	 */
	@Override
	public Hand nextHand() {
		int bet = random.nextInt(getSum(currentHandValue));
		int handvalue = -1;
		if (bet < history[currentHandValue][0]) {
			handvalue = 0;
		} else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) {
			handvalue = 1;
		} else {
			handvalue = 2;
		}
		prevHandValue = currentHandValue;
		currentHandValue = handvalue;
		return Hand.getHand(handvalue);
	}
	
	/**
	 * 今回出した手をもとに次に出すすべての手の過去の勝ち数の合計を求める
	 * 
	 * @param handvalue 今回出した手
	 * @return 合計
	 */
	private int getSum(int handvalue) {
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += history[handvalue][i];
		}
		return sum;
	}
	
	/**
	 * じゃんけんの結果から学習する<br>
	 * 過去の勝ち数の表を更新する
	 * 
	 * @param win 勝ったかどうか(勝った場合はtrue、負けた場合はfalse)
	 */
	@Override
	public void study(boolean win) {
		if (win) {
			history[prevHandValue][currentHandValue]++;
		} else {
			history[prevHandValue][(currentHandValue + 1) % 3]++;
			history[prevHandValue][(currentHandValue + 2) % 3]++;
		}
	}
}
