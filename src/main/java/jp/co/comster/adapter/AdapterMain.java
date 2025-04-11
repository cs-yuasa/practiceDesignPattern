package jp.co.comster.adapter;

import java.io.IOException;

import org.tinylog.Logger;

import jp.co.comster.adapter.fileio.FileIO;
import jp.co.comster.adapter.fileio.FileProperties;

/**
 * Client
 */
public class AdapterMain {
	public static void main(String[] args) {
		FileIO f = new FileProperties();
		try {
			f.readFromFile("src/main/resources/adapter/file.txt");
			f.setValue("width", "1024");
			f.setValue("height", "512");
			f.setValue("depth", "32");
			f.writeToFile("src/main/resources/adapter/newFile.txt");
			Logger.info("newfile.txt is created.");
		} catch (IOException e) {
			Logger.error(e, "IOException occurred");
		}
	}
}
