package jp.co.comster.visitor.behavior;

import java.util.ArrayList;
import java.util.List;

import jp.co.comster.visitor.stracture.Directory;
import jp.co.comster.visitor.stracture.Entry;
import jp.co.comster.visitor.stracture.File;

/**
 * ConcreteVisitor<br>
 * Visitorクラスを継承している<br>
 * ファイルを拡張子で検索して対象の情報を格納する機能を持つ
 */
public class FileFindVisitor extends Visitor {
	/** 検索する文字列 */
	private String extension;
	/** 検索条件に合致したFileクラスのインスタンスのリスト */
	private List<File> foundFiles = new ArrayList<>();
	
	public FileFindVisitor(String searchText) {
		this.extension = searchText;
	}
	
	/**
	 * 対象ファイルが指定した文字列(拡張子)で終わる場合格納する
	 * 
	 * @param file Fileクラスのインスタンス
	 */
	@Override
	public void visit(File file) {
		if (file.getName().endsWith(extension)) {
			foundFiles.add(file);
		}
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
	
	/**
	 * 検索条件に合致したファイルに対するイテレータを返す
	 * 
	 * @return Fileクラスのイテレータ
	 */
	public Iterable<File> getFoundFiles() {
		return foundFiles;
	}
}
