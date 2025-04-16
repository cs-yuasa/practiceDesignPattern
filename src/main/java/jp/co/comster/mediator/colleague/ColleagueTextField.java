package jp.co.comster.mediator.colleague;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import jp.co.comster.mediator.framework.Mediator;

/**
 * ConcreteColleague<br>
 * Colleagueインターフェース・TextListenerインターフェースを実装し、
 * TextFieldクラスを継承している
 */
public class ColleagueTextField extends TextField implements TextListener, Colleague {
	private Mediator mediator;
	
	public ColleagueTextField(String text, int columns) {
		super(text, columns);
	}
	
	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
	
	@Override
	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);
		// 有効/無効に合わせて背景色を変更する
		setBackground(enabled ? Color.white : Color.lightGray);
	}
	
	/**
	 * 文字列が変化したときに呼び出される<br>
	 * Mediatorに通知する
	 * 
	 * @param e イベント
	 */
	@Override
	public void textValueChanged(TextEvent e) {
		mediator.colleagueChanged();
	}
}
