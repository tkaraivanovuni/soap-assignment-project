package com.client;

import java.rmi.RemoteException;

import com.client.CurrencyConversionServiceStub.CurrenciesHolder;
import com.client.CurrencyConversionServiceStub.ViewExchangeRate;
import com.client.CurrencyConversionServiceStub.ViewExchangeRateResponse;

public class CurrencyConversionClient {

	public static void main(String[] args) throws RemoteException, CurrencyConversionServiceIOExceptionException {
		
		CurrencyConversionServiceStub stub = new CurrencyConversionServiceStub();
		
		CurrenciesHolder currenciesHolder = new CurrenciesHolder();
		currenciesHolder.setCurrencyToConvert("USD");
		currenciesHolder.setCurrencyToConvertTo("BGN");
		
		CurrenciesHolder[] currencies = new CurrenciesHolder[] {currenciesHolder};
		
		ViewExchangeRate request = new ViewExchangeRate();
		request.setRequestedCurrencies(currencies);
		
		ViewExchangeRateResponse response = stub.viewExchangeRate(request);
		
		System.out.println(response);

	}

}
