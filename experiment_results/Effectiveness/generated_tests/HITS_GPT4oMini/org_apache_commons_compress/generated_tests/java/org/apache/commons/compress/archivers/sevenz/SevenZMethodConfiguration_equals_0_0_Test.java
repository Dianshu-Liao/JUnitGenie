package org.apache.commons.compress.archivers.sevenz;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

public class SevenZMethodConfiguration_equals_0_0_Test {

    @Test
    public void testEquals_SameInstance() {
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(SevenZMethod.COPY, new Object());
        assertTrue(config.equals(config), "Same instance should be equal");
    }

    @Test
    public void testEquals_NullObject() {
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(SevenZMethod.COPY, new Object());
        assertFalse(config.equals(null), "Should not be equal to null");
    }

    @Test
    public void testEquals_DifferentClass() {
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(SevenZMethod.COPY, new Object());
        assertFalse(config.equals(new Object()), "Should not be equal to an object of a different class");
    }

    @Test
    public void testEquals_DifferentMethods() {
        SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(SevenZMethod.COPY, new Object());
        SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(SevenZMethod.LZMA, new Object());
        assertFalse(config1.equals(config2), "Should not be equal with different methods");
    }

    @Test
    public void testEquals_DifferentOptions() {
        SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(SevenZMethod.COPY, "Option1");
        SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(SevenZMethod.COPY, "Option2");
        assertFalse(config1.equals(config2), "Should not be equal with different options");
    }

    @Test
    public void testEquals_SameMethodAndOptions() {
        SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(SevenZMethod.COPY, new Object());
        SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(SevenZMethod.COPY, new Object());
        assertTrue(config1.equals(config2), "Should be equal with same method and options");
    }

    @Test
    public void testEquals_SameMethodDifferentOptions() {
        SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(SevenZMethod.COPY, null);
        SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(SevenZMethod.COPY, null);
        assertTrue(config1.equals(config2), "Should be equal with same method and null options");
    }
}
