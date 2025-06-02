package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.PropertyName;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class introspect_JacksonAnnotationIntrospector__propertyName_String_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void test_propertyName_withNonEmptyLocalNameAndNullNamespace() {
        JacksonAnnotationIntrospector introspector = new JacksonAnnotationIntrospector();
        String localName = "testName";
        String namespace = null;

        try {
            Method method = JacksonAnnotationIntrospector.class.getDeclaredMethod("_propertyName", String.class, String.class);
            method.setAccessible(true);
            PropertyName result = (PropertyName) method.invoke(introspector, localName, namespace);
            PropertyName expected = PropertyName.construct(localName);
            assertEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void test_propertyName_withNonEmptyLocalNameAndEmptyNamespace() {
        JacksonAnnotationIntrospector introspector = new JacksonAnnotationIntrospector();
        String localName = "testName";
        String namespace = "";

        try {
            Method method = JacksonAnnotationIntrospector.class.getDeclaredMethod("_propertyName", String.class, String.class);
            method.setAccessible(true);
            PropertyName result = (PropertyName) method.invoke(introspector, localName, namespace);
            PropertyName expected = PropertyName.construct(localName);
            assertEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void test_propertyName_withEmptyLocalName() {
        JacksonAnnotationIntrospector introspector = new JacksonAnnotationIntrospector();
        String localName = "";
        String namespace = "testNamespace";

        try {
            Method method = JacksonAnnotationIntrospector.class.getDeclaredMethod("_propertyName", String.class, String.class);
            method.setAccessible(true);
            PropertyName result = (PropertyName) method.invoke(introspector, localName, namespace);
            PropertyName expected = PropertyName.USE_DEFAULT;
            assertEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}