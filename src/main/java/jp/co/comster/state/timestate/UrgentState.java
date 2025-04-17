package jp.co.comster.state.timestate;

import jp.co.comster.state.context.Context;

/**
 * ConcreteState<br>
 * Stateインターフェースを実装している<br>
 * 非常時の状態を表すクラス
 */
public class UrgentState implements State {
	private static UrgentState singleton = new UrgentState();
	
	private UrgentState() {}
	
	public static State getInstance() {
		return singleton;
	}
	
	@Override
	public void doClock(Context context, int hour) {
		// 何もしない
	}
	
	@Override
	public void doUse(Context context) {
		context.recordLog("非常：非常時の金庫使用！");
	}
	
	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("非常ベル(非常時)");
	}
	
	@Override
	public void doPhone(Context context) {
		context.callSecurityCenter("通常の通話(非常時)");
	}
	
	@Override
	public String toString() {
		return "[非常時]";
	}
}
