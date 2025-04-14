package jp.co.comster.abstractfactory.listfactory;

import jp.co.comster.abstractfactory.factory.Link;

/**
 * ConcreteProduct<br>
 * Linkクラスを継承している
 */
public class ListLink extends Link {
	public ListLink(String caption, String url) {
		super(caption, url);
	}
	
	@Override
	public String makeHTML() {
		return "  <li><a href=\"" + url + "\">" + caption + "</a></li>\n";
	}
}
