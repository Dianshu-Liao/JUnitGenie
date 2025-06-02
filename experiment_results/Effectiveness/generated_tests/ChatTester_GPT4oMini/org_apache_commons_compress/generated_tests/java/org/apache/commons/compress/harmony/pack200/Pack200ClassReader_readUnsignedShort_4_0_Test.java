package org.apache.commons.compress.harmony.pack200;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.objectweb.asm.ClassReader;

public class Pack200ClassReader_readUnsignedShort_4_0_Test {

    private Pack200ClassReader pack200ClassReader;

    @BeforeEach
    public void setUp() {
        // Initialize with a sample byte array
        // 19 is the ldc_w instruction
        byte[] sampleBytes = new byte[] { 0, 0, 0, 19, 1, 2 };
        pack200ClassReader = new Pack200ClassReader(sampleBytes);
    }

    @Test
    public void testReadUnsignedShort_WithLdcWInstruction() throws Exception {
        // Invoke readUnsignedShort with an index that follows the ldc_w instruction
        Method method = Pack200ClassReader.class.getDeclaredMethod("readUnsignedShort", int.class);
        method.setAccessible(true);
        // Index after ldc_w (19)
        int result = (int) method.invoke(pack200ClassReader, 4);
        // 1 << 8 + 2 = 258
        assertEquals(258, result);
    }

    @Test
    public void testReadUnsignedShort_WithoutLdcWInstruction() throws Exception {
        // Invoke readUnsignedShort with an index that does not follow the ldc_w instruction
        Method method = Pack200ClassReader.class.getDeclaredMethod("readUnsignedShort", int.class);
        method.setAccessible(true);
        // Index after the unsigned short
        int result = (int) method.invoke(pack200ClassReader, 5);
        // The value should be 0 as per byte array
        assertEquals(0, result);
    }

    @Test
    public void testReadUnsignedShort_OutOfBounds() throws Exception {
        // Invoke readUnsignedShort with an out of bounds index
        Method method = Pack200ClassReader.class.getDeclaredMethod("readUnsignedShort", int.class);
        method.setAccessible(true);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            // Out of bounds index
            method.invoke(pack200ClassReader, 10);
        });
    }

    @Test
    public void testReadUnsignedShort_WithNegativeIndex() throws Exception {
        // Invoke readUnsignedShort with a negative index
        Method method = Pack200ClassReader.class.getDeclaredMethod("readUnsignedShort", int.class);
        method.setAccessible(true);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            // Negative index
            method.invoke(pack200ClassReader, -1);
        });
    }
}
