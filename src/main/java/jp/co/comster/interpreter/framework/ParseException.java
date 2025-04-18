package jp.co.comster.interpreter.framework;

import org.tinylog.Logger;

/**
 * 構文エラークラス
 */
public class ParseException extends Exception {
	public ParseException(String msg) {
		Logger.error(msg);
	}
}
