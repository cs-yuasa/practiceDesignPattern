package jp.co.comster.memento;

import org.tinylog.Logger;

import jp.co.comster.memento.game.Gamer;
import jp.co.comster.memento.game.Memento;

/**
 * Caretaker
 */
public class MementoMain {
	public static void main(String[] args) {
		Gamer gamer = new Gamer(100);
		Memento memento = Memento.loadFromFile("game.dat");
		
		if (memento == null) {
			Logger.info("新規にスタートします。");
			memento = gamer.createMemento();
		} else {
			Logger.info("前回保存した結果からスタートします。");
			gamer.restoreMemento(memento);
		}
		
		for (int i = 0; i < 20; i++) {
			Logger.info(i + 1 + "回目\n現状:" + gamer);
			gamer.bet();
			Logger.info("所持金は" + gamer.getMoney() + "円になりました。");
			
			if (gamer.getMoney() > memento.getMoney()) {
				Logger.info("※だいぶ増えたので、現在の状態を保存しておこう！");
			    memento = gamer.createMemento();
			    if (Memento.savaToFile("game.dat", memento)) {
			    	Logger.info("現在の状態をファイルに保存しました。");
			    }
			} else if (gamer.getMoney() < memento.getMoney() / 2) {
				Logger.info("※だいぶ減ったので、以前の状態を復元しよう！");
			    gamer.restoreMemento(memento);
			}
		}
	}
}
