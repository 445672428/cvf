package com.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortUtils {
	public static void main(String[] args) {
		SortUtils  sortUtils = new SortUtils();
		sortUtils.testxxxSplistSort();
	}
	private static long TEN = 10;
	private static long HUNDRED = 100;
	private static long THOUSAND = 100;
	private static long MILLON = 10000;
	private static long TEN_MILLON = 100000;
	private static long HUNDRED_MILLON = 1000000;

	private static long THUNDRED_MILLON = 10000000;
	private static long BILLION = 100000000;
	private static long TEN_BILLION = 1000000000;
	private static long HUNDRED_BILLION = 10000000000L;
	private static long THUNDRED_BILLION = 100000000000L;

	private static String INPUT_FILE = "c:\\test\\input.txt";
	private static String OUTPUT_FILE = "c:\\test\\output.txt";

	// 拆分大小
	private static int SPLIT_SIZE = 10 * 1000;

	private static int numSize;
	
	
	public void testxxxSplistSort(){
		//createDir("c:\\test");
		try {
			//createFile(INPUT_FILE);
			//numSize = createRandomNum(THUNDRED_BILLION);
			sortFile(INPUT_FILE);
			long startTime = System.currentTimeMillis();
			splitFile(INPUT_FILE,numSize);
			List<String> splitFilePathList = new ArrayList<String>();
			File dir = new File("c:\\test\\temp");
			File[] files = dir.listFiles();
			for(File ff : files){
				splitFilePathList.add(ff.getAbsolutePath());
			}
			//合并文件
			createFile(OUTPUT_FILE);
			mergeFile(splitFilePathList, OUTPUT_FILE);
			System.gc();
			Runtime.getRuntime().exec(new String[]{"cmd","/c","del","c:\\test\\temp\\*.txt"});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createDir(String path) {
		File dir = new File(path);
		if (!dir.exists()) {
			if (dir.mkdir()) {
				System.out.println(dir.getName()+" is create");
			}
		}
	}

	public void createFile(String path) throws IOException {
		File file = new File(path);
		if (!file.exists()) {
			if (file.createNewFile()) {
				System.out.println(file.getName()+" is create");
			}
		}
	}
	/***
	 * 生成随机数
	 * @param path
	 */
	public int createRandomNum(long numSize) {
		Set<Integer> set = new LinkedHashSet<Integer>();
		int count = 0;
		boolean isSplit = false;
		while(count < numSize){
			int num = (int)(Math.random()*numSize + 1);
			if (set.add(num)) {
				count ++;
			}
			//拆分批量写入文件
			if (set.size()>=SPLIT_SIZE) {
				writeFile(INPUT_FILE, set, true);
				set.clear();
				isSplit = true;
			}
		}
		//从未拆分过则一次写入文件
		if(set.size()>0&&set.size()<SPLIT_SIZE&&isSplit){
			writeFile(INPUT_FILE, set, false);
		}else if(set.size() >0 && set.size() < SPLIT_SIZE && isSplit){
			//曾拆分过剩余部分写入文件
			writeFile(INPUT_FILE, set, true);
		}
		return count;
	}

	public void sortFile(String path) {
		SortedSet<Integer> set = new TreeSet<Integer>();
		File file = new File(path);
		try {
			FileReader reader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String value = null;
			while ((value = bufferedReader.readLine()) != null) {
				set.add(Integer.parseInt(value));
			}
			bufferedReader.close();
			reader.close();
			createFile("c:\\test\\input.txt");
			writeFile("c:\\test\\input.txt", set, false);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void writeFile(String path, Set<Integer> set, boolean isAppend) {
		File file = new File(path);
		try {
			//isAppend 是否追加
			FileWriter fileWriter = new FileWriter(file,isAppend);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			Iterator<Integer> iterator = set.iterator();
			while(iterator.hasNext()){
				bufferedWriter.write(iterator.next().toString());
			}
			bufferedWriter.flush();
			if (bufferedWriter!=null) {
				bufferedWriter.close();
			}
			if (fileWriter!=null) {
				fileWriter.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 拆分文件
	public void splitFile(String path, int numSize) {
		File file = new File(path);
		try {
			FileReader reader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(reader);
			SortedSet<Integer> set = new TreeSet<Integer>();
			String str = null;
			createDir("c:\\test\\temp");
			if (numSize>SPLIT_SIZE) {
				int count = 1;
				int fileNum = 1;
				while((str = bufferedReader.readLine())!=null){
					set.add(Integer.parseInt(str));
					//超过拆分数 写入子文件
					if (count>=SPLIT_SIZE) {
						createFile("c:\\test\\temp\\"+fileNum+".txt");
						writeFile("c:\\test\\temp\\"+fileNum+".txt", set, false);
						set.clear();
						count = 0;
						fileNum ++;
					}
					count ++; //读取文件当前行
				}
			}else{
				//总量未达到拆分文件 写入子文件
				while((str=bufferedReader.readLine())!=null){
					set.add(Integer.parseInt(str));
				}
				createFile("c:\\test\\temp\\1.txt");
				writeFile("c:\\test\\temp\\1.txt", set, false);
			}
			if(bufferedReader!=null){
				bufferedReader.close();
			}
			if (reader!=null) {
				reader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	// 合并文件
	public void mergeFile(List<String> splitFiles, String path) throws IOException {
		SortedSet<FileInfo> fileInfoSet = new TreeSet<FileInfo>(new FileInfoComparator());
		if (fileInfoSet.isEmpty()) {
			for(int i = 0; i < splitFiles.size(); i ++){
				File file = new File(splitFiles.get(i));
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				FileInfo info = new FileInfo();
				String splitFilePath = splitFiles.get(i);
				//文件号
				info.setFileNum(Integer.parseInt(splitFilePath.substring(splitFilePath.indexOf("\\")+1, splitFilePath.indexOf(".txt"))));
				info.setReader(bufferedReader);
				String value = bufferedReader.readLine();
				if (value!=null) {
					info.setValue(value);
					info.setLineNum(info.getLineNum()+1);//设置当前行号
					fileInfoSet.add(info);
				}
			}
		}
		Set<Integer> valueSet = new LinkedHashSet<Integer>();
		boolean isSplit = false;
		int count = 1;
		//输出set元素
		while(!fileInfoSet.isEmpty()){
			FileInfo currentFileInfo = fileInfoSet.first();
			valueSet.add(Integer.parseInt(currentFileInfo.getValue()));
			//拆分批量写入文件
			if (valueSet.size()>= SPLIT_SIZE) {
				writeFile(path, valueSet, true);
				valueSet.clear();
				isSplit = true;
			}
			FileInfo newFileInfo = new FileInfo();
			newFileInfo.setFileNum(currentFileInfo.getFileNum());
			newFileInfo.setLineNum(currentFileInfo.getLineNum());
			newFileInfo.setValue(currentFileInfo.getValue());
			newFileInfo.setReader(currentFileInfo.getReader());
			boolean isSuccess = newFileInfo.readNextValue();
			if (isSuccess) {
				if (fileInfoSet.remove(currentFileInfo)) {
					fileInfoSet.add(newFileInfo);//set中的fileinfo 重新排序
				}
			}else{
				//已经到文件末尾 从set中移除改文件
				fileInfoSet.remove(currentFileInfo);
			}
		}
		//从未拆分则一次性写入文件
		if (valueSet.size() > 0 && valueSet.size() < SPLIT_SIZE && !isSplit) {
			writeFile(path, valueSet, false);
		}else if(valueSet.size() > 0 && valueSet.size() < SPLIT_SIZE && isSplit){
			writeFile(path, valueSet, true);
		}
	}
	class FileInfo{
		//文件号
		private int fileNum;
		//当前行号 
		private int lineNum = 0;
		//当前值
		private String value;
		//bufferedReader 引用
		private BufferedReader reader;
		public boolean readNextValue() throws IOException{
			String value;
			if((value=this.reader.readLine())!=null){
				this.value = value;
				this.lineNum ++;
				return true;
			}else{
				this.reader.close();
				return false;
			}
		}
		public void setFileNum(int fileNum) {
			this.fileNum = fileNum;
		}
		public int getFileNum() {
			return fileNum;
		}
		public void setLineNum(int lineNum) {
			this.lineNum = lineNum;
		}
		public int getLineNum() {
			return lineNum;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public void setReader(BufferedReader reader) {
			this.reader = reader;
		}
		public BufferedReader getReader() {
			return reader;
		}
	}
	class FileInfoComparator implements Comparator<FileInfo>{
		@Override
		public int compare(FileInfo o1, FileInfo o2) {
			if (Integer.parseInt(o1.getValue())!=Integer.parseInt(o2.getValue())) {
				return Integer.parseInt(o1.getValue())-Integer.parseInt(o2.getValue());
			}else{
				//如果存在重复值 使用文件号比较
				return o1.getFileNum()-o2.getFileNum();
			}
		}
		
	}
	
	public void nearFile() {
		try {
			File file = new File("D:/排序/source.txt");
			int numCount = 10000000;
			Random r = new Random();
			if (file.exists())
				file.delete();
			FileWriter fw = new FileWriter(file);
			for (int i = 0; i < numCount; i++) {
				fw.write(r.nextInt() + "\n");
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void outSort() throws IOException {
		File file = new File("D:/排序/source.txt");
		BufferedReader fr = new BufferedReader(new FileReader(file));// 源数据文件读取。
		final int SIZE = 10000;// 这里是定义我们将源文件中以10000条记录作为单位进行分割。
		int[] nums = new int[SIZE];// 临时存放分割时的记录
		List<String> fileNames = new ArrayList<String>();// 保存所有分割文件的名称
		int index = 0;
		while (true) {
			String num = fr.readLine();// 从原文件中读取一条记录
			if (num == null) {// 如果读取完毕后，进行一次排序并保存
				fileNames.add(sortAndSave(nums, index));
				break;
			}
			nums[index] = Integer.valueOf(num);
			index++;
			if (index == SIZE) {// 当nums里面读的数字到达长度边界时，排序，存储
				fileNames.add(sortAndSave(nums, index));// sortAndSave是将nums中前index条记录先快速排序，然后存入文件，最好将文件名返回。
				index = 0;// 重置index
			}
		}
		fr.close();

		mergeSort(fileNames);// 将所有fileNames的文件进行合并

	}

	// sortAndSave是将nums中前index条记录先快速排序，然后存入文件，最好将文件名返回

	public static String sortAndSave(int[] nums, int size) throws IOException {
		quicksort.sort(nums, 0, size - 1);
		String fileName = "E:/排序/sort" + System.nanoTime() + ".txt";
		File rf = new File(fileName);
		BufferedWriter bw = new BufferedWriter(new FileWriter(rf));
		for (int i = 0; i < nums.length; i++)
			bw.write(nums[i] + "\n");
		bw.close();
		return fileName;
	}

	public static void mergeSort(List<String> fileNames) throws IOException {
		List<String> tempFileNames = new ArrayList<String>();
		for (int i = 0; i < fileNames.size(); i++) {
			String resultFileName = "E:/排序/sort" + System.nanoTime() + ".txt";
			File resultFile = new File(resultFileName);
			tempFileNames.add(resultFileName);
			BufferedWriter bw = new BufferedWriter(new FileWriter(resultFile));

			File file1 = new File(fileNames.get(i++));
			BufferedReader br1 = new BufferedReader(new FileReader(file1));
			if (i < fileNames.size()) {
				File file2 = new File(fileNames.get(i));
				BufferedReader br2 = new BufferedReader(new FileReader(file2));
				int num1 = 0;
				int num2 = 0;
				boolean isFirst = true;
				boolean firstNext = true;
				String numVal1 = null, numVal2 = null;
				for (;;) {
					if (isFirst) {
						numVal1 = br1.readLine();
						numVal2 = br2.readLine();
						num1 = Integer.valueOf(numVal1);
						num2 = Integer.valueOf(numVal2);
						isFirst = false;
					} else if (firstNext)
						numVal1 = br1.readLine();
					else
						numVal2 = br2.readLine();
					if (numVal1 != null && numVal2 != null) {
						if (firstNext) {
							num1 = Integer.valueOf(numVal1);
						} else {
							num2 = Integer.valueOf(numVal2);
						}
						if (num1 < num2) {
							bw.write(num1 + "\n");
							firstNext = true;
						} else {
							bw.write(num2 + "\n");
							firstNext = false;
						}
					} else {
						if (numVal1 != null)
							bw.write(numVal1 + "\n");
						if (numVal2 != null)
							bw.write(numVal2 + "\n");
						break;
					}
				}
				while (true) {
					numVal2 = br2.readLine();
					;
					if (numVal2 != null)
						bw.write(numVal2 + "\n");
					else
						break;
				}
				br2.close();
				file2.delete();
			}
			while (true) {
				String numVal1 = br1.readLine();
				if (numVal1 != null) {
					bw.write(numVal1 + "\n");
				} else
					break;
			}
			br1.close();
			file1.delete();
			bw.close();
		}
		int size = tempFileNames.size();
		if (size > 1) {
			mergeSort(tempFileNames);
		} else if (size == 1) {
			File file = new File(tempFileNames.get(0));
			file.renameTo(new File("E:/排序/result.txt"));
		}
	}

}

// 快速排序
class quicksort {
	public static void sort(int data[], int low, int hight) {
		quicksort qs = new quicksort();
		qs.data = data;
		qs.sort(low, hight);
	}

	public int data[];

	private int partition(int sortArray[], int low, int hight) {
		int key = sortArray[low];
		while (low < hight) {
			while (low < hight && sortArray[hight] >= key)
				hight--;
			sortArray[low] = sortArray[hight];
			while (low < hight && sortArray[low] <= key)
				low++;
			sortArray[hight] = sortArray[low];
		}
		sortArray[low] = key;
		return low;
	}

	public void sort(int low, int hight) {
		if (low < hight) {
			int result = partition(data, low, hight);
			sort(low, result - 1);
			sort(result + 1, hight);
		}
	}

	public void display() {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print(" ");
		}
	}

	public static int BUFFER_SIZE = 10;

	public File sort(File file) throws IOException {
		ArrayList<File> files = split(file);
		return process(files);
	}

	// recursive method to merge the lists until we are left with a
	// single merged list
	private File process(ArrayList<File> list) throws IOException {
		if (list.size() == 1) {
			return list.get(0);
		}
		ArrayList<File> inter = new ArrayList<File>();
		for (Iterator<File> itr = list.iterator(); itr.hasNext();) {
			File one = itr.next();
			if (itr.hasNext()) {
				File two = itr.next();
				inter.add(merge(one, two));
			} else {
				return one;
			}
		}
		return process(inter);
	}

	/**
	 * Splits the original file into a number of sub files.
	 */
	private ArrayList<File> split(File file) throws IOException {
		ArrayList<File> files = new ArrayList<File>();
		int[] buffer = new int[BUFFER_SIZE];
		FileInputStream fr = new FileInputStream(file);
		boolean fileComplete = false;
		while (!fileComplete) {
			int index = buffer.length;
			for (int i = 0; i < buffer.length && !fileComplete; i++) {
				buffer[i] = readInt(fr);
				if (buffer[i] == -1) {
					fileComplete = true;
					index = i;
				}
			}
			if (buffer[0] > -1) {
				Arrays.sort(buffer, 0, index);
				File f = new File("set" + new Random().nextInt());
				FileOutputStream writer = new FileOutputStream(f);
				for (int j = 0; j < index; j++) {
					writeInt(buffer[j], writer);
				}
				writer.close();
				files.add(f);
			}

		}
		fr.close();
		return files;
	}

	/**
	 * Merges two sorted files into a single file.
	 * 
	 * @param one
	 * @param two
	 * @return
	 * @throws IOException
	 */
	private File merge(File one, File two) throws IOException {
		FileInputStream fis1 = new FileInputStream(one);
		FileInputStream fis2 = new FileInputStream(two);
		File output = new File("merged" + new Random().nextInt());
		FileOutputStream os = new FileOutputStream(output);
		int a = readInt(fis1);
		int b = readInt(fis2);
		boolean finished = false;
		while (!finished) {
			if (a != -1 && b != -1) {
				if (a < b) {
					writeInt(a, os);
					a = readInt(fis1);
				} else {
					writeInt(b, os);
					b = readInt(fis2);
				}
			} else {
				finished = true;
			}

			if (a == -1 && b != -1) {
				writeInt(b, os);
				b = readInt(fis2);
			} else if (b == -1 && a != -1) {
				writeInt(a, os);
				a = readInt(fis1);
			}
		}
		os.close();
		return output;
	}

	private void writeInt(int value, FileOutputStream merged)
			throws IOException {
		merged.write(value);
		merged.write(value >> 8);
		merged.write(value >> 16);
		merged.write(value >> 24);
		merged.flush();
	}

	private int readInt(FileInputStream fis) throws IOException {
		int buffer = fis.read();
		if (buffer == -1) {
			return -1;
		}
		buffer |= (fis.read() << 8);
		buffer |= (fis.read() << 16);
		buffer |= (fis.read() << 24);
		return buffer;
	}

	public void print(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public void insertSort(int[] a) {
		for (int i = 1; i < a.length; i++) {// 从头部第一个当做已经排好序的，把后面的一个一个的插到已经排好的列表中去。
			int j;
			int x = a[i];// x为待插入元素
			for (j = i; j > 0 && x < a[j - 1]; j--) {// 通过循环，逐个后移一位找到要插入的位置。
				a[j] = a[j - 1];
			}
			a[j] = x;// 插入
		}

	}

	private void shellSort(int[] a) {
		int dk = a.length / 2;
		while (dk >= 1) {
			ShellInsertSort(a, dk);
			dk = dk / 2;
		}
	}

	private void ShellInsertSort(int[] a, int dk) {// 类似插入排序，只是插入排序增量是1，这里增量是dk,把1换成dk就可以了
		for (int i = dk; i < a.length; i++) {
			if (a[i] < a[i - dk]) {
				int j;
				int x = a[i];// x为待插入元素
				a[i] = a[i - dk];
				for (j = i - dk; j >= 0 && x < a[j]; j = j - dk) {// 通过循环，逐个后移一位找到要插入的位置。
					a[j + dk] = a[j];
				}
				a[j + dk] = x;// 插入
			}

		}

	}

	private void selectSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int k = i;// k存放最小值下标。每次循环最小值下标+1
			for (int j = i + 1; j < a.length; j++) {// 找到最小值下标
				if (a[k] > a[j])
					k = j;
			}
			swap(a, k, i);// 把最小值放到它该放的位置上
		}
	}

	public void swap(int[] data, int i, int j) {
		if (i == j) {
			return;
		}
		data[i] = data[i] + data[j];
		data[j] = data[i] - data[j];
		data[i] = data[i] - data[j];
	}

	void SelectSort(int r[], int n) {
		int i, j, min, max, tmp;
		for (i = 1; i <= n / 2; i++) {
			// 做不超过n/2趟选择排序
			min = i;
			max = i; // 分别记录最大和最小关键字记录位置
			for (j = i + 1; j <= n - i; j++) {
				if (r[j] > r[max]) {
					max = j;
					continue;
				}
				if (r[j] < r[min]) {
					min = j;
				}
			}
			// 该交换操作还可分情况讨论以提高效率
			tmp = r[i - 1];
			r[i - 1] = r[min];
			r[min] = tmp;
			tmp = r[n - i];
			r[n - i] = r[max];
			r[max] = tmp;

		}
	}

	/*
	 * Java实现快速排序算法 由大到小排序两个步骤：1，建堆 2，对顶与堆的最后一个元素交换位置
	 */
	/*
	 * 创建小顶堆：双亲节点小于子节点的值。从叶子节点开始，直到根节点。这样建立的堆定位最小值
	 */
	// 创建堆,创建的是小顶堆。每次循环完，二叉树的根节点都是最小值，所以与此时的未排好部分最后一个值交换位置
	private void createLittleHeap(int[] data, int last) {
		for (int i = (last - 1) / 2; i >= 0; i--) { // 找到最后一个叶子节点的双亲节点
			// 保存当前正在判断的节点
			int parent = i;
			// 若当前节点的左子节点存在，即子节点存在
			while (2 * parent + 1 <= last) {
				// biggerIndex总是记录较大节点的值,先赋值为当前判断节点的左子节点
				int bigger = 2 * parent + 1;// bigger指向左子节点
				if (bigger < last) { // 说明存在右子节点

					if (data[bigger] > data[bigger + 1]) { // 右子节点>左子节点时

						bigger = bigger + 1;
					}
				}
				if (data[parent] > data[bigger]) { // 若双亲节点值大于子节点中最大的
					// 若当前节点值比子节点最大值小，则交换2者得值，交换后将biggerIndex值赋值给k
					swap(data, parent, bigger);
					parent = bigger;
				} else {
					break;
				}
			}
		}
	}

	// 与最后一个值交换位置，最小值找到了位置
	public void swapHeap(int[] data, int i, int j) {
		if (i == j) {
			return;
		}
		data[i] = data[i] + data[j];
		data[j] = data[i] - data[j];
		data[i] = data[i] - data[j];
	}

	/*
	 * 输入n个整数，找出其中最小的K个数。 例如输入4,5,1,6,2,7,3,8这8个数字， 则最小的4个数字是1,2,3,4,。
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (k > input.length)
			return result;
		for (int i = 0; i < k; i++) {// 只排前k次
			heapSort(input, i, input.length);// 进行第i次排序
			result.add(input[i]);
		}
		return result;
	}

	private void heapSort(int[] input, int root, int end) {// 小顶堆实现
		for (int j = end - 1; j >= root; j--) {
			int parent = (j + root - 1) / 2;// 算出j节点的双亲节点的序号
			if (input[parent] > input[j]) {// 双亲节点大于当前节点，交换位置。
				int temp = input[j];
				input[j] = input[parent];
				input[parent] = temp;
			}
		}
	}

	/*
	 * Java实现堆排序算法（改进） 由大到小排序两个步骤：1，建堆 2，对顶与堆的最后一个元素交换位置
	 */
	/*
	 * 创建小顶堆：双亲节点小于子节点的值。从叶子节点开始，直到根节点。这样建立的堆定位最小值
	 */
	private void createLittleHeap2(int[] data, int last) {
		for (int i = last; i > 0; i--) {
			int parent = (i - 1) / 2;// 当前节点的双亲节点
			if (data[parent] > data[i])
				swap(data, parent, i);
		}
	}

	public void print2(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public void swap2(int[] data, int i, int j) {
		if (i == j) {
			return;
		}
		data[i] = data[i] + data[j];
		data[j] = data[i] - data[j];
		data[i] = data[i] - data[j];
	}

	void bubbleSort(int a[], int n) {
		for (int i = 0; i < n - 1; ++i) {
			for (int j = 0; j < n - i - 1; ++j) {
				if (a[j] > a[j + 1]) {
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
		}
	}

	void Bubble_1(int r[], int n) {
		int i = n - 1; // 初始时,最后位置保持不变
		while (i > 0) {
			int pos = 0; // 每趟开始时,无记录交换
			for (int j = 0; j < i; j++)
				if (r[j] > r[j + 1]) {
					pos = j; // 记录交换的位置
					int tmp = r[j];
					r[j] = r[j + 1];
					r[j + 1] = tmp;
				}
			i = pos; // 为下一趟排序作准备
		}
	}

	void Bubble_2(int r[], int n) {
		int low = 0;
		int high = n - 1; // 设置变量的初始值
		int tmp, j;
		while (low < high) {
			for (j = low; j < high; ++j)
				// 正向冒泡,找到最大者
				if (r[j] > r[j + 1]) {
					tmp = r[j];
					r[j] = r[j + 1];
					r[j + 1] = tmp;
				}
			--high; // 修改high值, 前移一位
			for (j = high; j > low; --j)
				// 反向冒泡,找到最小者
				if (r[j] < r[j - 1]) {
					tmp = r[j];
					r[j] = r[j - 1];
					r[j - 1] = tmp;
				}
			++low; // 修改low值,后移一位
		}
	}

	private void quickSort(int[] a, int low, int high) {
		if (low < high) { // 如果不加这个判断递归会无法退出导致堆栈溢出异常
			int middle = getMiddle(a, low, high);
			quickSort(a, 0, middle - 1); // 递归对低子表递归排序
			quickSort(a, middle + 1, high); // 递归对高子表递归排序
		}
	}

	public int getMiddle(int[] a, int low, int high) {

		int key = a[low];// 基准元素，排序中会空出来一个位置
		while (low < high) {
			while (low < high && a[high] >= key) {// 从high开始找比基准小的，与low换位置
				high--;
			}
			a[low] = a[high];
			while (low < high && a[low] <= key) {// 从low开始找比基准大,放到之前high空出来的位置上
				low++;
			}
			a[high] = a[low];
		}
		a[low] = key;// 此时low=high 是基准元素的位置，也是空出来的那个位置
		return low;

	}

	public static void mergeSort(int[] data) {
		sort(data, 0, data.length - 1);
	}

	public static void sort2(int[] data, int left, int right) {
		if (left >= right)
			return;
		// 找出中间索引
		int center = (left + right) / 2;
		// 对左边数组进行递归
		sort(data, left, center);
		// 对右边数组进行递归
		sort(data, center + 1, right);
		// 合并
		merge(data, left, center, right);
	}

	/**
	 * 将两个数组进行归并，归并前面2个数组已有序，归并后依然有序
	 * 
	 * @param data
	 *            数组对象
	 * @param left
	 *            左数组的第一个元素的索引
	 * @param center
	 *            左数组的最后一个元素的索引，center+1是右数组第一个元素的索引
	 * @param right
	 *            右数组最后一个元素的索引
	 */
	public static void merge(int[] data, int left, int center, int right) {
		// 临时数组
		int[] tmpArr = new int[data.length];
		// 右数组第一个元素索引
		int mid = center + 1;
		// third 记录临时数组的索引
		int third = left;
		// 缓存左数组第一个元素的索引
		int tmp = left;
		while (left <= center && mid <= right) {
			// 从两个数组中取出最小的放入临时数组
			if (data[left] <= data[mid]) {
				tmpArr[third++] = data[left++];
			} else {
				tmpArr[third++] = data[mid++];
			}
		}
		// 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
		while (mid <= right) {
			tmpArr[third++] = data[mid++];
		}
		while (left <= center) {
			tmpArr[third++] = data[left++];
		}
		// 将临时数组中的内容拷贝回原数组中
		// （原left-right范围的内容被复制回原数组）
		while (tmp <= right) {
			data[tmp] = tmpArr[tmp++];
		}
	}
}
