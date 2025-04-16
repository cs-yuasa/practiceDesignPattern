package jp.co.comster.mediator.colleague;

import java.awt.Button;

import jp.co.comster.mediator.framework.Mediator;

/**
 * ConcreteColleague<br>
 * Colleagueインターフェースを実装し、Buttonクラスを継承している
 */
public class ColleagueButton extends Button implements Colleague {
	private Mediator mediator;
	
	public ColleagueButton(String caption) {
		super(caption);
	}
	
	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
	
	@Override
	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);
	}
}
