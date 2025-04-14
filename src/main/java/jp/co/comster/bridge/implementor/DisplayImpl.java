package jp.co.comster.bridge.implementor;

/**
 * Implementor
 */
public abstract class DisplayImpl {
	/** 表示の前処理 */
	public abstract void rawOpen();
	/** 表示処理 */
	public abstract void rawPrint();
	/** 表示の後処理 */
	public abstract void rawClose();
}
