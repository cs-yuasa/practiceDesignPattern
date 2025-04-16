package jp.co.comster.observer.generator;

/**
 * ConcreteSubject<br>
 * NumberGeneratorクラスを継承している<br>
 * 一定値増加させながら数を複数生成する
 */
public class IncrementalNumberGenerator extends NumberGenerator {
	/** 現在の数 */
	private int number;
	/** 終了値(この値を含まない) */
	private int end;
	/** 増加値 */
	private int step;
	
	public IncrementalNumberGenerator(int start, int end, int step) {
		this.number = start;
		this.end = end;
		this.step = step;
	}
	
	@Override
	public int getNumber() {
		return number;
	}
	
	/**
	 *  一定値(step)増加させながら数を複数生成する
	 */
	@Override
	public void execute() {
		while (number < end) {
			notifyObservers();
			number += step;
		}
	}
}
