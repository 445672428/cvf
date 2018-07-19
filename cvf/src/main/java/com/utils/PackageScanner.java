package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PackageScanner {
	private Logger logger = LoggerFactory.getLogger(PackageScanner.class);
	private String basePackage;
	private ClassLoader cl;

	public PackageScanner(String basePackage) {
		this.basePackage = basePackage;
		this.cl = getClass().getClassLoader();
	}

	public List<String> getCheckPackageFullyQualifiedClassNameList() throws IOException {
		return doScan(basePackage, new ArrayList<String>());
	}

	private List<String> doScan(String basePackage2, ArrayList<String> nameList) throws IOException {
		String splashPath = dotToSplash(basePackage);
		URL url = cl.getResource(splashPath);
		String filePath = getRootPath(url);
		List<String> names = null;
		if (isJarFile(filePath)) {// 先判断是否是jar包，如果是jar包，通过JarInputStream产生的JarEntity去递归查询所有类
			 names = readFromJarFile(filePath, splashPath);
		}else{
			names = readFromDirectory(filePath);
		}
		for(String name : names){
			if (isClassFile(name)) {
				nameList.add(toFullyQualifiedName(name, basePackage));
			}else{
				doScan(basePackage + "." + name, nameList);
			}
		}
		return nameList;
	}

	private String toFullyQualifiedName(String shortName, String basePackage) {
		StringBuilder sb = new StringBuilder(basePackage);
		sb.append('.');
		sb.append(trimExtension(shortName));
		// 打印出结果
		return sb.toString();
	}

	private List<String> readFromJarFile(String jarPath,String splashedPackageName) throws IOException {
		if (logger.isDebugEnabled()) {
			logger.debug("从JAR包中读取类: {}", jarPath);
		}
		JarInputStream jarIn = new JarInputStream(new FileInputStream(jarPath));
		JarEntry entry = jarIn.getNextJarEntry();
		List<String> nameList = new ArrayList<String>();
		while (null != entry) {
			String name = entry.getName();
			if (name.startsWith(splashedPackageName) && isClassFile(name)) {
				nameList.add(name);
			}
			entry = jarIn.getNextJarEntry();
		}
		jarIn.close();
		return nameList;
	}

	private boolean isJarFile(String name) {
		return name.endsWith(".jar");
	}

	private boolean isClassFile(String name) {
		return name.endsWith(".class");
	}

	private List<String> readFromDirectory(String path) {
		File file = new File(path);
		String[] names = file.list();
		if (null == names) {
			return null;
		}
		return Arrays.asList(names);
	}

	public static String dotToSplash(String name) {
		return name.replaceAll("\\.", "/");
	}

	public static String getRootPath(URL url) {
		String fileUrl = url.getFile();
		int pos = fileUrl.indexOf('!');

		if (-1 == pos) {
			return fileUrl;
		}

		return fileUrl.substring(5, pos);
	}

	public static String trimExtension(String name) {
		int pos = name.indexOf('.');
		if (-1 != pos) {
			return name.substring(0, pos);
		}
		return name;
	}

	public static String trimURI(String uri) {
		String trimmed = uri.substring(1);
		int splashIndex = trimmed.indexOf('/');

		return trimmed.substring(splashIndex);
	}
}
