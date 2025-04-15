package jp.co.comster.decorator.display;

import org.tinylog.Logger;

/**
 * ConcreteComponent<br>
 * Displayクラスを継承している
 */
public class StringDisplay extends Display {
	/** 表示文字列 */
	private String string;
	
	public StringDisplay(String string) {
		this.string = string;
	}
	
	@Override
	public int getColumns() {
		return string.length();
	}
	
	@Override
	public int getRows() {
		return 1;
	}
	
	@Override
	public String getRowText(int row) {
		if (row != 0) {
			IndexOutOfBoundsException e = new IndexOutOfBoundsException();
			Logger.error(e, "IndexOutOfBoundsException occurred");
			throw e;
		}
		return string;
	}
}
