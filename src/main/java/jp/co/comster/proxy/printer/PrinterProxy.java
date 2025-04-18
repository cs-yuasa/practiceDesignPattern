package jp.co.comster.proxy.printer;

import org.tinylog.Logger;

/**
 * Proxy<br>
 * Printableインターフェースを実装している
 */
public class PrinterProxy implements Printable {
	private String name;
	private Printable real;
	/** realのクラス名 */
	private String classname;
	
	public PrinterProxy(String name, String classname) {
		this.name = name;
		this.real = null;
		this.classname = classname;
	}
	
	/**
	 * 名前を設定する<br>
	 * realのインスタンスがあればそちらにも設定する
	 * 
	 * @param name 名前
	 */
	@Override
	public synchronized void setPrinterName(String name) {
		if (real != null) {
			real.setPrinterName(name);
		}
		this.name = name;
	}
	
	@Override
	public String getPrinterName() {
		return name;
	}
	
	@Override
	public void print(String string) {
		realize();
		real.print(string);
	}
	
	/**
	 * realクラスのインスタンスが作られていなければ、
	 * 作成してnameを保存する
	 */
	private synchronized void realize() {
		if (real == null) {
			try {
				real = (Printable)Class.forName(classname).getDeclaredConstructor().newInstance();
				real.setPrinterName(name);
			} catch (ClassNotFoundException e) {
				Logger.error("クラス" + classname + "が見つかりません。");
			} catch (Exception e) {
				Logger.error(e, "Exception occurred");
			}
		}
	}
}
