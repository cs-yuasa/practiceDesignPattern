package jp.co.comster.mediator.colleague;

import jp.co.comster.mediator.framework.Mediator;

/**
 * Colleague
 */
public interface Colleague {
	/**
	 * Mediatorを設定する
	 * 
	 * @param mediator Mediatorクラスのインスタンス
	 */
	public abstract void setMediator(Mediator mediator);
	
	// Mediatorから有効/無効が指示される
	/**
	 * 有効/無効状態をMediatorが指示する
	 * 
	 * @param enabled 有効ならtrue、無効ならfalse
	 */
	public abstract void setColleagueEnabled(boolean enabled);
}
