package jp.co.comster.interpreter;

import java.nio.file.Files;
import java.nio.file.Path;

import org.tinylog.Logger;

import jp.co.comster.interpreter.framework.Context;
import jp.co.comster.interpreter.node.Node;
import jp.co.comster.interpreter.node.ProgramNode;

/**
 * Client
 */
public class InterpreterMain {
	public static void main(String[] args) {
		try {
			for (String text: Files.readAllLines(Path.of("src/main/resources/interpreter/program.txt"))) {
				Logger.info("text = \"" + text + "\"");
				Node node = new ProgramNode();
				node.parse(new Context(text));
				Logger.info("node = " + node);
			}
		} catch (Exception e) {
			Logger.error(e, "Exception occurred");
		}
	}
}
