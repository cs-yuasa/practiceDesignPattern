package jp.co.comster.chainofresponsibility.support;

import jp.co.comster.chainofresponsibility.trouble.Trouble;

/**
 * ConcreteHandler<br>
 * Supportクラスを継承している<br>
 * トラブル番号が奇数なら解決できる
 */
public class OddSupport extends Support {
	public OddSupport(String name) {
		super(name);
	}
	
	/**
	 * トラブル番号が奇数なら解決する
	 * 
	 * @param trouble トラブル
	 * @return 解決できたらtrue、できなかったらfalse
	 */
	@Override
	protected boolean resolve(Trouble trouble) {
		if (trouble.getNumber() % 2 == 1) {
			return true;
		} else {
			return false;
		}
	}
}
