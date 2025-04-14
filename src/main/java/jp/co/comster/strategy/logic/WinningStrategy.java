package jp.co.comster.strategy.logic;

import java.util.Random;

import jp.co.comster.strategy.hand.Hand;

/**
 * ConcreteStrategy<br>
 * Strategyインターフェースを実装している
 */
public class WinningStrategy implements Strategy {
	private Random random;
	/** 今回勝ったかどうか */
	private boolean won = false;
	/** 前回出した手を表すenum定数 */
	private Hand prevHand;
	
	/**
	 * 乱数を生成するコンストラクタ
	 *  
	 * @param seed 初期シード値
	 */
	public WinningStrategy(int seed) {
		random = new Random(seed);
	}
	
	/**
	 * 次に出す手を得る<br>
	 * 前回勝っていれば、同じ手を得る<br>
	 * そうでなければランダムに手を得る
	 * 
	 * @return じゃんけんの手を表すenum定数
	 */
	@Override
	public Hand nextHand() {
		if (!won) {
			prevHand = Hand.getHand(random.nextInt(3));
		}
		return prevHand;
	}
	
	/**
	 * じゃんけんの結果から学習する<br>
	 * 勝ったら記憶する
	 * 
	 * @param win 勝ったかどうか(勝った場合はtrue、負けた場合はfalse)
	 */
	@Override
	public void study(boolean win) {
		won = win;
	}
}
