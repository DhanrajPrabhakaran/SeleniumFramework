package HybridFramework;

import java.lang.reflect.Method;

public class DriverScriptJava {

	public static Actions actionKeywords;
	public static String sActions;
	public static Method method[];
	
	public static void main(String[] args) throws Exception {
	
		String spath ="C:\\Users\\Dhanraj Prabhakaran\\eclipse-workspace\\SeleniumFramework\\data\\dataEngine.xlsx";
		ReadExcel.setExcelFile(spath,"Sheet1");
		
		for (int iRow=1; iRow<=7; iRow++)
		{
			sActions = ReadExcel.getCellData(iRow,1);
			execute_Actions();	
		}
	}

	private static void execute_Actions() throws Exception
	{
		actionKeywords = new Actions();
		method = actionKeywords.getClass().getMethods();
		for (int i=0; i<method.length; i++)
		{
			if(method[i].getName().equals(sActions))
			{
				method[i].invoke(actionKeywords);
				break;
			}
		}
	}
}
