package jp.co.comster.templatemethod.display;

/**
 * AbstractClass
 */
public interface AbstractDisplay {
	/** 表示開始時に呼ばれる */
	public void open();
	/** 表示処理時に呼ばれる */
	public void print();
	/** 表示終了時に呼ばれる */
	public void close();
	
	/** 表示処理を行う */
	public default void display() {
		open();
		for (int i = 0; i < 5; i++) {
			print();
		}
		close();
	}
}
