package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class introspect_JacksonAnnotationIntrospector__propertyName_String_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void test_propertyName_withNonEmptyLocalNameAndNullNamespace() {
        try {
            // Instantiate the class under test
            JacksonAnnotationIntrospector introspector = new JacksonAnnotationIntrospector();

            // Use reflection to access the protected method
            Method method = JacksonAnnotationIntrospector.class.getDeclaredMethod("_propertyName", String.class, String.class);
            method.setAccessible(true);

            // Define test parameters
            String localName = "testLocalName";
            String namespace = null;

            // Invoke the method
            PropertyName result = (PropertyName) method.invoke(introspector, localName, namespace);

            // Assert the expected result
            PropertyName expected = PropertyName.construct(localName);
            assertEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void test_propertyName_withNonEmptyLocalNameAndEmptyNamespace() {
        try {
            // Instantiate the class under test
            JacksonAnnotationIntrospector introspector = new JacksonAnnotationIntrospector();

            // Use reflection to access the protected method
            Method method = JacksonAnnotationIntrospector.class.getDeclaredMethod("_propertyName", String.class, String.class);
            method.setAccessible(true);

            // Define test parameters
            String localName = "testLocalName";
            String namespace = "";

            // Invoke the method
            PropertyName result = (PropertyName) method.invoke(introspector, localName, namespace);

            // Assert the expected result
            PropertyName expected = PropertyName.construct(localName);
            assertEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void test_propertyName_withEmptyLocalName() {
        try {
            // Instantiate the class under test
            JacksonAnnotationIntrospector introspector = new JacksonAnnotationIntrospector();

            // Use reflection to access the protected method
            Method method = JacksonAnnotationIntrospector.class.getDeclaredMethod("_propertyName", String.class, String.class);
            method.setAccessible(true);

            // Define test parameters
            String localName = "";
            String namespace = "testNamespace";

            // Invoke the method
            PropertyName result = (PropertyName) method.invoke(introspector, localName, namespace);

            // Assert the expected result
            PropertyName expected = PropertyName.USE_DEFAULT;
            assertEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}