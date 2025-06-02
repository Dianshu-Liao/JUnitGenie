package org.apache.commons.compress.harmony.pack200;

import org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.compress.harmony.pack200.IcBands.IcTuple;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

public class ClassBands_addFieldAttribute_9_1_Test {

    private ClassBands classBands;

    private Segment segment;

    private NewAttributeBands newAttributeBands;

    private NewAttribute newAttribute;

    @BeforeEach
    public void setUp() throws Exception {
        segment = new Segment();
        classBands = new ClassBands(segment, 1, 0, false);
        CPUTF8 name = new CPUTF8("attributeName");
        CPUTF8 signature = new CPUTF8("signature");
        newAttributeBands = new NewAttributeBands(0, new CpBands(segment, 0), segment.getSegmentHeader(), new AttributeDefinition(0, 0, name, signature));
        // Add a valid attribute
        newAttributeBands.addAttribute(new NewAttribute(name.getUnderlyingString(), "layout", 0));
    }

    @Test
    public void testAddFieldAttribute_Success() {
        String attributeName = "TestAttribute";
        newAttribute = new NewAttribute(attributeName, "layout", 0);
        // Directly add the attribute to the classBands
        classBands.addFieldAttribute(newAttribute);
        assertNotNull(newAttributeBands);
        assertTrue(newAttributeBands.isUsedAtLeastOnce());
    }

    @Test
    public void testAddFieldAttribute_NoSuitableDefinition() {
        String attributeName = "InvalidAttribute";
        newAttribute = new NewAttribute(attributeName, "layout", 0);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            classBands.addFieldAttribute(newAttribute);
        });
        assertEquals("No suitable definition for " + attributeName, thrown.getMessage());
    }
}
