package jp.co.comster.facade;

import jp.co.comster.facade.pagemaker.PageMaker;

/**
 * Client
 */
public class FacadeMain {
	public static void main(String[] args) {
		PageMaker.makeWelcomePage("hyuki@example.com", "welcome.html");
		PageMaker.makeLinkPage("linkpage.html");
	}
}
