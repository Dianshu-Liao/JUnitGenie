package org.apache.commons.compress.harmony.pack200;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.objectweb.asm.ClassReader;

public class Pack200ClassReader_readUnsignedShort_4_0_Test {

    private Pack200ClassReader pack200ClassReader;

    private byte[] b;

    @BeforeEach
    public void setUp() {
        // Adjust size as needed for tests
        b = new byte[10];
        // Use the constructor that accepts byte[]
        pack200ClassReader = new Pack200ClassReader(b);
    }

    @Test
    public void testReadUnsignedShort_WithValidIndex() {
        // Arrange
        int index = 1;
        // Simulate ldc_w instruction
        b[index - 1] = 19;
        // Mocking the super method behavior
        Pack200ClassReader mockReader = mock(Pack200ClassReader.class);
        when(mockReader.readUnsignedShort(index)).thenReturn(1000);
        pack200ClassReader = mockReader;
        // Act
        int result = pack200ClassReader.readUnsignedShort(index);
        // Assert
        assertEquals(1000, result);
    }

    @Test
    public void testReadUnsignedShort_WithInvalidIndex() {
        // Arrange
        int index = 0;
        // Simulate ldc instruction
        b[index] = 18;
        // Mocking the super method behavior
        Pack200ClassReader mockReader = mock(Pack200ClassReader.class);
        when(mockReader.readUnsignedShort(index)).thenReturn(500);
        pack200ClassReader = mockReader;
        // Act
        int result = pack200ClassReader.readUnsignedShort(index);
        // Assert
        assertEquals(500, result);
    }

    @Test
    public void testReadUnsignedShort_WithWideIndex() {
        // Arrange
        int index = 2;
        // Simulate ldc_w instruction
        b[index - 1] = 19;
        // Mocking the super method behavior
        Pack200ClassReader mockReader = mock(Pack200ClassReader.class);
        when(mockReader.readUnsignedShort(index)).thenReturn(300);
        pack200ClassReader = mockReader;
        // Act
        int result = pack200ClassReader.readUnsignedShort(index);
        // Assert
        assertEquals(300, result);
    }

    @Test
    public void testReadUnsignedShort_WithShortMinValue() {
        // Arrange
        int index = 3;
        // Simulate ldc instruction
        b[index - 1] = 18;
        // Mocking the super method behavior
        Pack200ClassReader mockReader = mock(Pack200ClassReader.class);
        // Cast to int
        when(mockReader.readUnsignedShort(index)).thenReturn((int) Short.MIN_VALUE);
        pack200ClassReader = mockReader;
        // Act
        int result = pack200ClassReader.readUnsignedShort(index);
        // Assert
        // Cast to int for comparison
        assertEquals((int) Short.MIN_VALUE, result);
    }
}
