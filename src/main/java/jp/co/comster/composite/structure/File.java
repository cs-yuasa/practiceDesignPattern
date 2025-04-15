package jp.co.comster.composite.structure;

import org.tinylog.Logger;

/**
 * Leaf<br>
 * Entryクラスを継承している
 */
public class File extends Entry {
	private String name;
	private int size;
	
	public File(String name, int size) {
		this.name = name;
		this.size = size;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public int getSize() {
		return size;
	}
	
	@Override
	protected void printList(String prefix) {
		Logger.info(prefix + "/" + this);
	}
}
