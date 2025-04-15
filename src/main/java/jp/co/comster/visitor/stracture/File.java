package jp.co.comster.visitor.stracture;

import jp.co.comster.visitor.behavior.Visitor;

/**
 * ConcreteElement<br>
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
	public void accept(Visitor v) {
		v.visit(this);
	}
}
