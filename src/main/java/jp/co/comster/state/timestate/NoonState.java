package jp.co.comster.state.timestate;

import jp.co.comster.state.context.Context;

/**
 * ConcreteState<br>
 * Stateインターフェースを実装している<br>
 * 昼食時の状態を表すクラス
 */
public class NoonState implements State {
	private static NoonState singleton = new NoonState();
	
	private NoonState() {}
	
	public static State getInstance() {
		return singleton;
	}
	
	@Override
	public void doClock(Context context, int hour) {
		if (hour < 8 || 21 <= hour) {
			context.changeState(NightState.getInstance());
		} else if (8 <= hour && hour < 12 || 13 <= hour && hour < 21) {
			context.changeState(DayState.getInstance());
		}
	}
	
	@Override
	public void doUse(Context context) {
		context.recordLog("非常：昼食時の金庫使用！");
	}
	
	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("非常ベル(昼食時)");
		context.changeState(UrgentState.getInstance());
	}
	
	@Override
	public void doPhone(Context context) {
		context.callSecurityCenter("昼食時の通話録音");
	}
	
	@Override
	public String toString() {
		return "[昼食時]";
	}
}
