package jp.co.comster.decorator.display;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteComponent<br>
 * Displayクラスを継承している
 */
public class MultiStringDisplay extends Display {
	/** 表示文字列のリスト */
	private List<String> stringList = new ArrayList<>();
	private int maxLength = 0;
	
	@Override
	public int getColumns() {
		return maxLength;
	}
	
	@Override
	public int getRows() {
		return stringList.size();
	}
	
	@Override
	public String getRowText(int row) {
		return stringList.get(row);
	}
	
	/**
	 * 文字列を追加して文字列の幅を一定に整える
	 * 
	 * @param string 追加する文字列
	 */
	public void add(String string) {
		maxLength = Math.max(string.length(), maxLength);
		stringList.add(string);
		for (int i = 0; i < stringList.size(); i++) {
			String currentString = stringList.get(i);
			if (currentString.length() < maxLength) {
				stringList.set(i, String.format("%-" + maxLength + "s", currentString));
			}
		}
	}
}
