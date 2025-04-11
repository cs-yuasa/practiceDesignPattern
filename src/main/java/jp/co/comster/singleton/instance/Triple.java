package jp.co.comster.singleton.instance;

import java.util.Map;

import org.tinylog.Logger;

/**
 * Singleton
 */
public class Triple {
	/** Mapのkeyに利用する名前 */
	private static String[] names = {"ALPHA", "BETA", "GAMMA"};
	/** 自クラスのインスタンスを名前で管理するMap<br>
	 *  自クラスのロード時にインスタンスを作成する
	 */
	private static Map<String, Triple> tripleMap = Map.of(
		names[0], new Triple(names[0]),
		names[1], new Triple(names[1]),
		names[2], new Triple(names[2])
	);
	
	private String name;
	
	/**
	 * Singletonのコンストラクタ<br>
	 * 他クラスからアクセスできない
	 */
	private Triple(String name) {
		this.name = name;
		Logger.info("name:" + name + "のTripleクラスのインスタンスを生成しました。");
	}
	
	/**
	 * 自クラスの作成済みのインスタンスを名前をkeyにして取得する
	 * @param name インスタンスのkeyである名前
	 * @return Tripleクラスのインスタンス(存在しない場合はnull)
	 */
	public static Triple getInstance(String name) {
		return tripleMap.get(name);
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
