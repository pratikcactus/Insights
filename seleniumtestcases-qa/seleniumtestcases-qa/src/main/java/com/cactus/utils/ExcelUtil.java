package com.cactus.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public Object[][] getUserDataFromExcel(String fileName, String sheetName, String column, String columnValue) {

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());

		String[][] excelData = readExcelFile(file.getAbsolutePath(), sheetName);

		// With Yes Flag
		int rows = 0;

		for (String[] s : excelData) {
			if (!s[0].equalsIgnoreCase("No")) {
				rows++;
			}
		}

		// Without Yes Flag
		Object[][] dataSet = new Object[rows][1];
		int index = 0;
		for (int i = 0; i < excelData.length; i++) {
			Map<String, String> user = new HashedMap<String, String>();
			if (excelData[i][0].equalsIgnoreCase("Yes")) {
				for (int j = 0; j < excelData[i].length; j++) {
					user.put(excelData[0][j], excelData[i][j]);
				}
				Map<String, String> temp = user;
				dataSet[index][0] = temp;
				index++;
			}
		}

		return dataSet;
	}

	public Object[][] getUserDataFromExcel(String fileName, String sheetName) {

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());

		String[][] excelData = readExcelFile(file.getAbsolutePath(), sheetName);

		// With Yes Flag
		int rows = 0;

		for (String[] s : excelData) {
			if (s[0].toLowerCase().equalsIgnoreCase("yes")) {
				rows++;
			}
		}

		// Without Yes Flag
		Object[][] dataSet = new Object[rows][1];
		int index = 0;
		for (int i = 2; i < excelData.length; i++) {
			Map<String, String> user = new HashedMap<String, String>();
			if (excelData[i][0].toLowerCase().equalsIgnoreCase("yes")) {
				for (int j = 0; j < excelData[i].length; j++) {
					user.put(excelData[1][j], excelData[i][j]);
				}
				Map<String, String> temp = user;
				dataSet[index][0] = temp;
				index++;
			}
		}

		return dataSet;
	}

	public Map<String, String> getUserDataInMapFromExcel(String fileName, String sheetName, String columnToBeChecked,
			String checkForValue) {

		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource(fileName).getFile());
			// File file = new File(fileName);

			Workbook wb = WorkbookFactory.create(file);

			Sheet sheet = wb.getSheet(sheetName);
			Row rowCol = sheet.getRow(1);
			int cols = rowCol.getPhysicalNumberOfCells();
			int rows = sheet.getPhysicalNumberOfRows();

			FileInputStream inputStream = new FileInputStream(file);
			Workbook wbk = WorkbookFactory.create(inputStream);
			Sheet firstSheet = wbk.getSheet(sheetName);

			int colNoToBeChecked = getColNo(cols, columnToBeChecked, rowCol);
			int rowNoToBeUpdated = getRowNo(rows, colNoToBeChecked, sheet, checkForValue);
			Map<String, String> user = new HashedMap<String, String>();
			Row row = firstSheet.getRow(rowNoToBeUpdated);
			cols = row.getPhysicalNumberOfCells();
			for (int i = 0; i < cols; i++) {
				Cell cell = row.getCell(i);
				Cell colName = rowCol.getCell(i);
				user.put(colName.getStringCellValue(), cell.getStringCellValue());
			}
			inputStream.close();

			return user;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	public String[][] readExcelFile(String filePath, String sheetName) {

		try {

			Workbook wb = WorkbookFactory.create(new File(filePath));

			Sheet sheet = wb.getSheet(sheetName);

			int rows = sheet.getPhysicalNumberOfRows();
			Row row = sheet.getRow(2);
			int cells = row.getPhysicalNumberOfCells();

			String[][] sheetData = new String[rows][cells];

			for (int i = 0; i < rows; i++) {
				row = sheet.getRow(i);
				for (int j = 0; j < cells; j++) {
					Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cell.toString();
					String cellValue = "";

					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						cellValue = cell.getStringCellValue();
						break;
					case Cell.CELL_TYPE_NUMERIC:
						cellValue = String.valueOf(cell.getNumericCellValue());
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						cellValue = String.valueOf(cell.getBooleanCellValue());
						break;
					default:
						cellValue = "";
						break;
					}

					sheetData[i][j] = cellValue;

				}
			}
			return sheetData;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void writeExcelFile(String filePath, String sheetName, Map<String, String> data) {
		try {
			File file = new File(filePath);

			Workbook wb = WorkbookFactory.create(file);

			Sheet sheet = wb.getSheet(sheetName);
			Row rowCol = sheet.getRow(1);
			int cols = rowCol.getPhysicalNumberOfCells();
			int rows = sheet.getPhysicalNumberOfRows();

			int rowno = rows;
			FileInputStream inputStream = new FileInputStream(file);
			Workbook wbk = WorkbookFactory.create(inputStream);
			Sheet firstSheet = wbk.getSheet(sheetName);

			Row row = firstSheet.createRow(rowno);
			// sheet.getRow(1).getCell(1);
			for (int i = 0; i < cols; i++) {
				row.createCell(i).setCellValue(data.get(rowCol.getCell(i) + ""));
			}
			inputStream.close();
			FileOutputStream fos = new FileOutputStream(new File(filePath));
			wbk.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
	}

	public void setCellValue(String filePath, String sheetName, String columnToBeChecked, String columnToBeUpdated,
			String checkForValue, String valueTobeUpdated) {
		try {
			File file = new File(filePath);

			Workbook wb = WorkbookFactory.create(file);

			Sheet sheet = wb.getSheet(sheetName);
			Row rowCol = sheet.getRow(1);
			int cols = rowCol.getPhysicalNumberOfCells();
			int rows = sheet.getPhysicalNumberOfRows();

			FileInputStream inputStream = new FileInputStream(file);
			Workbook wbk = WorkbookFactory.create(inputStream);
			Sheet firstSheet = wbk.getSheet(sheetName);

			int colNoToBeChecked = getColNo(cols, columnToBeChecked, rowCol);
			int colNoToBeUpdated = getColNo(cols, columnToBeUpdated, rowCol);
			int rowNoToBeUpdated = getRowNo(rows, colNoToBeChecked, sheet, checkForValue);

			Row row = firstSheet.getRow(rowNoToBeUpdated);
			Cell cell = row.getCell(colNoToBeUpdated);
			if (cell == null) {
				cell = row.createCell(colNoToBeUpdated);
			}
			cell.setCellValue(valueTobeUpdated);

			inputStream.close();
			FileOutputStream fos = new FileOutputStream(new File(filePath));
			wbk.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
	}

	public int getColNo(int cols, String columnToBeChecked, Row rowCol) {
		int colNoToBeChecked = 0;
		for (int i = 0; i < cols; i++) {
			String colValue = rowCol.getCell(i).getStringCellValue();
			if (colValue.equalsIgnoreCase(columnToBeChecked)) {
				colNoToBeChecked = i;
				break;
			}
		}
		return colNoToBeChecked;
	}

	public int getRowNo(int rows, int colNoToBeChecked, Sheet sheet, String checkForValue) {
		int rowNoToBeUpdated = 0;
		for (int i = 0; i < rows; i++) {
			Row rowI = sheet.getRow(i);
			String colValue = rowI.getCell(colNoToBeChecked).getStringCellValue();

			if (colValue.equalsIgnoreCase(checkForValue)) {
				rowNoToBeUpdated = i;
				break;
			}
		}
		return rowNoToBeUpdated;
	}

	public Map<String, Map<String, Map<String, String>>> getUserDataInMapFromExcelServiceFeedbackTranslation(String fileName, String sheetName) {

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());

		String[][] excelData = readExcelFile(file.getAbsolutePath(), sheetName);
		
		Map<String,Map<String,Map<String,String>>>user=new HashMap<String, Map<String,Map<String,String>>>();

		int rows =excelData.length;
		int cols =excelData[0].length;
		
		for (int i = 1; i < rows; i++) {
			String key=excelData[i][0];
			if(user.get(key)==null){
				Map<String,Map<String,String>> user1=new HashMap<String,Map<String,String>>();
				Map<String,String> user2=new HashMap<String,String>();
				for(int j=1;j<cols;j++){
					user2.put(excelData[0][j], excelData[i][j]);
					
				}
				user1.put(excelData[i][1], user2);
				user.put(key, user1);
				
			}else{
				Map<String,Map<String,String>> user1=user.get(key);
				String key1=excelData[i][1];
					Map<String,String> user2=new HashMap<String,String>();
					for(int j=1;j<cols;j++){
						user2.put(excelData[0][j], excelData[i][j]);
						
					}
					user1.put(key1, user2);
					user.put(key, user1);
						
			}
			
		}

		return user;
	}

}
