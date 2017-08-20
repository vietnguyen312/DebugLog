package co.vietnguyen.debuglog;

import android.util.Log;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;



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
        String strObject = getObjectString(object);
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



    private static String getObjectString(Object object) {
        String strObject = "";
        if (object == null) {
            strObject = "NULL";
        } else if (isPrimitiveType(object.getClass())) {
            strObject = String.valueOf(object);
        } else if (isIterator(object.getClass())) {
            Iterable iterable = (Iterable) object;
            int index = 0;
            for (Object iterableObject : iterable) {
                strObject += "[" + String.valueOf(index) + "]: "
                        + getObjectString(iterableObject) + "\n";
                index++;
            }
        } else if(isMap(object.getClass())) {
            Map<?,?> map = (Map<?, ?>) object;
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                strObject += "[" + String.valueOf(entry.getKey()) + "]: "
                        + getObjectString(entry.getValue()) + "\n";
            }
        } else {
            strObject = ReflectionToStringBuilder.toString(
                    object, new CustomMultilineRecursiveToStringStyle());
        }
        return strObject;
    }



    private static boolean isIterator(Class<?> clazz) {
        return Collection.class.isAssignableFrom(clazz);
    }



    private static boolean isMap(Class<?> clazz) {
        return Map.class.isAssignableFrom(clazz);
    }



    private static boolean isPrimitiveType(Class<?> clazz) {
        return clazz.equals(Boolean.class) ||
                clazz.equals(Integer.class) ||
                clazz.equals(Character.class) ||
                clazz.equals(String.class) ||
                clazz.equals(Byte.class) ||
                clazz.equals(Short.class) ||
                clazz.equals(Double.class) ||
                clazz.equals(Long.class) ||
                clazz.equals(Float.class);
    }
}