package jp.co.comster.chainofresponsibility.support;

import jp.co.comster.chainofresponsibility.trouble.Trouble;

/**
 * ConcreteHandler<br>
 * Supportクラスを継承している<br>
 * トラブル番号がlimit未満なら解決できる
 */
public class LimitSupport extends Support {
	private int limit;
	
	public LimitSupport(String name, int limit) {
		super(name);
		this.limit = limit;
	}
	
	/**
	 * トラブル番号がlimit未満なら解決する
	 * 
	 * @param trouble トラブル
	 * @return 解決できたらtrue、できなかったらfalse
	 */
	@Override
	protected boolean resolve(Trouble trouble) {
		if (trouble.getNumber() < limit) {
			return true;
		} else {
			return false;
		}
	}
}
