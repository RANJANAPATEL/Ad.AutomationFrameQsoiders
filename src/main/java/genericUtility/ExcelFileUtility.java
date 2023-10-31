package genericUtility;

	import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

	/**
	 * This class consist of generic methods related to excel file
	 * @author ranjanapatel
	 *
	 */

	public class ExcelFileUtility {
		/**
		 * This method will read data from excel file and return the value to caller
		 * @param sheetname
		 * @param rowNo
		 * @param cellNo
		 * @return
		 * @throws EncrytedDocumentException
		 * @throws Exception
		 */
		
		public String readDataFromExcel(String sheetname, int rowNo, int cellNo) throws Exception
		{
			
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
				String value = wb.getSheet(sheetname).getRow(rowNo).getCell(cellNo).getStringCellValue();
			return value;
			
		}
		
		public Object [][] readMultipleData(String sheetname) throws EncryptedDocumentException, IOException
		{
			
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int lastRow = sh.getLastRowNum();
	short lastcell = sh.getRow(0).getLastCellNum();
	
	Object[][] data = new Object[lastRow][lastcell];
	
	for(int i =0; i<lastRow;i++)
	{
		for(int j=0; j<lastcell;j++)
		{
			data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
			return null;
			
		}
	}


