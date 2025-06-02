package org.apache.commons.compress.harmony.pack200;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.util.List;
import java.lang.reflect.Field;
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

class ClassBands_addClass_3_2_Test {

    private ClassBands classBands;

    private Segment segment;

    private CpBands cpBands;

    @BeforeEach
    void setUp() throws Exception {
        segment = new Segment();
        cpBands = new CpBands(segment, 0);
        classBands = new ClassBands(segment, 10, 0, false);
    }

    private Object getPrivateField(String fieldName) throws Exception {
        Field field = ClassBands.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(classBands);
    }

    @Test
    void testAddClass_withValidInput() throws Exception {
        String className = "TestClass";
        String signature = "LTestClass;";
        String superName = "SuperClass";
        String[] interfaces = { "Interface1", "Interface2" };
        int major = 1;
        int flags = 0;
        assertDoesNotThrow(() -> classBands.addClass(major, flags, className, signature, superName, interfaces));
        assertNotNull(getPrivateField("class_this"));
        assertNotNull(getPrivateField("class_super"));
        assertEquals(2, ((int[]) getPrivateField("class_interface_count"))[0]);
        assertNotNull(getPrivateField("class_interface"));
        assertEquals(major, ((int[]) getPrivateField("major_versions"))[0]);
        assertEquals(flags, ((long[]) getPrivateField("class_flags"))[0]);
    }

    @Test
    void testAddClass_withNullSignature() throws Exception {
        String className = "TestClass";
        String superName = "SuperClass";
        String[] interfaces = { "Interface1", "Interface2" };
        int major = 1;
        int flags = 0;
        assertDoesNotThrow(() -> classBands.addClass(major, flags, className, null, superName, interfaces));
        assertNotNull(getPrivateField("class_this"));
        assertNotNull(getPrivateField("class_super"));
        assertEquals(2, ((int[]) getPrivateField("class_interface_count"))[0]);
        assertNotNull(getPrivateField("class_interface"));
        assertEquals(major, ((int[]) getPrivateField("major_versions"))[0]);
        assertEquals(flags, ((long[]) getPrivateField("class_flags"))[0]);
        assertFalse(((List<?>) getPrivateField("classSignature")).contains(null));
    }

    @Test
    void testAddClass_withSyntheticFlag() throws Exception {
        String className = "SyntheticClass";
        String signature = "LSyntheticClass;";
        String superName = "SuperClass";
        String[] interfaces = {};
        int major = 1;
        int flags = 1 << 12;
        assertDoesNotThrow(() -> classBands.addClass(major, flags, className, signature, superName, interfaces));
        assertTrue((boolean) getPrivateField("anySyntheticClasses"));
    }
}
