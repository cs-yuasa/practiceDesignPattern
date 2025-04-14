package jp.co.comster.bridge.concreteimplementor;

import org.tinylog.Logger;

import jp.co.comster.bridge.implementor.DisplayImpl;

/**
 * ConcreteImplemntor<br>
 * DisplayImplクラスを継承している
 */
public class StringDisplayImpl extends DisplayImpl {
	private StringBuilder sb = new StringBuilder();
	private String string;
	private int width;
	
	public StringDisplayImpl(String string) {
		this.string = string;
		this.width = string.length();
	}
	
	@Override
	public void rawOpen() {
		sb.append("\n");
		printLine();
	}
	
	@Override
	public void rawPrint() {
		sb.append("|" + string + "|\n");
	}
	
	@Override
	public void rawClose() {
		printLine();
		Logger.info(sb);
		sb.setLength(0);
	}
	
	/**
	 * 1行の飾り文字を作成する
	 */
	private void printLine() {
		sb.append("+");
		for (int i = 0; i < width; i++) {
			sb.append("-");
		}
		sb.append("+\n");
	}
}
