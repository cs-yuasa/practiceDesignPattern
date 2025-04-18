package jp.co.comster.command.drawer;

import java.awt.Color;

import jp.co.comster.command.framework.Command;

/**
 * ConcreteCommand<br>
 * Commandインターフェースを実装している
 */
public class ColorCommand implements Command {
	/** 描画対象 */
	protected Drawable drawable;
	/** 描画色 */
	private Color color;
	
	public ColorCommand(Drawable drawable, Color color) {
		this.drawable = drawable;
		this.color = color;
	}
	
	@Override
	public void execute() {
		drawable.setColor(color);
	}
}
