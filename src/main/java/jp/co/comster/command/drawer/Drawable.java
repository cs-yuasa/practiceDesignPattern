package jp.co.comster.command.drawer;

import java.awt.Color;

public interface Drawable {
	
	/**
	 * 初期化処理
	 */
	public abstract void init();
	
	/**
	 * 描画する
	 * 
	 * @param x X座標
	 * @param y Y座標
	 */
	public abstract void draw(int x, int y);
	public abstract Color getColor();
	public abstract void setColor(Color color);
}
