package jp.co.comster.observer.observers;

import org.tinylog.Logger;

import jp.co.comster.observer.generator.NumberGenerator;

/**
 * ConcreteObserver<br>
 * Observerインターフェースを実装している<br>
 * 数字をそのまま表示する
 */
public class BinaryObserver implements Observer {
	/**
	 * ジェネレータの内容が更新されたときに呼び出される<br>
	 * ジェネレータ内のnumberを2進数して表示する
	 * 
	 * @param generator ジェネレータ
	 */
	@Override
	public void update(NumberGenerator generator) {
		Logger.info("BinaryObserver:" + Integer.toBinaryString(generator.getNumber()) + "(2)");
	}
}
