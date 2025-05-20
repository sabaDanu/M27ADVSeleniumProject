package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis =new FileInputStream("C:\\Users\\sabap\\eclipse-workspace\\SeleniumProject\\src\\main\\resources\\commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value ;
	}
	public String readDataFromExcel(String sheetname,int rowno,int cellno) throws EncryptedDocumentException, IOException {
		FileInputStream flse =new FileInputStream("C:\\Users\\sabap\\eclipse-workspace\\SeleniumProject\\src\\main\\resources\\AdvSele.xlsx");
		Workbook wb = WorkbookFactory.create(flse);
		Sheet sh = wb.getSheet(sheetname);
		Row rw = sh.getRow(rowno);
		Cell cl = rw.getCell(cellno);
		String value = cl.getStringCellValue();
		return value;
	}
}
