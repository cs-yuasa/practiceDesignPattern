package jp.co.comster.composite;

import org.tinylog.Logger;

import jp.co.comster.composite.structure.Directory;
import jp.co.comster.composite.structure.File;

/**
 * Client
 */
public class CompositeMain {
	public static void main(String[] args) {
		Logger.info("Making root entries...");
		Directory rootdir = new Directory("root");
		Directory bindir = new Directory("bin");
		Directory tmpdir = new Directory("tmp");
		Directory usrdir = new Directory("usr");
		rootdir.add(bindir);
		rootdir.add(tmpdir);
		rootdir.add(usrdir);
		bindir.add(new File("vi", 10000));
		bindir.add(new File("latex", 20000));
		rootdir.printList();
		
		Logger.info("Making user entries...");
		Directory yuki = new Directory("yuki");
		Directory hanako = new Directory("hanako");
		Directory tomura = new Directory("tomura");
		usrdir.add(yuki);
		usrdir.add(hanako);
		usrdir.add(tomura);
		yuki.add(new File("diary.html", 100));
		yuki.add(new File("Composite.java", 200));
		hanako.add(new File("memo.tex", 300));
		tomura.add(new File("game.doc", 400));
		tomura.add(new File("junk.mail", 500));
		rootdir.printList();
		
		Logger.info("tmpのフルパス: " + tmpdir.getFullPass());
		Logger.info("yukiのフルパス: " + yuki.getFullPass());
	}
}
