package com.nikhil.banking.utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static Object[][] getTestData() {

        Object[][] data = null;

        try {

            FileInputStream fis = new FileInputStream(
                    "src/test/resources/testdata/SearchData.xlsx");

            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            XSSFSheet sheet = workbook.getSheetAt(0);

            int rows = sheet.getPhysicalNumberOfRows();

            data = new Object[rows - 1][1];

            for (int i = 1; i < rows; i++) {

                data[i - 1][0] =
                        sheet.getRow(i)
                             .getCell(0)
                             .getStringCellValue();
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return data;
    }

    public static Object[][] getLoginData() {

        Object[][] data = null;

        try {

            FileInputStream fis =
                    new FileInputStream(
                            "src/test/resources/testdata/LoginData.xlsx");

            XSSFWorkbook workbook =
                    new XSSFWorkbook(fis);

            XSSFSheet sheet =
                    workbook.getSheetAt(0);

            int rows =
                    sheet.getPhysicalNumberOfRows();

            int cols =
                    sheet.getRow(0).getPhysicalNumberOfCells();

            data = new Object[rows - 1][cols];

            for (int i = 1; i < rows; i++) {

                for (int j = 0; j < cols; j++) {

                    data[i - 1][j] =
                            sheet.getRow(i)
                                 .getCell(j)
                                 .getStringCellValue();
                }
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return data;
    }
}