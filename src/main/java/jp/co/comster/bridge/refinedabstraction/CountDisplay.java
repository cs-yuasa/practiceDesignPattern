package jp.co.comster.bridge.refinedabstraction;
import jp.co.comster.bridge.abstraction.Display;
import jp.co.comster.bridge.implementor.DisplayImpl;

/**
 * RefinedAbstraction<br>
 * Displayクラスを継承している
 */
public class CountDisplay extends Display {
	public CountDisplay(DisplayImpl impl) {
		super(impl);
	}
	
	/**
	 * 複数回表示する
	 * 
	 * @param times 表示する回数
	 */
	public void multiDisplay(int times) {
		open();
		for (int i = 0; i < times; i++) {
			print();
		}
		close();
	}
}
