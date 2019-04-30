package ru.bakhuss.fisher;

import java.util.List;

import org.springframework.web.client.RestTemplate;
import ru.bakhuss.fisher.cdek.model.CDEKRegion;
import ru.bakhuss.fisher.cdek.model.CDEKCity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.*;
import org.springframework.core.ParameterizedTypeReference;

public class Application {
	public static void main(String[] args) {
		String url = "https://integration.cdek.ru/v1/location/regions/json?size=5&page=25";
		RestTemplate template = new RestTemplate();
		ResponseEntity<List<CDEKRegion>> regions = template.exchange(
			url, HttpMethod.GET, null, new ParameterizedTypeReference<List<CDEKRegion>>(){}
		);
		regions.getBody().forEach(System.out::println);

		url = "http://integration.cdek.ru/v1/location/cities/json?size=5&page=0&regionCode=23";
		RestTemplate templ = new RestTemplate();
		ResponseEntity<List<CDEKCity>> cities = templ.exchange(
			url, HttpMethod.GET, null, new ParameterizedTypeReference<List<CDEKCity>>(){}
		);
		cities.getBody().forEach(System.out::println);
	}
}
