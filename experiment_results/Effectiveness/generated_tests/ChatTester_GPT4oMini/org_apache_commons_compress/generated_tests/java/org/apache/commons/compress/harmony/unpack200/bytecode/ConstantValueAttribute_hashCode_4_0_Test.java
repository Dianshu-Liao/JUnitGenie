package org.apache.commons.compress.harmony.unpack200.bytecode;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

public class ConstantValueAttribute_hashCode_4_0_Test {

    private ClassFileEntry mockEntry;

    private ConstantValueAttribute constantValueAttribute;

    @BeforeEach
    public void setUp() {
        mockEntry = mock(ClassFileEntry.class);
        constantValueAttribute = new ConstantValueAttribute(mockEntry);
    }

    @Test
    public void testHashCode_withNonNullEntry() {
        // Arrange
        when(mockEntry.hashCode()).thenReturn(12345);
        // Act
        int hashCode = constantValueAttribute.hashCode();
        // Assert
        // Assuming super.hashCode() returns a fixed value
        int expectedHashCode = 31 * super.hashCode() + 12345;
        assertEquals(expectedHashCode, hashCode);
    }

    @Test
    public void testHashCode_withNullEntry() {
        // Arrange
        constantValueAttribute = new ConstantValueAttribute(null);
        // Act
        int hashCode = constantValueAttribute.hashCode();
        // Assert
        // Assuming super.hashCode() returns a fixed value
        int expectedHashCode = 31 * super.hashCode() + 0;
        assertEquals(expectedHashCode, hashCode);
    }
}
