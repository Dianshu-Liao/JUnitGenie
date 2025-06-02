package org.apache.commons.compress.archivers.sevenz;

import org.apache.commons.compress.archivers.sevenz.SevenZMethod;
import org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

class SevenZMethodConfiguration_equals_0_0_Test {

    @Test
    void testEquals_SameReference() {
        SevenZMethod method = SevenZMethod.COPY;
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(method);
        assertTrue(config.equals(config));
    }

    @Test
    void testEquals_NullObject() {
        SevenZMethod method = SevenZMethod.COPY;
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(method);
        assertFalse(config.equals(null));
    }

    @Test
    void testEquals_DifferentClass() {
        SevenZMethod method = SevenZMethod.COPY;
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(method);
        assertFalse(config.equals("Not a SevenZMethodConfiguration"));
    }

    @Test
    void testEquals_SameValues() {
        SevenZMethod method = SevenZMethod.COPY;
        Object options = new Object();
        SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(method, options);
        SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(method, options);
        assertTrue(config1.equals(config2));
    }

    @Test
    void testEquals_DifferentMethods() {
        SevenZMethod method1 = SevenZMethod.COPY;
        SevenZMethod method2 = SevenZMethod.LZMA;
        SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(method1);
        SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(method2);
        assertFalse(config1.equals(config2));
    }

    @Test
    void testEquals_DifferentOptions() {
        SevenZMethod method = SevenZMethod.COPY;
        SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(method, new Object());
        SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(method, new Object());
        // Different options reference
        assertFalse(config1.equals(config2));
    }

    @Test
    void testEquals_SameMethodDifferentOptions() {
        SevenZMethod method = SevenZMethod.COPY;
        Object options1 = new Object();
        Object options2 = new Object();
        SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(method, options1);
        SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(method, options2);
        // Different options references
        assertFalse(config1.equals(config2));
    }
}
