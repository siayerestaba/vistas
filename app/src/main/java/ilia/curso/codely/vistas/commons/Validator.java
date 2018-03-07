package ilia.curso.codely.vistas.commons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	private static final String EMAIL_PATTERN = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
			+ "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

	public static boolean isEmailValid(String email) {
		return isValid(EMAIL_PATTERN, email);
	}

	private static boolean isValid(String patt, String toValid) {
		Pattern pattern = Pattern.compile(patt, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(toValid);

		return matcher.matches();
	}
}
