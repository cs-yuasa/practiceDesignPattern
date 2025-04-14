package jp.co.comster.bridge;

import jp.co.comster.bridge.abstraction.Display;
import jp.co.comster.bridge.concreteimplementor.CharDisplayImpl;
import jp.co.comster.bridge.concreteimplementor.StringDisplayImpl;
import jp.co.comster.bridge.concreteimplementor.TextFileDisplayImpl;
import jp.co.comster.bridge.refinedabstraction.CountDisplay;
import jp.co.comster.bridge.refinedabstraction.IncreaseDisplay;
import jp.co.comster.bridge.refinedabstraction.RandomCountDisplay;

public class BridgeMain {
	public static void main(String[] args) {
		Display d1 = new Display(new StringDisplayImpl("Hello, Japan."));
		Display d2 = new CountDisplay(new StringDisplayImpl("Hello, World."));
		CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe."));
		RandomCountDisplay d4 = new RandomCountDisplay(new StringDisplayImpl("Hello, Universe."));
		Display d5 = new Display(new TextFileDisplayImpl("src/main/resources/bridge/sample.txt"));
		IncreaseDisplay d6 = new IncreaseDisplay(new CharDisplayImpl('<', '*', '>'), 1);
		d1.display();
		d2.display();
		d3.display();
		d3.multiDisplay(5);
		d4.randomDisplay(10);
		d5.display();
		d6.increaseDisplay(4);
	}
}
