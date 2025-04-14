package jp.co.comster.bridge.refinedabstraction;
import jp.co.comster.bridge.implementor.DisplayImpl;

/**
 * RefinedAbstraction<br>
 * CountDisplayクラスを継承している
 */
public class IncreaseDisplay extends CountDisplay {
	/** 増加量 */
	private int step;
	
	public IncreaseDisplay(DisplayImpl impl, int step) {
		super(impl);
		this.step = step;
	}
	
	/**
	 * 表示処理の回数を増加させながら、複数回表示する
	 * 
	 * @param times 表示する回数
	 */
	public void increaseDisplay(int times) {
		int count = 0;
		for (int i = 0; i < times; i++) {
			multiDisplay(count);
			count += step;
		}
	}
}
