package jp.co.comster.strategy.logic;

import jp.co.comster.strategy.hand.Hand;

/**
 * Strategy
 */
public interface Strategy {
	/**
	 * 次に出す手を得る
	 * 
	 * @return じゃんけんの手を表すenum定数
	 */
	public abstract Hand nextHand();
	
	/**
	 * じゃんけんの結果から学習する
	 * 
	 * @param win 勝ったかどうか(勝った場合はtrue、負けた場合はfalse)
	 */
	public abstract void study(boolean win);
}
