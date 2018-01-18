package others.demo.hadoop;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HadoopDemo {
	private static String url = "hdfs://192.168.121.100:9000";
	public static void main(String[] args) throws Exception {
		URI uri = new URI(url);
		Configuration configuration = new Configuration();
		FileSystem system = FileSystem.get(uri, configuration);
		InputStream inputStream = system.open(new Path("/bobotest"));
		OutputStream out = new FileOutputStream("/usr/environment/tomcat/apache-tomcat-7.0.82.tar.gz");
		IOUtils.copyLarge(inputStream, out, new byte[4096]);
	}
}
