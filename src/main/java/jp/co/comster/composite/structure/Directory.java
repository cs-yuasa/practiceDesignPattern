package jp.co.comster.composite.structure;

import java.util.ArrayList;
import java.util.List;

import org.tinylog.Logger;

/**
 * Composite<br>
 * Entryクラスを継承している
 */
public class Directory extends Entry {
	private String name;
	/** 再起的構造のためスーパークラスのリストを持つ */
	private List<Entry> directory = new ArrayList<>();
	
	public Directory(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	/**
	 * 再起的呼び出しを行いサイズの合計を取得して返す
	 */
	@Override
	public int getSize() {
		int size = 0;
		for (Entry entry: directory) {
			size += entry.getSize();
		}
		return size;
	}
	
	/**
	 * 再起的呼び出しを行い一覧を表示する
	 * 
	 * @param prefix 前につける文字列
	 */
	@Override
	protected void printList(String prefix) {
		Logger.info(prefix + "/" + this);
		for (Entry entry: directory) {
			entry.printList(prefix + "/" + name);
		}
	}
	
	/**
	 * 要素を追加して階層構造にする
	 * 
	 * @param entry 追加する要素
	 * @return 自インスタンス
	 */
	public Entry add(Entry entry) {
		directory.add(entry);
		entry.parent = this;
		return this;
	}
}
