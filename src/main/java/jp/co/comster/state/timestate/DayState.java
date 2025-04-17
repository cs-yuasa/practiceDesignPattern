package jp.co.comster.state.timestate;

import jp.co.comster.state.context.Context;

/**
 * ConcreteState<br>
 * Stateインターフェースを実装している<br>
 * 昼間の状態を表すクラス
 */
public class DayState implements State {
	private static DayState singleton = new DayState();
	
	private DayState() {}
	
	public static State getInstance() {
		return singleton;
	}
	
	@Override
	public void doClock(Context context, int hour) {
		if (hour < 8 || 21 <= hour) {
			context.changeState(NightState.getInstance());
		} else if (12 <= hour && hour < 13) {
			context.changeState(NoonState.getInstance());
		}
	}
	
	@Override
	public void doUse(Context context) {
		context.recordLog("金庫使用(昼間)");
	}
	
	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("非常ベル(昼間)");
		context.changeState(UrgentState.getInstance());
	}
	
	@Override
	public void doPhone(Context context) {
		context.callSecurityCenter("通常の通話(昼間)");
	}
	
	@Override
	public String toString() {
		return "[昼間]";
	}
}
