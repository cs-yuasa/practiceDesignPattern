package jp.co.comster.builder.concretebuilder;

import jp.co.comster.builder.framework.Builder;

/**
 * ConcreteBuilder<br>
 * Builderインターフェースを実装している
 */
public class TextBuilder implements Builder {
	private StringBuilder sb = new StringBuilder();
	
	@Override
	public void makeTitle(String title) {
		sb.append("\n==============================\n");
		sb.append("『");
		sb.append(title);
		sb.append("』\n\n");
	}
	
	@Override
	public void makeString(String str) {
		sb.append("■");
		sb.append(str);
		sb.append("\n\n");
	}
	
	@Override
	public void makeItems(String[] items) {
		for (String s: items) {
			sb.append("　・");
			sb.append(s);
			sb.append("\n");
		}
		sb.append("\n");
	}
	
	@Override
	public void close() {
		sb.append("==============================\n");
	}
	
	/**
	 * 作成したテキストを返す
	 * @return テキスト
	 */
	public String getTextResult() {
		return sb.toString();
	}
}
