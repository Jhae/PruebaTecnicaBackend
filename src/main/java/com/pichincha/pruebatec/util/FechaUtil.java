package com.pichincha.pruebatec.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FechaUtil {
	
	private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public static String formatddMMyyyyHHmmss(Date fecha) {
		return format.format(fecha);
	}
}
