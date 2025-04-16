package jp.co.comster.mediator.colleague;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import jp.co.comster.mediator.framework.Mediator;

/**
 * ConcreteColleague<br>
 * Colleagueインターフェース・ItemListenerインターフェースを実装し、
 * Checkboxクラスを継承している
 */
public class ColleagueCheckbox extends Checkbox implements ItemListener, Colleague {
	private Mediator mediator;
	
	public ColleagueCheckbox(String caption, CheckboxGroup group, boolean state) {
		super(caption, group, state);
	}
	
	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
	
	@Override
	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);
	}
	
	/**
	 * 状態が変化したときに呼び出される<br>
	 * Mediatorに通知する
	 * 
	 * @param e イベント
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		mediator.colleagueChanged();
	}
}
