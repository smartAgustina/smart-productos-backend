package com.smart.smartproductospet.excepciones;

public class ServiceException extends Exception {
	
		private static final long serialVersionUID = -1652562322862534323L;

		public ServiceException() {
		}

		public ServiceException(String message) {
			super(message);
		}

		public ServiceException(Throwable cause) {
			super(cause);
		}

		public ServiceException(String message, Throwable cause) {
			super(message, cause);
		}

}
