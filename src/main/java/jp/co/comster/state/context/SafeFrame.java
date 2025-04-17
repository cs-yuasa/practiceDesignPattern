package jp.co.comster.state.context;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

import org.tinylog.Logger;

import jp.co.comster.state.timestate.DayState;
import jp.co.comster.state.timestate.State;

/**
 * Context<br>
 * Contextインターフェースを実装し、Frameクラスを継承している
 */
public class SafeFrame extends Frame implements Context {
	/** 現在時刻表示 */
	private TextField textClock = new TextField(60);
	/** 警備センター出力 */
	private TextArea textScreen = new TextArea(10, 60);
	/** 金庫使用ボタン */
	private Button buttonUse = new Button("金庫使用");
	/** 非常ベルボタン */
	private Button buttonAlarm = new Button("非常ベル");
	/** 通常通話ボタン */
	private Button buttonPhone = new Button("通常通話");
	/** 終了ボタン */
	private Button buttonExit = new Button("終了");
	
	/** 現在の状態 */
	private State state = DayState.getInstance();
	
	public SafeFrame(String title) {
		super(title);
		setBackground(Color.lightGray);
		setLayout(new BorderLayout());
		// textClockを配置
		add(textClock, BorderLayout.NORTH);
		textClock.setEditable(false);
		// textScreenを配置
		add(textScreen, BorderLayout.CENTER);
		textScreen.setEditable(false);
		// パネルにボタンを格納
		Panel panel = new Panel();
		panel.add(buttonUse);
		panel.add(buttonAlarm);
		panel.add(buttonPhone);
		panel.add(buttonExit);
		// そのパネルを配置
		add(panel, BorderLayout.SOUTH);
		// 表示
		pack();
		setVisible(true);
		// リスナーの設定
		buttonUse.addActionListener(e -> state.doUse(this));
		buttonAlarm.addActionListener(e -> state.doAlarm(this));
		buttonPhone.addActionListener(e -> state.doPhone(this));
		buttonExit.addActionListener(e -> this.dispose());
	}
	
	@Override
	public void setClock(int hour) {
		String clockstring = String.format("現在時刻は%02d:00", hour);
		textClock.setText(clockstring);
		state.doClock(this, hour);
	}
	
	@Override
	public void changeState(State state) {
		Logger.info(this.state + "から" + state + "へ状態が変化しました。");
		this.state = state;
	}
	
	@Override
	public void callSecurityCenter(String msg) {
		textScreen.append("call! " + msg + "\n");
	}
	
	@Override
	public void recordLog(String msg) {
		textScreen.append("record ... " + msg + "\n");
	}
}
