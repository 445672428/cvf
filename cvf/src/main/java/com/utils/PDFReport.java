package com.utils;

import com.lowagie.text.Element;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
  
public class PDFReport{  
    
 
      
     public static PdfPCell createCell(String value,com.lowagie.text.Font font,int align){  
         PdfPCell cell = new PdfPCell();  
         cell.setVerticalAlignment(Element.ALIGN_MIDDLE);          
         cell.setHorizontalAlignment(align);      
         cell.setPhrase(new Phrase(value,font));  
        return cell;  
    }  
     
     
    public static PdfPCell createCell(String value,com.lowagie.text.Font font,int align,float FixedHeight){  
        PdfPCell cell = new PdfPCell();  
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);          
        cell.setHorizontalAlignment(align);      
        cell.setPhrase(new Phrase(value,font));  
        cell.setFixedHeight(FixedHeight);
       return cell;  
   }  
     
     
     public static PdfPCell createCell(String value,com.lowagie.text.Font font){  
         PdfPCell cell = new PdfPCell();  
         cell.setVerticalAlignment(Element.ALIGN_MIDDLE);  
         cell.setHorizontalAlignment(Element.ALIGN_CENTER);   
         cell.setPhrase(new Phrase(value,font));  
        return cell;  
    }  
     
     
     public static PdfPCell createCell(String value,com.lowagie.text.Font font,float FixedHeight){  
         PdfPCell cell = new PdfPCell();  
         cell.setVerticalAlignment(Element.ALIGN_MIDDLE);  
         cell.setHorizontalAlignment(Element.ALIGN_CENTER); 
         cell.setFixedHeight(FixedHeight);
         cell.setPhrase(new Phrase(value,font));  
        return cell;  
    } 
  
     
     public static PdfPCell createCell(String value,com.lowagie.text.Font font,int align,int colspan){  
         PdfPCell cell = new PdfPCell();  
         cell.setVerticalAlignment(Element.ALIGN_MIDDLE);  
         cell.setHorizontalAlignment(align);      
         cell.setColspan(colspan);  
         cell.setPhrase(new Phrase(value,font));  
        return cell;  
    }  
    
     
    public static PdfPCell createCell(String value,com.lowagie.text.Font font,int align,int colspan,boolean boderFlag){  
         PdfPCell cell = new PdfPCell();  
         cell.setVerticalAlignment(Element.ALIGN_MIDDLE);  
         cell.setHorizontalAlignment(align);      
         cell.setColspan(colspan); 
         cell.setPhrase(new Phrase(value,font)); 
         cell.setPadding(3.0f);  
         if(!boderFlag){  
             cell.setBorder(0);  
             cell.setPaddingTop(15.0f);  
             cell.setPaddingBottom(8.0f);  
         }  
        return cell;  
    }  
    
    
   public static PdfPCell createCell(String value,com.lowagie.text.Font font,int align,int colspan,boolean boderFlag,float FixedHeight){  
        PdfPCell cell = new PdfPCell();  
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);  
        cell.setHorizontalAlignment(align);      
        cell.setColspan(colspan); 
        cell.setPhrase(new Phrase(value,font)); 
        //cell.setPadding(3.0f); //上下左右单元格填充
        cell.setFixedHeight(FixedHeight);
        if(!boderFlag){  
            cell.setBorder(0);  
          /*  cell.setPaddingTop(15.0f); //上单元格填充
            cell.setPaddingBottom(8.0f);//下单元格填充  */
        }
        //cell.setBackgroundColor(new Color(255, 0, 0));
       return cell;  
   }  
    
    /**
     * 创建表格
     * @param colNumber 列数
     * @param maxWidth 表的宽度
     * @return
     */
    public static PdfPTable createTable(int colNumber,int maxWidth){  
        PdfPTable table = new PdfPTable(colNumber);  
        try{  
            table.setTotalWidth(maxWidth);  
            table.setLockedWidth(true);  
            table.setHorizontalAlignment(Element.ALIGN_CENTER);       
            table.getDefaultCell().setBorder(1);  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
        return table;  
    }  
    
    
    public  static PdfPTable createTable(float[] widths,int maxWidth){  
            PdfPTable table = new PdfPTable(widths);  
            try{  
                table.setTotalWidth(maxWidth);  
                table.setLockedWidth(true); 
                table.setHorizontalAlignment(Element.ALIGN_CENTER);   
                table.getDefaultCell().setBorder(1);
            }catch(Exception e){  
                e.printStackTrace();  
            }  
            return table;  
        }  

   /*  public static void main(String[] args) throws Exception {  
                      
    }  
      */
      
}
