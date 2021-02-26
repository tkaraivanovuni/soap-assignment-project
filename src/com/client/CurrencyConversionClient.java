package com.client;

import java.rmi.RemoteException;

import com.client.CurrencyConversionServiceStub.CurrenciesHolder;
import com.client.CurrencyConversionServiceStub.DateHolder;
import com.client.CurrencyConversionServiceStub.ViewExchangeRateOnDate;
import com.client.CurrencyConversionServiceStub.ViewExchangeRateOnDateResponse;

public class CurrencyConversionClient {

	public static void main(String[] args) throws RemoteException, CurrencyConversionServiceIOExceptionException {

		CurrencyConversionServiceStub stub = new CurrencyConversionServiceStub();
		
		CurrenciesHolder currenciesHolder = new CurrenciesHolder();
		currenciesHolder.setCurrencyToConvert("USD");
		currenciesHolder.setCurrencyToConvertTo("BGN");
		
		DateHolder dateHolder = new DateHolder();
		dateHolder.setYear(2021);
		dateHolder.setMonth(2);
		dateHolder.setDay(15);
		
		ViewExchangeRateOnDate request = new ViewExchangeRateOnDate();
		request.setRequestedCurrencies(currenciesHolder);
		request.setDate(dateHolder);
		
		ViewExchangeRateOnDateResponse response = stub.viewExchangeRateOnDate(request);
		
		System.out.println(response.get_return());
		
	}

}
