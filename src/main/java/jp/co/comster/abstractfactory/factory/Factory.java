package jp.co.comster.abstractfactory.factory;

import org.tinylog.Logger;

/**
 * AbstractFactory
 */
public abstract class Factory {
	
	/**
	 * 指定したクラスを動的に読み込み、コンストラクタを得てインスタンスを作成する
	 * 
	 * @param classname インスタンスを生成するクラス名
	 * @return クラス名に対応するインスタンス(見つからない場合はnull9
	 */
	public static Factory getFactory(String classname) {
		Factory factory = null;
		try {
			factory = (Factory)Class.forName(classname).getDeclaredConstructor().newInstance();
		} catch (ClassNotFoundException e) {
			Logger.error("クラス " + classname + " が見つかりません。");
			Logger.error(e, "実行時に引数に含めたjavaファイルをコンパイル対象に含めてください。");
		} catch (Exception e) {
			Logger.error(e, "Exception occurred");
		}
		return factory;
	}
	
	/**
	 * 見出しとURLをもとに、Linkクラスを継承したクラスのインスタンスを作成する
	 * 
	 * @param caption 見出し
	 * @param url URL
	 * @return Linkクラスを継承したクラスのインスタンス
	 */
	public abstract Link createLink(String caption, String url);
	
	/**
	 * 見出しをもとにTrayクラスを継承したクラスのインスタンスを作成する
	 * 
	 * @param caption 見出し
	 * @return Trayクラスを継承したクラスのインスタンス
	 */
	public abstract Tray createTray(String caption);
	
	/**
	 * タイトルと著者をもとに、Pageクラスを継承したクラスのインスタンスを作成する
	 * 
	 * @param title タイトル
	 * @param author 著者
	 * @return Pageクラスを継承したクラスのインスタンス
	 */
	public abstract Page createPage(String title, String author);
	
	/**
	 * Yahooのリンクのみからなるページを作成する
	 * 
	 * @return Pageクラスを継承したクラスのインスタンス
	 */
	public Page createYahooPage() {
		Link link = createLink("Yahoo!", "https://www.yahoo.com/");
		Page page = createPage("Yahoo!", "Yahoo!");
		page.add(link);
		return page;
	}
}
