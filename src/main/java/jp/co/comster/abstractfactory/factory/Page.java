package jp.co.comster.abstractfactory.factory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.tinylog.Logger;

/**
 * AbstractProduct
 */
public abstract class Page {
	protected String title;
	protected String author;
	/** ItemクラスのList */
	protected List<Item> content = new ArrayList<>();
	
	public Page(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	/**
	 * ItemクラスのListにitemを追加する
	 * @param item Itemクラスを継承したクラスのインスタンス
	 */
	public void add(Item item) {
		content.add(item);
	}
	
	/**
	 * ファイルパスをもとにファイルを作成する
	 * 
	 * @param filepass ファイルパス
	 */
	public void output(String filepass) {
		try {
			Files.writeString(Path.of(filepass), makeHTML(),
					StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING,
					StandardOpenOption.WRITE);
			Logger.info("HTMLファイルが" + filepass + "に作成されました。");
		} catch (IOException e) {
			Logger.error(e, "IOException occurred");
		}
	}
	
	/**
	 * HTMLの文字列を作成する
	 * 
	 * @return HTMLの文字列
	 */
	public abstract String makeHTML();
}
