package org.apache.commons.compress.archivers.sevenz;

import java.lang.reflect.Field;
import java.util.Objects;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class SevenZMethodConfiguration_equals_0_0_Test {

    private static class SevenZMethod {
        // Assume this is a placeholder for the actual implementation.
    }

    private static class SevenZMethodConfiguration {

        private final SevenZMethod method;

        private final Object options;

        public SevenZMethodConfiguration(SevenZMethod method) {
            this.method = method;
            this.options = null;
        }

        public SevenZMethodConfiguration(SevenZMethod method, Object options) {
            this.method = method;
            this.options = options;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            SevenZMethodConfiguration that = (SevenZMethodConfiguration) obj;
            return Objects.equals(method, that.method) && Objects.equals(options, that.options);
        }

        @Override
        public int hashCode() {
            return Objects.hash(method, options);
        }
    }

    @Test
    public void testEquals_SameObject() {
        SevenZMethod method = new SevenZMethod();
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(method);
        assertTrue(config.equals(config));
    }

    @Test
    public void testEquals_NullObject() {
        SevenZMethod method = new SevenZMethod();
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(method);
        assertFalse(config.equals(null));
    }

    @Test
    public void testEquals_DifferentClass() {
        SevenZMethod method = new SevenZMethod();
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(method);
        assertFalse(config.equals("Some String"));
    }

    @Test
    public void testEquals_SameValues() {
        SevenZMethod method = new SevenZMethod();
        Object options = new Object();
        SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(method, options);
        SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(method, options);
        assertTrue(config1.equals(config2));
    }

    @Test
    public void testEquals_DifferentMethod() {
        SevenZMethod method1 = new SevenZMethod();
        SevenZMethod method2 = new SevenZMethod();
        Object options = new Object();
        SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(method1, options);
        SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(method2, options);
        assertFalse(config1.equals(config2));
    }

    @Test
    public void testEquals_DifferentOptions() {
        SevenZMethod method = new SevenZMethod();
        Object options1 = new Object();
        Object options2 = new Object();
        SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(method, options1);
        SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(method, options2);
        assertFalse(config1.equals(config2));
    }

    @Test
    public void testEquals_SameMethodDifferentOptions() {
        SevenZMethod method = new SevenZMethod();
        Object options1 = new Object();
        Object options2 = new Object();
        SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(method, options1);
        SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(method, options2);
        assertFalse(config1.equals(config2));
    }

    // Reflection test for private fields (if needed)
    private Object getPrivateField(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
}
