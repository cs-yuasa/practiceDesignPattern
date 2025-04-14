package jp.co.comster.abstractfactory.divfactory;

import jp.co.comster.abstractfactory.factory.Link;

/**
 * ConcreteProduct<br>
 * Linkクラスを継承している
 */
public class DivLink extends Link {
	public DivLink(String caption, String url) {
		super(caption, url);
	}
	
	@Override
	public String makeHTML() {
		return "<div class=\"LINK\"><a href=\"" + url + "\">" + caption + "</a></div>\n";
	}
}
