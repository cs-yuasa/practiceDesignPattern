package jp.co.comster.state;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.CountDownLatch;

import org.tinylog.Logger;

import jp.co.comster.state.context.SafeFrame;

public class StateMain {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(1);
		SafeFrame frame = new SafeFrame("State Sample");
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				latch.countDown();
			}
		});
		
		int hour = 0;
		while (latch.getCount() > 0) {
			frame.setClock(hour);
			hour = (hour + 1) % 24;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				Logger.error(e, "InterruptedException occurred");
				break;
			}
		}
		Logger.info("Stateパターン終了");
	}
}
