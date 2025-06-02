package com.fasterxml.jackson.databind.introspect;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.lang.reflect.Method;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.PropertyName;

public class introspect_JacksonAnnotationIntrospector__propertyName_String_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void test_propertyName_withEmptyLocalName() throws Exception {
        // Given
        JacksonAnnotationIntrospector introspector = new JacksonAnnotationIntrospector();
        String localName = "";
        String namespace = "namespace";

        // When
        Method method = JacksonAnnotationIntrospector.class.getDeclaredMethod("_propertyName", String.class, String.class);
        method.setAccessible(true);
        PropertyName result = (PropertyName) method.invoke(introspector, localName, namespace);

        // Then
        assertEquals(PropertyName.USE_DEFAULT, result);
    }
    
    @Test(timeout = 4000)
    public void test_propertyName_withNullNamespace() throws Exception {
        // Given
        JacksonAnnotationIntrospector introspector = new JacksonAnnotationIntrospector();
        String localName = "localName";
        String namespace = null;

        // When
        Method method = JacksonAnnotationIntrospector.class.getDeclaredMethod("_propertyName", String.class, String.class);
        method.setAccessible(true);
        PropertyName result = (PropertyName) method.invoke(introspector, localName, namespace);

        // Then
        assertEquals(PropertyName.construct(localName), result);
    }

    @Test(timeout = 4000)
    public void test_propertyName_withNonEmptyLocalNameAndNamespace() throws Exception {
        // Given
        JacksonAnnotationIntrospector introspector = new JacksonAnnotationIntrospector();
        String localName = "localName";
        String namespace = "namespace";

        // When
        Method method = JacksonAnnotationIntrospector.class.getDeclaredMethod("_propertyName", String.class, String.class);
        method.setAccessible(true);
        PropertyName result = (PropertyName) method.invoke(introspector, localName, namespace);

        // Then
        assertEquals(PropertyName.construct(localName, namespace), result);
    }

}