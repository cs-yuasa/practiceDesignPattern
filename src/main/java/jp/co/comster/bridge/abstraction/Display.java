package jp.co.comster.bridge.abstraction;

import jp.co.comster.bridge.implementor.DisplayImpl;

/**
 * Abstraction
 */
public class Display {
	private DisplayImpl impl;
	
	public Display(DisplayImpl impl) {
		this.impl = impl;
	}
	
	/** 表示の前処理 */
	public void open() {
		impl.rawOpen();
	}
	
	/** 表示処理 */
	public void print() {
		impl.rawPrint();
	}
	
	/** 表示の後処理 */
	public void close() {
		impl.rawClose();
	}
	
	/**
	 * 表示する
	 */
	public final void display() {
		open();
		print();
		close();
	}
}
