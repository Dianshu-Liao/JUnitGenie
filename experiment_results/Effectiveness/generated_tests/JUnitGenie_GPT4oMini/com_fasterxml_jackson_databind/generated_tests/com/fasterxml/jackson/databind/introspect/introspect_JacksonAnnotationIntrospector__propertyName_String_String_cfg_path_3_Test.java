package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.PropertyName;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class introspect_JacksonAnnotationIntrospector__propertyName_String_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void test_propertyName_withNonEmptyLocalNameAndNullNamespace() {
        JacksonAnnotationIntrospector introspector = new JacksonAnnotationIntrospector();
        String localName = "testLocalName";
        String namespace = null;

        try {
            PropertyName result = (PropertyName) introspector.getClass().getDeclaredMethod("_propertyName", String.class, String.class)
                    .invoke(introspector, localName, namespace);
            assertEquals(PropertyName.construct(localName), result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void test_propertyName_withNonEmptyLocalNameAndEmptyNamespace() {
        JacksonAnnotationIntrospector introspector = new JacksonAnnotationIntrospector();
        String localName = "testLocalName";
        String namespace = "";

        try {
            PropertyName result = (PropertyName) introspector.getClass().getDeclaredMethod("_propertyName", String.class, String.class)
                    .invoke(introspector, localName, namespace);
            assertEquals(PropertyName.construct(localName), result);
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
            PropertyName result = (PropertyName) introspector.getClass().getDeclaredMethod("_propertyName", String.class, String.class)
                    .invoke(introspector, localName, namespace);
            assertEquals(PropertyName.USE_DEFAULT, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}