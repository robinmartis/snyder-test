package com.snyder.test.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {
	
	public static String fromExcel(String filepath, String sheetname, int row_indes, int cel_index)
	{
		String data =null;
		try
		{
			File f = new File("./test-data/" + filepath + ".xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetname);
			Row r = st.getRow(row_indes);
			Cell c = r.getCell(cel_index);
			data= c.toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	public static String fromProperty(String filename, String key)
	{
		String data= null;
		try 
		{
			File f = new File("./test-config/" + filename + ".properties");
			FileInputStream fis = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fis);
			data = (String) prop.get(key);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}

}
