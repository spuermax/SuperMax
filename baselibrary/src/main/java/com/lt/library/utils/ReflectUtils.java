package com.lt.library.utils;

import android.support.annotation.NonNull;
import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * 作者：lantian
 * 创建时间：2018/11/14/
 * 10:50
 */
public class ReflectUtils {
    private static final String TAG = "ReflectUtils";
    public static <T> T createFromParameter(int index, Class clazz) {
        Type type = getClassFromType(index, clazz);
        if (type == null)
            return null;
        try {
            return ((Class<T>) type).newInstance();
        } catch (IllegalAccessException  e) {
            Log.e(TAG, "createFromParameter: ",e );
            e.printStackTrace();
        } catch (InstantiationException e) {
            Log.e(TAG, "createFromParameter: ",e );
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static Type getClassFromType(int index, Class clazz) {
        Type parameterType;
        if (clazz.isInterface())
            parameterType = clazz.getGenericInterfaces()[0];
        else
            parameterType = clazz.getGenericSuperclass();
        if (!(parameterType instanceof ParameterizedType))
            return null;
        return ((ParameterizedType) parameterType).getActualTypeArguments()[index];
    }

    public static Method getMethod(String methodName, Class<?> fromClazz, Class<?>[] parametersClass) {
        try {
            Method method = fromClazz.getMethod(methodName, parametersClass);
            if (method == null)
                method = fromClazz.getDeclaredMethod(methodName, parametersClass);
            if (method != null)
                method.setAccessible(true);
            return method;
        } catch (NoSuchMethodException e) {
            Log.e(TAG, "getMethod: ", e);
            e.printStackTrace();
        }
        return null;
    }

    public static Field getFieldByName(String fieldName, Class<?> fromClazz) {
        try {
            Field field = fromClazz.getField(fieldName);
            if (field == null)
                field = fromClazz.getDeclaredField(fieldName);
            if (field != null)
                field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "getFieldByName: ", e);
            e.printStackTrace();
        }
        return null;
    }

    public static Field[] getFieldsByType(Class<?> fieldType, Class<?> fromClazz) {
        Field[] fields = fromClazz.getFields();
        Field[] declaredFields = fromClazz.getDeclaredFields();
        ArrayList<Field> fieldList = new ArrayList<>();
        if (fields != null && fields.length > 0)
            for (Field field : fields) {
                if (field.getType().equals(fieldType)) {
                    field.setAccessible(true);
                    fieldList.add(field);
                }
            }
        if (declaredFields != null && declaredFields.length > 0)
            for (Field declaredField : declaredFields) {
                if (declaredField.getType().equals(fieldType)) {
                    declaredField.setAccessible(true);
                    fieldList.add(declaredField);
                }
            }
        if (fieldList.size() > 0)
            return (Field[]) fieldList.toArray();
        else
            return null;
    }

    public static <T> T getValueFromField(@NonNull Object fromObj, String fieldName, Class<T> valueType) {
        Field fieldByName = getFieldByName(fieldName, fromObj.getClass());
        try {
            Object o = fieldByName.get(fromObj);
            return valueType.cast(o);
        } catch (IllegalAccessException e) {
            Log.e(TAG, "getValueFromField: ", e);
            e.printStackTrace();
        }

        return null;
    }

    public static <T> T getValueFromField(@NonNull Class<?> fromClazz, String fieldName, Class<T> valueType) {
        Field fieldByName = getFieldByName(fieldName, fromClazz);
        try {
            return valueType.cast(fieldByName.get(null));
        } catch (IllegalAccessException e) {
            Log.e(TAG, "getValueFromField: ", e);
            e.printStackTrace();
        }
        return null;
    }
    public static void setValueForField(Object obj,Field... field){
        if (field == null || field.length == 0)
            return;
        for (Field f : field) {
            f.setAccessible(true);
            try {
                f.set(f,obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }
    public static <T> T newInstance(Class<T> tClass, Object o ,Class<?>[] parametersType) {
        T t = null;
        try {
            if (o == null)
            t = tClass.newInstance();
        } catch (IllegalAccessException e) {
            Log.e(TAG, "newInstance: ", e);
        } catch (InstantiationException e) {
            Log.e(TAG, "newInstance: ", e);
        }
        if (t != null)
            return t;
        try {
            Constructor<T> declaredConstructor = parametersType == null ? tClass.getDeclaredConstructor() : tClass.getDeclaredConstructor(parametersType);
            if (declaredConstructor == null)
                declaredConstructor = parametersType == null ? tClass.getConstructor() : tClass.getConstructor(parametersType);
            if (declaredConstructor == null)
                return null;
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(o);
        } catch (NoSuchMethodException e) {
            Log.e(TAG, "newInstance: ", e);
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            Log.e(TAG, "newInstance: ", e);
            e.printStackTrace();
        } catch (InstantiationException e) {
            Log.e(TAG, "newInstance: ", e);
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            Log.e(TAG, "newInstance: ", e);
            e.printStackTrace();
        }

        return null;
    }
    public static final <T> T cast(Object o,Class<T> tClass){
        return tClass.cast(o);
    }
}
