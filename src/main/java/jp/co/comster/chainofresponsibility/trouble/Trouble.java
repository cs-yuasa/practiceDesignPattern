package jp.co.comster.chainofresponsibility.trouble;

public class Trouble {
	/** トラブル番号 */
	private int number;
	
	public Trouble(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
	
	@Override
	public String toString() {
		return "[Trouble " + number + "]";
	}
}
