package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CPMethodRef_hashCode_2_0_Test {

    private CPMethodRef cpMethodRef;

    private CPClass mockClassName;

    private CPNameAndType mockDescriptor;

    @BeforeEach
    void setUp() {
        mockClassName = mock(CPClass.class);
        mockDescriptor = mock(CPNameAndType.class);
        cpMethodRef = new CPMethodRef(mockClassName, mockDescriptor, 1);
    }

    @Test
    void testHashCodeInitiallyComputesHashCode() throws Exception {
        // Prepare the mock to simulate hash code generation
        Method generateHashCodeMethod = CPMethodRef.class.getDeclaredMethod("generateHashCode");
        generateHashCodeMethod.setAccessible(true);
        // Mock the generateHashCode method to set cachedHashCode
        doAnswer(invocation -> {
            Field cachedHashCodeField = CPMethodRef.class.getDeclaredField("cachedHashCode");
            cachedHashCodeField.setAccessible(true);
            cachedHashCodeField.setInt(cpMethodRef, 12345);
            Field hashCodeComputedField = CPMethodRef.class.getDeclaredField("hashCodeComputed");
            hashCodeComputedField.setAccessible(true);
            hashCodeComputedField.setBoolean(cpMethodRef, true);
            return null;
        }).when(generateHashCodeMethod).invoke(cpMethodRef);
        // Call hashCode to trigger hash code computation
        int hashCode = cpMethodRef.hashCode();
        // Ensure the hash code is computed and cached
        assertEquals(12345, hashCode);
        assertEquals(12345, cpMethodRef.hashCode());
    }

    @Test
    void testHashCodeReturnsCachedValue() throws Exception {
        // Prepare the mock to simulate hash code generation
        Method generateHashCodeMethod = CPMethodRef.class.getDeclaredMethod("generateHashCode");
        generateHashCodeMethod.setAccessible(true);
        // Mock the generateHashCode method to set cachedHashCode
        doAnswer(invocation -> {
            Field cachedHashCodeField = CPMethodRef.class.getDeclaredField("cachedHashCode");
            cachedHashCodeField.setAccessible(true);
            cachedHashCodeField.setInt(cpMethodRef, 67890);
            Field hashCodeComputedField = CPMethodRef.class.getDeclaredField("hashCodeComputed");
            hashCodeComputedField.setAccessible(true);
            hashCodeComputedField.setBoolean(cpMethodRef, true);
            return null;
        }).when(generateHashCodeMethod).invoke(cpMethodRef);
        // Invoke hashCode to compute and cache the value
        cpMethodRef.hashCode();
        // Now, call hashCode again
        int cachedHashCode = cpMethodRef.hashCode();
        // Ensure that the cached value is returned and no further computation occurs
        assertEquals(cachedHashCode, cpMethodRef.hashCode());
    }
}
