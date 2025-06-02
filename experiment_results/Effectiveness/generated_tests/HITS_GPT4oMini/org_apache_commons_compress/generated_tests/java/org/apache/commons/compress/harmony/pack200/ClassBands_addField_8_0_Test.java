package org.apache.commons.compress.harmony.pack200;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition;
import org.apache.commons.compress.harmony.pack200.IcBands.IcTuple;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

@ExtendWith(MockitoExtension.class)
class ClassBands_addField_8_0_Test {

    private ClassBands classBands;

    private Segment segment;

    private CpBands cpBands;

    @BeforeEach
    void setUp() throws Exception {
        segment = Mockito.mock(Segment.class);
        cpBands = Mockito.mock(CpBands.class);
        Mockito.when(segment.getCpBands()).thenReturn(cpBands);
        classBands = new ClassBands(segment, 1, 1, false);
    }

    private List<Long> getTempFieldFlags() throws Exception {
        Field field = ClassBands.class.getDeclaredField("tempFieldFlags");
        field.setAccessible(true);
        return (List<Long>) field.get(classBands);
    }

    private List<CPSignature> getFieldSignature() throws Exception {
        Field field = ClassBands.class.getDeclaredField("fieldSignature");
        field.setAccessible(true);
        return (List<CPSignature>) field.get(classBands);
    }

    @Test
    void testAddField_withValidFlags() throws Exception {
        int flags = 0xFFFF;
        String name = "fieldName";
        String desc = "I";
        String signature = null;
        Object value = null;
        classBands.addField(flags, name, desc, signature, value);
        List<Long> tempFieldFlags = getTempFieldFlags();
        assertEquals(1, tempFieldFlags.size());
        assertEquals(Long.valueOf(flags), tempFieldFlags.get(0));
    }

    @Test
    void testAddField_withNegativeFlags() throws Exception {
        int flags = -1;
        String name = "fieldName";
        String desc = "I";
        String signature = null;
        Object value = null;
        classBands.addField(flags, name, desc, signature, value);
        List<Long> tempFieldFlags = getTempFieldFlags();
        assertEquals(1, tempFieldFlags.size());
        assertEquals(Long.valueOf(0xFFFF), tempFieldFlags.get(0));
    }

    @Test
    void testAddField_withFlagsGreaterThanFFFF() throws Exception {
        int flags = 0x1FFFF;
        String name = "fieldName";
        String desc = "I";
        String signature = null;
        Object value = null;
        classBands.addField(flags, name, desc, signature, value);
        List<Long> tempFieldFlags = getTempFieldFlags();
        assertEquals(1, tempFieldFlags.size());
        assertEquals(Long.valueOf(0xFFFF), tempFieldFlags.get(0));
    }

    @Test
    void testAddField_withSignature() throws Exception {
        int flags = 0x1;
        String name = "fieldName";
        String desc = "I";
        String signature = "Ljava/lang/String;";
        Object value = null;
        classBands.addField(flags, name, desc, signature, value);
        List<Long> tempFieldFlags = getTempFieldFlags();
        assertEquals(1, tempFieldFlags.size());
        assertFalse(getFieldSignature().isEmpty());
    }
}
