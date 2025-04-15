package jp.co.comster.visitor.stracture;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jp.co.comster.visitor.behavior.SizeVisitor;
import jp.co.comster.visitor.behavior.Visitor;

/**
 * ConcreteElement<br>
 * Entryクラスを継承し、Iterable&lt;Entry&gt;インターフェースを実装している
 */
public class Directory extends Entry implements Iterable<Entry> {
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
		SizeVisitor v = new SizeVisitor();
		accept(v);
		return v.getSize();
	}
	
	/**
	 * 要素を追加する
	 * 
	 * @param entry 追加する要素
	 * @return 自インスタンス
	 */
	public Entry add(Entry entry) {
		directory.add(entry);
		return this;
	}
	
	/**
	 * ディレクトリ内のエントリに対するイテレータを返す
	 * 
	 * @return Entryクラスのイテレータ
	 */
	@Override
	public Iterator<Entry> iterator() {
		return directory.iterator();
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
