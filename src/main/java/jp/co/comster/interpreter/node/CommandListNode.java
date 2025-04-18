package jp.co.comster.interpreter.node;

import java.util.ArrayList;
import java.util.List;

import jp.co.comster.interpreter.framework.Context;
import jp.co.comster.interpreter.framework.ParseException;

/**
 * NonterminalExpression<br>
 * Nodeクラスを継承している<br>
 * &lt;command list&gt; ::= &lt;command&gt;* end 
 * という構文を扱う
 */
public class CommandListNode extends Node {
	private List<Node> list = new ArrayList<>();
	
	@Override
	public void parse(Context context) throws ParseException {
		while (true) {
			if (context.currentToken() == null) {
				throw new ParseException("Error: Missing 'end'");
			} else if (context.currentToken().equals("end")) {
				context.skipToken("end");
				break;
			} else {
				Node commandNode = new CommandNode();
				commandNode.parse(context);
				list.add(commandNode);
			}
		}
	}
	
	@Override
	public String toString() {
		return list.toString();
	}
}
