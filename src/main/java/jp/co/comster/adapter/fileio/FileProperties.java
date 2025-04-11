package jp.co.comster.adapter.fileio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Adapter<br>
 * FiloIOインターフェースを実装している
 */
public class FileProperties implements FileIO {
	Properties p = new Properties();
	
	/**
	 * ファイルをReader経由で読み込む
	 * @param filepass ファイルパス
	 */
	@Override
	public void readFromFile(String filepass) throws IOException {
		p.load(new FileReader(filepass));
	}
	
	/**
	 * ファイルをReader経由で書き込む
	 * @param filepass ファイルパス
	 */
	@Override
	public void writeToFile(String filename) throws IOException {
		p.store(new FileWriter(filename), "test");
	}
	
	/**
	 * プロパティを設定する
	 * @param key キー
	 * @param value 値
	 */
	@Override
	public void setValue(String key, String value) {
		p.setProperty(key, value);
	}
	
	/**
	 * キーに対応する値を返す
	 * @param key キー
	 * @return キーに対応する値(存在しない場合は空文字列を返す)
	 */
	@Override
	public String getValue(String key) {
		return p.getProperty(key, "");
	}
}
