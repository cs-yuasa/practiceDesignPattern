package jp.co.comster.flyweight.bignumber;

/**
 * Client
 */
public class BigString {
    /** 「大きな文字」の配列 */
	private BigChar[] bigchars;
	
	/**
	 * BigCharクラスのインスタンスを共有するかを決め、<br>
	 * 文字列から「大きな文字」に変換し、配列に格納する
	 * 
	 * @param string 文字列
	 * @param shared 共有するか
	 */
	public BigString(String string, boolean shared) {
		if (shared) {
			BigCharFactory factory = BigCharFactory.getInstance();
			bigchars = new BigChar[string.length()];
			for (int i = 0; i < bigchars.length; i++) {
				bigchars[i] = factory.getBigChar(string.charAt(i));
			}
		} else {
			bigchars = new BigChar[string.length()];
			for (int i = 0; i < bigchars.length; i++) {
				bigchars[i] = new BigChar(string.charAt(i));
			}
		}
		
	}
	
	/**
	 * 「大きな文字」列を表示する
	 */
	public void print() {
		for (BigChar bc: bigchars) {
			bc.print();
		}
	}
}
