package app.ucsal.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class ParseUtil {

	public static String dateToString(Date data, String padrao) {

		String dataStr = null;

		if (data != null) {

			SimpleDateFormat dtFormat = new SimpleDateFormat(padrao);

			dataStr = dtFormat.format(data);
		} else {

			dataStr = "";
		}

		return dataStr;
	}

	public static List<Integer> stringToArray(String arrayString) {

		String[] stringsSeparadas = arrayString.replaceAll("\\[", "").replaceAll("]", "").split(",");

		List<Integer> intArray = new ArrayList<Integer>();

		for (String str : stringsSeparadas) {

			intArray.add(Integer.parseInt(str));
		}
		return intArray;
	}
}
