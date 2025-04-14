package jp.co.comster.abstractfactory.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * AbstractProduct<br>
 * Itemクラスを継承している
 */
public abstract class Tray extends Item {
	/** ItemクラスのList */
	protected List<Item> tray = new ArrayList<>();
	
	public Tray(String caption) {
		super(caption);
	}
	
	/**
	 * ItemクラスのListにitemを追加する
	 * @param item Itemクラスを継承したクラスのインスタンス
	 */
	public void add(Item item) {
		tray.add(item);
	}
}
