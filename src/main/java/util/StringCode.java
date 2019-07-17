package util;

import java.io.UnsupportedEncodingException;

public class StringCode {

	public static String transformCode(String text) {
		try {
			byte[] utf8Bytes = text.getBytes("UTF-8");
			text = new String(utf8Bytes,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;
	}
}
