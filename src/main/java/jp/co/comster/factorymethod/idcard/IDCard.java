package jp.co.comster.factorymethod.idcard;

import org.tinylog.Logger;

import jp.co.comster.factorymethod.framework.Product;

/**
 * Productクラスを継承している
 */
public class IDCard extends Product {
	/** 所持者 */
	private String owner;
	/** 通し番号 */
	private int serial;
	
	IDCard(String owner, int serial) {
		Logger.info(owner + "(" + serial + "番)のカードを作ります。");
		this.owner = owner;
		this.serial = serial;
	}
	
	@Override
	public void use() {
		Logger.info(this + "を使います。");
	}
	
	@Override
	public String toString() {
		return "[IDCard:" + owner + "(" + serial + ")]";
	}
	
	public String getOwner() {
		return owner;
	}
}
