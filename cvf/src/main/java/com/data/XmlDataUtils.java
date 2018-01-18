package com.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.QName;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

public class XmlDataUtils {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		SAXParser parser = parserFactory.newSAXParser();
		SAXParserHandle handle = new SAXParserHandle();
		parser.parse("D:\\Download\\2000W\\POST.xml", handle);

/*		 File f=new File("D:\\Download\\2000W\\POST.xml");
	     Dom4J(f);*/
	}
	public static void Dom4J(File f){
		PrintStream printStream = null;
        try {
        	printStream = new PrintStream(new FileOutputStream(new File("C:\\TXTMIN5temp\\sql1.sql")));
            SAXReader reader=new SAXReader();    //使用SAXReader方式读取XML文件
            Document doc=reader.read(f);        //加载XML配置文件，得到Document对象
            Element root=doc.getRootElement();  //获得根节点
            Element chElement = root.element("dataroot");
            for(Iterator i=root.elementIterator("POST");i.hasNext();){
            	Element temp=(Element) i.next();
            	Element t1 = temp.element("id");
            	String id = t1.getText();
            	System.out.println(id);
            	//String sql = "insert into city (id,cityName,pid,zipCode) VALUES ('"+ID+"','"+CityName+"','"+PID+"','"+ZipCode+"');";
            	//printStream.println(sql);
            	//System.out.println(ZipCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
