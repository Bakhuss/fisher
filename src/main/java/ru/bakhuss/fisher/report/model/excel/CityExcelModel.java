package ru.bakhuss.fisher.report.model.excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CityExcelModel {

    public Workbook getCities() {
        Workbook citiesWB = new XSSFWorkbook();
        Sheet sheet0 = citiesWB.createSheet("sheet0");
        Row rowName = sheet0.createRow(0);

        rowName.createCell(0).setCellValue("нас. пункт");
        rowName.createCell(1).setCellValue("Сдэк ПВЗ");
        sheet0.addMergedRegion(new CellRangeAddress(0,0,1,2));
        rowName.createCell(3).setCellValue("Сдэк адрес");
        sheet0.addMergedRegion(new CellRangeAddress(0,0,3,4));

        Row row1 = sheet0.createRow(1);
        row1.createCell(1).setCellValue("срок");
        row1.createCell(2).setCellValue("цена");
        row1.createCell(3).setCellValue("срок");
        row1.createCell(4).setCellValue("цена");

        sheet0.addMergedRegion(new CellRangeAddress(0,1,0,0));

        for (int i = 0; i < 6; i++) {
            sheet0.autoSizeColumn(i);
        }

        return citiesWB;
    }
}
