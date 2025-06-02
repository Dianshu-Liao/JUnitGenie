package org.apache.commons.compress.harmony.unpack200;

import org.apache.commons.compress.harmony.unpack200.CpBands;
import org.apache.commons.compress.harmony.unpack200.bytecode.*;
import java.util.Arrays;
import java.util.Iterator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.Annotation;
import org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue;
import org.apache.commons.compress.harmony.unpack200.bytecode.RuntimeVisibleorInvisibleParameterAnnotationsAttribute.ParameterAnnotation;

class MetadataBandGroup_getParameterAttribute_8_0_Test {

    private MetadataBandGroup metadataBandGroup;

    @BeforeEach
    void setUp() {
        CpBands cpBands = new CpBands(null);
        metadataBandGroup = new MetadataBandGroup("RVPA", cpBands);
        // Set up the necessary fields for the test
        // One parameter
        metadataBandGroup.param_NB = new int[] { 1 };
        // One annotation
        metadataBandGroup.anno_N = new int[] { 1 };
        metadataBandGroup.type_RS = new CPUTF8[][] { new CPUTF8[] { new CPUTF8("TestType") } };
        // One pair count
        metadataBandGroup.pair_N = new int[][] { { 1 } };
        metadataBandGroup.name_RU = new CPUTF8[] { new CPUTF8("TestName") };
        // Set static attributes
        MetadataBandGroup.setRvpaAttributeName(new CPUTF8("RVPA"));
        MetadataBandGroup.setRipaAttributeName(new CPUTF8("RIPA"));
    }

    @Test
    void testGetParameterAttribute() throws Exception {
        Iterator<CPUTF8> namesIterator = Arrays.asList(metadataBandGroup.name_RU).iterator();
        // Use reflection to access the private method
        Attribute attribute = (Attribute) MetadataBandGroup.class.getDeclaredMethod("getParameterAttribute", int.class, Iterator.class).invoke(metadataBandGroup, metadataBandGroup.param_NB[0], namesIterator);
        assertNotNull(attribute);
        assertEquals(RuntimeVisibleorInvisibleParameterAnnotationsAttribute.class, attribute.getClass());
        // Further assertions can be made based on expected contents of the attribute
        RuntimeVisibleorInvisibleParameterAnnotationsAttribute parameterAnnotationsAttribute = (RuntimeVisibleorInvisibleParameterAnnotationsAttribute) attribute;
        // Use reflection to access the private field 'parameterAnnotations'
        Field field = RuntimeVisibleorInvisibleParameterAnnotationsAttribute.class.getDeclaredField("parameterAnnotations");
        field.setAccessible(true);
        ParameterAnnotation[] parameterAnnotations = (ParameterAnnotation[]) field.get(parameterAnnotationsAttribute);
        // One parameter
        assertEquals(1, parameterAnnotations.length);
    }

    @Test
    void testGetParameterAttributeWithDifferentType() throws Exception {
        // Change type to "RIPA" and test
        metadataBandGroup = new MetadataBandGroup("RIPA", new CpBands(null));
        metadataBandGroup.param_NB = new int[] { 1 };
        metadataBandGroup.anno_N = new int[] { 1 };
        metadataBandGroup.type_RS = new CPUTF8[][] { new CPUTF8[] { new CPUTF8("TestType") } };
        metadataBandGroup.pair_N = new int[][] { { 1 } };
        metadataBandGroup.name_RU = new CPUTF8[] { new CPUTF8("TestName") };
        // Set static attributes
        MetadataBandGroup.setRvpaAttributeName(new CPUTF8("RVPA"));
        MetadataBandGroup.setRipaAttributeName(new CPUTF8("RIPA"));
        Iterator<CPUTF8> namesIterator = Arrays.asList(metadataBandGroup.name_RU).iterator();
        // Use reflection to access the private method
        Attribute attribute = (Attribute) MetadataBandGroup.class.getDeclaredMethod("getParameterAttribute", int.class, Iterator.class).invoke(metadataBandGroup, metadataBandGroup.param_NB[0], namesIterator);
        assertNotNull(attribute);
        assertEquals(RuntimeVisibleorInvisibleParameterAnnotationsAttribute.class, attribute.getClass());
        // Further assertions can be made based on expected contents of the attribute
        RuntimeVisibleorInvisibleParameterAnnotationsAttribute parameterAnnotationsAttribute = (RuntimeVisibleorInvisibleParameterAnnotationsAttribute) attribute;
        // Use reflection to access the private field 'parameterAnnotations'
        Field field = RuntimeVisibleorInvisibleParameterAnnotationsAttribute.class.getDeclaredField("parameterAnnotations");
        field.setAccessible(true);
        ParameterAnnotation[] parameterAnnotations = (ParameterAnnotation[]) field.get(parameterAnnotationsAttribute);
        // One parameter
        assertEquals(1, parameterAnnotations.length);
    }
}
