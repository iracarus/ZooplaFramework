package com.zoopla.base;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ExcelUtils {
    public static String getCellData(int row, int col)
    {
        String FILE_NAME = "/Users/Kingslayer/Downloads/Selenium/NaveenHybridFramework/AutomationChallenge/src/main/resources/AutomationData.xlsx";
        try {
            FileInputStream input = new FileInputStream(FILE_NAME);
            XSSFWorkbook wb = new XSSFWorkbook(input);
            XSSFSheet ws = wb.getSheetAt(0);

            try
            {
                if(ws.getRow(row).getCell(col).getCellType() == CellType.STRING)
                    return ws.getRow(row).getCell(col).getStringCellValue();
                else if(ws.getRow(row).getCell(col).getCellType() == CellType.NUMERIC)
                    return String.valueOf(ws.getRow(row).getCell(col).getNumericCellValue());
            }catch (NullPointerException npe)
            {
                System.out.println("non existing cell");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
