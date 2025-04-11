package jp.co.comster.factorymethod.idcard;

import org.tinylog.Logger;

import jp.co.comster.factorymethod.framework.Factory;
import jp.co.comster.factorymethod.framework.Product;

/**
 * ConcreteCreator<br>
 * Factoryクラスを継承している
 */
public class IDCardFactory extends Factory {
	/** 通し番号 */
	private int serial = 100;
	
	@Override
	protected Product createProduct(String owner) {
		return new IDCard(owner, serial++);
	}
	
	@Override
	protected void registerProduct(Product product) {
		Logger.info(product + "を登録しました。");
	}

}
