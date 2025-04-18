package jp.co.comster.interpreter.node;

import jp.co.comster.interpreter.framework.Context;
import jp.co.comster.interpreter.framework.ParseException;

/**
 * NonterminalExpression<br>
 * Nodeクラスを継承している<br>
 * &lt;command&gt; ::= &lt;repeat command&gt; | &lt;primitive command&gt; 
 * という構文を扱う
 */
public class CommandNode extends Node {
	private Node node;
	
	@Override
	public void parse(Context context) throws ParseException {
		if (context.currentToken().equals("repeat")) {
			node = new RepeatCommandNode();
			node.parse(context);
		} else {
			node = new PrimitiveCommandNode();
			node.parse(context);
		}
	}
	
	@Override
	public String toString() {
		return node.toString();
	}
}
