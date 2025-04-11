package jp.co.comster.factorymethod.framework;

/**
 * Creator
 */
public abstract class Factory {
	/**
	 * 所持者をもとに作成・登録処理を行う
	 * @param owner 所持者
	 * @return Productクラスを継承したクラスのインスタンス
	 */
	public final Product create(String owner) {
		Product p = createProduct(owner);
		registerProduct(p);
		return p;
	}
	
	/**
	 * 所持者をもとにProductクラスを継承したクラスのインスタンスを作成する
	 * @param owner 所持者
	 * @return Productクラスを継承したクラスのインスタンス
	 */
	protected abstract Product createProduct(String owner);
	
	/**
	 * インスタンスをもとに登録処理を行う
	 * @param product Productクラスを継承したクラスのインスタンス
	 */
	protected abstract void registerProduct(Product product);
}
