package jp.co.comster.decorator;

import jp.co.comster.decorator.border.FullBorder;
import jp.co.comster.decorator.border.SideBorder;
import jp.co.comster.decorator.border.UpDownBorder;
import jp.co.comster.decorator.display.Display;
import jp.co.comster.decorator.display.MultiStringDisplay;
import jp.co.comster.decorator.display.StringDisplay;

public class DecoratorMain {
	public static void main(String[] args) {
		Display b1 = new StringDisplay("Hello, world.");
		Display b2 = new SideBorder(b1, '#');
		Display b3 = new FullBorder(b2);
		Display b4 = new UpDownBorder(b3, '-');
		b1.show();
		b2.show();
		b3.show();
		b4.show();
		Display b5 =
					new SideBorder(
						new FullBorder(
							new UpDownBorder(
								new SideBorder(
									new FullBorder(
										new StringDisplay("Hello, world.")
									),
									'*'
								),
								'-'
							)
						),
						'/'
					);
		b5.show();
		
		MultiStringDisplay md = new MultiStringDisplay();
		md.add("Hi!");
		md.add("Good morning.");
		md.add("Good night!");
		md.show();
		
		Display d6 = new SideBorder(new UpDownBorder(md, '-'), '+');
		d6.show();
	}
}
