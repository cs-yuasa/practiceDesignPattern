package jp.co.comster.interpreter.node;

import jp.co.comster.interpreter.framework.Context;
import jp.co.comster.interpreter.framework.ParseException;

/**
 * NonterminalExpression<br>
 * Nodeクラスを継承している<br>
 * &lt;repeat command&gt; ::= repeat &lt;number&gt; &lt;command list&gt; 
 * という構文を扱う
 */
public class RepeatCommandNode extends Node {
	private int number;
	private Node commandListNode;
	
	@Override
	public void parse(Context context) throws ParseException {
		context.skipToken("repeat");
		number = context.currentNumber();
		context.nextToken();
		commandListNode = new CommandListNode();
		commandListNode.parse(context);
	}
	
	@Override
	public String toString() {
		return "[repeat " + number + " " + commandListNode + "]";
	}
}
