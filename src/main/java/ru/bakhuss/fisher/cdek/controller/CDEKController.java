package ru.bakhuss.fisher.cdek.controller;

import org.springframework.http.ResponseEntity;

public interface CDEKController {
    ResponseEntity<byte[]> getRegions(String size, String page, String countryCode);
    ResponseEntity<byte[]> getCities(String size, String page, String countryCode);
}
