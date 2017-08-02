package co.vietnguyen.debuglog;

import java.util.regex.Pattern;
import android.util.Log;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;



public class Debug {



	public static void log(String message, Object object) {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		StackTraceElement stackTraceElement = stackTraceElements[3];
		String fileName = getPart(stackTraceElement.getFileName().toString(), 0);
		String className = getPart(stackTraceElement.getClassName().toString(), -1);
		String methodName = stackTraceElement.getMethodName().toString();
		String tag = "";
		if (fileName.equals(className)) {
			tag = fileName + " - " + methodName;
		} else {
			tag = fileName + " - " + className + " - " + methodName;
		}
		String strObject = "";
		if (isPrimitiveType(object.getClass())) {
			strObject = String.valueOf(object);
		} else {
			strObject = ReflectionToStringBuilder.toString(object, ToStringStyle.MULTI_LINE_STYLE);
			String objectClassName = getPart(strObject.substring(0, strObject.indexOf("@")), -1);
			strObject = objectClassName + " " + strObject.substring(strObject.indexOf("["));
		}
		if (!message.isEmpty()) {
			Log.d(tag, message + " - " + strObject);
		} else {
			Log.d(tag, strObject);
		}
	}



	private static String getPart(String str, int part) {
		String[] split = str.split(Pattern.quote("."));
		if (part < 0) {
			return split[split.length - 1];
		} else {
			return split[part];
		}
	}



	private static boolean isPrimitiveType(Class<?> clazz) {
		return clazz.equals(Boolean.class) ||
				clazz.equals(Integer.class) ||
				clazz.equals(Character.class) ||
				clazz.equals(Byte.class) ||
				clazz.equals(Short.class) ||
				clazz.equals(Double.class) ||
				clazz.equals(Long.class) ||
				clazz.equals(Float.class);
	}
}