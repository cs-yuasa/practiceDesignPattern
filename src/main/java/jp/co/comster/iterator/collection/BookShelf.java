package jp.co.comster.iterator.collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ConcreteAggregate<br>
 * Iterable&lt;Book&gt;インターフェースを実装している
 */
public class BookShelf implements Iterable<Book> {
	/** 複数の本を表すArrayList */
	private ArrayList<Book> books = new ArrayList<>();
	
	/**
	 * 添え字に対応するBookインスタンスを返す
	 * @param index 添え字
	 * @return Bookインスタンス
	 */
	public Book getBookAt(int index) {
		return books.get(index);
	}
	
	/**
	 * 本を追加する
	 * @param book 追加するBookインスタンス
	 */
	public void appendBook(Book book) {
		books.add(book);
	}
	
	/**
	 * booksの長さを返す
	 * @return booksの長さ
	 */
	public int getLength() {
		return books.size();
	}
	
	@Override
	public Iterator<Book> iterator() {
		return new BookShelfIterator(this);
	}
}
