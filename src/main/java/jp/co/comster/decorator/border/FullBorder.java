package jp.co.comster.decorator.border;

import jp.co.comster.decorator.display.Display;

/**
 * ConcreteDecorator<br>
 * Borderクラスを継承している
 */
public class FullBorder extends Border {
	public FullBorder(Display display) {
		super(display);
	}
	
	@Override
	public int getColumns() {
		return 1 + display.getColumns() + 1;
	}
	
	@Override
	public int getRows() {
		return 1 + display.getRows() + 1;
	}
	
	@Override
	public String getRowText(int row) {
		if (row == 0) {                             // 上端
			return "+" + makeLine('-', display.getColumns()) + "+";
		} else if (row == display.getRows() + 1) {  // 下端
			return "+" + makeLine('-', display.getColumns()) + "+";
		} else {
			return "|" + display.getRowText(row - 1) + "|";
		}
	}
	
	/**
	 * 指定した文字が連続する文字列を返す
	 * 
	 * @param ch 指定した文字
	 * @param count 連続する回数
	 * @return 指定した文字が連続する文字列
	 */
	private String makeLine(char ch, int count) {
		StringBuilder line = new StringBuilder();
		for (int i = 0; i < count; i++) {
			line.append(ch);
		}
		return line.toString();
	}
}
