package ru.bakhuss.fisher;

import java.util.List;

import org.springframework.web.client.RestTemplate;
import ru.bakhuss.fisher.cdek.model.CDEKRegion;
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
	}
}
