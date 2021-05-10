package cn.com.aaic.policyticker.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 处理单页xls，入参为文件地址，数据从第几行开始 回参为List<List<String>>
 * 
 * @author 76350
 *
 */
public class xlsToCodeUtil {
	
	
	public static void main(String[] args) throws IOException {
		List<List<String>> alllist = handler("C:\\Users\\76350\\Desktop\\新建 Microsoft Excel 工作表 (2).xlsx",1);
		for(List<String> list :alllist) {
//			else if(CompanyType.equals("0") && SubdivideType.equals("1") && policyGrade.equals("2") &&  numEmployees >= 3  && numEmployees <= 4) {
//				double[] arr = new double[4];	
//				arr[0] = 5;
//				arr[1] = 6;
//				arr[2] = 7;
//				arr[3] = 8;
//				return arr;
//			}
			
			System.out.println("else if(CompanyType.equals(\"" +list.get(0)  +"\") && SubdivideType.equals(\"" + list.get(1) +"\") && policyGrade.equals(\"" +  list.get(2) + "\") &&  numEmployees >= " +list.get(3)  + "  && numEmployees <= " + list.get(4)+ ") {");
			System.out.println("double[] arr = new double[4];	");
			System.out.println("arr[0] = " + list.get(5) + ";");
			System.out.println("arr[1] = " + list.get(6) + ";");
			System.out.println("arr[2] = " + list.get(7) + ";");
			System.out.println("arr[3] = " + list.get(8) + ";");
			System.out.println("return arr;");
			System.out.println("}");
		}
		
	}
	
	
	public static List<List<String>> handler(String filePath, int firstDataRow) throws IOException {
		List<List<String>> zongList = new ArrayList<List<String>>();

		// 获取excle文件
		Workbook wb = null;
		String extString = filePath.substring(filePath.lastIndexOf("."));
		InputStream is = null;
		is = new FileInputStream(filePath);
		if (".xls".equals(extString)) {
			wb = new HSSFWorkbook(is);
		} else if (".xlsx".equals(extString)) {
			wb = new XSSFWorkbook(is);
		}

		// 读第一页
		Sheet sheet = wb.getSheetAt(0);
		// 获取最大行数
		int maxrownum = sheet.getPhysicalNumberOfRows();
		// 获取第一行
		Row row = sheet.getRow(firstDataRow - 1); // 从0开始计数
		// 获取最大列数
		int maxcolnum = row.getPhysicalNumberOfCells();

		for (int i = firstDataRow - 1; i < maxrownum; i++) {
			// 定义数据存储集合
			List<String> list = new ArrayList<String>();
			// 获取一行
			row = sheet.getRow(i);
			// 循环列，一个个获取
			for (int j = 0; j < maxcolnum; j++) {
				// 获取一个格内容
				Cell cell = row.getCell(j);
				// 获取数据
				String cellData = getCellValue(cell); // 这里只处理了String类型,其它内容单独处理
				list.add(cellData);
			}
			zongList.add(list);
		}

		return zongList;
	}

	/**
	 * 对不同类型处理
	 * 
	 * @param cell
	 * @return
	 */
	public static String getCellValue(Cell cell) {
		String cellValue = "";
		if (cell == null) {
			return cellValue;
		}
		switch (cell.getCellType()) {
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case STRING:
			return String.valueOf(cell.getStringCellValue());
		case BLANK:
			return "";
		case ERROR:
			return String.valueOf(cell.getErrorCellValue());
		/*
		 * case FORMULA: //公式类型
		 * System.out.println(evaluator.evaluate(row.getCell(k)).getNumberValue());
		 * break;
		 */
		default:
			return "";
		}
	}
}
