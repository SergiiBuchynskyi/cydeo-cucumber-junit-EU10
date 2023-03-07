package com.cydeo.test;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    String filePath = "SampleData.xlsx";

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    @Test
    public void excel_write() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet("Employees");

        XSSFCell salaryCell = sheet.getRow(0).createCell(3);
        salaryCell.setCellValue("Salary");
        XSSFCell salary1 = sheet.getRow(1).createCell(3);
        salary1.setCellValue("200000");
        XSSFCell salary2 = sheet.getRow(2).createCell(3);
        salary2.setCellValue("100000");
        XSSFCell salary3 = sheet.getRow(3).createCell(3);
        salary3.setCellValue("84000");
        XSSFCell salary4 = sheet.getRow(4).createCell(3);
        salary4.setCellValue("130000");

        //Mary lastname change to Jones
        for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Mary")){
                sheet.getRow(rowNum).getCell(1).setCellValue("Jones");
            }
        }

        //save changes
        //to read to the file : FileInputStream
        //to write to the file : FileOutputStream
        FileOutputStream outputStream = new FileOutputStream(filePath);

        //save
        workbook.write(outputStream);

        //close all
        outputStream.close();
        workbook.close();
        fileInputStream.close();

    }

}
