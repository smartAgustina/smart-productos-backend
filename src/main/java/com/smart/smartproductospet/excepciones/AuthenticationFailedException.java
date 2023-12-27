package com.smart.smartproductospet.excepciones;

    public class AuthenticationFailedException extends RuntimeException {

        public AuthenticationFailedException(String message) {
            super(message);
        }
    }
