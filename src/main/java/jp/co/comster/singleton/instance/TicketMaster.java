package jp.co.comster.singleton.instance;

import org.tinylog.Logger;

/**
 * Singleton
 */
public class TicketMaster {
	/** チケットの番号 */
	private int ticket = 1000;
	/** 自クラスのロード時に作成される自クラスのインスタンス */
	private static TicketMaster ticketMaster = new TicketMaster();
	
	/**
	 * Singletonのコンストラクタ<br>
	 * 他クラスからアクセスできない
	 */
	private TicketMaster() {
		Logger.info("TickMasterクラスのインスタンスを生成しました。");
	}
	
	/**
	 * 自クラスの作成済みのインスタンスを取得する
	 * @return TicketMasterクラスのインスタンス
	 */
	public static TicketMaster getInstance() {
		return ticketMaster;
	}
	
	/**
	 * 現在のチケットの番号を返してインクリメントする<br>
	 * 例：ticketが0のときに呼ばれると0が返されticketが1になる
	 * @return 現在のチケットの番号
	 */
	public int getNextTicketNumber() {
		return ticket++;
	}
}
