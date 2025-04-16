package jp.co.comster.observer.observers;

import org.tinylog.Logger;

import jp.co.comster.observer.generator.NumberGenerator;

/**
 * ConcreteObserver<br>
 * Observerインターフェースを実装している<br>
 * 数字をそのまま表示する
 */
public class DigitObserver implements Observer {
	/**
	 * ジェネレータの内容が更新されたときに呼び出される<br>
	 * ジェネレータ内のnumberをそのまま表示する
	 * 
	 * @param generator ジェネレータ
	 */
	@Override
	public void update(NumberGenerator generator) {
		Logger.info("DigitObserver:" + generator.getNumber());
	}
}
