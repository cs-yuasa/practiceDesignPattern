package jp.co.comster.strategy.player;

import jp.co.comster.strategy.hand.Hand;
import jp.co.comster.strategy.logic.Strategy;

/**
 * Context
 */
public class Player {
	private String name;
	private Strategy strategy;
	/** 勝ち数 */
	private int wincount;
	/** 負け数 */
	private int losecount;
	/** ゲーム数 */
	private int gamecount;
	
	public Player(String name, Strategy strategy) {
		this.name = name;
		this.strategy = strategy;
	}
	
	/**
	 * 次に出す手を得る
	 * 
	 * @return じゃんけんの手を表すenum定数
	 */
	public Hand nextHand() {
		return strategy.nextHand();
	}
	
	/**
	 * 勝った場合の処理
	 */
	public void win() {
		strategy.study(true);
		wincount++;
		gamecount++;
	}
	
	/**
	 * 負けた場合の処理
	 */
	public void lose() {
		strategy.study(false);
		losecount++;
		gamecount++;
	}
	
	/**
	 * 引き分けの場合の処理
	 */
	public void even() {
		gamecount++;
	}
	
	@Override
	public String toString() {
		return "["
			+ name + ":"
			+ gamecount + " games, "
			+ wincount + " win, "
			+ losecount + " lose"
			+ "]";
	}
}
