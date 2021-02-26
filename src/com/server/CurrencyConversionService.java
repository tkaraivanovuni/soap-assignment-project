package com.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

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
		Scanner scanner = new Scanner(responseStream);
		String result = scanner.hasNext()? scanner.next() : "";
		scanner.close();
		return result;
	}
	
	public String viewExchangeRateOnDate(CurrenciesHolder requestedCurrencies, DateHolder date) throws IOException {
		StringBuilder dateBuilder = new StringBuilder();
		dateBuilder.append(date.getYear());
		dateBuilder.append("-");
		dateBuilder.append(date.getMonth());
		dateBuilder.append("-");
		dateBuilder.append(date.getDay());
		
		StringBuilder urlBuilder = new StringBuilder("https://free.currconv.com/api/v7/convert?q=");
		urlBuilder.append(requestedCurrencies.getCurrencyToConvert());
		urlBuilder.append("_");
		urlBuilder.append(requestedCurrencies.getCurrencyToConvertTo());
		urlBuilder.append("&compact=ultra&date=");
		urlBuilder.append(dateBuilder);
		urlBuilder.append("&apiKey=");
		urlBuilder.append(apiKey);
		
		URL url = new URL(urlBuilder.toString());
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("accept", "application/json");
		
		InputStream responseStream = connection.getInputStream();
		Scanner scanner = new Scanner(responseStream);
		String result = scanner.hasNext()? scanner.next() : "";
		scanner.close();
		return result;
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
		Scanner scanner = new Scanner(responseStream);
		String result = scanner.hasNext()? scanner.next() : "";
		double rate = Double.parseDouble(result.substring(11, 19));
		scanner.close();
		return ("" + amount + requestedCurrencies.getCurrencyToConvert() + " equals " + amount * rate + requestedCurrencies.getCurrencyToConvertTo());
	}

}
