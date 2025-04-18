package jp.co.comster.builder.framework;

/**
 * Director
 */
public class Director {
	private Builder builder;
	
	public Director(Builder builder) {
		this.builder = builder;
	}
	
	/**
	 * 文書を作る
	 */
	public void construct() {
		builder.makeTitle("Greeting");
		builder.makeString("一般的なあいさつ");
		builder.makeItems(new String[]{
			"How are you?",
			"Hello.",
			"Hi.",
		});
		builder.makeString("時間帯に応じたあいさつ");
		builder.makeItems(new String[]{
			"Good morning.",
			"Good afternoon.",
			"Good evening.",
		});
		builder.close();
	}
}
