package jp.co.comster.decorator.border;

import jp.co.comster.decorator.display.Display;

/**
 * ConcreteDecorator<br>
 * Borderクラスを継承している
 */
public class SideBorder extends Border {
	/** 飾り文字 */
	private char borderChar;
	
	public SideBorder(Display display, char ch) {
		super(display);
		this.borderChar = ch;
	}
	
	@Override
	public int getColumns() {
		return 1 + display.getColumns() + 1;
	}
	
	@Override
	public int getRows() {
		return display.getRows();
	}
	
	@Override
	public String getRowText(int row) {
		return borderChar + display.getRowText(row) + borderChar;
	}
}
