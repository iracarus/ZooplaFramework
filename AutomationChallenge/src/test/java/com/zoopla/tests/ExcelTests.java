package com.zoopla.tests;

import com.zoopla.base.ExcelUtils;
import org.testng.annotations.Test;

public class ExcelTests {
    @Test
    public void getData()
    {
        System.out.println(ExcelUtils.getCellData(0,0));
        System.out.println(ExcelUtils.getCellData(0,1));
        System.out.println(ExcelUtils.getCellData(1,0));
        System.out.println((int)Double.parseDouble(ExcelUtils.getCellData(1,1)));
        System.out.println(ExcelUtils.getCellData(2,2));
        //System.out.println(ExcelUtils.getCellData(2,2));
    }
}
