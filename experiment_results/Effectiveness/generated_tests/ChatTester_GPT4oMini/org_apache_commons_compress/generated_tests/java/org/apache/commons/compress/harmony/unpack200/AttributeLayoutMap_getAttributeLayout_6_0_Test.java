package org.apache.commons.compress.harmony.unpack200;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AttributeLayoutMap_getAttributeLayout_6_0_Test {

    private AttributeLayoutMap attributeLayoutMap;

    private Map<Integer, AttributeLayout> mockLayoutMap;

    @BeforeEach
    void setUp() throws Pack200Exception {
        attributeLayoutMap = new AttributeLayoutMap();
        mockLayoutMap = new HashMap<>();
        mockLayoutMap.put(1, new AttributeLayout("layout1", AttributeLayout.CONTEXT_METHOD, "", 0));
        mockLayoutMap.put(2, new AttributeLayout("layout2", AttributeLayout.CONTEXT_METHOD, "", 0));
    }

    @Test
    void testGetAttributeLayoutReturnsCorrectLayout() throws Exception {
        // Reflection to set the private field
        setPrivateField(attributeLayoutMap, "methodLayouts", mockLayoutMap);
        AttributeLayout result = attributeLayoutMap.getAttributeLayout("layout1", AttributeLayout.CONTEXT_METHOD);
        assertNotNull(result);
        assertEquals("layout1", result.getName());
    }

    @Test
    void testGetAttributeLayoutReturnsNullForNonExistingLayout() throws Exception {
        // Reflection to set the private field
        setPrivateField(attributeLayoutMap, "methodLayouts", mockLayoutMap);
        AttributeLayout result = attributeLayoutMap.getAttributeLayout("nonExistingLayout", AttributeLayout.CONTEXT_METHOD);
        assertNull(result);
    }

    @Test
    void testGetAttributeLayoutHandlesEmptyLayout() throws Exception {
        // Reflection to set the private field with an empty map
        setPrivateField(attributeLayoutMap, "methodLayouts", new HashMap<>());
        AttributeLayout result = attributeLayoutMap.getAttributeLayout("layout1", AttributeLayout.CONTEXT_METHOD);
        assertNull(result);
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        // Fixed the buggy line by replacing 'var' with 'Field'
        java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}
