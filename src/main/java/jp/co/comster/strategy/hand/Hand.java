package jp.co.comster.strategy.hand;

public enum Hand {
	// じゃんけんの手を表す3つのenum定数
	ROCK("グー", 0),
	SCISSORS("チョキ", 1),
	PAPER("パー", 2);
	
	/** じゃんけんの手の名前 */
	private String name;
	/** じゃんけんの手の値 */
	private int handvalue;
	
	/** 手の値から定数を得るための配列 */
	private static Hand[] hands = {
	    ROCK, SCISSORS, PAPER
	};
	
	private Hand(String name, int handvalue) {
	    this.name = name;
	    this.handvalue = handvalue;
	}
	
	/**
	 * 手の値からenum定数を得る
	 * 
	 * @param handvalue じゃんけんの手の値
	 * @return じゃんけんの手を表すenum定数
	 */
	public static Hand getHand(int handvalue) {
	    return hands[handvalue];
	}
	
	/**
	 * thisがhより強いときtrue、そうでなければfalse
	 * 
	 * @param h じゃんけんの手を表すenum定数
	 * @return 結果
	 */
	public boolean isStrongerThan(Hand h) {
	    return fight(h) == 1;
	}
	
	/**
	 * thisがhより弱いときtrue、そうでなければfalse
	 * 
	 * @param h じゃんけんの手を表すenum定数
	 * @return 結果
	 */
	public boolean isWeakerThan(Hand h) {
	    return fight(h) == -1;
	}
	
	/**
	 * thisとhのどちらの手が強いか決める<br>
	 * 引き分けは0, thisの勝ちなら1, hの勝ちなら-1
	 * 
	 * @param h じゃんけんの手を表すenum定数
	 * @return 結果
	 */
	private int fight(Hand h) {
		if (this == h) {
			return 0;
		} else if ((this.handvalue + 1) % 3 == h.handvalue) {
			return 1;
		} else {
			return -1;
		}
	}
	
	@Override
	public String toString() {
		return name;
	}
}
