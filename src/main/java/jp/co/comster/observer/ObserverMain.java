package jp.co.comster.observer;

import jp.co.comster.observer.generator.IncrementalNumberGenerator;
import jp.co.comster.observer.generator.NumberGenerator;
import jp.co.comster.observer.observers.BinaryObserver;
import jp.co.comster.observer.observers.DigitObserver;
import jp.co.comster.observer.observers.GraphObserver;
import jp.co.comster.observer.observers.Observer;

public class ObserverMain {
	public static void main(String[] args) {
		NumberGenerator generator = new IncrementalNumberGenerator(10, 42, 4);
		Observer observer1 = new DigitObserver();
		Observer observer2 = new GraphObserver();
		Observer observer3 = new BinaryObserver();
		generator.addObserver(observer1);
		generator.addObserver(observer2);
		generator.addObserver(observer3);
		generator.execute();
	}
}
