package com.snyder.test.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteData {

	public static void toExcel(String filepath, String sheetname, int row_indes, int cel_index, String data)
	{
		try
		{
			File f = new File("./test-data/" + filepath + ".xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetname);
			Row r = st.getRow(row_indes);
			Cell c = r.getCell(cel_index);
			c.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void fromProperty(String filename, String key, String value, String comments)
	{
		try 
		{
			File f = new File("./test-data/" + filename + ".xlsx");
			FileInputStream fis = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fis);
			prop.put(key, value);
			FileOutputStream fos = new FileOutputStream(f);
			prop.save(fos, comments);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
