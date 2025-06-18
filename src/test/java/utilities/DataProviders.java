package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//Data provider1
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=".\\D:\\DataProviderTest.xlsx"; // Taking excel file from location
		
		ExcelUtility xlutil=new ExcelUtility(path); // Creating an object for Excel Utility class 
		int totalrows=xlutil.getRowCount("sheet1");
		int totacells=xlutil.getCellCount("sheet1", 1);
		String logindata[][]=new String[totalrows][totacells];//Created for 2 dimension array which can store values
		
		for(int i=1; i<=totalrows; i++) //1 //reading data from excel storing in 2 dimension array
		{
			for(int j=0; j<=totacells; j++) // i is row j is column
			{
				logindata[i-1][j]=xlutil.getCellData("sheet1", i, j); // 1, 0
			}
		}
		return logindata; // returning 2 dimension array
	}
			

}
