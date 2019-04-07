package com.zoopla.base;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.StrictMath.max;

public class TestUtil {
    public static final int PAGE_LOAD_TIMEOUT = 20;
    public static final int IMPLICITLY_WAIT = 10;
    public static final String TEST_DATA_FILE_PATH = "/Users/Kingslayer/Downloads/Selenium/NaveenHybridFramework/AutomationChallenge/src/main/resources/AutomationData.xlsx";
    static Workbook book;
    static Sheet sheet;

    // Method to extract the maximum value
    public static int getNumeric(String str)
    {
        String string;
        string = str.replaceAll("[^0-9]", "");
        return Integer.parseInt(string);
    }

    public static Object[][] getTestData(String sheetName){
        FileInputStream inputFile = null;
        try
        {
            inputFile = new FileInputStream(TEST_DATA_FILE_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try
        {
            book = WorkbookFactory.create(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sheet = book.getSheet(sheetName);

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for(int i = 0; i<sheet.getLastRowNum(); i++)
        {
            for(int k=0; k < sheet.getRow(0).getLastCellNum(); k++)
            {
                data[i][k] = sheet.getRow(i+1).getCell(k).toString();
            }
        }

        return data;
    }
}
