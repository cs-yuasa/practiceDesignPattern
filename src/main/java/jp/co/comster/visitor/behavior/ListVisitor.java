package jp.co.comster.visitor.behavior;

import org.tinylog.Logger;

import jp.co.comster.visitor.stracture.Directory;
import jp.co.comster.visitor.stracture.Entry;
import jp.co.comster.visitor.stracture.File;

/**
 * ConcreteVisitor<br>
 * Visitorクラスを継承している<br>
 * 一覧を表示する機能を持つ
 */
public class ListVisitor extends Visitor {
	/** 現在注目しているディレクトリ名 */
	private String currentdir = "";
	/** 一覧 */
	private final StringBuilder output = new StringBuilder("\n");
	
	/**
	 * 一覧にfileの情報を格納する
	 * 
	 * @param file Fileクラスのインスタンス
	 */
	@Override
	public void visit(File file) {
		output.append(currentdir).append("/").append(file).append("\n");
	}
	
	/**
	 * 一覧にdirectoryの情報を格納し、再帰的呼び出しを行う
	 * 
	 * @param directory Directoryクラスのインスタンス
	 */
	@Override
	public void visit(Directory directory) {
		output.append(currentdir).append("/").append(directory).append("\n");
		String savedir = currentdir;
		currentdir = currentdir + "/" + directory.getName();
		for (Entry entry: directory) {
			entry.accept(this);
		}
		currentdir = savedir;
	}
	
	/**
	 * 一覧を表示する
	 */
	public void printList() {
		Logger.info(output.toString());
	}
}
