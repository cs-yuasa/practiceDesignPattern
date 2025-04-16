package jp.co.comster.facade.pagemaker;

import java.io.IOException;
import java.io.Writer;

/**
 * HTMLファイルの要素を出力する
 */
class HtmlWriter {
	private Writer writer;
	
	public HtmlWriter(Writer writer) {
		this.writer = writer;
	}
	
	/**
	 * タイトルを出力する
	 * 
	 * @param title タイトル名
	 * @throws IOException Writerで発生する例外
	 */
	public void title(String title) throws IOException {
		writer.write("<!DOCTYPE html>");
		writer.write("<html>");
		writer.write("<head>");
		writer.write("<title>" + title + "</title>");
		writer.write("</head>");
		writer.write("<body>");
		writer.write("\n");
		writer.write("<h1>" + title + "</h1>");
		writer.write("\n");
	}
	
	/**
	 * 段落を出力する
	 * 
	 * @param msg メッセージ
	 * @throws IOException Writerで発生する例外
	 */
	public void paragraph(String msg) throws IOException {
		writer.write("<p>" + msg + "</p>");
		writer.write("\n");
	}
	
	/**
	 * リンクを出力する
	 * 
	 * @param href リンク
	 * @param caption 詳細
	 * @throws IOException Writerで発生する例外
	 */
	public void link(String href, String caption) throws IOException {
		paragraph("<a href=\"" + href + "\">" + caption + "</a>");
	}
	
	/**
	 * メールアドレスのリンクを作成する
	 * 
	 * @param mailaddr メールアドレス
	 * @param username ユーザー名
	 * @throws IOException Writerで発生する例外
	 */
	public void mailto(String mailaddr, String username) throws IOException {
		link("mailto:" + mailaddr, username);
	}
	
	/**
	 * 終了処理
	 * 
	 * @throws IOException Writerで発生する例外
	 */
	public void close() throws IOException {
		writer.write("</body>");
		writer.write("</html>");
		writer.write("\n");
		writer.close();
	}
}
