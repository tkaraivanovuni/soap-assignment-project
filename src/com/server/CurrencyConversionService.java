package com.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CurrencyConversionService {
	
	private final String apiKey = "e4fb81d394d9982107ea";
	
	public String viewExchangeRate(CurrenciesHolder ... requestedCurrencies) throws IOException {
		StringBuilder urlBuilder = new StringBuilder("https://free.currconv.com/api/v7/convert?q=");
		for (CurrenciesHolder requestedConversionRate : requestedCurrencies) {
			urlBuilder.append(requestedConversionRate.getCurrencyToConvert());
			urlBuilder.append("_");
			urlBuilder.append(requestedConversionRate.getCurrencyToConvertTo());
			urlBuilder.append(",");
		}
		urlBuilder.deleteCharAt(urlBuilder.length() - 1);
		urlBuilder.append("&compact=ultra&apiKey=");
		urlBuilder.append(apiKey);
		
		URL url = new URL(urlBuilder.toString());
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("accept", "application/json");
		InputStream responseStream = connection.getInputStream();
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> jsonMap = mapper.readValue(responseStream, Map.class);
		String result = jsonMap.toString();
		return result.substring(1, (result.length()-1));
	}
	
	public String viewExchangeRateOnDate(CurrenciesHolder requestedCurrencies, LocalDate date) throws IOException {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String dateString = simpleDateFormat.format(date);
		StringBuilder urlBuilder = new StringBuilder("https://free.currconv.com/api/v7/convert?q=");
		urlBuilder.append(requestedCurrencies.getCurrencyToConvert());
		urlBuilder.append("_");
		urlBuilder.append(requestedCurrencies.getCurrencyToConvertTo());
		urlBuilder.append("&compact=ultra&date=");
		urlBuilder.append(dateString);
		urlBuilder.append("&apiKey=");
		urlBuilder.append(apiKey);
		
		URL url = new URL(urlBuilder.toString());
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("accept", "application/json");
		
		InputStream responseStream = connection.getInputStream();
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> jsonMap = mapper.readValue(responseStream, Map.class);
		String response = jsonMap.toString().substring(1, 31);
		return response;
	}
	
	public String calculateExchangedAmount(CurrenciesHolder requestedCurrencies, double amount) throws IOException {
		StringBuilder urlBuilder = new StringBuilder("https://free.currconv.com/api/v7/convert?q=");
		urlBuilder.append(requestedCurrencies.getCurrencyToConvert());
		urlBuilder.append("_");
		urlBuilder.append(requestedCurrencies.getCurrencyToConvertTo());
		urlBuilder.append("&compact=ultra&apiKey=");
		urlBuilder.append(apiKey);
		
		URL url = new URL(urlBuilder.toString());
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("accept", "application/json");
		InputStream responseStream = connection.getInputStream();
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> jsonMap = mapper.readValue(responseStream, Map.class);
		String response = jsonMap.toString();
		double rate = Double.parseDouble(response.substring(9, response.length()-1));
		return ("" + amount + requestedCurrencies.getCurrencyToConvert() + " equals " + amount * rate + requestedCurrencies.getCurrencyToConvertTo());
	}

}
