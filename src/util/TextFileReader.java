package util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class TextFileReader {
	
	public static Collection<String> read(String path, String delimiter) {
		Collection<String> strings = new ArrayList<>();
		InputStream input = TextFileReader.class.getResourceAsStream(path);
		try (Scanner reader = new Scanner(input)) {
			reader.useDelimiter("\n");
			while (reader.hasNext()) {
				strings.add(reader.next());
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strings;
	}

}
