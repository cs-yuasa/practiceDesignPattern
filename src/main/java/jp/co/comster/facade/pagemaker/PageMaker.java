package jp.co.comster.facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.tinylog.Logger;

/**
 * Facade<br>
 * Webページを作成する
 */
public class PageMaker {
	/**
	 * メールアドレスとファイル名をもとに、Webページを作成する
	 * 
	 * @param mailaddr メールアドレス
	 * @param filename 作成先のファイル名
	 */
	public static void makeWelcomePage(String mailaddr, String filename) {
		try {
			Properties mailprop = Database.getProperties("maildata");
			String username = mailprop.getProperty(mailaddr);
			HtmlWriter writer = new HtmlWriter(new FileWriter("src/main/resources/facade/" + filename));
			writer.title(username + "'s web page");
			writer.paragraph("Welcome to " + username + "'s web page!");
			writer.paragraph("Nice to meet you!");
			writer.mailto(mailaddr, username);
			writer.close();
			Logger.info(filename + " is created for " + mailaddr + " (" + username + ")");
		} catch (IOException e) {
			Logger.error(e, "IOException occurred");
		}
	}
	
	/**
	 * データファイル(maildata.txt)に含まれているユーザーのメールアドレスのリンク集を作成する
	 * 
	 * @param filename 作成先のファイル名
	 */
	public static void makeLinkPage(String filename) {
		try {
			Properties mailprop = Database.getProperties("maildata");
			HtmlWriter writer = new HtmlWriter(new FileWriter("src/main/resources/facade/" + filename));
			writer.title("Link page");
			for (String mailaddr: mailprop.stringPropertyNames()) {
				String username = mailprop.getProperty(mailaddr);
				writer.mailto(mailaddr, username);
			}
			writer.close();
			Logger.info(filename + " is created");
		} catch (IOException e) {
			Logger.error(e, "IOException occurred");
		}
	}
}
