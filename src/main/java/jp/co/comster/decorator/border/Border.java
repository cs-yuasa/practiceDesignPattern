package jp.co.comster.decorator.border;

import jp.co.comster.decorator.display.Display;

/**
 * Decorator<br>
 * Displayクラスを継承している
 */
public abstract class Border extends Display {
	protected Display display;
	
	protected Border(Display display) {
		this.display = display;
	}
}
