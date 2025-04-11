package jp.co.comster.builder;
import org.tinylog.Logger;

import jp.co.comster.builder.concretebuilder.HTMLBuilder;
import jp.co.comster.builder.concretebuilder.MarkdownBuilder;
import jp.co.comster.builder.concretebuilder.TextBuilder;

/**
 * Client
 */
public class BuilderMain {
    public static void main(String[] args) {
		if (args.length != 1) {
			usage();
			System.exit(0);
		}
		if (args[0].equals("text")) {
			TextBuilder textBuilder = new TextBuilder();
			Director director = new Director(textBuilder);
			director.construct();
			String result = textBuilder.getTextResult();
			Logger.info(result);
		} else if (args[0].equals("html")) {
			HTMLBuilder htmlBuilder = new HTMLBuilder();
			Director director = new Director(htmlBuilder);
			director.construct();
			String filepass = htmlBuilder.getHTMLResult();
			Logger.info("HTMLファイルが" + filepass + "に保存されました。");
		} else if (args[0].equals("markdown")) {
			MarkdownBuilder markdownBuilder = new MarkdownBuilder();
			Director director = new Director(markdownBuilder);
			director.construct();
			String filepass = markdownBuilder.getMarkdownResult();
			Logger.info("Markdownファイルが" + filepass + "に保存されました。");
		} else {
			usage();
			System.exit(0);
		}
	}
	
    /**
     * 使い方説明
     */
	public static void usage() {
		Logger.info("\n"
				+ "Usage: java Main text       テキストで文書作成\n"
				+ "Usage: java Main html       HTMLファイルで文書作成\n"
				+ "Usage: java Main markdown   Markdownファイルで文書作成");
	}
}
