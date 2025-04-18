package jp.co.comster.command.drawer;

import java.awt.Point;

import jp.co.comster.command.framework.Command;

/**
 * ConcreteCommand<br>
 * Commandインターフェースを実装している
 */
public class DrawCommand implements Command {
	/** 描画対象 */
	protected Drawable drawable;
	/** 描画位置 */
	private Point position;
	
	public DrawCommand(Drawable drawable, Point position) {
		this.drawable = drawable;
		this.position = position;
	}
	
	@Override
	public void execute() {
		drawable.draw(position.x, position.y);
	}
}
