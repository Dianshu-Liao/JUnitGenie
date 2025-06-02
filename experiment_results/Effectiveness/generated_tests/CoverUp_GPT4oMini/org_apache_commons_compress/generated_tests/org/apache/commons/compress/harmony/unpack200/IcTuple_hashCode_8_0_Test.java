package org.apache.commons.compress.harmony.unpack200;

import org.apache.commons.compress.harmony.unpack200.IcTuple;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IcTuple_hashCode_8_0_Test {

    private IcTuple icTuple;

    @BeforeEach
    public void setUp() {
        icTuple = new IcTuple("ClassA", 1, "ClassB", null, 0, 0, 0, 0);
    }

    @Test
    public void testHashCodeWithNonNullValues() throws Exception {
        // Given
        icTuple = new IcTuple("ClassA", 1, "ClassB", "ClassC", 0, 0, 0, 0);
        // When
        int hashCode = icTuple.hashCode();
        // Then
        assertEquals("ClassA".hashCode() + "ClassB".hashCode() + "ClassC".hashCode(), hashCode);
    }

    @Test
    public void testHashCodeWithNullC2() throws Exception {
        // Given
        icTuple = new IcTuple("ClassA", 1, null, "ClassC", 0, 0, 0, 0);
        // When
        int hashCode = icTuple.hashCode();
        // Then
        assertEquals("ClassA".hashCode() + "ClassC".hashCode(), hashCode);
    }

    @Test
    public void testHashCodeWithNullN() throws Exception {
        // Given
        icTuple = new IcTuple("ClassA", 1, "ClassB", null, 0, 0, 0, 0);
        // When
        int hashCode = icTuple.hashCode();
        // Then
        assertEquals("ClassA".hashCode() + "ClassB".hashCode(), hashCode);
    }

    @Test
    public void testHashCodeWithAllNulls() throws Exception {
        // Given
        icTuple = new IcTuple(null, 1, null, null, 0, 0, 0, 0);
        // When
        int hashCode = icTuple.hashCode();
        // Then
        assertEquals(0, hashCode);
    }

    @Test
    public void testHashCodeCaching() throws Exception {
        // Given
        icTuple = new IcTuple("ClassA", 1, "ClassB", "ClassC", 0, 0, 0, 0);
        // When
        int firstHashCode = icTuple.hashCode();
        // Should hit the cache
        int secondHashCode = icTuple.hashCode();
        // Then
        assertEquals(firstHashCode, secondHashCode);
    }

    private void invokeGenerateHashCode(IcTuple instance) throws Exception {
        Method method = IcTuple.class.getDeclaredMethod("generateHashCode");
        method.setAccessible(true);
        method.invoke(instance);
    }
}
