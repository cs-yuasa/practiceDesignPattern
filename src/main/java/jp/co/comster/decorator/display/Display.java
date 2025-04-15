package jp.co.comster.decorator.display;

import org.tinylog.Logger;

/**
 * Component
 */
public abstract class Display {
	
	/**
	 * 横の文字数を返す
	 * 
	 * @return 横の文字数
	 */
	public abstract int getColumns();
	
	/**
	 * 縦の行数を返す
	 * 
	 * @return 縦の行数
	 */
	public abstract int getRows();
	
	/**
	 * row行目の文字列を返す
	 * 
	 * @param row 行数
	 * @return row行目の文字列
	 */
	public abstract String getRowText(int row);
	
	/**
	 * すべての行を表示する
	 */
	public void show() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		for (int i = 0; i < getRows(); i++) {
			sb.append(getRowText(i) + "\n");
		}
		Logger.info(sb);
	}
}
