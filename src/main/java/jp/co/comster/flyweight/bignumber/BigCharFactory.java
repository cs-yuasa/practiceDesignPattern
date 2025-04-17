package jp.co.comster.flyweight.bignumber;

import java.util.HashMap;
import java.util.Map;

/**
 * FlyweightFactory
 */
public class BigCharFactory {
	/** すでに作ったBigCharクラスのインスタンスを管理するMap */
	private Map<String,BigChar> pool = new HashMap<>();
	private static BigCharFactory singleton = new BigCharFactory();
	
	private BigCharFactory() {}
	
	public static BigCharFactory getInstance() {
		return singleton;
	}
	
	// BigCharのインスタンス生成(共有)
	/**
	 * poolに文字に対応するBigCharクラスのインスタンスが存在する場合はそれを返し、
	 * 存在しない場合は生成してpoolに格納して返す
	 * 
	 * @param charname 対象文字
	 * @return BigCharクラスのインスタンス
	 */
	public synchronized BigChar getBigChar(char charname) {
		BigChar bc = pool.get(String.valueOf(charname));
		if (bc == null) {
			bc = new BigChar(charname);
			pool.put(String.valueOf(charname), bc);
		}
		return bc;
	}
}
