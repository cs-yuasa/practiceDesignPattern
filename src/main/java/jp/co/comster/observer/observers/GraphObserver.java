package jp.co.comster.observer.observers;

import org.tinylog.Logger;

import jp.co.comster.observer.generator.NumberGenerator;

/**
 * ConcreteObserver<br>
 * Observerインターフェースを実装している<br>
 * 数字と同じ数の*を表示する
 */
public class GraphObserver implements Observer {
	/**
	 * ジェネレータの内容が更新されたときに呼び出される<br>
	 * ジェネレータ内のnumberと同じ数の*を表示する
	 * 
	 * @param generator ジェネレータ
	 */
	@Override
	public void update(NumberGenerator generator) {
		StringBuilder output = new StringBuilder("GraphObserver:");
		int count = generator.getNumber();
		for (int i = 0; i < count; i++) {
			output.append("*");
		}
		Logger.info(output.toString());
	}
}
