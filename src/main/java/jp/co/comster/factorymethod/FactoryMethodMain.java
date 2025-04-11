package jp.co.comster.factorymethod;

import jp.co.comster.factorymethod.framework.Factory;
import jp.co.comster.factorymethod.framework.Product;
import jp.co.comster.factorymethod.idcard.IDCardFactory;

public class FactoryMethodMain {
	public static void main(String[] args) {
		Factory factory = new IDCardFactory();
		Product card1 = factory.create("Hiroshi Yuki");
		Product card2 = factory.create("Tomura");
		Product card3 = factory.create("Hanako Sato");
		card1.use();
		card2.use();
		card3.use();
	}
}
