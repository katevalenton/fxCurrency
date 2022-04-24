package com.practicalTest.fx.ws.Controller;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("fxCurrency")
public class FxCurrencyController {
	
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(FxCurrencyController.class);
	
	final String accessKey = "f5f7c9a5c623918ce57961dbcc85b0d7";
	
	@GetMapping
	// Get List of Currency Symbols and Description
	public String getCurrencyList() {
		String url = "http://api.exchangeratesapi.io/v1/symbols?access_key=" + accessKey;
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(url, String.class);
		return response;
	}
	
	// Endpoint for the api.exchangeratesapi.io, this needs an Upgrade of Plan to avail of the Convert Endpoint
//	@PostMapping
//	public String convertAmount(@RequestParam(required = true) String from,
//		    @RequestParam(required = true) String to,
//		    @RequestParam(required = true) String amount,
//		    @RequestParam(required = false) String date) {
//		String url = "http://api.exchangeratesapi.io/v1/convert?access_key=" + accessKey + "&from=" + from + "&to=" + to + "&amount=" + amount;
//		LOGGER.debug("URL  = " + url);
//		if(Optional.ofNullable(date).isEmpty() || date.isBlank()) {
//			LOGGER.debug("Empty ung DATE");
//		}else {
//			url = url + "&date=" + date;
//			LOGGER.debug("NOT empty ung DATE");;
//		}
//		RestTemplate restTemplate = new RestTemplate();
//		String response = restTemplate.getForObject(url, String.class);
//		
//		return response;
//	}
	
	// Endpoint for the api.exchangerate.host, free conversion of currency. No API Key needed as of April 2022 
	@PostMapping
	@RequestMapping("/convert")
	public String convertAmount(@RequestParam(required = true) String from,
		    @RequestParam(required = true) String to,
		    @RequestParam(required = true) String amount) {
		String url = "https://api.exchangerate.host/convert?from=" + from + "&to=" + to + "&amount=" + amount;
		
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(url, String.class);

		return response;
	}
	
}
