package jp.co.comster.templatemethod;

import jp.co.comster.templatemethod.display.AbstractDisplay;
import jp.co.comster.templatemethod.display.CharDisplay;
import jp.co.comster.templatemethod.display.StringDisplay;

public class TemplateMethodMain {
	public static void main(String[] args) {
		AbstractDisplay d1 = new CharDisplay('H');
		AbstractDisplay d2 = new StringDisplay("Hello, world.");
		d1.display();
		d2.display();
	}
}
