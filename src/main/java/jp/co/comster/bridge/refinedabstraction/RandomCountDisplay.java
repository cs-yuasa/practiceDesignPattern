package jp.co.comster.bridge.refinedabstraction;
import java.util.Random;

import jp.co.comster.bridge.implementor.DisplayImpl;

/**
 * RefinedAbstraction<br>
 * CountDisplayクラスを継承している
 */
public class RandomCountDisplay extends CountDisplay {
	private Random random = new Random();
	
	public RandomCountDisplay(DisplayImpl impl) {
		super(impl);
	}
	
	/**
	 * 0からtimesまでのランダムな回数表示する
	 * 
	 * @param times 表示する上限の回数
	 */
	public void randomDisplay(int times) {
		multiDisplay(random.nextInt(times));
	}
}
