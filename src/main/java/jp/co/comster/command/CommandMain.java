package jp.co.comster.command;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.CountDownLatch;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.tinylog.Logger;

import jp.co.comster.command.drawer.ColorCommand;
import jp.co.comster.command.drawer.DrawCanvas;
import jp.co.comster.command.drawer.DrawCommand;
import jp.co.comster.command.framework.Command;
import jp.co.comster.command.framework.MacroCommand;

/**
 * Clien・Invoker<br>
 * JFrameクラスを継承している
 */
public class CommandMain extends JFrame {
	/** 描画履歴 */
	private MacroCommand history = new MacroCommand();
	/** 描画領域 */
	private DrawCanvas canvas = new DrawCanvas(400, 400, history);
	/** 赤ボタン */
	private JButton redButton = new JButton("red");
	/** 緑ボタン */
	private JButton greenButton = new JButton("green");
	/** 青ボタン */
	private JButton blueButton = new JButton("blue");
	/** ひとつ戻るボタン */
	private JButton undoButton = new JButton("undo");
	/** 消去ボタン */
	private JButton clearButton  = new JButton("clear");
	
	public CommandMain(String title, CountDownLatch latch) {
		super(title);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				latch.countDown();
			}
		});
		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Command cmd = new DrawCommand(canvas, e.getPoint());
				history.append(cmd);
				cmd.execute();
			}
		});
		redButton.addActionListener(e -> {
			Command cmd = new ColorCommand(canvas, Color.red);
			history.append(cmd);
			cmd.execute();
		});
		greenButton.addActionListener(e -> {
			Command cmd = new ColorCommand(canvas, Color.green);
			history.append(cmd);
			cmd.execute();
		});
		blueButton.addActionListener(e -> {
			Command cmd = new ColorCommand(canvas, Color.blue);
			history.append(cmd);
			cmd.execute();
		});
		undoButton.addActionListener(e -> {
			history.undo();
			canvas.repaint();
		});
		clearButton.addActionListener(e -> {
			history.clear();
			canvas.init();
			canvas.repaint();
		});
		
		Box buttonBox = new Box(BoxLayout.X_AXIS);
		buttonBox.add(redButton);
		buttonBox.add(greenButton);
		buttonBox.add(blueButton);
		buttonBox.add(undoButton);
		buttonBox.add(clearButton);
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		mainBox.add(buttonBox);
		mainBox.add(canvas);
		getContentPane().add(mainBox);
		
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(1);
		new CommandMain("Command Pattern Sample", latch);
		try {
			latch.await();  // ウィンドウが閉じられるまで待機
		} catch (InterruptedException e) {
			Logger.error(e, "InterruptedException occurred");
		}
		Logger.info("Commandパターン終了");
	}
}
