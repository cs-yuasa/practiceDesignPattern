package jp.co.comster.builder.framework;

/**
 * Builder
 */
public interface Builder {
	/**
	 * タイトルを作成する
	 * @param title タイトル
	 */
	public abstract void makeTitle(String title);
	
	/**
	 * 文字列を作成する
	 * @param str 文字列
	 */
	public abstract void makeString(String str);
	
	/**
	 * アイテムを作成する
	 * @param items アイテム
	 */
	public abstract void makeItems(String[] items);
	
	/**
	 * 終了処理
	 */
	public abstract void close();
}
