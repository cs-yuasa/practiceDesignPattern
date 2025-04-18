package jp.co.comster.interpreter.node;

import jp.co.comster.interpreter.framework.Context;
import jp.co.comster.interpreter.framework.ParseException;

/**
 * AbstractionExpression
 */
public abstract class Node {
	/**
	 * 構文解析を行う
	 * 
	 * @param context コンテキスト
	 * @throws ParseException 構文エラークラス
	 */
	public abstract void parse(Context context) throws ParseException;
}
