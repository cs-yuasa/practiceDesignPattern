package jp.co.comster.command.framework;

import java.util.ArrayDeque;
import java.util.Deque;

import org.tinylog.Logger;

/**
 * ConcreteCommand<br>
 * Commandインターフェースを実装している
 */
public class MacroCommand implements Command {
	/** 命令の列 */
	private Deque<Command> commands = new ArrayDeque<>();
	
	@Override
	public void execute() {
		for (Command cmd: commands) {
			cmd.execute();
		}
	}
	
	/**
	 * 命令を追加する
	 * 
	 * @param cmd 命令
	 */
	public void append(Command cmd) {
		if (cmd == this) {
			IllegalArgumentException e = new IllegalArgumentException("infinite loop caused by append");
			Logger.error(e, "IllegalArgumentException occurred");
			throw e;
		}
		commands.addLast(cmd);
	}
	
	/**
	 *  最後の命令を削除する
	 */
	public void undo() {
		if (!commands.isEmpty()) {
			commands.removeLast();
		}
	}
	
	/**
	 *  全ての命令を削除する
	 */
	public void clear() {
		commands.clear();
	}
}
