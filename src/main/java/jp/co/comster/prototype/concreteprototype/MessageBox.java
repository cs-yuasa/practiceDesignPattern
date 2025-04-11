package jp.co.comster.prototype.concreteprototype;

import org.tinylog.Logger;

import jp.co.comster.prototype.framework.Product;

/**
 * ConcretePrototype<br>
 * Productインターフェースを実装している
 */
public class MessageBox implements Product {
	/** 飾り文字 */
	private char decochar;
	
	public MessageBox(char decochar) {
		this.decochar = decochar;
	}
	
	/**
	 * コピーコンストラクタ
	 * @param prototype コピーするインスタンス
	 */
	public MessageBox(MessageBox prototype) {
		this.decochar = prototype.decochar;
	}
	
	/**
	 * 上下左右に飾り文字を入れる
	 * @param s 飾り文字を入れる対象の文字列
	 */
	@Override
	public void use(String s) {
		StringBuilder sb = new StringBuilder();
		int decolen = 1 + s.length() + 1;
		sb.append("\n");
		for (int i = 0; i < decolen; i++) {
			sb.append(decochar);
		}
		sb.append("\n")
		  .append(decochar + s + decochar)
		  .append("\n");
		for (int i = 0; i < decolen; i++) {
			sb.append(decochar);
		}
		Logger.info(sb);
	}
	
	@Override
	public Product createCopy() {
		return new MessageBox(this);
	}
}
