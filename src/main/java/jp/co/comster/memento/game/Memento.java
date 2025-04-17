package jp.co.comster.memento.game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.tinylog.Logger;

/**
 * Memento
 */
public class Memento {
	private int number;
	/** 所持金 */
	private int money;
	/** フルーツ */
	private List<String> fruits;
	
	public int getMoney() {
		return money;
	}
	
	Memento(int money) {
		this.money = money;
		this.fruits = new ArrayList<>();
	}
	
	/**
	 *  フルーツを追加する
	 *  
	 * @param fruit フルーツ
	 */
	void addFruit(String fruit) {
		fruits.add(fruit);
	}
	
	List<String> getFruits() {
		return new ArrayList<>(fruits);
	}
	
	int getNumber() {
		return number;
	}
	
	/**
	 * ファイルに書き込む
	 * 
	 * @param filename ファイル名
	 * @param memento Mementoクラスのインスタンス
	 * @return 書き込みが成功すればtrue、しなければfalse
	 */
	public static boolean savaToFile(String filename, Memento memento) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format("%d", memento.money)).append("\n");
		for (String f: memento.getFruits()) {
			sb.append(f).append("\n");
		}
		try {
			Files.writeString(Path.of("src/main/resources/memento/" + filename), sb,
					StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING,
					StandardOpenOption.WRITE);
		} catch (IOException e) {
			Logger.error(e, "IOException occurred");
			return false;
		}
		return true;
	}
	
	/**
	 * ファイルを読み込んで生成
	 * 
	 * @param filename ファイル名
	 * @return 生成されたMementoクラスのインスタンス
	 */
	public static Memento loadFromFile(String filename) {
		try {
			List<String> lines = Files.readAllLines(Path.of("src/main/resources/memento/" + filename));
			if (lines.size() == 0) {
				Logger.error("Empty file");
				return null;
			}
			
			int money = 0;
			try {
				money = Integer.parseInt(lines.get(0));
			} catch (NumberFormatException e) {
				Logger.error("Format error: " + e);
				return null;
			}
			
			Memento memento = new Memento(money);
			
			for (int i = 1; i < lines.size(); i++) {
				memento.addFruit(lines.get(i));
			}
			return memento;
		} catch (IOException e) {
			Logger.error(e, "IOException occurred");
			return null;
		}
	}
}
