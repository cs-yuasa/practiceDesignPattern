package jp.co.comster.command.drawer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import jp.co.comster.command.framework.MacroCommand;

/**
 * Receiver<br>
 * Drawableインターフェースを実装し、Canvasクラスを継承している
 */
public class DrawCanvas extends Canvas implements Drawable {
	/** 描画色 */
	private Color color;
	/** 描画する点の半径 */
	private int radius;
	/** 命令の履歴 */
	private MacroCommand history;
	
	public DrawCanvas(int width, int height, MacroCommand history) {
		setSize(width, height);
		setBackground(Color.white);
		this.history = history;
		init();
	}
	
	@Override
	public void init() {
		color = Color.red;
		radius = 6;
		history.append(new ColorCommand(this, color));
	}
	
	/**
	 *  履歴全体を再描画する
	 */
	@Override
	public void paint(Graphics g) {
		history.execute();
	}
	
	@Override
	public void draw(int x, int y) {
		Graphics g = getGraphics();
		g.setColor(color);
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}
	
	@Override
	public Color getColor() {
	    return this.color;
	}
	
	@Override
	public void setColor(Color color) {
		this.color = color;
	}
}
