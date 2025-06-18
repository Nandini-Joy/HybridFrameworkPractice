package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	public ExcelUtility(String path)
	{
		this.path=path;
	}
	
	// To get row count
	public int getRowCount(String sheetname) throws IOException
	{
		fi=new FileInputStream(path);
		workbook =new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;
	}
	
	public int getCellCount(String sheetname, int rowcount) throws IOException
	{
		fi=new FileInputStream(path);
		workbook =new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		int colcount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return colcount;
	}

	public String getCellData(String sheetname, int rownum, int colnum) throws IOException 
	{
		fi=new FileInputStream(path);
		workbook =new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter formatter =new DataFormatter();
		String data;
		try {
			data=formatter.formatCellValue(cell);
		}
		catch(Exception e)
		{
			data="";
			workbook.close();
			fi.close();
		
		}
		return data;
		
	}

}
