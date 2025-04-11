package jp.co.comster.templatemethod.display;

import org.tinylog.Logger;

/**
 * ConcreteClass<br>
 * AbstractDisplayインターフェースを実装している
 */
public class CharDisplay implements AbstractDisplay {
	private StringBuilder sb = new StringBuilder();
	private char ch;
	
	public CharDisplay(char ch) {
		this.ch = ch;
	}
	
	@Override
	public void open() {
		sb.append("<<");
	}
	
	@Override
	public void print() {
		sb.append(ch);
	}
	
	@Override
	public void close() {
		sb.append(">>");
		Logger.info(sb);
		sb.setLength(0);
	}
}
