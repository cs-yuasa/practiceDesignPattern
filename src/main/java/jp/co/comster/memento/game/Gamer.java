package jp.co.comster.memento.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.tinylog.Logger;

/**
 * Originator
 */
public class Gamer {
	/** 所持金 */
	private int money;
	/** フルーツ */
	private List<String> fruits = new ArrayList<>();
	private Random random = new Random();
	
	/** フルーツ名のリスト */
	private static String[] fruitsName = {
	    "リンゴ", "ぶどう", "バナナ", "みかん",
	};
	
	public Gamer(int money) {
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}
	
	/**
	 * ゲームを進行する
	 */
	public void bet() {
		int dice = random.nextInt(6) + 1;
		if (dice == 1) {
			money += 100;
			Logger.info("所持金が増えました。");
		} else if (dice == 2) {
			money /= 2;
			Logger.info("所持金が半分になりました。");
		} else if (dice == 6) {
			String f = getFruit();
			Logger.info("フルーツ(" + f + ")をもらいました。");
			fruits.add(f);
		} else {
			Logger.info("何も起こりませんでした。");
		}
	}
	
	/**
	 * スナップショットをとる
	 * 
	 * @return スナップショット(Mementoクラスのインスタンス)
	 */
	public Memento createMemento() {
		Memento m = new Memento(money);
		for (String f: fruits) {
			// フルーツはおいしいものだけ保存
			if (f.startsWith("おいしい")) {
				m.addFruit(f);
			}
		}
		return m;
	}
	
	/**
	 * アンドゥを行う
	 * 
	 * @param memento 保存してあるスナップショット
	 */
	public void restoreMemento(Memento memento) {
		this.money = memento.getMoney();
		this.fruits = memento.getFruits();
	}
	
	@Override
	public String toString() {
		return "[money = " + money + ", fruits = " + fruits + "]";
	}
	
	/**
	 *  ランダムなフルーツを1個得る
	 *  
	 * @return フルーツ
	 */
	private String getFruit() {
		String f = fruitsName[random.nextInt(fruitsName.length)];
		if (random.nextBoolean()) {
			return "おいしい" + f;
		} else {
			return f;
		}
	}
}
