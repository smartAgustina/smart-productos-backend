package  com.smart.smartproductospet.utils;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
public class Propiedades {

		private static final String BUNDLE_NAME = "environment";
		private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

		public static final String TIEMPO_EXPIRACION_MILISEGUNDOS_KEY = "tiempoDeExpiracionEnMilisegundos";
		public static final String BUNDLE_BASE_NAME_KEY = "bundleBaseName";

		protected Propiedades() {
		}

		protected static String getString(String key) {
			try {
				return RESOURCE_BUNDLE.getString(key);
			} catch (MissingResourceException e) {
				return '!' + key + '!';
			}
		}

		protected static Integer getInteger(String key) {
			try {
				String numero = RESOURCE_BUNDLE.getString(key);
				return new Integer(numero);
			} catch (MissingResourceException e) {
				return -1;
			}
		}

		protected static boolean getBoolean(String key) {
			try {
				String value = RESOURCE_BUNDLE.getString(key);
				boolean respuesta = value.toLowerCase().equals("true");
				return respuesta;
			} catch (MissingResourceException e) {
				return false;
			}
		}

		private static Integer TIEMPO_EXPIRACION_MILISEGUNDOS;
		private static String BUNDLE_BASE_NAME;

		public static Integer getTIEMPO_EXPIRACION_MILISEGUNDOS() {
			if (TIEMPO_EXPIRACION_MILISEGUNDOS == null) {
				TIEMPO_EXPIRACION_MILISEGUNDOS = getInteger(TIEMPO_EXPIRACION_MILISEGUNDOS_KEY);
			}
			return TIEMPO_EXPIRACION_MILISEGUNDOS;
		}

		public static String getBUNDLE_BASE_NAME() {
			if (BUNDLE_BASE_NAME == null) {
				BUNDLE_BASE_NAME = getString(BUNDLE_BASE_NAME_KEY);
			}
			return BUNDLE_BASE_NAME;		}

}
