package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class CPInterfaceMethodRef_hashCode_1_0_Test {

    private CPInterfaceMethodRef cpInterfaceMethodRef;

    private CPClass mockClassName;

    private CPNameAndType mockDescriptor;

    @BeforeEach
    public void setUp() {
        mockClassName = mock(CPClass.class);
        mockDescriptor = mock(CPNameAndType.class);
        cpInterfaceMethodRef = new CPInterfaceMethodRef(mockClassName, mockDescriptor, 1);
    }

    @Test
    public void testHashCodeWhenNotComputed() throws Exception {
        // Arrange
        when(mockClassName.hashCode()).thenReturn(42);
        when(mockDescriptor.hashCode()).thenReturn(24);
        // Act
        int hashCode = cpInterfaceMethodRef.hashCode();
        // Assert
        assertEquals(31 * 1 + 31 * 42 + 24, hashCode);
    }

    @Test
    public void testHashCodeWhenAlreadyComputed() throws Exception {
        // Arrange
        when(mockClassName.hashCode()).thenReturn(42);
        when(mockDescriptor.hashCode()).thenReturn(24);
        // Act
        // Compute hash code
        int firstHashCode = cpInterfaceMethodRef.hashCode();
        // Should use cached value
        int secondHashCode = cpInterfaceMethodRef.hashCode();
        // Assert
        assertEquals(firstHashCode, secondHashCode);
    }

    @Test
    public void testGenerateHashCode() throws Exception {
        // Use reflection to invoke the private method generateHashCode
        Method generateHashCodeMethod = CPInterfaceMethodRef.class.getDeclaredMethod("generateHashCode");
        generateHashCodeMethod.setAccessible(true);
        // Arrange
        when(mockClassName.hashCode()).thenReturn(42);
        when(mockDescriptor.hashCode()).thenReturn(24);
        // Act
        generateHashCodeMethod.invoke(cpInterfaceMethodRef);
        int hashCode = cpInterfaceMethodRef.hashCode();
        // Assert
        assertEquals(31 * 1 + 31 * 42 + 24, hashCode);
    }
}
