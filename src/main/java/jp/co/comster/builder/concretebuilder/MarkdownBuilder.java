package jp.co.comster.builder.concretebuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.tinylog.Logger;

import jp.co.comster.builder.framework.Builder;

/**
 * ConcreteBuilder<br>
 * Builderインターフェースを実装している
 */
public class MarkdownBuilder implements Builder {
	private String filepass = "src/main/resources/builder/untitled.md";
	private StringBuilder sb = new StringBuilder();
	
	@Override
	public void makeTitle(String title) {
		filepass = "src/main/resources/builder/" + title + ".md";
		sb.append("# ").append(title).append("\n\n");
	}
	
	@Override
	public void makeString(String str) {
		sb.append("## ").append(str).append("\n\n");
	}
	
	@Override
	public void makeItems(String[] items) {
		for (String item : items) {
			sb.append("- ").append(item).append("\n");
		}
		sb.append("\n");
	}
	
	@Override
	public void close() {
		try (Writer writer = new FileWriter(filepass)) {
			writer.write(sb.toString());
			writer.close();
		} catch (IOException e) {
			Logger.error(e, "IOException occurred");
		}
	}
	
	/**
	 * ファイルパスを返す
	 * @return ファイルパス
	 */
	public String getMarkdownResult() {
		return filepass;
	}
}
