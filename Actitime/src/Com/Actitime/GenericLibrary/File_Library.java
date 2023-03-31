package Com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import net.bytebuddy.asm.Advice.Return;

public class File_Library {
	/**
	 * this method is a non static which is used to read the data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
public String readDataFromProperty(String key) throws IOException
{ 
	FileInputStream fis=new FileInputStream("./testdata/commondata.property");
	Properties p=new Properties();
	p.load(fis);
	String value=p.getProperty(key);
	return value; 
}
/**
 * this methode is a non static used to read the data from excel sheet
 * @param sheetname
 * @param row
 * @param cell
 * @return
 * @throws IOException
 */
public String readDatafromExcelFile(String sheetname,int row,int cell) throws IOException
{
	FileInputStream fis =new FileInputStream("./testdata/Nook.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	return value;
	
}

}
