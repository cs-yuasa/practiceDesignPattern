package jp.co.comster.state.timestate;

import jp.co.comster.state.context.Context;

/**
 * State
 */
public interface State {
	/**
	 * 
	 * @param context コンテキスト
	 * @param hour 時刻
	 */
	public abstract void doClock(Context context, int hour);
	
	/**
	 * 金庫を使用する
	 * 
	 * @param context コンテキスト
	 */
	public abstract void doUse(Context context);
	
	/**
	 * 非常ベルを鳴らす
	 * 
	 * @param context コンテキスト
	 */
	public abstract void doAlarm(Context context);
	
	/**
	 * 通常通話をする
	 * 
	 * @param context コンテキスト
	 */
	public abstract void doPhone(Context context);
}
