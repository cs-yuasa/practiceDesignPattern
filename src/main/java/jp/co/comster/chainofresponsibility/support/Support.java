package jp.co.comster.chainofresponsibility.support;

import org.tinylog.Logger;

import jp.co.comster.chainofresponsibility.trouble.Trouble;

/**
 * Handler
 */
public abstract class Support {
	/** トラブル解決者の名前 */
	private String name;
	/** たらい回し先 */
	private Support next;
	
	public Support(String name) {
		this.name = name;
		this.next = null;
	}
	
	public Support setNext(Support next) {
		this.next = next;
		return next;
	}
	
	/**
	 * トラブル解決の手順
	 * 
	 * @param trouble トラブル
	 */
	public void support(Trouble trouble) {
		Support sup = this;
		while(!sup.resolve(trouble)) {
			if (sup.next == null) {
				sup.fail(trouble);
				return;
			}
			sup = sup.next;
		}
		sup.done(trouble);
	}
	
	@Override
	public String toString() {
		return "[" + name + "]";
	}
	
	/**
	 * トラブルを解決しようとする
	 * 
	 * @param trouble トラブル
	 * @return 解決できたらtrue、できなかったらfalse
	 */
	protected abstract boolean resolve(Trouble trouble);
	
	/**
	 * トラブルが解決した場合の処理
	 * 
	 * @param trouble トラブル
	 */
	protected void done(Trouble trouble) {
		Logger.info(trouble + " is resolved by " + this + ".");
	}
	
	/**
	 * トラブルが解決しなかった場合の処理
	 * 
	 * @param trouble トラブル
	 */
	protected void fail(Trouble trouble) {
		Logger.info(trouble + " cannot be resolved.");
	}
}
