package jp.co.comster.prototype.framework;

/**
 * Prototype
 */
public interface Product {
	/** 使用処理 */
	public abstract void use(String s);
	/** インスタンスのコピーを作成する */
	public abstract Product createCopy();
}
