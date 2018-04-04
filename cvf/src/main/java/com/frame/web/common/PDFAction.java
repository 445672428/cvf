package com.frame.web.common;

import java.awt.Color;
import java.io.FileOutputStream;

import org.bytedeco.javacpp.RealSense.float2;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfWriter;

public class PDFAction {
	int marginLeft;
	int marginRight;
	int marginTop;
	int marginBottom;
	
	int left;
	int right;
	int top;
	int bottom;

	String color;
	
	
	public static void main(String[] args) throws Exception {
		Document document = new Document();
		FileOutputStream outStream = new FileOutputStream("D://hello.PDF");
		PdfWriter.getInstance(document, outStream);
		document.open();
//		document.add(new Paragraph("hello world"));
		
//		Table table = new Table(2);
//		float[] wdh = {2f,3f};
//		table.setWidths(wdh);
//		table.setWidth(100);
//		table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
//		Cell cell = new Cell(new Paragraph("地址:家里肯德基案款杜卡迪换货单号我卡山东快书快递单号去问哈时间冻结撒包括打不开打扮的"));
//		table.addCell(cell);
		Font font = new Font();
//		PdfPCell cell = createPDFCell("地址:家里肯德基案款杜卡迪换货单号我卡山东快书快递单号去问哈时间冻结撒包括打不开打扮的", font);
		
		Table table = new Table(3);
		table.setBorderWidth(1);
		table.setBorderColor(new Color(0, 0, 255));
		table.setPadding(5);
		table.setSpacing(5);
		Cell cell = new Cell("header");
		cell.setHeader(true);
		cell.setColspan(3);
		table.addCell(cell);
		table.endHeaders();
		
		
		cell = new Cell("example cell with colspan 1 and rowspan 2");
		cell.setRowspan(2);
		cell.setBorderColor(new Color(255, 0, 0));
		table.addCell(cell);
		table.addCell("1.1");
		table.addCell("2.1");
		table.addCell("1.2");
		table.addCell("2.2");
		table.addCell("cell test1");
		
		
		cell = new Cell("big cell");
		cell.setRowspan(2);
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("cell test2"); 
		
		document.add(table);

//		document.add(new Paragraph("hello world2"));
		document.close();
	}
	
	
	
	
	//创建表单
	
	public static PdfPCell createPDFCell(String value,Font font){
        PdfPCell cell = new PdfPCell(); 
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);  
        cell.setPhrase(new Phrase(value,font)); 
        return cell;
	}
}
