package jp.co.comster.mediator;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.CountDownLatch;

import org.tinylog.Logger;

import jp.co.comster.mediator.framework.LoginFrame;

public class MediatorMain {
	static public void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(1);
		Frame frame = new LoginFrame("Mediator Sample");
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				latch.countDown();
			}
		});
		try {
			latch.await();
		} catch (InterruptedException e) {
			Logger.error(e, "InterruptedException occurred");
		}
		Logger.info("Mediatorパターン終了");
	}
}
