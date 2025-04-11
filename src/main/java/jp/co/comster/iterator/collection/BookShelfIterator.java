package jp.co.comster.iterator.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ConcreteIterator<br>
 * Iterator&lt;Book&gt;インターフェースを実装している
 */
public class BookShelfIterator implements Iterator<Book> {
	/** 本棚 */
	private BookShelf bookShelf;
	/** 添え字 */
	private int index;
	
	public BookShelfIterator(BookShelf bookShelf) {
		this.bookShelf = bookShelf;
		this.index = 0;
	}

	@Override
	public boolean hasNext() {
		if (index < bookShelf.getLength()) {
			return true;
		}
		return false;
	}
	
	@Override
	public Book next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		Book book = bookShelf.getBookAt(index);
		index++;
		return book;
	}

}
