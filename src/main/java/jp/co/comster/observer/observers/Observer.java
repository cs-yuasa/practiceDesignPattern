package jp.co.comster.observer.observers;

import jp.co.comster.observer.generator.NumberGenerator;

/**
 * Observer
 */
public interface Observer {
	/**
	 * ジェネレータの内容が更新されたときに呼び出される
	 * 
	 * @param generator ジェネレータ
	 */
	public abstract void update(NumberGenerator generator);
}
