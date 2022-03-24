package com.paynet.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//need to delete
public class Demo1Test {

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream("data/TestData.xlsx");

		XSSFWorkbook book = new XSSFWorkbook(file);

		XSSFSheet sheet = book.getSheet("validCredentialTest");

		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();

		String[][] main = new String[rowCount - 1][cellCount];

		for (int r = 1; r < rowCount; r++) {
			for (int c = 0; c < cellCount; c++) {
				XSSFCell cell = sheet.getRow(r).getCell(c);

				DataFormatter format = new DataFormatter();
				String value = format.formatCellValue(cell);
				System.out.println(value);

				main[r - 1][c] = value;
			}
		}

		System.out.println(main);
		book.close();
		file.close();

	}

}
