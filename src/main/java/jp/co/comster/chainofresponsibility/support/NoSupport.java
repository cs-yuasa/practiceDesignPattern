package jp.co.comster.chainofresponsibility.support;

import jp.co.comster.chainofresponsibility.trouble.Trouble;

/**
 * ConcreteHandler<br>
 * Supportクラスを継承している<br>
 * どのトラブルも解決できない
 */
public class NoSupport extends Support {
	public NoSupport(String name) {
		super(name);
	}
	
	/**
	 * どのトラブルも解決できない
	 * 
	 * @param trouble トラブル
	 * @return 解決できたらtrue、できなかったらfalse
	 */
	@Override
	protected boolean resolve(Trouble trouble) {
		return false;
	}
}
