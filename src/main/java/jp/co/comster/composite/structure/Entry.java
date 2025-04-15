package jp.co.comster.composite.structure;

/**
 * Component
 */
public abstract class Entry {
	protected Entry parent;
	
	public abstract String getName();
	
	/**
	 * その要素のサイズを返す
	 * 
	 * @return サイズ
	 */
	public abstract int getSize();
	
	/**
	 * 一覧を表示する
	 */
	public void printList() {
	    printList("");
	}
	
	/**
	 * 一覧を表示する
	 * 
	 * @param prefix 前につける文字列
	 */
	protected abstract void printList(String prefix);
	
	/**
	 * その要素のフルパスを返す
	 * 
	 * @return フルパス
	 */
	public String getFullPass() {
		StringBuilder sb = new StringBuilder();
		Entry entry = this;
		do {
			sb.insert(0, "/" + entry.getName());
			entry = entry.parent;
		} while(entry != null);
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return getName() + " (" + getSize() + ")";
	}
}
