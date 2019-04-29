package ru.bakhuss.fisher.cdek.model;

import lombok.Data;

@Data
public class CDEKRegion {
	private String regionUuid;
	private String regionName;
	private String prefix;
	private String regionCodeEx;
	private String regionCode;
	private String regionFiasGuid;
	private String countryName;
	private String countryCode;
	private String countryCodeExt;
}
