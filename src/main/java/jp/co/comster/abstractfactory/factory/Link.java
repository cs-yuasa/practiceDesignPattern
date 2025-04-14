package jp.co.comster.abstractfactory.factory;

/**
 * AbstractProduct<br>
 * Itemクラスを継承している
 */
public abstract class Link extends Item {
	protected String url;
	
	public Link(String caption, String url) {
		super(caption);
		this.url = url;
	}
}
