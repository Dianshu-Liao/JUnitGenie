package org.apache.commons.compress.harmony.unpack200;

import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.unpack200.AttributeLayout;
import org.apache.commons.compress.harmony.unpack200.AttributeLayoutMap;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttributeLayoutMap_getAttributeLayout_6_0_Test {

    private AttributeLayoutMap attributeLayoutMap;

    @BeforeEach
    public void setUp() throws Pack200Exception {
        attributeLayoutMap = new AttributeLayoutMap();
    }

    @Test
    public void testGetAttributeLayoutFound() {
        String name = AttributeLayout.ACC_PUBLIC;
        int context = AttributeLayout.CONTEXT_CLASS;
        AttributeLayout layout = attributeLayoutMap.getAttributeLayout(name, context);
        assertEquals(name, layout.getName());
    }

    @Test
    public void testGetAttributeLayoutNotFound() {
        String name = "NonExistentAttribute";
        int context = AttributeLayout.CONTEXT_CLASS;
        AttributeLayout layout = attributeLayoutMap.getAttributeLayout(name, context);
        assertNull(layout);
    }

    @Test
    public void testGetAttributeLayoutContextField() {
        String name = AttributeLayout.ACC_PRIVATE;
        int context = AttributeLayout.CONTEXT_FIELD;
        AttributeLayout layout = attributeLayoutMap.getAttributeLayout(name, context);
        assertEquals(name, layout.getName());
    }

    @Test
    public void testGetAttributeLayoutContextMethod() {
        String name = AttributeLayout.ACC_PROTECTED;
        int context = AttributeLayout.CONTEXT_METHOD;
        AttributeLayout layout = attributeLayoutMap.getAttributeLayout(name, context);
        assertEquals(name, layout.getName());
    }

    @Test
    public void testGetAttributeLayoutContextCode() {
        String name = AttributeLayout.ATTRIBUTE_LINE_NUMBER_TABLE;
        int context = AttributeLayout.CONTEXT_CODE;
        AttributeLayout layout = attributeLayoutMap.getAttributeLayout(name, context);
        assertEquals(name, layout.getName());
    }

    @Test
    public void testGetAttributeLayoutInvalidContext() throws Exception {
        String name = AttributeLayout.ACC_PUBLIC;
        // Invalid context
        int context = 99;
        // Using reflection to access private method getLayout
        Method getLayoutMethod = AttributeLayoutMap.class.getDeclaredMethod("getLayout", int.class);
        getLayoutMethod.setAccessible(true);
        // Simulating the behavior of invalid context
        AttributeLayout layout = (AttributeLayout) getLayoutMethod.invoke(attributeLayoutMap, context);
        assertNull(layout);
    }
}
