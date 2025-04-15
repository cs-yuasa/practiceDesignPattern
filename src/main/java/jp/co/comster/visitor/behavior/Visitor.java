package jp.co.comster.visitor.behavior;

import jp.co.comster.visitor.stracture.Directory;
import jp.co.comster.visitor.stracture.File;

/**
 * Visitor
 */
public abstract class Visitor {
	/**
	 * Fileクラスを訪問したときにFileクラスが呼び出すメソッド
	 * 
	 * @param file Fileクラスのインスタンス
	 */
	public abstract void visit(File file);
	
	/**
	 * Directoryクラスを訪問したときにDirectoryクラスが呼び出すメソッド
	 * 
	 * @param directory Directoryクラスのインスタンス
	 */
	public abstract void visit(Directory directory);
}
