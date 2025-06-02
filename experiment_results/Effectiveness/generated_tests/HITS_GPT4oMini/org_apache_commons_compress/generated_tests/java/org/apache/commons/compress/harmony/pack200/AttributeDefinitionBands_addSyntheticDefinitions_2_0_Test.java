package org.apache.commons.compress.harmony.pack200;

import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.objectweb.asm.Attribute;
import java.io.IOException;
import java.util.ArrayList;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AttributeDefinitionBands_addSyntheticDefinitions_2_0_Test {

    private Segment segment;

    private ClassBands classBands;

    private CpBands cpBands;

    private AttributeDefinitionBands attributeDefinitionBands;

    @BeforeEach
    public void setUp() {
        segment = mock(Segment.class);
        classBands = mock(ClassBands.class);
        cpBands = mock(CpBands.class);
        attributeDefinitionBands = new AttributeDefinitionBands(segment, 1, new Attribute[0]);
        when(segment.getClassBands()).thenReturn(classBands);
        when(segment.getCpBands()).thenReturn(cpBands);
    }

    private void invokePrivateMethod(String methodName) throws Exception {
        Method method = AttributeDefinitionBands.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(attributeDefinitionBands);
    }

    @Test
    public void testAddSyntheticDefinitions_WithSyntheticClasses() throws Exception {
        when(classBands.isAnySyntheticClasses()).thenReturn(true);
        when(classBands.isAnySyntheticMethods()).thenReturn(false);
        when(classBands.isAnySyntheticFields()).thenReturn(false);
        invokePrivateMethod("addSyntheticDefinitions");
        List<AttributeDefinitionBands.AttributeDefinition> definitions = attributeDefinitionBands.getClassAttributeLayouts();
        assertEquals(1, definitions.size());
        assertTrue(definitions.stream().anyMatch(def -> def.equals(new AttributeDefinitionBands.AttributeDefinition(12, AttributeDefinitionBands.CONTEXT_CLASS, null, null))));
    }

    @Test
    public void testAddSyntheticDefinitions_WithSyntheticMethods() throws Exception {
        when(classBands.isAnySyntheticClasses()).thenReturn(false);
        when(classBands.isAnySyntheticMethods()).thenReturn(true);
        when(classBands.isAnySyntheticFields()).thenReturn(false);
        invokePrivateMethod("addSyntheticDefinitions");
        List<AttributeDefinitionBands.AttributeDefinition> definitions = attributeDefinitionBands.getMethodAttributeLayouts();
        assertEquals(1, definitions.size());
        assertTrue(definitions.stream().anyMatch(def -> def.equals(new AttributeDefinitionBands.AttributeDefinition(12, AttributeDefinitionBands.CONTEXT_METHOD, null, null))));
    }
}
