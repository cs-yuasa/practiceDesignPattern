package jp.co.comster.strategy.logic;

import java.util.Random;

import jp.co.comster.strategy.hand.Hand;

/**
 * ConcreteStrategy<br>
 * Strategyインターフェースを実装している
 */
public class RandomStrategy implements Strategy {
	private Random random;
	
	/**
	 * 乱数を生成するコンストラクタ
	 *  
	 * @param seed 初期シード値
	 */
	public RandomStrategy(int seed) {
		random = new Random(seed);
	}
	
	/**
	 * ランダムに次に出す手を得る
	 * 
	 * @return じゃんけんの手を表すenum定数
	 */
	@Override
	public Hand nextHand() {
		return Hand.getHand(random.nextInt(3));
	}
	
	/**
	 * じゃんけんの結果から学習する<br>
	 * ランダムなので何もしない
	 * 
	 * @param win 勝ったかどうか(勝った場合はtrue、負けた場合はfalse)
	 */
	@Override
	public void study(boolean win) {}
}
