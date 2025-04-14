package jp.co.comster.bridge.concreteimplementor;

import org.tinylog.Logger;

import jp.co.comster.bridge.implementor.DisplayImpl;

/**
 * ConcreteImplemntor<br>
 * DisplayImplクラスを継承している
 */
public class CharDisplayImpl extends DisplayImpl {
	private StringBuilder sb = new StringBuilder();
	private char head;
	private char body;
	private char foot;
	
	public CharDisplayImpl(char head, char body, char foot) {
		this.head = head;
		this.body = body;
		this.foot = foot;
	}
	
	@Override
	public void rawOpen() {
		sb.append(head);
	}

	@Override
	public void rawPrint() {
		sb.append(body);
	}
	
	@Override
	public void rawClose() {
		sb.append(foot);
		Logger.info(sb);
		sb.setLength(0);
	}
}
