package jp.co.comster.flyweight.bignumber;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.tinylog.Logger;

/**
 * Flyweight
 */
public class BigChar {
	/** 文字の名前 */
	private char charname;
	/** 「大きな文字」を表現する文字列 */
	private String fontdata;
	
	/**
	 * ファイルから「大きな文字」を表現する文字列を受け取りfontdataに格納する
	 * 
	 * @param charname 文字の名前
	 */
	public BigChar(char charname) {
		this.charname = charname;
		try {
			String filename = "big" + charname + ".txt";
			StringBuilder sb = new StringBuilder();
			for (String line: Files.readAllLines(Path.of("src/main/resources/flyweight/" + filename))) {
				sb.append(line);
				sb.append("\n");
			}
			this.fontdata = sb.toString();
		} catch (IOException e) {
			this.fontdata = charname + "?";
		}
	}
	
	/**
	 *  「大きな文字」を表示する
	 */
	public void print() {
		Logger.info("\n" + fontdata);
	}
}
