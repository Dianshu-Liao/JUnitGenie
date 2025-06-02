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

public class AttributeLayoutMap_AttributeLayoutMap_8_0_Test {

    private AttributeLayoutMap attributeLayoutMap;

    @BeforeEach
    public void setUp() throws Pack200Exception {
        attributeLayoutMap = new AttributeLayoutMap();
    }

    @Test
    public void testConstructor() throws Exception {
        // Using reflection to invoke the private method getDefaultAttributeLayouts
        Method method = AttributeLayoutMap.class.getDeclaredMethod("getDefaultAttributeLayouts");
        method.setAccessible(true);
        AttributeLayout[] layouts = (AttributeLayout[]) method.invoke(attributeLayoutMap);
        assertNotNull(layouts);
        assertNotNull(attributeLayoutMap);
    }
}
