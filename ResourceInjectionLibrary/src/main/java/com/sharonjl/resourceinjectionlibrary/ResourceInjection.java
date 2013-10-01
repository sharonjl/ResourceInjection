package com.sharonjl.resourceinjectionlibrary;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by sharon on 2013-10-01.
 */
public class ResourceInjection {
    public static <T> void inject(T object, Context context, View view) {
        Class c = object.getClass();
        Annotation[] annotations = c.getAnnotations();
        Field[] fields = c.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FromResource.class)) {
                TypedValue v = new TypedValue();
                Class clazz = field.getType();
                FromResource fromResource = field.getAnnotation(FromResource.class);

                context.getResources().getValue(fromResource.value(), v, false);

                try {
                    field.setAccessible(true);
                    Object fieldObject = field.get(object);
                    field.set(object, clazz.cast(v));
                } catch (Exception e) {

                }
            }
        }
    }
}
