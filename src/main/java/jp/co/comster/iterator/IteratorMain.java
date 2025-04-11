package jp.co.comster.iterator;

import java.util.Iterator;

import org.tinylog.Logger;

import jp.co.comster.iterator.collection.Book;
import jp.co.comster.iterator.collection.BookShelf;

public class IteratorMain {
	public static void main(String[] args) {
		BookShelf bookShelf = new BookShelf();
		bookShelf.appendBook(new Book("A"));
		bookShelf.appendBook(new Book("B"));
		bookShelf.appendBook(new Book("C"));
		bookShelf.appendBook(new Book("D"));
		
		// 明示的にIteratorを使う方法
		Iterator<Book> it = bookShelf.iterator();
		while (it.hasNext()) {
			Book book = it.next();
			Logger.info(book.getName());
		}
		
		// 拡張for文を使う方法
		for (Book book : bookShelf) {
			Logger.info(book.getName());
		}
	}
}
