package ssnb6.selenium.testng.data;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import ssnb6.selenium.framework.utils.ExcelReader;

public class HeatclinicLoginData {

	 private static final String EXCEL_FILE_LOCATION = System.getProperty("user.dir") + "/src/test/resources/HeatclinicLoginData.xls";
	 
	@DataProvider
	public Object[][] getTestData(){
		Object[][] data = {
				
				            {"Y","shiftqa01@gmail.com","shiftedtech","Shift"},
							{"Y","nefaur.rb@gmail.com","123456nrbxx","Nefaur"},
							{"N","arifurkh64@yahoo.com","iq9006564","Arifur"}
				           
						   };
		
		return data;
	}
	
	
	@DataProvider
	public Object[][] getTestDataExcel(){
		Object[][] data = null;
		
		//Read Excel
		Workbook workbook = null;
		
		try {
			workbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));
			Sheet sheet = workbook.getSheet(0);
			
			int rows = sheet.getRows();
			int cols  = sheet.getColumns();
			
			//For Array Row first and then Col
			data = new Object[rows - 1][cols - 1];
			for(int i = 1; i < rows; i++) {
			
				//For Excel object first col and then row
				Cell cell1 = sheet.getCell(1, i);
				data[i - 1][0] = cell1.getContents();
				
				Cell cell2 = sheet.getCell(2, i);
				data[i - 1][1] = cell2.getContents();
				
				Cell cell3 = sheet.getCell(3, i);
				data[i - 1][2] = cell3.getContents();
				
				Cell cell4 = sheet.getCell(4, i);
				data[i - 1][3] = cell4.getContents();
			}
			
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	@DataProvider
	public Object[][] getTestDataExcelByPOI(){
		Object[][] data = null;
		
		ExcelReader reader = new ExcelReader(EXCEL_FILE_LOCATION);
		data = reader.getExcelSheetData("Sheet2", true);
		
		return data;
	}
	

}
