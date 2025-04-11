package jp.co.comster.prototype.framework;

import java.util.HashMap;
import java.util.Map;

/**
 * Client
 */
public class Manager {
	/** Productインスタンスを名前で管理するMap */
	private Map<String,Product> showcase = new HashMap<>();
	
	/**
	 * 名前をキーにしてインスタンスをMapに登録する
	 * @param name 名前
	 * @param prototype 登録するインスタンス
	 */
	public void register(String name, Product prototype) {
		showcase.put(name, prototype);
	}
	
	/**
	 * 名前をキーにして保存されているインスタンスのコピーを返す
	 * @param prototypeName 名前
	 * @return インスタンスのコピー
	 */
	public Product create(String prototypeName) {
		Product p = showcase.get(prototypeName);
		return p.createCopy();
	}
}
