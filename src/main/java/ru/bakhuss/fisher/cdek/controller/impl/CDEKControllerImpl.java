package ru.bakhuss.fisher.cdek.controller.impl;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.bakhuss.fisher.cdek.controller.CDEKController;
import ru.bakhuss.fisher.report.ReportExcel;

import java.util.Date;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/", produces = APPLICATION_JSON_VALUE)
public class CDEKControllerImpl implements CDEKController {

    @Override
    @GetMapping(value = "/regions")
    public ResponseEntity<byte[]> getRegions(@RequestParam(required = false) String size,
                                             @RequestParam(required = false) String page,
                                             @RequestParam(required = false) String countryCode) {
        byte[] bytes;
        try {
            bytes = ReportExcel.getRegions(size, page, countryCode);
            HttpHeaders headers = new HttpHeaders();
            String fileName = "attachment; filename=regions_" + new Date().toString() + ".xlsx";
            headers.set("Content-Disposition", fileName);
            headers.add("Content-Type",
                    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @GetMapping("/cities")
    public ResponseEntity<byte[]> getCities(@RequestParam(required = false) String size,
                                            @RequestParam(required = false) String page,
                                            @RequestParam(required = false) String countryCode) {
        byte[] bytes;
        try {
//            bytes = ReportExcel.getCities(size, page, countryCode);
            bytes = ReportExcel.method(size, page, countryCode);
            HttpHeaders headers = new HttpHeaders();
            String fileName = "attachment; filename=cities_" + new Date().toString() + ".xlsx";
            headers.set("Content-Disposition", fileName);
            headers.add("Content-Type",
                    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/string")
    public String getString() {
        return "string";
    }
}
