package ru.bakhuss.fisher.cdek.report;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.bakhuss.fisher.cdek.model.CDEKCity;
import ru.bakhuss.fisher.cdek.model.CDEKRegion;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class CDEKReportExcel {
    public static byte[] getRegions(String size, String page, String countryCode) throws Exception {
        if (size == null || !parseInt(size)) size = "1";
        if (page == null || !parseInt(page)) page = "0";
        if (countryCode == null) countryCode = "";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet0 = workbook.createSheet("sheet0");
        Row rowName = sheet0.createRow(0);

        String url = "https://integration.cdek.ru/v1/location/regions/json?size=" + size
                + "&page=" + page
                + "&countryCode=" + countryCode;
        ;
        RestTemplate template = new RestTemplate();
        ResponseEntity<List<CDEKRegion>> regions = template.exchange(
                url, HttpMethod.GET, null, new ParameterizedTypeReference<List<CDEKRegion>>() {
                }
        );
//        regions.getBody().forEach(System.out::println);

        rowName.createCell(0).setCellValue("region uuid");
        rowName.createCell(1).setCellValue("region name");
        rowName.createCell(2).setCellValue("prefix");
        rowName.createCell(3).setCellValue("region code ext");
        rowName.createCell(4).setCellValue("region code");
        rowName.createCell(5).setCellValue("region fias");
        rowName.createCell(6).setCellValue("country name");
        rowName.createCell(7).setCellValue("country code");
        rowName.createCell(8).setCellValue("country code ext");


        List<CDEKRegion> body = regions.getBody();
        System.out.println("body regions size: " + body.size());
        for (int i = 0; i < regions.getBody().size(); i++) {
            Row row = sheet0.createRow(i + 1);
            row.createCell(0).setCellValue(body.get(i).getRegionUuid());
            row.createCell(1).setCellValue(body.get(i).getRegionName());
            row.createCell(2).setCellValue(body.get(i).getPrefix());
            row.createCell(3).setCellValue(body.get(i).getRegionCodeEx());
            row.createCell(4).setCellValue(body.get(i).getRegionCode());
            row.createCell(5).setCellValue(body.get(i).getRegionFiasGuid());
            row.createCell(6).setCellValue(body.get(i).getCountryName());
            row.createCell(7).setCellValue(body.get(i).getCountryCode());
            row.createCell(8).setCellValue(body.get(i).getCountryCodeExt());
        }
        for (int i = 0; i < 9; i++) {
            sheet0.autoSizeColumn(i);
        }

        workbook.write(baos);
        workbook.close();
        return baos.toByteArray();
    }

    public static byte[] getCities(String size, String page, String countryCode) throws Exception {
        if (size == null || !parseInt(size)) size = "1";
        if (page == null || !parseInt(page)) page = "0";
        if (countryCode == null) countryCode = "";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet0 = workbook.createSheet("sheet0");
        Row rowName = sheet0.createRow(0);

        String url = "http://integration.cdek.ru/v1/location/cities/json?size=" + size
                + "&page=" + page
                + "&countryCode=" + countryCode;
        RestTemplate templ = new RestTemplate();
        ResponseEntity<List<CDEKCity>> cities = templ.exchange(
                url, HttpMethod.GET, null, new ParameterizedTypeReference<List<CDEKCity>>() {
                }
        );
//        cities.getBody().forEach(System.out::println);

        rowName.createCell(0).setCellValue("city uuid");
        rowName.createCell(1).setCellValue("city name");
        rowName.createCell(2).setCellValue("city code");
        rowName.createCell(3).setCellValue("region");
        rowName.createCell(4).setCellValue("region code ext");
        rowName.createCell(5).setCellValue("region code");
        rowName.createCell(6).setCellValue("sub region");
        rowName.createCell(7).setCellValue("country");
        rowName.createCell(8).setCellValue("country code");
        rowName.createCell(9).setCellValue("latitude");
        rowName.createCell(10).setCellValue("longitude");
        rowName.createCell(11).setCellValue("kladr");
        rowName.createCell(12).setCellValue("fias guid");
        rowName.createCell(13).setCellValue("region fias guid");
        rowName.createCell(14).setCellValue("payment limit");


        List<CDEKCity> body = cities.getBody();
        System.out.println("body cities size: " + body.size());
        for (int i = 0; i < cities.getBody().size(); i++) {
            Row row = sheet0.createRow(i + 1);
            row.createCell(0).setCellValue(body.get(i).getCityUuid());
            row.createCell(1).setCellValue(body.get(i).getCityName());
            row.createCell(2).setCellValue(body.get(i).getCityCode());
            row.createCell(3).setCellValue(body.get(i).getRegion());
            row.createCell(4).setCellValue(body.get(i).getRegionCodeExt());
            row.createCell(5).setCellValue(body.get(i).getRegionCode());
            row.createCell(6).setCellValue(body.get(i).getSubRegion());
            row.createCell(7).setCellValue(body.get(i).getCountry());
            row.createCell(8).setCellValue(body.get(i).getCountryCode());
            row.createCell(9).setCellValue(body.get(i).getLatitude());
            row.createCell(10).setCellValue(body.get(i).getLongitude());
            row.createCell(11).setCellValue(body.get(i).getKladr());
            row.createCell(12).setCellValue(body.get(i).getFiasGuid());
            row.createCell(13).setCellValue(body.get(i).getRegionFiasGuid());
            row.createCell(14).setCellValue(body.get(i).getPaymentLimit());
        }
        for (int i = 0; i < 9; i++) {
            sheet0.autoSizeColumn(i);
        }

        workbook.write(baos);
        workbook.close();
        return baos.toByteArray();
    }

    private static boolean parseInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
