package others.demo.moredown;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadFile extends Thread {

	// 涓嬭浇鏂囦欢url
	private String url;
	// 涓嬭浇鏂囦欢璧峰浣嶇疆
	private long startPos;
	// 涓嬭浇鏂囦欢缁撴潫浣嶇疆
	private long endPos;
	// 绾跨▼id
	private int threadId;

	// 涓嬭浇鏄惁瀹屾垚
	private boolean isDownloadOver = false;

	private SaveItemFile itemFile;

	private static final int BUFF_LENGTH = 1024 * 8;

	/**
	 * @param url
	 *            涓嬭浇鏂囦欢url
	 * @param name
	 *            鏂囦欢鍚嶇О
	 * @param startPos
	 *            涓嬭浇鏂囦欢璧风偣
	 * @param endPos
	 *            涓嬭浇鏂囦欢缁撴潫鐐�
	 * @param threadId
	 *            绾跨▼id
	 * @throws IOException
	 */
	public DownloadFile(String url, String name, long startPos, long endPos,
			int threadId) throws IOException {
		super();
		this.url = url;
		this.startPos = startPos;
		this.endPos = endPos;
		this.threadId = threadId;
		// 鍒嗗潡涓嬭浇鍐欏叆鏂囦欢鍐呭
		this.itemFile = new SaveItemFile(name, startPos);
	}

	@Override
	public void run() {
		while (endPos > startPos && !isDownloadOver) {
			try {
				URL url = new URL(this.url);
				HttpURLConnection conn = (HttpURLConnection) url
						.openConnection();

				// 璁剧疆杩炴帴瓒呮椂鏃堕棿涓�0000ms
				conn.setConnectTimeout(10000);
				// 璁剧疆璇诲彇鏁版嵁瓒呮椂鏃堕棿涓�0000ms
				conn.setReadTimeout(10000);

				setHeader(conn);

				String property = "bytes=" + startPos + "-";
				conn.setRequestProperty("RANGE", property);

				// 杈撳嚭log淇℃伅
				LogUtils.log("寮� " + threadId + "锛� + property + endPos");
				// printHeader(conn);

				// 鑾峰彇鏂囦欢杈撳叆娴侊紝璇诲彇鏂囦欢鍐呭
				InputStream is = conn.getInputStream();

				byte[] buff = new byte[BUFF_LENGTH];
				int length = -1;
				LogUtils.log("#start#Thread: " + threadId + ", startPos: "
						+ startPos + ", endPos: " + endPos);
				while ((length = is.read(buff)) > 0 && startPos < endPos
						&& !isDownloadOver) {
					// 鍐欏叆鏂囦欢鍐呭锛岃繑鍥炴渶鍚庡啓鍏ョ殑闀垮害
					startPos += itemFile.write(buff, 0, length);
				}
				LogUtils.log("#over#Thread: " + threadId + ", startPos: "
						+ startPos + ", endPos: " + endPos);
				LogUtils.log("Thread " + threadId + " is execute over!");
				this.isDownloadOver = true;
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (itemFile != null) {
						itemFile.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (endPos < startPos && !isDownloadOver) {
			LogUtils.log("Thread " + threadId
					+ " startPos > endPos, not need download file !");
			this.isDownloadOver = true;
		}
		if (endPos == startPos && !isDownloadOver) {
			LogUtils.log("Thread " + threadId
					+ " startPos = endPos, not need download file !");
			this.isDownloadOver = true;
		}
	}

	/**
	 * <b>function:</b> 鎵撳嵃涓嬭浇鏂囦欢澶撮儴淇℃伅
	 * 
	 * @author hoojo
	 * @createDate 2011-9-22 涓嬪崍05:44:35
	 * @param conn
	 *            HttpURLConnection
	 */
	public static void printHeader(URLConnection conn) {
		int i = 1;
		while (true) {
			String header = conn.getHeaderFieldKey(i);
			i++;
			if (header != null) {
				LogUtils.info(header + ":" + conn.getHeaderField(i));
			} else {
				break;
			}
		}
	}

	/**
	 * <b>function:</b> 璁剧疆URLConnection鐨勫ご閮ㄤ俊鎭紝浼璇锋眰淇℃伅
	 * 
	 * @author hoojo
	 * @createDate 2011-9-28 涓嬪崍05:29:43
	 * @param con
	 */
	public static void setHeader(URLConnection conn) {
		conn.setRequestProperty(
				"User-Agent",
				"Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.3) Gecko/2008092510 Ubuntu/8.04 (hardy) Firefox/3.0.3");
		conn.setRequestProperty("Accept-Language", "en-us,en;q=0.7,zh-cn;q=0.3");
		conn.setRequestProperty("Accept-Encoding", "utf-8");
		conn.setRequestProperty("Accept-Charset",
				"ISO-8859-1,utf-8;q=0.7,*;q=0.7");
		conn.setRequestProperty("Keep-Alive", "300");
		conn.setRequestProperty("connnection", "keep-alive");
		conn.setRequestProperty("If-Modified-Since",
				"Fri, 02 Jan 2009 17:00:05 GMT");
		conn.setRequestProperty("If-None-Match", "\"1261d8-4290-df64d224\"");
		conn.setRequestProperty("Cache-conntrol", "max-age=0");
		conn.setRequestProperty("Referer", "http://www.baidu.com");
	}

	public boolean isDownloadOver() {
		return isDownloadOver;
	}

	public long getStartPos() {
		return startPos;
	}

	public long getEndPos() {
		return endPos;
	}
}
