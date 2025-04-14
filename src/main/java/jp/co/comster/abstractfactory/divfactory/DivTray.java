package jp.co.comster.abstractfactory.divfactory;

import jp.co.comster.abstractfactory.factory.Item;
import jp.co.comster.abstractfactory.factory.Tray;

/**
 * ConcreteProduct<br>
 * Trayクラスを継承している
 */
public class DivTray extends Tray {
	public DivTray(String caption) {
		super(caption);
	}
	
	@Override
	public String makeHTML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<p><b>");
		sb.append(caption);
		sb.append("</b></p>\n");
		sb.append("<div class=\"TRAY\">");
		for (Item item: tray) {
			sb.append(item.makeHTML());
		}
		sb.append("</div>\n");
		return sb.toString();
	}
}
