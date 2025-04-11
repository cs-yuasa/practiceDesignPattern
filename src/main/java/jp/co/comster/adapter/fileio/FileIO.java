package jp.co.comster.adapter.fileio;

import java.io.IOException;

/**
 * Target
 */
public interface FileIO {
	public void readFromFile(String filepass) throws IOException;
	public void writeToFile(String filepass) throws IOException;
	public void setValue(String key, String value);
	public String getValue(String key);
}
