package org.apache.commons.compress.harmony.unpack200;

import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import org.apache.commons.compress.harmony.unpack200.bytecode.RuntimeVisibleorInvisibleParameterAnnotationsAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.RuntimeVisibleorInvisibleParameterAnnotationsAttribute.ParameterAnnotation;
import java.util.Arrays;
import java.util.Iterator;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.Annotation;
import org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue;
import org.apache.commons.compress.harmony.unpack200.bytecode.Attribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPDouble;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPFloat;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPInteger;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPLong;
import org.apache.commons.compress.harmony.unpack200.bytecode.RuntimeVisibleorInvisibleAnnotationsAttribute;

public class MetadataBandGroup_getParameterAttribute_8_0_Test {

    private MetadataBandGroup metadataBandGroup;

    private CPUTF8[] nameRU;

    private int[] annoN;

    private int[][] pairN;

    private CPUTF8[][] typeRS;

    @BeforeEach
    public void setUp() {
        nameRU = new CPUTF8[] { new CPUTF8("param1"), new CPUTF8("param2") };
        annoN = new int[] { 1, 2 };
        pairN = new int[][] { { 0 }, { 0, 1 } };
        typeRS = new CPUTF8[][] { { new CPUTF8("Type1") }, { new CPUTF8("Type2"), new CPUTF8("Type3") } };
        CpBands cpBands = new CpBands(null);
        metadataBandGroup = new MetadataBandGroup("RVPA", cpBands);
        metadataBandGroup.name_RU = nameRU;
        metadataBandGroup.anno_N = annoN;
        metadataBandGroup.pair_N = pairN;
        metadataBandGroup.type_RS = typeRS;
    }

    @Test
    public void testGetParameterAttribute_ValidInput() throws Exception {
        Iterator<CPUTF8> namesIterator = Arrays.asList(nameRU).iterator();
        Method method = MetadataBandGroup.class.getDeclaredMethod("getParameterAttribute", int.class, Iterator.class);
        method.setAccessible(true);
        RuntimeVisibleorInvisibleParameterAnnotationsAttribute result = (RuntimeVisibleorInvisibleParameterAnnotationsAttribute) method.invoke(metadataBandGroup, 2, namesIterator);
        assertNotNull(result);
        // Instead of getParameterAnnotations(), we need to access the annotations correctly
        Field parameterAnnotationsField = RuntimeVisibleorInvisibleParameterAnnotationsAttribute.class.getDeclaredField("parameterAnnotations");
        parameterAnnotationsField.setAccessible(true);
        ParameterAnnotation[] parameterAnnotations = (ParameterAnnotation[]) parameterAnnotationsField.get(result);
        assertNotNull(parameterAnnotations);
        assertEquals(2, parameterAnnotations.length);
        // Use reflection to access the private field 'annotations'
        for (ParameterAnnotation parameterAnnotation : parameterAnnotations) {
            Field annotationsField = ParameterAnnotation.class.getDeclaredField("annotations");
            annotationsField.setAccessible(true);
            Annotation[] annotations = (Annotation[]) annotationsField.get(parameterAnnotation);
            assertNotNull(annotations);
        }
    }
}
