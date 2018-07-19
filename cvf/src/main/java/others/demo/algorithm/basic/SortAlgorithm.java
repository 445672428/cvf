package others.demo.algorithm.basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

import org.apache.commons.httpclient.NTCredentials;

/**
 * 时间复杂度T(n)=O(f(n))
 * 按数量级递增排列依次为：常数阶O(1)、对数阶O(log2n)、线性阶O(n)、线性对数阶O(nlog2n)、平方阶O(n^2)、立方阶O(n^3)、k次方阶O(n^k)、指数阶O(2^n)
 * @author bobo
 *
 */
public class SortAlgorithm {
	/**
	 * 插入排序 最优O(n) 最坏O(n²)
	 * @param a
	 */
	public void insertSort(int[] a){
		int len = a.length;
		int num;
		for(int i = 1;i < len; i++){
			num = a[i];
			int j = i -1;
			while(j>=0&&a[j]>num){
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = num;
		}
	}
	
	/**
	 * 希尔排序 O(nlog2n) O(n2)
	 * @param a
	 */
	public void sheelSort(int[] a){
		int len = a.length;
		while(len!=0){
			len = len/2;
			for(int i = 0; i < len;i++){//分组
				for(int j = i+len;j<a.length;j+=len){
					int k = j - len;//k为有序序列最后一位的位数
					int temp = a[j];
					while(k>=0&&temp<a[k]){//从后往前遍历
						a[k+len]=a[k];
						k-=len;//向后移动len位
					}
					a[k+len]= temp;
				}
			}
		}
	}
	
	/**
	 * 选择排序
	 * O(n2) O(1)
	 */
	public void selectSort(int[]a){
        int len=a.length;
        for(int i=0;i<len;i++){//循环次数
            int value=a[i];
            int position=i;
            for(int j=i+1;j<len;j++){//找到最小的值和位置
                if(a[j]<value){
                    value=a[j];
                    position=j;
                }
            }
            a[position]=a[i];//进行交换
            a[i]=value;
        }
    }
	/**
	 * 堆排序
	 * O(nlog2n)
	 * @param a
	 */
	public void heapSort(int[] a){
		int len = a.length;
		for(int i = 0; i < len - 1; i ++){
			buildMaxHeap(a,len-1-i);
		}
	}
	/**
	 * 建立大顶堆
	 * @param data
	 * @param last
	 */
	public void buildMaxHeap(int[] data,int last){
		for(int i = (last-1)/2 ;i > 0;i--){
			int k = i;
			while(k*2+1 <= last){
				int bigIndex = 2*k + 1;
				//如果bigIndex小于last，即bigIndex+1代表的k节点的右子节点存在  
				if (bigIndex<last) {
					if (data[bigIndex]<data[last]) {
						bigIndex ++;
					}
				}
				//如果k节点的值小于其较大的子节点的值  
				if (data[k]<data[bigIndex]) {
					swap(data,k,bigIndex);
					//将bigIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值  
					k = bigIndex;
				}else{
					break;
				}
			}
		}
	}
    private  void swap(int[] data, int i, int j) {
        int tmp=data[i];
        data[i]=data[j];
        data[j]=tmp;
    }
	/**
	 * 冒泡排序O(n2)
	 * @param a
	 */
	public void simpleSort(int[] a){
		int len = a.length;
		for(int i = 0; i < len; i ++){
			for(int j = 0; j < len - i - 1; j++){
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
			}
		}
	}
	/**
	 * 快速排序O(n2)	O(nlogn)
	 * @param a
	 * @param start
	 * @param end
	 */
	public void quickSort(int[] a ,int start,int end){
		if (start < end) {
			int base = a[start];
			int mid;//记录中间值
			int i = start;
			int j = end;
			do{
				while(a[i]<base&&i<end){
					i++;
				}
				while(a[j]>base&&j>start){
					j--;
				}
				if(i <= j){
					mid = a[i];
					a[i] = a[j];
					a[j] = mid;
					i++;
					j--;
				}
			}while(i<=j);
			if(start<j){
				quickSort(a, start, j);
			}
			if (end<j) {
				quickSort(a, i, end);
			}
		}
	}
	/**
	 * 归并排序
	 */
	public  void mergeSort(int[] a, int left, int right) {  
        int t = 1;// 每组元素个数  
        int size = right - left + 1;  
        while (t < size) {  
            int s = t;// 本次循环每组元素个数  
            t = 2 * s;  
            int i = left;  
            while (i + (t - 1) < size) {  
                merge(a, i, i + (s - 1), i + (t - 1));  
                i += t;  
            }  
            if (i + (s - 1) < right)  
                merge(a, i, i + (s - 1), right);  
        }  
     }  
    
     private static void merge(int[] data, int p, int q, int r) {  
        int[] B = new int[data.length];  
        int s = p;  
        int t = q + 1;  
        int k = p;  
        while (s <= q && t <= r) {  
            if (data[s] <= data[t]) {  
                B[k] = data[s];  
                s++;  
            } else {  
                B[k] = data[t];  
                t++;  
            }  
            k++;  
        }  
        if (s == q + 1)  
            B[k++] = data[t++];  
        else  
            B[k++] = data[s++];  
        for (int i = p; i <= r; i++)  
            data[i] = B[i];  
     }
     /**
      * 基数排序
      * @param array
      * @param d
      */
     private static void radixSort(int[] array,int d)
     {
         int n=1;//代表位数对应的数：1,10,100...
         int k=0;//保存每一位排序后的结果用于下一位的排序输入
         int length=array.length;
         int[][] bucket=new int[10][length];//排序桶用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一个桶里
         int[] order=new int[length];//用于保存每个桶里有多少个数字
         while(n<d)
         {
             for(int num:array) //将数组array里的每个数字放在相应的桶里
             {
                 int digit=(num/n)%10;
                 bucket[digit][order[digit]]=num;
                 order[digit]++;
             }
             for(int i=0;i<length;i++)//将前一个循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
             {
                 if(order[i]!=0)//这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
                 {
                     for(int j=0;j<order[i];j++)
                     {
                         array[k]=bucket[i][j];
                         k++;
                     }
                 }
                 order[i]=0;//将桶里计数器置0，用于下一次位排序
             }
             n*=10;
             k=0;//将k置0，用于下一轮保存位排序结果
         }
         
     }
     
     public void baseSort(int[] a) {
         //首先确定排序的趟数;    
         int max = a[0];
         for (int i = 1; i < a.length; i++) {
             if (a[i] > max) {
                 max = a[i];
             }
         }
         int time = 0;
         //判断位数;    
         while (max > 0) {
             max /= 10;
             time++;
         }
         //建立10个队列;    
         List<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();
         for (int i = 0; i < 10; i++) {
             ArrayList<Integer> queue1 = new ArrayList<Integer>();
             queue.add(queue1);
         }
         //进行time次分配和收集;    
         for (int i = 0; i < time; i++) {
             //分配数组元素;    
             for (int j = 0; j < a.length; j++) {
                 //得到数字的第time+1位数;  
                 int x = a[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                 ArrayList<Integer> queue2 = queue.get(x);
                 queue2.add(a[j]);
                 queue.set(x, queue2);
             }
             int count = 0;//元素计数器;    
             //收集队列元素;    
             for (int k = 0; k < 10; k++) {
                 while (queue.get(k).size() > 0) {
                     ArrayList<Integer> queue3 = queue.get(k);
                     a[count] = queue3.get(0);
                     queue3.remove(0);
                     count++;
                 }
             }
         }
  }
     
     // 二分查找普通循环实现   
     public static int binSearch(int srcArray[], int key) {   
         int mid = srcArray.length / 2;   
         if (key == srcArray[mid]) {   
             return mid;   
         }   

         int start = 0;   
         int end = srcArray.length - 1;   
         while (start <= end) {   
             mid = (end - start) / 2 + start;   
             if (key < srcArray[mid]) {   
                end = mid - 1;   
             } else if (key > srcArray[mid]) {   
                 start = mid + 1;   
             } else {   
                 return mid;   
             }   
         }   
         return -1;   
     }
     public static int search(int[] number,int key){

         int[] temp = new int[number.length+1];
         //设置末尾为监视哨
         for(int i=0;i<number.length;i++){
             temp[i] = number[i];
         }
         temp[number.length] = key;
         int result = 0;
         //进行查找匹对
         for(int i=0;;i++){
             if(temp[i] == key){
                 result = i;
                 break;
             }
         }
         if(result < number.length){
             return result;
         }else{
             return -1;
         }
     }
     public static int halfSort(int[] data,int key){
         int left = 0;//左标记
         int right = data.length-1;//右标记
         int result = -1;
         while(left<=right){ //进行中间判断
             int half = (left+right)/2;
             if(data[half] == key){
                 result = half;
                 break;
             }else if(data[half] < key){
                 left = half;
             }else{
                 right = half;
             }
         }
         return result;
     }
     
     /*
      * 分块查找算法
      * */
     private int[] index;//建立索引
     private ArrayList[] list;
  	
  	
  	/**
  	 * @Descript:初始化索引
  	 *
  	 * @author LJonah 2018年3月12日
  	 * @param index
  	 * @return 
  	 */
  	public void BlockSearch(int[] index){
  		if(null != index && index.length!=0){
  			this.index = index;
  			this.list = new ArrayList[index.length];
  			for (int i = 0;i < list.length;i++) {
  				list[i] = new ArrayList();//初始化容器
  			}
  		}else{
  			throw new Error("index cannot be null or empty");
  		}
  	}
  	
  	
  	/**
  	 * @Descript:插入索引
  	 *
  	 * @author LJonah 2018年3月12日
  	 * @param value
  	 */
  	public void insert(int value){
  		int i = binarySearch(value);
  	    list[i].add(value);
  	}
  	
  	
  	/**
  	 * @Descript:二分法查找
  	 *
  	 * @author LJonah 2018年3月12日
  	 * @param value
  	 * @return
  	 */
  	private int binarySearch(int value){
  		int start = 0,end =index.length;int mid = -1;
  		while(start<=end){
  			mid=(start+end)/2;
  			if(index[mid]>value){
  				end = mid -1;
  			}else{
  	            //如果相等，也插入后面
  				start = mid+1;
  			}
  		}
  		return start;
  	}
  	
      /**
       * @Descript:查找元素
       *
       * @author LJonah 2018年3月12日
       * @param data
       * @return
       */
      public boolean search(int data)  
      {  
          int i=binarySearch(data);  
          for(int j=0;j<list[i].size();j++)  
          {  
              if(data==(int)list[i].get(j))  
              {  
                  return true;  
              }  
          }  
          return false;  
      }  
      
  	/**
  	 * @Descript:打印每块的元素
  	 *
  	 * @author LJonah 2018年3月12日
  	 */
  	public void printAll(){
  		for (int i = 0; i < list.length; i++) {
  			ArrayList l = list[i];
  			
  			for (int j = 0; j < l.size(); j++) {
  			}
  		}
  	}

  	/**
  	 * BFS
  	 */
  	private static void bfs(HashMap<Character, LinkedList<Character>> graph,HashMap<Character, Integer> dist,char start)
  	{
  	    Queue<Character> q=new LinkedList<>();
  	    q.add(start);//将s作为起始顶点加入队列
  	    dist.put(start, 0);
  	    int i=0;
  	    while(!q.isEmpty())
  	    {
  	        char top=q.poll();//取出队首元素
  	        i++;
  	        int d=dist.get(top)+1;//得出其周边还未被访问的节点的距离
  	        for (Character c : graph.get(top)) {
  	            if(!dist.containsKey(c))//如果dist中还没有该元素说明还没有被访问
  	            {
  	                dist.put(c, d);
  	                q.add(c);
  	            }
  	        }
  	    }
  	}
  	/**
  	 * DFS
  	 */
  	private static int count;
  	private static void dfs(HashMap<Character , LinkedList<Character>> graph,HashMap<Character, Boolean> visited)
  	{
  	    visit(graph, visited, 'u');//为了和图中的顺序一样，我认为控制了DFS先访问u节点
  	    visit(graph,visited,'w');
  	}
  	private static void visit(HashMap<Character , LinkedList<Character>> graph,HashMap<Character, Boolean> visited,char start)
  	{
  	    if(!visited.containsKey(start))
  	    {
  	        count++;
  	        visited.put(start, true);
  	        for (char c : graph.get(start)) 
  	        {
  	        if(!visited.containsKey(c))
  	        {
  	            visit(graph,visited,c);//递归访问其邻近节点
  	        }
  	        }
  	        count++;
  	    }
  	}
  	
  	public static class NaiveBayesian {
  		
  		private List<Double> p0Vec = null;
  		//垃圾邮件中每个词出现的概率
  		private List<Double> p1Vec = null;
  		//垃圾邮件出现的概率
  		private double pSpamRatio;
  	 
  		/**
  		 * 初始化数据集
  		 * 
  		 * @return
  		 */
  		public List<Email> initDataSet() {
  			List<Email> dataSet = new ArrayList<Email>();
  			BufferedReader bufferedReader1 = null;
  			BufferedReader bufferedReader2 = null;
  			try {
  				for (int i = 1; i < 26; i++) {
  					bufferedReader1 = new BufferedReader(new InputStreamReader(new FileInputStream("/home/shenchao/Desktop/MLSourceCode/machinelearninginaction/Ch04/email/ham/"+ i + ".txt")));
  					StringBuilder sb1 = new StringBuilder();
  					String string = null;
  					while ((string = bufferedReader1.readLine()) != null) {
  						sb1.append(string);
  					}
  					Email hamEmail = new Email();
  					hamEmail.setWordList(textParse(sb1.toString()));
  					hamEmail.setFlag(0);
  	 
  					bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/home/shenchao/Desktop/MLSourceCode/machinelearninginaction/Ch04/email/spam/"+ i + ".txt")));
  					StringBuilder sb2 = new StringBuilder();
  					while ((string = bufferedReader2.readLine()) != null) {
  						sb2.append(string);
  					}
  					Email spamEmail = new Email();
  					spamEmail.setWordList(textParse(sb2.toString()));
  					spamEmail.setFlag(1);
  	 
  					dataSet.add(hamEmail);
  					dataSet.add(spamEmail);
  				}
  				return dataSet;
  			} catch (Exception e) {
  				e.printStackTrace();
  				throw new RuntimeException();
  			} finally {
  				try {
  					bufferedReader1.close();
  					bufferedReader2.close();
  				} catch (IOException e) {
  					e.printStackTrace();
  				}
  	 
  			}
  		}
  	 
  		/**
  		 * 分词，英文的分词相比中文的分词要简单很多，这里使用的分隔符为除单词、数字外的任意字符串
  		 * 如果使用中文，则可以使用中科院的一套分词系统，分词效果还算不错
  		 * 
  		 * @param originalString
  		 * @return
  		 * @return
  		 */
  		private List<String> textParse(String originalString) {
  			String[] s = originalString.split("\\W");
  			List<String> wordList = new ArrayList<String>();
  			for (String string : s) {
  				if (string.contains(" ")) {
  					continue;
  				}
  				if (string.length() > 2) {
  					wordList.add(string.toLowerCase());
  				}
  			}
  			return wordList;
  		}
  	 
  		/**
  		 * 构建单词集，此长度等于向量长度
  		 * 
  		 * @return
  		 */
  		public Set<String> createVocabList(List<Email> dataSet) {
  			Set<String> set = new LinkedHashSet<String>();
  			for (Email email : dataSet) {
  				for (String string : email.getWordList()) {
  					set.add(string);
  				}
  			}
  			return set;
  		}
  	 
  		/**
  		 * 将邮件转换为向量
  		 * 
  		 * @param vocabSet
  		 * @param inputSet
  		 * @return
  		 */
  		public List<Integer> setOfWords2Vec(Set<String> vocabSet, Email email) {
  			List<Integer> returnVec = new ArrayList<Integer>();
  			for (String word : vocabSet) {
  				returnVec.add(calWordFreq(word, email));
  			}
  			return returnVec;
  		}
  	 
  		/**
  		 * 计算一个词在某个集合中的出现次数
  		 * 
  		 * @return
  		 */
  		private int calWordFreq(String word, Email email) {
  			int num = 0;
  			for (String string : email.getWordList()) {
  				if (string.equals(word)) {
  					++num;
  				}
  			}
  			return num;
  		}
  	 
  		public void trainNB(Set<String> vocabSet, List<Email> dataSet) {
  			// 训练文本的数量
  			int numTrainDocs = dataSet.size();
  			// 训练集中垃圾邮件的概率
  			pSpamRatio = (double) calSpamNum(dataSet) / numTrainDocs;
  	 
  			// 记录每个类别下每个词的出现次数
  			List<Integer> p0Num = new ArrayList<Integer>();
  			List<Integer> p1Num = new ArrayList<Integer>();
  			// 记录每个类别下一共出现了多少词,为防止分母为0，所以在此默认值为2
  			double p0Denom = 2.0, p1Denom = 2.0;
  			for (Email email : dataSet) {
  				List<Integer> list = setOfWords2Vec(vocabSet, email);
  				// 如果是垃圾邮件
  				if (email.getFlag() == 1) {
  					p1Num = vecAddVec(p1Num, list);
  					//计算该类别下出现的所有单词数目
  					p1Denom += calTotalWordNum(list);
  				}else {
  					p0Num = vecAddVec(p0Num, list);
  					p0Denom += calTotalWordNum(list);
  				}
  			}
  			p0Vec = calWordRatio(p0Num, p0Denom);
  			p1Vec = calWordRatio(p1Num, p1Denom);
  		}
  	 
  		/**
  		 * 两个向量相加
  		 * 
  		 * @param vec1
  		 * @param vec2
  		 * @return
  		 */
  		private List<Integer> vecAddVec(List<Integer> vec1,
  				List<Integer> vec2) {
  			if (vec1.size() == 0) {
  				return vec2;
  			}
  			List<Integer> list = new ArrayList<Integer>();
  			for (int i = 0; i < vec1.size(); i++) {
  				list.add(vec1.get(i) + vec2.get(i));
  			}
  			return list;
  		}
  		
  		/**
  		 * 计算垃圾邮件的数量
  		 * 
  		 * @param dataSet
  		 * @return
  		 */
  		private int calSpamNum(List<Email> dataSet) {
  			int time = 0;
  			for (Email email : dataSet) {
  				time += email.getFlag();
  			}
  			return time;
  		}
  		
  		/**
  		 * 统计出现的所有单词数
  		 * @param list
  		 * @return
  		 */
  		private int calTotalWordNum(List<Integer> list) {
  			int num = 0;
  			for (Integer integer : list) {
  				num += integer;
  			}
  			return num;
  		}
  		
  		/**
  		 * 计算每个单词在该类别下的出现概率，为防止分子为0，导致朴素贝叶斯公式为0，设置分子的默认值为1
  		 * @param list
  		 * @param wordNum
  		 * @return
  		 */
  		private List<Double> calWordRatio(List<Integer> list, double wordNum) {
  			List<Double> vec = new ArrayList<Double>();
  			for (Integer i : list) {
  				vec.add(Math.log((double)(i+1) / wordNum));
  			}
  			return vec;
  		}
  		
  		/**
  		 * 比较不同类别 p(w0,w1,w2...wn | ci)*p(ci) 的大小   <br>
  		 *  p(w0,w1,w2...wn | ci) = p(w0|ci)*p(w1|ci)*p(w2|ci)... <br>
  		 *  由于防止下溢，对中间计算值都取了对数，因此上述公式化为log(p(w0,w1,w2...wn | ci)) + log(p(ci)),即
  		 *  化为多个式子相加得到结果
  		 *  
  		 * @param email
  		 * @return 返回概率最大值 
  		 */
  		public int classifyNB(List<Integer> emailVec) {
  			double p0 = calProbabilityByClass(p0Vec, emailVec) + Math.log(1 - pSpamRatio);
  			double p1 = calProbabilityByClass(p1Vec, emailVec) + Math.log(pSpamRatio);
  			if (p0 > p1) {
  				return 0;
  			}else {
  				return 1;
  			}
  		}
  		
  		private double calProbabilityByClass(List<Double> vec,List<Integer> emailVec) {
  			double sum = 0.0;
  			for (int i = 0; i < vec.size(); i++) {
  				sum += (vec.get(i) * emailVec.get(i));
  			}
  			return sum;
  		}
  		
  		public double testingNB() {
  			List<Email> dataSet = initDataSet();
  			List<Email> testSet = new ArrayList<Email>();
  			//随机取前10作为测试样本
  			for (int i = 0; i < 10; i++) {
  				Random random = new Random();
  				int n = random.nextInt(50-i);
  				testSet.add(dataSet.get(n));
  				//从训练样本中删除这10条测试样本
  				dataSet.remove(n);
  			}
  			Set<String> vocabSet = createVocabList(dataSet);
  			//训练样本
  			trainNB(vocabSet, dataSet);
  			
  			int errorCount = 0;
  			for (Email email : testSet) {
  				if (classifyNB(setOfWords2Vec(vocabSet, email)) != email.getFlag()) {
  					++errorCount;
  				}
  			}
  			return (double) errorCount / testSet.size();
  		}
  	 
  	 
  	}
  	public static class Email {
  		
  		private List<String> wordList;
  		private int flag;
  		
  		public int getFlag() {
  			return flag;
  		}
  		public void setFlag(int flag) {
  			this.flag = flag;
  		}
  		public List<String> getWordList() {
  			return wordList;
  		}
  		public void setWordList(List<String> wordList) {
  			this.wordList = wordList;
  		}
  	}
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	public static class CoinsChange {    
        /**   
         * 硬币找零：动态规划算法   
         *    
         * @param values   
         *            :保存每一种硬币的币值的数组   
         * @param valueKinds   
         *            :币值不同的硬币种类数量，即coinValue[]数组的大小   
         * @param money   
         *            :需要找零的面值   
         * @param coinsUsed   
         *            :保存面值为i的纸币找零所需的最小硬币数   
         */   
        public static void makeChange(int[] values, int valueKinds, int money,    
                int[] coinsUsed) {    
       
            coinsUsed[0] = 0;    
            // 对每一分钱都找零，即保存子问题的解以备用，即填表    
            for (int cents = 1; cents <= money; cents++) {    
       
                // 当用最小币值的硬币找零时，所需硬币数量最多    
                int minCoins = cents;    
       
                // 遍历每一种面值的硬币，看是否可作为找零的其中之一    
                for (int kind = 0; kind < valueKinds; kind++) {                 
                    // 若当前面值的硬币小于当前的cents则分解问题并查表    
                    if (values[kind] <= cents) {    
                        int temp = coinsUsed[cents - values[kind]] + 1;    
                        if (temp < minCoins) {    
                            minCoins = temp;    
                        }    
                    }    
                }    
                // 保存最小硬币数    
                coinsUsed[cents] = minCoins;    
            }    
        }    
            
    }   

  	
  	public static class Knapsack {      
        
        /** 背包重量  */      
        private int weight;      
              
        /** 背包物品价值  */      
        private int value;      
        /***   
         * 构造器   
         */      
        public Knapsack(int weight, int value) {      
            this.value = value;      
            this.weight = weight;      
        }      
        public int getWeight() {      
            return weight;      
        }      
              
        public int getValue() {      
            return value;      
        }      
              
        public String toString() {      
            return "[weight: " + weight + " " + "value: " + value + "]";        
        }      
    }       

  	
  	public static class KnapsackProblem {      
        
        /** 指定背包 */      
        private Knapsack[] bags;      
              
        /** 总承重  */      
        private int totalWeight;      
              
        /** 给定背包数量  */      
        private int n;      
              
        /** 前 n 个背包，总承重为 totalWeight 的最优值矩阵  */      
        private int[][] bestValues;      
              
        /** 前 n 个背包，总承重为 totalWeight 的最优值 */      
        private int bestValue;      
              
        /** 前 n 个背包，总承重为 totalWeight 的最优解的物品组成 */      
        private ArrayList<Knapsack> bestSolution;      
              
        public KnapsackProblem(Knapsack[] bags, int totalWeight) {      
            this.bags = bags;      
            this.totalWeight = totalWeight;      
            this.n = bags.length;      
            if (bestValues == null) {      
                bestValues = new int[n+1][totalWeight+1];      
            }      
        }      
              
        /**   
         * 求解前 n 个背包、给定总承重为 totalWeight 下的背包问题   
         *    
         */      
        public void solve() {      
                  
            for(Knapsack b: bags) {      
            }      
                  
            // 求解最优值      
            for (int j = 0; j <= totalWeight; j++) {      
                for (int i = 0; i <= n; i++) {      
                      
                    if (i == 0 || j == 0) {      
                        bestValues[i][j] = 0;      
                    }         
                    else       
                    {      
                        // 如果第 i 个背包重量大于总承重，则最优解存在于前 i-1 个背包中，      
                        // 注意：第 i 个背包是 bags[i-1]      
                        if (j < bags[i-1].getWeight()) {      
                            bestValues[i][j] = bestValues[i-1][j];      
                        }         
                        else       
                        {      
                            // 如果第 i 个背包不大于总承重，则最优解要么是包含第 i 个背包的最优解，      
                            // 要么是不包含第 i 个背包的最优解， 取两者最大值，这里采用了分类讨论法      
                            // 第 i 个背包的重量 iweight 和价值 ivalue      
                            int iweight = bags[i-1].getWeight();      
                            int ivalue = bags[i-1].getValue();      
                            bestValues[i][j] =       
                                Math.max(bestValues[i-1][j], ivalue + bestValues[i-1][j-iweight]);            
                        } // else      
                    } //else               
               } //for      
            } //for      
                  
            // 求解背包组成      
            if (bestSolution == null) {      
                bestSolution = new ArrayList<Knapsack>();      
            }      
            int tempWeight = totalWeight;      
            for (int i=n; i >= 1; i--) {      
               if (bestValues[i][tempWeight] > bestValues[i-1][tempWeight]) {      
                   bestSolution.add(bags[i-1]);  // bags[i-1] 表示第 i 个背包      
                   tempWeight -= bags[i-1].getWeight();      
               }      
               if (tempWeight == 0) { break; }      
            }      
            bestValue = bestValues[n][totalWeight];      
        }      
              
        /**   
         * 获得前  n 个背包， 总承重为 totalWeight 的背包问题的最优解值   
         * 调用条件： 必须先调用 solve 方法   
         *    
         */      
        public int getBestValue() {       
            return bestValue;      
        }      
              
        /**   
         * 获得前  n 个背包， 总承重为 totalWeight 的背包问题的最优解值矩阵   
         * 调用条件： 必须先调用 solve 方法   
         *    
         */      
        public int[][] getBestValues() {      
                  
            return bestValues;      
        }      
              
        /**   
         * 获得前  n 个背包， 总承重为 totalWeight 的背包问题的最优解值矩阵   
         * 调用条件： 必须先调用 solve 方法   
         *    
         */      
        public ArrayList<Knapsack> getBestSolution() {      
            return bestSolution;      
        }      
              
    }     

  	
  	
  	public static class RectTest {
  	     private static int N=5;//用户的数目
  	     private static int M=4;//产品的数目
  	     private static int K=2;//特征的数目
  	     private static DecimalFormat df=new DecimalFormat("###.000");
  	     public static void main(String[] args) {
  	         double[] R=new double[N*M];
  	         double[] P=new double[N*K];
  	         double[] Q=new double[N*M];
  	         R[0]=5;
  	         R[1]=3;
  	         R[2]=0;
  	         R[3]=1;
  	         R[4]=4;
  	         R[5]=0;
  	         R[6]=0;
  	         R[7]=1;
  	         R[8]=1;
  	         R[9]=1; 
  	         R[10]=0;
  	         R[11]=5;
  	         R[12]=1;
  	         R[13]=0;
  	         R[14]=0;
  	         R[15]=4;
  	         R[16]=0;
  	         R[17]=1;
  	         R[18]=5;
  	         R[19]=4;
  	         for(int i=0;i<N;++i) { 
  	          for(int j=0;j<M;++j){ 
  	          }
  	         } 
  	        //初始化P，Q矩阵，这里简化了，通常也可以对服从正态分布的数据进行随机数生成 
  	         for(int i=0;i<N;++i) 
  	         {
  	             for(int j=0;j<K;++j)
  	             {
  	                 P[i*K+j]=Math.random()%9;
  	             }
  	         }
  	         for(int i=0;i<K;++i) 
  	         {
  	             for(int j=0;j<M;++j)
  	             {
  	                 Q[i*M+j]=Math.random()%9;
  	             }
  	         }           
  	         //矩阵分解开始;
  	         matrix_factorization(R,P,Q,N,M,K);  
  	         //重构出来的R矩阵
  	         for(int i=0;i<N;++i) 
  	         { 
  	          for(int j=0;j<M;++j) 
  	          { 
  	           double temp=0; 
  	           for (int k=0;k<K;++k){
  	               temp+=P[i*K+k]*Q[k*M+j]; 
  	            } 
  	          } 
  	         }
  	     }
  	     public static void matrix_factorization(double[] R,double[] P,double[] Q,int N,int M,int K){
  	        int steps=5000;
  	        double alpha=0.0002;
  	        double beta=0.02;
  	        for(int step =0;step<steps;++step){
  	            for(int i=0;i<N;++i) {
  	                for(int j=0;j<M;++j){
  	                    if(R[i*M+j]>0){
  	                        double eij = R[i*M+j];
  	                        for(int k=0;k<K;++k){
  	                            eij -= P[i*K+k]*Q[k*M+j]; 
  	                        }
  	                        for(int k=0;k<K;++k){
  	                            P[i*K+k] +=alpha * (2 * eij * Q[k*M+j] - beta * P[i*K+k]);
  	                            Q[k*M+j] +=alpha * (2 * eij * P[i*K+k] - beta *  Q[k*M+j]);
  	                        } 
  	                        } 
  	                    }
  	                }
  	            double loss=0;
  	            for(int i=0;i<N;++i){
  	                 for(int j=0;j<M;++j) {
  	                     if(R[i*M+j]>0){
  	                         double eij =0;
  	                            for(int k=0;k<K;++k){
  	                                eij += P[i*K+k]*Q[k*M+j]; 
  	                            } 
  	                             loss += Math.pow(R[i*M+j]-eij,2); 
  	                             for(int k=0;k<K;++k){
  	                                 loss += (beta/2) * (Math.pow(P[i*K+k],2) + Math.pow(Q[k*M+j],2)); 
  	                             }  
  	                     }
  	                 }
  	            } 
  	            if(loss<0.001){
  	                break;
  	            } 
  	            if (step%1000==0){
  	            }
  	        }
  	    }
  	}
	/**
	 * 
	 * 
	 * 
	 * 1,
	算法复杂度是在《数据结构》这门课程的第一章里出现的，因为它稍微涉及到一些数学问题，所以很多同学感觉很难，加上这个概念也不是那么具体，更让许多同学复习起来无从下手，下面我们就这个问题给各位考生进行分析。
	首先了解一下几个概念。一个是时间复杂度，一个是渐近时间复杂度。前者是某个算法的时间耗费，它是该算法所求解问题规模n的函数，而后者是指当问题规模趋向无穷大时，该算法时间复杂度的数量级。
	当我们评价一个算法的时间性能时，主要标准就是算法的渐近时间复杂度，因此，在算法分析时，往往对两者不予区分，经常是将渐近时间复杂度T(n)=O(f(n))简称为时间复杂度，其中的f(n)一般是算法中频度最大的语句频度。
	此外，算法中语句的频度不仅与问题规模有关，还与输入实例中各元素的取值相关。但是我们总是考虑在最坏的情况下的时间复杂度。以保证算法的运行时间不会比它更长。
	常见的时间复杂度，按数量级递增排列依次为：常数阶O(1)、对数阶O(log2n)、线性阶O(n)、线性对数阶O(nlog2n)、平方阶O(n^2)、立方阶O(n^3)、k次方阶O(n^k)、指数阶O(2^n)。
	下面我们通过例子加以说明，让大家碰到问题时知道如何去解决。
	1、设三个函数f,g,h分别为 f(n)=100n^3+n^2+1000 , g(n)=25n^3+5000n^2 , h(n)=n^1.5+5000nlgn
	请判断下列关系是否成立：
	（1） f(n)=O(g(n))
	（2） g(n)=O(f(n))
	（3） h(n)=O(n^1.5)
	（4） h(n)=O(nlgn)
	这 里我们复习一下渐近时间复杂度的表示法T(n)=O(f(n))，这里的"O"是数学符号，它的严格定义是"若T(n)和f(n)是定义在正整数集合上的 两个函数，则T(n)=O(f(n))表示存在正的常数C和n0 ,使得当n≥n0时都满足0≤T(n)≤C?f(n)。"用容易理解的话说就是这两个函数当整型自变量n趋向于无穷大时，两者的比值是一个不等于0的常 数。这么一来，就好计算了吧。
	 
	◆ (1)成立。题中由于两个函数的最高次项都是n^3,因此当n→∞时，两个函数的比值是一个常数，所以这个关系式是成立的。
	◆ （2）成立。与上同理。
	◆ （3）成立。与上同理。
	◆ （4）不成立。由于当n→∞时n^1.5比nlgn递增的快，所以h(n)与nlgn的比值不是常数，故不成立。
	 
	2、设n为正整数，利用大"O"记号，将下列程序段的执行时间表示为n的函数。
	(1) i=1; k=0
	while(i<n)
	{ k=k+10*i;i++;
	}
	解答：T(n)=n-1， T(n)=O(n)， 这个函数是按线性阶递增的。
	(2) x=n; // n>1
	while (x>=(y+1)*(y+1))
	y++;
	解答：T(n)=n1/2 ，T(n)=O(n1/2)， 最坏的情况是y=0，那么循环的次数是n1/2次，这是一个按平方根阶递增的函数。
	(3) x=91; y=100;
	while(y>0)
	if(x>100)
	{x=x-10;y--;}
	else x++;
	解答： T(n)=O(1)， 这个程序看起来有点吓人，总共循环运行了1000次，但是我们看到n没有? 没。这段程序的运行是和n无关的，就算它再循环一万年，我们也不管他，只是一个常数阶的函数。
	一个经验规则
	 
	有如下复杂度关系
	 
	c < log2N < n < n * Log2N < n^2 < n^3 < 2^n < 3^n < n!
	 
	其中c是一个常量，如果一个算法的复杂度为c 、 log2N 、n 、 n*log2N ,那么这个算法时间效率比较高 ，如果是 2^n , 3^n ,n!，那么稍微大一些的n就会令这个算法不能动了，居于中间的几个则差强人意。
	 
	 
	2,
	 
	学习算法的同学，如果不知道计算一个算法的时间复杂度该如何计算，其实是一件很丢脸的事情。最近选修了高级算法这门课，由于时间紧张，原本就想混过去算了，但是不料考试的时候有40%的题目是计算时间复杂度的，干脆就好好的总结一下。
	 
	概念我也不讲了，大家都清楚。关键讲讲怎么计算比较实际一点。
	 
	求解算法的时间复杂度的具体步骤是：
	 
	　　⑴ 找出算法中的基本语句；
	 
	　　算法中执行次数最多的那条语句就是基本语句，通常是最内层循环的循环体。
	 
	　　⑵ 计算基本语句的执行次数的数量级；
	 
	　　只需计算基本语句执行次数的数量级，这就意味着只要保证基本语句执行次数的函数中的最高次幂正确即可，可以忽略所有低次幂和最高次幂的系数。这样能够简化算法分析，并且使注意力集中在最重要的一点上：增长率。
	 
	　　⑶ 用大Ο记号表示算法的时间性能。
	 
	　　将基本语句执行次数的数量级放入大Ο记号中。
	 
	　　如果算法中包含嵌套的循环，则基本语句通常是最内层的循环体，如果算法中包含并列的循环，则将并列循环的时间复杂度相加。例如：
	 
	　　for (i=1; i<=n; i++)
	　　x++;
	 
	　　for (i=1; i<=n; i++)
	　　for (j=1; j<=n; j++)
	　　x++;
	 
	　　第一个for循环的时间复杂度为Ο(n)，第二个for循环的时间复杂度为Ο(n2)，则整个算法的时间复杂度为Ο(n+n2)=Ο(n2)。
	 
	　　常见的算法时间复杂度由小到大依次为：
	 
	　　Ο(1)＜Ο(log2n)＜Ο(n)＜Ο(nlog2n)＜Ο(n2)＜Ο(n3)＜…＜Ο(2n)＜Ο(n!)
	 
	Ο(1)表示基本语句的执行次数是一个常数，一般来说，只要算法中不存在循环语句，其时间复杂度就是Ο(1)。Ο(log2n)、Ο(n)、Ο(nlog2n)、Ο(n2)和Ο(n3)称为多项式时间，而Ο(2n)和Ο(n!)称为指数时间。计算机科学家普遍认为前者是有效算法，把这类问题称为P类问题，而把后者称为NP问题。
 
	 * 
	 */
     
   //去重复，需要额外定义一个List
     public static void RemoveRepeat(List<Integer> arrs) {
         List<Integer> tmp = new ArrayList<Integer>();
         Iterator<Integer> it = arrs.iterator();
         while (it.hasNext()) {
             int a = it.next();
             if (tmp.contains(a))
                 it.remove();
             else
                 tmp.add(a);
         }
     }
  // 去不重复的数，用的是选择排序算法变化版
     public static void RemoveNoRepeat(List<Integer> arrs) {
         Boolean isRepeate = false;
         for (int i = 0; i < arrs.size(); i++) {
             isRepeate = false;
             for (int j = 0; j < arrs.size(); j++) {
                 if (arrs.get(i) == arrs.get(j) && i != j) {
                     isRepeate = true;
                     break;
                 }
             }
             if (!isRepeate) {
                 arrs.remove(i);
                 i--;
             }
         }
     }

     public static void RemoveNoRepeatImprove(List<Integer> arrs) {
         Boolean isRepeate = false;
         for (int i = arrs.size() - 1; i >= 0; i--) {
             isRepeate = false;
             for (int j = arrs.size() - 1; j >= 0; j--) {
                 if (arrs.get(i) == arrs.get(j) && i != j) {
                     isRepeate = true;
                     break;
                 }
             }
             if (!isRepeate) {
                 arrs.remove(i);
             }
         }
     }

     public static void RemoveNoRepeatWithExtraMap(List<Integer> arrs) {
         Map<Integer, Integer> repeat = CountRepeat(arrs);

         for (int i = arrs.size() - 1; i >= 0; i--) {
             if (repeat.get(arrs.get(i)) == 1) {
                 arrs.remove(i);
             }
         }
     }

     // 统计重复数
     public static Map<Integer, Integer> CountRepeat(List<Integer> arrs) {
         Map<Integer, Integer> map = new HashMap<Integer, Integer>();
         Integer value = 0;
         for (Integer arr : arrs) {
             if (map.containsKey(arr)) {
                 value = map.get(arr);
                 map.put(arr, value + 1);
             } else {
                 map.put(arr, 1);
             }
         }
         return map;
     }
     public static void RemoveNotRepeat(List<Character> arrs)
     {
         Map<Character,Integer> tmp=new HashMap();
         for(char c:arrs)
         {
             if(tmp.containsKey(c))
                 tmp.put(c,tmp.get(c)+1);
             else
                 tmp.put(c,1);
         }
         Iterator<Character> it=arrs.iterator();

         while (it.hasNext())
         {
             Character c=it.next();
             if(tmp.get(c)==1)
                 it.remove();
         }
     }
     public static Map<String, String> TicketDispatch(List<String> customers, List<String> tickets) {
         Map<String, String> result = new HashMap<String, String>();

         Random r = new Random();
         int iCustomer;
         int iTicket;
         for (int i = customers.size(); i > 0; i--) {
             // 取值范围[0,i)
             iCustomer = r.nextInt(i);
             iTicket = r.nextInt(tickets.size());

             result.put(customers.get(iCustomer), tickets.get(iTicket));
             customers.remove(iCustomer);
             tickets.remove(iTicket);
         }

         return result;
     }
     private static void deleteDir(File dir) {
         if (dir.isDirectory()) {
             String[] children = dir.list();
             // 递归删除目录中的子目录下
             for (int i=0; i<children.length; i++) {
                deleteDir(new File(dir, children[i]));               
             }
         }
         dir.delete();
     }
     public static Integer GetNotExitMinInteger(Integer[] arr)
     {
         Integer minIndex;
         Integer tmp;
         Integer first=0;
         for(int i=0;i<arr.length;i++)
         {        
             minIndex=i;
             for(int j=i+1;j<arr.length;j++)
             {
                 if(arr[minIndex]>arr[j])
                     minIndex=j;
             }
             
             if(arr[minIndex]-first>1)
                 return first+1;
             else
             {
                 first=arr[minIndex];
             }
             
             if(minIndex!=i)
             {
                 tmp=arr[i];
                 arr[i]=arr[minIndex];
                 arr[minIndex]=tmp;
             }
         }
         return arr[arr.length-1]+1;
     }
     public static Integer GetNotExitMinIntegerByHashMap(Integer[] arr) {
         Integer minKey=Integer.MAX_VALUE;
         Integer maxKey=Integer.MIN_VALUE;
         Map<Integer,Integer> map=new HashMap<Integer,Integer>();

         for(int i=0;i<arr.length;i++)
         {
             map.put(arr[i],arr[i]);
             if(minKey>arr[i])
                 minKey=arr[i];
             if(maxKey<arr[i])
                 maxKey=arr[i];
         }

         Integer pre=minKey;

         if(minKey>1)
             return minKey-1;

         while(pre<=maxKey) {
             if(map.get(pre+1)==null)
                 return pre+1;
             else
                 ++pre;
         }

         return maxKey+1;
     }
     public static String longestPalindrome(String str)
     {
         if(str==null||str.length()==0)
             return "";

         int max=0,current=0,length=str.length();
         String subString="";

         for(int i=0;i<length;i++)
         {
             //考虑回文字段为奇数长度
             for(int j=0;i-j>=0&&i+j<length;j++)
             {
                 if(str.charAt(i-j)!=str.charAt(i+j))
                     break;
                 current=j*2+1;
             }
             if(current>max)
             {
                 max=current;
                 subString=str.substring(i-max/2,i+max/2+1);
             }
             //考虑回文字段为偶数长度
             for(int j=0;i-j>=0&&i+j+1<length;j++)
             {
                 if(str.charAt(i-j)!=str.charAt(i+j+1))
                     break;
                 current=j*2+2;
             }
             if(current>max)
             {
                 max=current;
                 subString=str.substring(i-max/2+1,i+max/2+1);
             }
         }

         return subString;
     }
     public static int toInt(String str)
     {
         if(str==null&&str.length()==0)
             throw new RuntimeException("字符串为空");

         //转换结果
         int result=0;
         //要转换的字符
         int current=0;
         //整数的正负
         char sign='+';
         if(str.charAt(0)=='-'||str.charAt(0)=='+')
         {
             sign=str.charAt(0);
             str=str.substring(1);
         }

         //是否需要判断
         boolean judgeOverflow=true;
         if(str.length()>10)
         {
             throw new RuntimeException("整形溢出了");
         }
         else if(str.length()<10)
         {
             judgeOverflow=false;
         }

         for(int i=0;i<str.length();i++){
             current=str.charAt(i)-'0';
             if(current>9||current<0)
                 throw new RuntimeException("包含非整数型字符");
             if(judgeOverflow)
             {
                 if(sign=='+'&&current>Integer.MAX_VALUE/(int)Math.pow(10,9-i)%10)
                 {
                     throw new RuntimeException("整形溢出了");
                 }
                 if(sign=='-'&&current>Math.abs(Integer.MIN_VALUE/(int)Math.pow(10,9-i)%10))
                 {
                     throw new RuntimeException("整形溢出了");
                 }
             }
             result=result*10+current;
         }
         if(sign=='-')
         {
             result=-result;
         }
         return result;
     }
     public static boolean isPatternMatch(String pattern,String target)
     {
         Map<Character,String> mPatternTarget=new HashMap<>();
         char[] cPattern=pattern.toCharArray();
         String[] strTarget=target.split(" ");
         for(int i=0;i<cPattern.length;i++)
         {
             if(!mPatternTarget.containsKey(cPattern[i]))
                 mPatternTarget.put(cPattern[i],strTarget[i]);
             else
             {
                 if(!mPatternTarget.get(cPattern[i]).equals(strTarget[i]))
                     return false;
             }
         }
         return true;
     }
     
     
     
}
