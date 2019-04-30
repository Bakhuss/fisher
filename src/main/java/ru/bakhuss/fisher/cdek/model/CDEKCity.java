package ru.bakhuss.fisher.cdek.model;

import lombok.Data;

@Data
public class CDEKCity {
	private String cityUuid;
	private String cityName;
	private String cityCode;
	private String region;
	private String regionCodeExt;
	private String regionCode;
	private String subRegion;
	private String country;
	private String countryCode;
	private String latitude;
	private String longitude;
	private String kladr;
	private String fiasGuid;
	private String regionFiasGuid;
	private String paymentLimit;
}
