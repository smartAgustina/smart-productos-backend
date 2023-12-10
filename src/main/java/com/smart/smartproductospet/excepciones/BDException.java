package com.smart.smartproductospet.excepciones;

public class BDException extends Exception{

	private static final long serialVersionUID = 1483523883224968060L;

	public BDException() {
	}

	public BDException(String arg0) {
		super(arg0);
	}

	public BDException(Throwable arg0) {
		super(arg0);
	}

	public BDException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
}
