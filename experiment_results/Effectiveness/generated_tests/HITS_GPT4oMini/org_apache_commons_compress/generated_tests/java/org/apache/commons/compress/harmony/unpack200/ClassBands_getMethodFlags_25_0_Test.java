package org.apache.commons.compress.harmony.unpack200;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.unpack200.bytecode.Attribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPClass;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPNameAndType;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry;
import org.apache.commons.compress.harmony.unpack200.bytecode.ConstantValueAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.DeprecatedAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionsAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.LineNumberTableAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.LocalVariableTableAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.LocalVariableTypeTableAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.SignatureAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.SourceFileAttribute;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ClassBands_getMethodFlags_25_0_Test {

    private ClassBands classBands;

    private Segment segment;

    @BeforeEach
    public void setUp() throws Exception {
        segment = mock(Segment.class);
        classBands = new ClassBands(segment);
        // Use reflection to set private fields
        setPrivateField(classBands, "methodFlags", new long[][] { { 0xFFFF, 0xAAAA }, { 0x5555, 0x0000 } });
        setPrivateField(classBands, "attrMap", new AttributeLayoutMap());
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    @Test
    public void testGetMethodFlags_WhenMethodAccessFlagsIsNull_ShouldInitializeAndReturnCorrectFlags() {
        long[][] expectedFlags = { { 0x7FFF, 0x7FFF }, { 0x7FFF, 0x0000 } };
        long[][] actualFlags = classBands.getMethodFlags();
        assertArrayEquals(expectedFlags, actualFlags);
    }

    @Test
    public void testGetMethodFlags_WhenMethodAccessFlagsAlreadyInitialized_ShouldReturnExistingFlags() {
        // First call to initialize
        classBands.getMethodFlags();
        // Modify methodFlags to check if it returns the already initialized methodAccessFlags
        long[][] actualFlagsFirstCall = classBands.getMethodFlags();
        long[][] actualFlagsSecondCall = classBands.getMethodFlags();
        assertArrayEquals(actualFlagsFirstCall, actualFlagsSecondCall);
    }
}
