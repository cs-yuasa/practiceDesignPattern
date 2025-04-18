package jp.co.comster.proxy.printer;

import org.tinylog.Logger;

/**
 * RealSubject<br>
 * Printableインターフェースを実装している
 */
public class Printer implements Printable {
	private String name;
	
	public Printer() {
		heavyJob("Printerのインスタンスを生成中");
	}
	
	public Printer(String name) {
		this.name = name;
		heavyJob("Printerのインスタンス(" + name + ")を生成中");
	}
	
	@Override
	public void setPrinterName(String name) {
		this.name = name;
	}
	
	@Override
	public String getPrinterName() {
		return name;
	}
	
	@Override
	public void print(String string) {
		Logger.info("--- " + name + " ---");
		Logger.info(string);
	}
	
	/**
	 *  重い作業(仮)をする
	 *  
	 * @param msg メッセージ
	 */
	private void heavyJob(String msg) {
		Logger.info(msg);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			Logger.error(e, "InterruptedException occurred");
		}
		Logger.info("完了。");
	}
}
