package jp.co.comster.proxy.printer;

/**
 * Subject
 */
public interface Printable {
	public abstract void setPrinterName(String name);
	public abstract String getPrinterName();
	public abstract void print(String string);
}
