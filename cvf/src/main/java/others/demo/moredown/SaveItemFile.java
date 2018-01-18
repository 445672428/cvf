package others.demo.moredown;

import java.io.IOException;
import java.io.RandomAccessFile;

public class SaveItemFile {
	// 存储文件
	private RandomAccessFile itemFile;

	public SaveItemFile() throws IOException {
		this("", 0);
	}
	// 文件路径 名称和写入点
	public SaveItemFile(String name, long pos) throws IOException {
		itemFile = new RandomAccessFile(name, "rw");
		// 指定的pos位置开始写入数据
		itemFile.seek(pos);
	}
	/**
	 * 同步方法写入文件 缓冲数组 起始位置 长度
	 */
	public synchronized int write(byte[] buffer, int start, int length) {
		int i = 1;
		try {
			itemFile.write(buffer, start, length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i = length;
		return i;
	}

	public void close() throws IOException {
		if (itemFile != null) {
			itemFile.close();
		}
	}
}
