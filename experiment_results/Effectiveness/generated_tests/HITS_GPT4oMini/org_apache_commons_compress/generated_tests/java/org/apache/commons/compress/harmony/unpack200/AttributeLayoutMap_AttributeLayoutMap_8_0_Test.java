package org.apache.commons.compress.harmony.unpack200;

import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AttributeLayoutMap_AttributeLayoutMap_8_0_Test {

    private AttributeLayoutMap attributeLayoutMap;

    @BeforeEach
    public void setUp() throws Pack200Exception {
        attributeLayoutMap = new AttributeLayoutMap();
    }

    @Test
    public void testClassLayoutsInitialization() {
        Map<Integer, AttributeLayout> classLayouts = getPrivateField(attributeLayoutMap, "classLayouts");
        assertNotNull(classLayouts, "classLayouts should not be null");
        assertTrue(classLayouts.isEmpty(), "classLayouts should be initialized as an empty HashMap");
    }

    @Test
    public void testFieldLayoutsInitialization() {
        Map<Integer, AttributeLayout> fieldLayouts = getPrivateField(attributeLayoutMap, "fieldLayouts");
        assertNotNull(fieldLayouts, "fieldLayouts should not be null");
        assertTrue(fieldLayouts.isEmpty(), "fieldLayouts should be initialized as an empty HashMap");
    }

    @Test
    public void testMethodLayoutsInitialization() {
        Map<Integer, AttributeLayout> methodLayouts = getPrivateField(attributeLayoutMap, "methodLayouts");
        assertNotNull(methodLayouts, "methodLayouts should not be null");
        assertTrue(methodLayouts.isEmpty(), "methodLayouts should be initialized as an empty HashMap");
    }

    @Test
    public void testCodeLayoutsInitialization() {
        Map<Integer, AttributeLayout> codeLayouts = getPrivateField(attributeLayoutMap, "codeLayouts");
        assertNotNull(codeLayouts, "codeLayouts should not be null");
        assertTrue(codeLayouts.isEmpty(), "codeLayouts should be initialized as an empty HashMap");
    }

    @SuppressWarnings("unchecked")
    private <T> T getPrivateField(AttributeLayoutMap instance, String fieldName) {
        try {
            java.lang.reflect.Field field = AttributeLayoutMap.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return (T) field.get(instance);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Failed to access private field: " + fieldName, e);
        }
    }
}
