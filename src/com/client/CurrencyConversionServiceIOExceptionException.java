
/**
 * CurrencyConversionServiceIOExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.4  Built on : Dec 28, 2015 (10:03:39 GMT)
 */

package com.client;

public class CurrencyConversionServiceIOExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1614290365508L;
    
    private com.client.CurrencyConversionServiceStub.CurrencyConversionServiceIOException faultMessage;

    
        public CurrencyConversionServiceIOExceptionException() {
            super("CurrencyConversionServiceIOExceptionException");
        }

        public CurrencyConversionServiceIOExceptionException(java.lang.String s) {
           super(s);
        }

        public CurrencyConversionServiceIOExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public CurrencyConversionServiceIOExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.client.CurrencyConversionServiceStub.CurrencyConversionServiceIOException msg){
       faultMessage = msg;
    }
    
    public com.client.CurrencyConversionServiceStub.CurrencyConversionServiceIOException getFaultMessage(){
       return faultMessage;
    }
}
    