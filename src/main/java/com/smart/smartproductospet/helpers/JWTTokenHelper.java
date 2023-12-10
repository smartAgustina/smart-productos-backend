package com.smart.smartproductospet.helpers;

	import java.security.Key;
	import java.security.SecureRandom;
	import java.time.LocalDateTime;
	import java.util.Date;
	import java.util.ResourceBundle;
	import javax.crypto.spec.SecretKeySpec;
	import org.apache.commons.codec.binary.Base64;
	import javax.xml.bind.DatatypeConverter;
	import org.springframework.context.annotation.Scope;
	import org.springframework.transaction.annotation.Transactional;

	import io.jsonwebtoken.Jwts;
	import io.jsonwebtoken.SignatureAlgorithm;

	@Scope("singleton")
	public class JWTTokenHelper {

		public static Integer tokenExpirationMinutes = Integer
				.parseInt(ResourceBundle.getBundle("environment").getString("token.expiration.minutes"));

		@Transactional
		@SuppressWarnings("deprecation")
		public static String generarTokenSesion(String idUsuario) {
	        Date fechaActual = new Date();

	        return Jwts.builder()
	                .setSubject(idUsuario)
	                .setIssuer("SmartPet")
	                .setIssuedAt(fechaActual)
	                .setExpiration(java.sql.Timestamp.valueOf(LocalDateTime.now().plusMinutes(tokenExpirationMinutes)))
	                .signWith(SignatureAlgorithm.HS256, getKey())
	                .compact();
	    }

		public static Key getKey() {
			byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(generarClaveAleatoria(20));
			Key key = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());
			return key;
		}
		
		public static String generarClaveAleatoria(int longitud) {
	        byte[] randomBytes = new byte[longitud];
	        new SecureRandom().nextBytes(randomBytes);
	        return Base64.encodeBase64String(randomBytes);
	    }

}
