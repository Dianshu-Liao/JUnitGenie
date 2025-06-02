package org.apache.commons.compress.harmony.pack200;

import org.apache.commons.compress.harmony.pack200.ClassBands;
import org.apache.commons.compress.harmony.pack200.CpBands;
import org.apache.commons.compress.harmony.pack200.Pack200ClassReader;
import org.apache.commons.compress.harmony.pack200.Segment;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
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
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition;
import org.apache.commons.compress.harmony.pack200.IcBands.IcTuple;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

@ExtendWith(MockitoExtension.class)
class ClassBands_addClass_3_2_Test {

    private ClassBands classBands;

    private Segment segment;

    private CpBands cpBands;

    @BeforeEach
    void setUp() throws IOException {
        segment = new Segment();
        cpBands = new CpBands(segment, 0);
        classBands = new ClassBands(segment, 10, 0, false);
    }

    @Test
    void testAddClass() throws Exception {
        String className = "TestClass";
        String signature = "LTestClass;";
        String superName = "SuperClass";
        String[] interfaces = new String[] { "Interface1", "Interface2" };
        // Prepare reflection to set the index
        Field indexField = ClassBands.class.getDeclaredField("index");
        indexField.setAccessible(true);
        indexField.setInt(classBands, 0);
        // Invoke addClass method
        classBands.addClass(1, 0, className, signature, superName, interfaces);
        // Verify the state after adding a class
        Field classThisField = ClassBands.class.getDeclaredField("class_this");
        Field classSuperField = ClassBands.class.getDeclaredField("class_super");
        Field classInterfaceCountField = ClassBands.class.getDeclaredField("class_interface_count");
        Field classInterfaceField = ClassBands.class.getDeclaredField("class_interface");
        Field majorVersionsField = ClassBands.class.getDeclaredField("major_versions");
        Field classFlagsField = ClassBands.class.getDeclaredField("class_flags");
        Field classSignatureField = ClassBands.class.getDeclaredField("classSignature");
        classThisField.setAccessible(true);
        classSuperField.setAccessible(true);
        classInterfaceCountField.setAccessible(true);
        classInterfaceField.setAccessible(true);
        majorVersionsField.setAccessible(true);
        classFlagsField.setAccessible(true);
        classSignatureField.setAccessible(true);
        CPClass[] classThis = (CPClass[]) classThisField.get(classBands);
        CPClass[] classSuper = (CPClass[]) classSuperField.get(classBands);
        int[] classInterfaceCount = (int[]) classInterfaceCountField.get(classBands);
        CPClass[][] classInterface = (CPClass[][]) classInterfaceField.get(classBands);
        int[] majorVersions = (int[]) majorVersionsField.get(classBands);
        long[] classFlags = (long[]) classFlagsField.get(classBands);
        List<CPSignature> classSignature = (List<CPSignature>) classSignatureField.get(classBands);
        assertNotNull(classThis[0]);
        assertNotNull(classSuper[0]);
        assertEquals(2, classInterfaceCount[0]);
        assertEquals(1, majorVersions[0]);
        assertEquals(0, classFlags[0]);
        assertNotNull(classSignature.get(0));
    }

    @Test
    void testAddClassWithSynthetic() throws Exception {
        String className = "SyntheticClass";
        String signature = "LSyntheticClass;";
        String superName = "SuperClass";
        String[] interfaces = new String[] { "Interface1" };
        // Prepare reflection to set the index
        Field indexField = ClassBands.class.getDeclaredField("index");
        indexField.setAccessible(true);
        indexField.setInt(classBands, 0);
        // Prepare reflection to set synthetic attributes
        Field anySyntheticClassesField = ClassBands.class.getDeclaredField("anySyntheticClasses");
        anySyntheticClassesField.setAccessible(true);
        anySyntheticClassesField.setBoolean(classBands, false);
        // Prepare mock for segment currentClassReader
        Field currentClassReaderField = Segment.class.getDeclaredField("currentClassReader");
        currentClassReaderField.setAccessible(true);
        currentClassReaderField.set(segment, new Pack200ClassReader(new byte[0]));
        // Invoke addClass method
        classBands.addClass(1 << 12, 1 << 12, className, signature, superName, interfaces);
        // Verify synthetic class flag
        Field classFlagsField = ClassBands.class.getDeclaredField("class_flags");
        classFlagsField.setAccessible(true);
        long[] classFlags = (long[]) classFlagsField.get(classBands);
        assertTrue((classFlags[0] & (1 << 12)) != 0);
    }
}
