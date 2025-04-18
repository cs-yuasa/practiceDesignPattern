package jp.co.comster.proxy;

import org.tinylog.Logger;

import jp.co.comster.proxy.printer.Printable;
import jp.co.comster.proxy.printer.PrinterProxy;

/**
 * Client
 */
public class ProxyMain {
	public static void main(String[] args) {
		Printable p = new PrinterProxy("Alice", "jp.co.comster.proxy.printer.Printer");
		Logger.info("名前は現在" + p.getPrinterName() + "です。");
		p.setPrinterName("Bob");
		Logger.info("名前は現在" + p.getPrinterName() + "です。");
		p.print("Hello, world.");
	}
}
