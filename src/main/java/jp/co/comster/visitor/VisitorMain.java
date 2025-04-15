package jp.co.comster.visitor;

import org.tinylog.Logger;

import jp.co.comster.visitor.behavior.FileFindVisitor;
import jp.co.comster.visitor.behavior.ListVisitor;
import jp.co.comster.visitor.stracture.Directory;
import jp.co.comster.visitor.stracture.File;

public class VisitorMain {
	public static void main(String[] args) {
		Logger.info("Making user entries...");
		Directory rootdir = new Directory("root");
		Directory usrdir = new Directory("usr");
		Directory yuki = new Directory("yuki");
		Directory hanako = new Directory("hanako");
		Directory tomura = new Directory("tomura");
		rootdir.add(usrdir);
		usrdir.add(yuki);
		usrdir.add(hanako);
		usrdir.add(tomura);
		yuki.add(new File("diary.html", 100));
		yuki.add(new File("Composite.java", 200));
		hanako.add(new File("memo.tex", 300));
		hanako.add(new File("index.html", 350));
		tomura.add(new File("game.doc", 400));
		tomura.add(new File("junk.mail", 500));
		ListVisitor lv = new ListVisitor();
		rootdir.accept(lv);
		lv.printList();
		
		FileFindVisitor ffv = new FileFindVisitor(".html");
		rootdir.accept(ffv);
		
		StringBuilder sb = new StringBuilder();
		sb.append("HTML files are:\n");
		for (File file: ffv.getFoundFiles()) {
			sb.append(file).append("\n");
		}
		Logger.info(sb);
	}
}

