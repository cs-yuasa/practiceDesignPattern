package jp.co.comster.observer.generator;

import java.util.Random;

/**
 * ConcreteSubject<br>
 * NumberGeneratorクラスを継承している<br>
 * ランダムに数を複数生成する
 */
public class RandomNumberGenerator extends NumberGenerator {
	private Random random = new Random();
	/** 現在の数 */
	private int number;
	
	@Override
	public int getNumber() {
		return number;
	}
	
	/**
	 *  ランダムに数を複数生成する
	 */
	@Override
	public void execute() {
		for (int i = 0; i < 10; i++) {
			number = random.nextInt(50);
			notifyObservers();
		}
	}
}
