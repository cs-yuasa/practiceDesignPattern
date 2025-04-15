package jp.co.comster.visitor.behavior;

import jp.co.comster.visitor.stracture.Directory;
import jp.co.comster.visitor.stracture.Entry;
import jp.co.comster.visitor.stracture.File;

/**
 * ConcreteVisitor<br>
 * Visitorクラスを継承している<br>
 * サイズを取得する機能を持つ
 */
public class SizeVisitor extends Visitor {
	private int size = 0;
	
	/**
	 * サイズを取得する
	 * 
	 * @param file Fileクラスのインスタンス
	 */
	@Override
	public void visit(File file) {
		size += file.getSize();
	}
	
	/**
	 * 再帰的呼び出しを行う
	 * 
	 * @param directory Directoryクラスのインスタンス
	 */
	@Override
	public void visit(Directory directory) {
		for (Entry entry: directory) {
			entry.accept(this);
		}
	}
	
	public int getSize() {
		return size;
	}
}
