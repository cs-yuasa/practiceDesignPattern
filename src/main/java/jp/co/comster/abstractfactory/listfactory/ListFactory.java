package jp.co.comster.abstractfactory.listfactory;

import jp.co.comster.abstractfactory.factory.Factory;
import jp.co.comster.abstractfactory.factory.Link;
import jp.co.comster.abstractfactory.factory.Page;
import jp.co.comster.abstractfactory.factory.Tray;

/**
 * ConcreteFactory<br>
 * Factoryクラスを継承している
 */
public class ListFactory extends Factory {
	@Override
	public Link createLink(String caption, String url) {
		return new ListLink(caption, url);
	}
	
	@Override
	public Tray createTray(String caption) {
		return new ListTray(caption);
	}
	
	@Override
	public Page createPage(String title, String author) {
		return new ListPage(title, author);
	}
}
