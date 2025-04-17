package jp.co.comster.mediator;

import org.tinylog.Logger;

import jp.co.comster.mediator.framework.LoginFrame;

public class MediatorMain {
	static public void main(String[] args) {
		Logger.info("Mediatorパターン開始");
		new LoginFrame("Mediator Sample");
	}
}
