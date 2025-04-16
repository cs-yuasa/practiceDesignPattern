package jp.co.comster.facade.pagemaker;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Ptopertiesクラスを簡易DBに見立て、
 * メールアドレスと名前の組をデータファイルとして管理する
 */
class Database {
	/**
	 * データファイルからメールアドレスと名前の組を持つプロパティを取得する
	 * 
	 * @param dbname データファイルの名前
	 * @return プロパティ
	 * @throws IOException Readerで発生する例外
	 */
	public static Properties getProperties(String dbname) throws IOException {
		String filename = dbname + ".txt";
		Properties prop = new Properties();
		prop.load(new FileReader("src/main/resources/facade/" + filename));
		return prop;
	}
}
