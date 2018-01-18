package com.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;

import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.entities.Post;

public class SAXParserHandle extends DefaultHandler{
	private Post post; 
	private String currentTag;
	private volatile PrintStream printStream;
	private volatile FileWriter fileWriter;
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
	}
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
	}
    @Override
    public void startElement(String arg0, String arg1, String name,Attributes attributes) throws SAXException {
        super.startElement(arg0, arg1, name, attributes);
        if(name.equals("POST")){
           post = new Post();
        }else if(name.equals("dataroot")){
        }
    }

    @Override
    public void endElement(String arg0, String arg1, String name)
            throws SAXException {
        super.endElement(arg0, arg1, name);
        if(name.equals("POST")){
            try {
            	String sql = "insert into post (id,postNumber,province,city,district,address,jd) VALUES ('"+StringUtils.trimToEmpty(post.getId())+"','"+StringUtils.trimToEmpty(post.getPostNumber())+"','"+StringUtils.trimToEmpty(post.getProvince())+"','"+StringUtils.trimToEmpty(post.getCity())+"','"+StringUtils.trimToEmpty(post.getDistrict())+"','"+StringUtils.trimToEmpty(post.getAddress())+"','"+StringUtils.trimToEmpty(post.getJd())+"');";
            	fileWriter = new FileWriter(new File("C:\\TXTMIN5temp\\sql1.sql"),true);
            	BufferedWriter writer = new BufferedWriter(fileWriter);
            	writer.write(sql);
            	writer.write("\n");
            	writer.flush();
    			//printStream = new PrintStream(new FileOutputStream(new File("C:\\TXTMIN5temp\\sql1.sql")));
    			//printStream.println(sql);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        }
        currentTag = name;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String nodeValue = new String(ch, start, length);
        
        if("id".equals(currentTag)){
        	post.setId(nodeValue);
        }else if("PostNumber".equals(currentTag)){
        	post.setPostNumber(nodeValue);
        }else if("Province".equals(currentTag)){
        	post.setProvince(nodeValue);
        }else if("City".equals(currentTag)){
        	post.setCity(nodeValue);
        	if (nodeValue.length()>20) {
        		System.out.println(nodeValue);
			}
        	
        }else if("District".equals(currentTag)){
        	post.setDistrict(nodeValue);
        }else if("Address".equals(currentTag)){
        	post.setAddress(nodeValue);
        }else if("jd".equals(currentTag)){
        	post.setJd(nodeValue);
        }
    }
}
