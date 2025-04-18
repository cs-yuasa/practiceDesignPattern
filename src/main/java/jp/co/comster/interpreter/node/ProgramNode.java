package jp.co.comster.interpreter.node;

import jp.co.comster.interpreter.framework.Context;
import jp.co.comster.interpreter.framework.ParseException;

/**
 * NonterminalExpression<br>
 * Nodeクラスを継承している<br>
 * &lt;program&gt; ::= program &lt;command list&gt; 
 * という構文を扱う
 */
public class ProgramNode extends Node {
	private Node commandListNode;
	
	@Override
	public void parse(Context context) throws ParseException {
		context.skipToken("program");
		commandListNode = new CommandListNode();
		commandListNode.parse(context);
	}
	
	@Override
	public String toString() {
		return "[program " + commandListNode + "]";
	}
}
