package jp.co.comster.state.context;

import jp.co.comster.state.timestate.State;

/**
 * Context
 */
public interface Context {
	/**
	 * 時刻の設定
	 * 
	 * @param hour 時刻
	 */
	public abstract void setClock(int hour);
	
	/**
	 *  状態を変化させる
	 * 
	 * @param state 変化後の状態
	 */
	public abstract void changeState(State state);
	
	/**
	 * 警備員呼び出し
	 * 
	 * @param msg メッセージ
	 */
	public abstract void callSecurityCenter(String msg);
	
	/**
	 * 警備センター記録
	 * 
	 * @param msg
	 */
	public abstract void recordLog(String msg);
}
