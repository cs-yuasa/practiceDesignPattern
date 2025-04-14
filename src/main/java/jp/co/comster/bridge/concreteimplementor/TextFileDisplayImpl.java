package jp.co.comster.bridge.concreteimplementor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.tinylog.Logger;

import jp.co.comster.bridge.implementor.DisplayImpl;

/**
 * ConcreteImplemntor<br>
 * DisplayImplクラスを継承している
 */
public class TextFileDisplayImpl extends DisplayImpl {
	private StringBuilder sb = new StringBuilder();
	private String filepass;
	
	public TextFileDisplayImpl(String filepass) {
		this.filepass = filepass;
	}
	
	@Override
	public void rawOpen() {
		sb.append("ファイルパス: " + filepass + "\n");
	}
	
	/**
	 * filepassの内容をStringBuilderに格納する
	 */
	@Override
	public void rawPrint() {
		try {
			for (String line : Files.readAllLines(Path.of(filepass))) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			Logger.error(e, "IOException occurred");
		}
	}
	
	@Override
	public void rawClose() {
		Logger.info(sb);
		sb.setLength(0);
	}
}
