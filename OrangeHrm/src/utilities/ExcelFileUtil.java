package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtil 
{
	  Workbook wb;
	    
	  public ExcelFileUtil() throws Throwable
	  {
    	    FileInputStream fis=new FileInputStream(".TestInputs\\InputSheet.xlsx");
	    	wb=WorkbookFactory.create(fis);
	    }
	
}
