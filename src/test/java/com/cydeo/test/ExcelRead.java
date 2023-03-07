package com.cydeo.test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {


    @Test
    public void read_from_exel_file() throws IOException {
        String path = "SampleData.xlsx";

        File file = new File(path);


        FileInputStream fileInputStream = new FileInputStream(file);

        //workbook>sheet>row>cell;
        //<1> Create a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        //<2> We need to get specific sheet from currently opened workbook
        XSSFSheet sheet = workbook.getSheet("Employees");
        //<3> Select row and cell
        // Print out mary's cell
        // Indexes start from 0
        System.out.println(sheet.getRow(1).getCell(0));

        // print out developer
        System.out.println(sheet.getRow(3).getCell(2));

        //counts NOT EMPTY raws
        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println(usedRows);

        //counts ALL raws from 0
        int lastUsedRaw = sheet.getLastRowNum();
        System.out.println(lastUsedRaw);

        //TODO: Create a logic to print Vinod's name
        for (int rowNum = 0; rowNum < usedRows; rowNum++) {

            if (sheet.getRow(rowNum).getCell(0).toString().equals("Vinod")) {
                System.out.println(sheet.getRow(rowNum).getCell(0));
            }


        }
        //TODO:Create a logic to print Linda's ID
        for (int rowNum = 0; rowNum < usedRows; rowNum++) {

            if (sheet.getRow(rowNum).getCell(0).toString().equals("Linda")) {
                System.out.println(sheet.getRow(rowNum).getCell(2));
            }


        }

    }


}
