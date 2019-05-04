package ru.bakhuss.fisher.report.model.excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.bakhuss.fisher.cdek.model.CDEKRegion;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class RegionExcelModel {

    public Workbook getRegions() {
        Workbook regionWB = new XSSFWorkbook();
        Sheet sheet0 = regionWB.createSheet("sheet0");
        Row rowName = sheet0.createRow(0);

        for (int i = 0; i < 6; i++) {
            sheet0.autoSizeColumn(i);
        }

        return regionWB;
    }
}
