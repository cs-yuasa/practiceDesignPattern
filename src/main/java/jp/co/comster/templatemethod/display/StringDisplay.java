package jp.co.comster.templatemethod.display;

import org.tinylog.Logger;

/**
 * ConcreteClass<br>
 * AbstractDisplayインターフェースを実装している
 */
public class StringDisplay implements AbstractDisplay {
	private StringBuilder sb = new StringBuilder();
	private String string;
	private int width;
	
	public StringDisplay(String string) {
		this.string = string;
		this.width = string.length();
	}
	
	@Override
	public void open() {
		sb.append("\n");
		printLine();
	}
	
	@Override
	public void print() {
		sb.append("|" + string + "|\n");
	}
	
	@Override
	public void close() {
		printLine();
		Logger.info(sb);
		sb.setLength(0);
	}
	
	/**
	 * 1行の飾り文字を作成する
	 */
	private void printLine() {
		sb.append("+");
		for(int i = 0; i < width; i++) {
			sb.append("-");
		}
		sb.append("+\n");
	}
}
