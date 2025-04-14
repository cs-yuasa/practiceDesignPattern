package jp.co.comster.abstractfactory.factory;

public abstract class Item {
	
	/**
	 * 見出し
	 */
	protected String caption;
	
	public Item(String caption) {
		this.caption = caption;
	}
	
	/**
	 * HTMLの文字列を作成する
	 * 
	 * @return HTMLの文字列
	 */
	public abstract String makeHTML();
}
