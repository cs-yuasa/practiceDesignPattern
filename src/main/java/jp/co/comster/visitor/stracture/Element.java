package jp.co.comster.visitor.stracture;

import jp.co.comster.visitor.behavior.Visitor;

/**
 * Element
 */
public interface Element {
	/**
	 * 自クラスのインスタンスを引数にvisitを呼び出す
	 * 
	 * @param v Visitorクラスのインスタンス
	 */
	public abstract void accept(Visitor v);
}
