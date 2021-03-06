package com.utils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.SequenceInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.imageio.ImageIO;

import contant.Contant;

public class FileUtils {
	/**
	 * 文件合并
	 * 
	 * @throws IOException
	 */
	public static void mergeFile(String fileName, String REALIP)
			throws IOException {
		String filePath = Contant.TMP_DIR + REALIP;
		File file = new File(filePath);
		List<FileInputStream> fileList = new ArrayList<FileInputStream>();
		if (file.listFiles().length > 0) {
			for (File f : file.listFiles()) {
				fileList.add(new FileInputStream(f));
			}
			Enumeration<FileInputStream> enumerationFile = Collections
					.enumeration(fileList);
			SequenceInputStream sequence = new SequenceInputStream(
					enumerationFile);
			File realFile = new File(Contant.USR_DIR);
			if (realFile.exists()) {
				realFile.mkdir();
			}
			FileOutputStream outputStream = new FileOutputStream(new File(
					Contant.USR_DIR, fileName));
			byte[] buffer = new byte[1024];
			int len;
			while ((len = sequence.read(buffer)) != -1) {
				outputStream.write(buffer, 0, len);
			}
			outputStream.flush();
			outputStream.close();
			sequence.close();
		}
	}

	/**
	 * 文件合并
	 * 
	 * @param fileName
	 *            合并文件名称
	 * @param tmpPath
	 *            分块文件临时存放文件路径
	 */
	public static void mergeMoreFile(String fileName, String tmpPath) {
		File file = new File(tmpPath);
		List<FileInputStream> fileList = new ArrayList<FileInputStream>();
		try {
			for (File f : file.listFiles()) {
				fileList.add(new FileInputStream(f));
				Enumeration<FileInputStream> enumerationFile = Collections
						.enumeration(fileList);
				SequenceInputStream sequence = new SequenceInputStream(
						enumerationFile);
				File realFile = new File(Contant.USR_DIR);
				if (realFile.exists()) {
					realFile.mkdir();
				}
				FileOutputStream outputStream = new FileOutputStream(new File(
						Contant.USR_DIR, fileName));
				byte[] buffer = new byte[1024];
				int len;
				while ((len = sequence.read(buffer)) != -1) {
					outputStream.write(buffer, 0, len);
				}
				outputStream.flush();
				outputStream.close();
				sequence.close();
			}
			// 删除当前临时文件下面所有文件
			deleteFile(new File(tmpPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 分块切割文件
	 * 
	 * @param fileName
	 *            需要分割文件名称
	 * @param tmpPathName
	 *            临时文件路径
	 * @throws IOException
	 */
	public static void splitChunkFile(String fileName, String tmpPathName)
			throws IOException {
		File srcFile = new File(fileName);
		File tempFile = new File(tmpPathName);
		// 读取源地址文件
		FileInputStream fis = new FileInputStream(srcFile);
		FileOutputStream fos = null;
		// 是否为文件，不是就创建
		if (!tempFile.isFile()) {
			tempFile.mkdirs();
		}
		byte[] b = new byte[1024];
		int len = 0;
		int count = 0;
		while ((len = fis.read(b)) != -1) {
			int num = count++;
			// 写入暂存地址目录中
			fos = new FileOutputStream(new File(tempFile, num + ".part"));
			fos.write(b, 0, len);

		}
		fos.flush();
		fos.close();
		fis.close();
	}

	/**
	 * 读取txt文件的内容
	 * 
	 * @param file
	 *            想要读取的文件对象
	 * @return 返回文件内容
	 */
	public static String readTextAllContent(File file) {
		StringBuilder result = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			// 构造一个BufferedReader类来读取文件
			String s = null;
			while ((s = br.readLine()) != null) {
				// 使用readLine方法，一次读一行
				result.append(System.lineSeparator() + s);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	/*
	 * 删除所有文件
	 */
	public static void deleteFile(File file) {
		if (file.exists()) {// 判断文件是否存在
			if (file.isFile()) {// 判断是否是文件
				file.delete();// 删除文件
			} else if (file.isDirectory()) {// 否则如果它是一个目录
				File[] files = file.listFiles();// 声明目录下所有的文件 files[];
				for (int i = 0; i < files.length; i++) {// 遍历目录下所有的文件
					deleteFile(files[i]);// 把每个文件用这个方法进行迭代
				}
				file.delete();// 删除文件夹
			}
		}
	}

	/**
	 * 创建文件
	 * 
	 * @param fileName
	 *            文件名称
	 * @param filecontent
	 *            文件内容
	 * @return 是否创建成功，成功则返回true
	 */
	public static boolean createFile(String fileName, String filecontent) {
		boolean flag = true;
		File file = new File(fileName);
		try {
			// 如果文件不存在，则创建新的文件
			if (!file.exists()) {
				file.createNewFile();
				// 创建文件成功后，写入内容到文件里
				flag = writeFileContent(fileName, filecontent);
			}
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	/**
	 * 向文件中写入内容
	 * 
	 * @param filepath
	 *            文件路径与名称
	 * @param newstr
	 *            写入的内容
	 * @return
	 * @throws IOException
	 */
	public static boolean writeFileContent(String filepath, String newstr)
			throws IOException {
		Boolean bool = false;
		String temp = "";

		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		FileOutputStream fos = null;
		PrintWriter pw = null;
		try {
			File file = new File(filepath);// 文件路径(包括文件名称)
			// 将文件读入输入流
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			StringBuffer buffer = new StringBuffer();
			// 文件原有内容
			for (int i = 0; (temp = br.readLine()) != null; i++) {
				buffer.append(temp);
				// 行与行之间的分隔符 相当于“\n”
				buffer = buffer.append(System.getProperty("line.separator"));
			}
			buffer.append(newstr);

			fos = new FileOutputStream(file);
			pw = new PrintWriter(fos);
			pw.write(buffer.toString().toCharArray());
			pw.flush();
			bool = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
			if (fos != null) {
				fos.close();
			}
			if (br != null) {
				br.close();
			}
			if (isr != null) {
				isr.close();
			}
			if (fis != null) {
				fis.close();
			}
		}
		return bool;
	}

	/**
	 * 以字符为单位读取文件，常用于读文本，数字等类型的文件
	 * 
	 * @param fileName
	 *            文件名
	 */
	public static String readFileByChars(String fileName, String result) {
		Reader reader = null;
		try {
			char[] tempchars = new char[30];
			int charread = 0;
			reader = new InputStreamReader(new FileInputStream(fileName));
			while ((charread = reader.read(tempchars)) != -1) {
				if ((charread == tempchars.length)&& (tempchars[tempchars.length - 1] != 'r')) {
					
				} else {
					for (int i = 0; i < charread; i++) {
						if (tempchars[i] == 'r') {
							continue;
						} else {
							result += tempchars[i];
						}
					}
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return result;
	}

	/**
	 * 随机读取文件内容
	 * 
	 * @param fileName
	 *            文件名
	 */
	public static void readFileByRandomAccess(String fileName) {
		RandomAccessFile randomFile = null;
		try {
			// 打开一个随机访问文件流，按只读方式
			randomFile = new RandomAccessFile(fileName, "r");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			// 读文件的起始位置
			int beginIndex = (fileLength > 4) ? 4 : 0;
			// 将读文件的开始位置移到beginIndex位置。
			randomFile.seek(beginIndex);
			byte[] bytes = new byte[10];
			int byteread = 0;
			// 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。
			// 将一次读取的字节数赋给byteread
			while ((byteread = randomFile.read(bytes)) != -1) {
				System.out.write(bytes, 0, byteread);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (randomFile != null) {
				try {
					randomFile.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	/**
	 * A方法追加文件：使用RandomAccessFile
	 * 
	 * @param fileName
	 *            文件名
	 * @param content
	 *            追加的内容
	 */
	public static void appendMethodTxt(String fileName,String content) {
		try {
			// 打开一个随机访问文件流，按读写方式
			RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			// 将写文件指针移到文件尾。
			randomFile.seek(fileLength);
			randomFile.writeBytes(content);
			randomFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * B方法追加文件：使用FileWriter
	 * 
	 * @param fileName
	 * @param content
	 */
	public static void appendFileWriterTxt(String fileName, String content) {
		try {
			// 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
			FileWriter writer = new FileWriter(fileName, true);
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ********************************************************** 大文件读取
	// ***************************************************************************//

	public static void bigFile() throws IOException {
		RandomAccessFile rf = new RandomAccessFile("rtest.dat", "rw");
		for (int i = 0; i < 10; i++) {
			// 写入基本类型double数据
			rf.writeDouble(i * 1.414);
		}
		rf.close();
		rf = new RandomAccessFile("rtest.dat", "rw");
		// 直接将文件指针移到第5个double数据后面
		rf.seek(5 * 8);
		// 覆盖第6个double数据
		rf.writeDouble(47.0001);
		rf.close();
		rf = new RandomAccessFile("rtest.dat", "r");
		rf.close();
	}

	static int length = 0x8000000; // 128 Mb

	public static void bigSeek() throws Exception {
		// 为了以可读可写的方式打开文件，这里使用RandomAccessFile来创建文件。
		FileChannel fc = new RandomAccessFile("test.dat", "rw").getChannel();
		// 注意，文件通道的可读可写要建立在文件流本身可读写的基础之上
		MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, length);
		// 写128M的内容
		for (int i = 0; i < length; i++) {
			out.put((byte) 'x');
		}
		fc.close();
	}

	public static void randomAccessFileDemo() throws IOException {
		RandomAccessFile file = new RandomAccessFile("file", "rw");
		// 以下向file文件中写数据
		file.writeInt(20);// 占4个字节
		file.writeDouble(8.236598);// 占8个字节
		file.writeUTF("这是一个UTF字符串");// 这个长度写在当前文件指针的前两个字节处，可用readShort()读取
		file.writeBoolean(true);// 占1个字节
		file.writeShort(395);// 占2个字节
		file.writeLong(2325451l);// 占8个字节
		file.writeUTF("又是一个UTF字符串");
		file.writeFloat(35.5f);// 占4个字节
		file.writeChar('a');// 占2个字节

		file.seek(0);// 把文件指针位置设置到文件起始处

		// 以下从file文件中读数据，要注意文件指针的位置

		file.skipBytes(3);// 将文件指针跳过3个字节，本例中即跳过了一个boolean值和short值。

		file.skipBytes(file.readShort()); // 跳过文件中“又是一个UTF字符串”所占字节，注意readShort()方法会移动文件指针，所以不用加2。

		// 以下演示文件复制操作
		//——————文件复制（从file到fileCopy）——————;
		file.seek(0);
		RandomAccessFile fileCopy = new RandomAccessFile("fileCopy", "rw");
		int len = (int) file.length();// 取得文件长度（字节数）
		byte[] b = new byte[len];
		file.readFully(b);
		fileCopy.write(b);
	}

	/**
	 * 
	 * @param skip
	 *            跳过多少过字节进行插入数据
	 * @param str
	 *            要插入的字符串
	 * @param fileName
	 *            文件路径
	 */
	public static void beiju(long skip, String str, String fileName) {
		try {
			RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
			if (skip < 0 || skip > raf.length()) {
				//"跳过字节数无效;
				return;
			}
			byte[] b = str.getBytes();
			raf.setLength(raf.length() + b.length);
			for (long i = raf.length() - 1; i > b.length + skip - 1; i--) {
				raf.seek(i - b.length);
				byte temp = raf.readByte();
				raf.seek(i);
				raf.writeByte(temp);
			}
			raf.seek(skip);
			raf.write(b);
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试利用多线程进行文件的写操作
	 */

	public static void runFile() throws Exception {
		// 预分配文件所占的磁盘空间，磁盘中会创建一个指定大小的文件
		RandomAccessFile raf = new RandomAccessFile("D://abc.txt", "rw");
		raf.setLength(1024 * 1024); // 预分配 1M 的文件空间
		raf.close();

		// 所要写入的文件内容
		String s1 = "第一个字符串";
		String s2 = "第二个字符串";
		String s3 = "第三个字符串";
		String s4 = "第四个字符串";
		String s5 = "第五个字符串";

		// 利用多线程同时写入一个文件
		new FileWriteThread(1024 * 1, s1.getBytes()).start(); // 从文件的1024字节之后开始写入数据
		new FileWriteThread(1024 * 2, s2.getBytes()).start(); // 从文件的2048字节之后开始写入数据
		new FileWriteThread(1024 * 3, s3.getBytes()).start(); // 从文件的3072字节之后开始写入数据
		new FileWriteThread(1024 * 4, s4.getBytes()).start(); // 从文件的4096字节之后开始写入数据
		new FileWriteThread(1024 * 5, s5.getBytes()).start(); // 从文件的5120字节之后开始写入数据
	}

	// 利用线程在文件的指定位置写入指定数据
	static class FileWriteThread extends Thread {
		private int skip;
		private byte[] content;

		public FileWriteThread(int skip, byte[] content) {
			this.skip = skip;
			this.content = content;
		}

		public void run() {
			RandomAccessFile raf = null;
			try {
				raf = new RandomAccessFile("D://abc.txt", "rw");
				raf.seek(skip);
				raf.write(content);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					raf.close();
				} catch (Exception e) {
				}
			}
		}
	}

	/**
	 * 图片转为二进制
	 * 
	 * @throws IOException
	 */
	public byte[] imageToBinary(String fileName) throws IOException {
		File file = new File(fileName);
		BufferedImage bf = ImageIO.read(file);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bf, "jpg", baos); // 经测试转换的图片是格式这里就什么格式，否则会失真
		byte[] bytes = baos.toByteArray();
		return bytes;
	}
	/**
	 * 图片转为二进制
	 * 
	 * @throws IOException
	 */
	public void imageToBinary(byte[] bytes,String path) throws IOException {
         ByteArrayInputStream bais = new ByteArrayInputStream(bytes);  
         BufferedImage bi1 = ImageIO.read(bais);  
         File w2 = new File(path);// 可以是jpg,png,gif格式  
         ImageIO.write(bi1, "jpg", w2);// 不管输出什么格式图片，此处不需改动  
	}
	

	// ********************************************************** File的所有操作
	// ***************************************************************************//

	public static void main(String[] args) throws Exception {
		 File file = new File("D:\\BaiduNetdiskDownload\\2000w.sql");//Text文件
         BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
         String s = null;
         int count = 0;
         while((s = br.readLine())!=null){//使用readLine方法，一次读一行
             count++;
         }
         br.close();
	}
}
