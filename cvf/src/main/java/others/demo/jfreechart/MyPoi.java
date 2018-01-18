package others.demo.jfreechart;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class MyPoi {
    public void poi() {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
      //获得第一个sheet页
        HSSFSheet sheet = hssfWorkbook.getSheetAt(0);
    }
}
