package org.apache.commons.compress.harmony.unpack200;

import org.apache.commons.compress.harmony.unpack200.CpBands;
import org.apache.commons.compress.harmony.unpack200.Segment;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPNameAndType;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPClass;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPDouble;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPFieldRef;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPFloat;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPInteger;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPInterfaceMethodRef;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPLong;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPMethodRef;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPString;

class CpBands_cpNameAndTypeValue_10_3_Test {

    private CpBands cpBands;

    @BeforeEach
    void setUp() throws Exception {
        Segment segment = new Segment();
        cpBands = new CpBands(segment);
        // Use reflection to set private fields
        setPrivateField(cpBands, "mapDescriptor", new HashMap<String, Integer>());
        setPrivateField(cpBands, "descriptorsToCPNameAndTypes", new HashMap<String, CPNameAndType>());
        setPrivateField(cpBands, "cpDescriptor", new String[] { "name:descriptor" });
        setPrivateField(cpBands, "cpDescriptorNameInts", new int[] { 0 });
        setPrivateField(cpBands, "cpDescriptorTypeInts", new int[] { 0 });
        setPrivateField(cpBands, "cpUTF8", new String[] { "name", "descriptor" });
        Map<String, Integer> mapDescriptor = (Map<String, Integer>) getPrivateField(cpBands, "mapDescriptor");
        mapDescriptor.put("name:descriptor", 0);
    }

    @Test
    void testCpNameAndTypeValue_withExistingDescriptor() throws Exception {
        CPUTF8 name = new CPUTF8("name", -1);
        CPUTF8 descriptor = new CPUTF8("descriptor", -1);
        CPNameAndType expected = new CPNameAndType(name, descriptor, -1);
        Method method = CpBands.class.getDeclaredMethod("cpNameAndTypeValue", String.class);
        method.setAccessible(true);
        CPNameAndType result = (CPNameAndType) method.invoke(cpBands, "name:descriptor");
        assertNotNull(result);
        Map<String, CPNameAndType> descriptorsToCPNameAndTypes = (Map<String, CPNameAndType>) getPrivateField(cpBands, "descriptorsToCPNameAndTypes");
        assertNotNull(descriptorsToCPNameAndTypes.get("name:descriptor"));
    }

    @Test
    void testCpNameAndTypeValue_withNonExistingDescriptor() throws Exception {
        Method method = CpBands.class.getDeclaredMethod("cpNameAndTypeValue", String.class);
        method.setAccessible(true);
        CPNameAndType result = (CPNameAndType) method.invoke(cpBands, "nonexistent:descriptor");
        assertNull(result);
        Map<String, CPNameAndType> descriptorsToCPNameAndTypes = (Map<String, CPNameAndType>) getPrivateField(cpBands, "descriptorsToCPNameAndTypes");
        assertNotNull(descriptorsToCPNameAndTypes.get("nonexistent:descriptor"));
    }

    @Test
    void testCpNameAndTypeValue_withColon() throws Exception {
        String descriptor = "name:descriptor";
        Method method = CpBands.class.getDeclaredMethod("cpNameAndTypeValue", String.class);
        method.setAccessible(true);
        CPNameAndType result = (CPNameAndType) method.invoke(cpBands, descriptor);
        assertNotNull(result);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private Object getPrivateField(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
}
