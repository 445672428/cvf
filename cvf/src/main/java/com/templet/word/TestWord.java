package com.templet.word;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

public class TestWord {
	public static void main(String[] args) {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("project", "bobo");
		reportDoc(m, "D:\\DocxProjectWithFreemarker.docx", "D:\\DocxProjectWithFreemarker_OUT.docx");
	}
	public static void reportDoc(Map<String, Object> reportData, String templateName, String outputFileName) {
	    Map<String, Object> params = reportData;
	    InputStream in = null;
	    OutputStream outputStream = null;
	    IXDocReport report = null;
	    try {
	        in = new FileInputStream(new File(templateName));

	        // 2) Create Java model context
	        IContext context = getReportContext(report, params);
	        // 输出文件，文件存在则删除
			
	        File outputFile = new File(outputFileName);
	        // 文件夹不存在，创建所有文件夹
	        File parentFile = outputFile.getParentFile();
	        if (!parentFile.exists()) {
	            parentFile.mkdirs();
	        }
	        if (outputFile.exists()) {
	            outputFile.renameTo(new File(outputFileName + "." + new Date().getTime()));
	        }
	        // 生成新的文件
	        outputStream = new FileOutputStream(outputFileName);
	        report.process(context, outputStream);
	    } catch (IOException e) {
	    } catch (XDocReportException e) {
	    } finally {
	        try {
	            if (outputStream != null) {
	                outputStream.close();
	            }
	            if (in != null) {
	                in.close();
	            }
	        } catch (IOException e) {
	        }
	    }
	}
	private static IContext getReportContext(IXDocReport report, Map<String, Object> params) throws XDocReportException {
	    IContext context = null;
	    if (report != null) {
	        context = report.createContext();
	        FieldsMetadata metadata = new FieldsMetadata();
	        for (Iterator<Entry<String, Object>> iterator = params.entrySet().iterator(); iterator.hasNext(); ) {
	            Map.Entry<String,Object> entry = (Map.Entry<String,Object>) iterator.next();
	            String name = entry.getKey();
	            Object value = entry.getValue();
	            context.put(name, value);
	        }
	        report.setFieldsMetadata(metadata);
	    }
	    return context;
	}
}
