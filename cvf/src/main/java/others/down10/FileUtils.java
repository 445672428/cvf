package others.down10;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils {
	public static byte[] fileToBytes(String filename) {
		File file = new File(filename);
		InputStream in = null;
		try {
			in = new FileInputStream(file);
			byte[] bytes = inputStreamToByte(in);
			in.close();
			return bytes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static byte[] inputStreamToByte(InputStream in) throws IOException {
		int ch;
		ByteArrayOutputStream bytesArray = new ByteArrayOutputStream();
		while ((ch = in.read()) != -1) {
			bytesArray.write(ch);
		}
		byte[] bytes = bytesArray.toByteArray();
		bytesArray.close();
		return bytes;
	}

	public static boolean deleteFile(String filename) {
		File file = new File(filename);
		if ((file.exists()) && (file.isFile())) {
			return (file.delete());
		}

		return false;
	}
}
