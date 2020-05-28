package asdaHomeInsurance;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ValuesFromExcel {

	public static void main(String[] args) throws IOException {

		String name = getValue("name");
		String sno = getValue("sl.no");
		String email = getValue("email");
		System.out.println(name + sno   + email);
//		HashMap<Integer, String> hash = new HashMap<Integer, String>();
//		hash.put(1, "sree");
//		hash.put(2, "chandu");
//		hash.put(3, "hari");name
//
//		for (Entry<Integer, String> m : hash.entrySet())
//			System.out.println(m.getKey() + " " + m.getValue());
//		System.out.println(hash.get(2));
//		hash.remove(1);
//		System.out.println(hash.get(1));

	}

	public static String getValue(String keyname) throws IOException {

		FileInputStream input = new FileInputStream(new File("src/resources/basicexcel.xlsx"));
		Workbook workbook = new XSSFWorkbook(input);
		Sheet sheet = workbook.getSheet("Sheet1");
		
		HashMap<String, String> hash1 = new HashMap<String, String>();

		int rowcount = sheet.getLastRowNum();
		System.out.println("row count is" + rowcount);
		for (int i = 1; i <= rowcount; i++) {
			int cellcount = sheet.getRow(i).getLastCellNum();
			System.out.println("cell count is" + cellcount);
			for (int j = 0; j < cellcount; j++) {
				
				String key=sheet.getRow(0).getCell(j).toString();
				String value=sheet.getRow(i).getCell(j).toString();
	
				
				hash1.put(key, value);

			}

		}
		
	    String value=(hash1.get(keyname));
	   //String value= System.out.println(hash1.get(keyname));
		
		return value;
	}

}
