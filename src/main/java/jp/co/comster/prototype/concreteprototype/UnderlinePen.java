package jp.co.comster.prototype.concreteprototype;

import org.tinylog.Logger;

import jp.co.comster.prototype.framework.Product;

/**
 * ConcretePrototype<br>
 * Productインターフェースを実装している
 */
public class UnderlinePen implements Product {
	/** 飾り文字 */
	private char ulchar;
	
	public UnderlinePen(char ulchar) {
		this.ulchar = ulchar;
	}
	
	/**
	 * コピーコンストラクタ
	 * @param prototype コピーするインスタンス
	 */
	public UnderlinePen(UnderlinePen prototype) {
		this.ulchar = prototype.ulchar;
	}
	
	/**
	 * 下に飾り文字を入れる
	 * @param s 飾り文字を入れる対象の文字列
	 */
	@Override
	public void use(String s) {
		StringBuilder sb = new StringBuilder();
		int ulen = s.length();
		sb.append("\n")
		  .append(s)
		  .append("\n");
		for (int i = 0; i < ulen; i++) {
			sb.append(ulchar);
		}
		Logger.info(sb);
	}
	
	@Override
	public Product createCopy() {
		return new UnderlinePen(this);
	}
}
