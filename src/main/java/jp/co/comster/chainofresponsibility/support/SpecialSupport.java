package jp.co.comster.chainofresponsibility.support;

import jp.co.comster.chainofresponsibility.trouble.Trouble;

/**
 * ConcreteHandler<br>
 * Supportクラスを継承している<br>
 * トラブル番号がnumberと一致するなら解決できる
 */
public class SpecialSupport extends Support {
	private int number;
	
	public SpecialSupport(String name, int number) {
		super(name);
		this.number = number;
	}
	
	/**
	 * トラブル番号がnumberと一致するなら解決する
	 * 
	 * @param trouble トラブル
	 * @return 解決できたらtrue、できなかったらfalse
	 */
	@Override
	protected boolean resolve(Trouble trouble) {
		if (trouble.getNumber() == number) {
			return true;
		} else {
			return false;
		}
	}
}
